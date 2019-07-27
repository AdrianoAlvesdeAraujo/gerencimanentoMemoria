
package gerenciamentomemoria;

import Memoria.*;


public class MMU {
    
    private MemVirtual mVirtual;
    private MemRAM Ram;
    private MemHD HD;
    private Paginacao pagina;
    private NRU nru;
   
  
    
    
    public MMU(MemRAM Ram, MemVirtual mVirtual, MemHD HD){
        
        this.Ram=Ram;
        this.mVirtual=mVirtual;
        this.HD=HD;
        
        NRU nru=new NRU(mVirtual, Ram, HD, pagina);
        
       
        
        
    }
    
     public synchronized void acessarSequencia(String s, int id){
         
         System.out.println("Processo: "+ id);
   
       
       String[] t = s.split("-");
      
       
      for(int i = 1; i<=t.length; i++){
          
          if(t[1].contains("R")){
              
              Leitura(Integer.parseInt(t[0]));
              
          }else{
              
              Escrita(Integer.parseInt(t[0]), Integer.parseInt(t[2]));
              
          }
          
      }
   }
     
     
     public void Leitura(int indiceVirtual){
         System.out.println("Leitura em :" + indiceVirtual );
		
                Paginacao leitura = this.mVirtual.getmVirtual(indiceVirtual);
		
		
		if(leitura.getPaginaVirtual() == null) {
                    //tentando ler pagina NULA
			System.out.println("LEITURA SENDO REALIZADA EM UMA PAGINA QUE NAO EXISTE ");
			
		}
		if(leitura != null) {
			if(leitura.getPresente()) {						//ela esta na ram
				System.out.println("Indice:" + indiceVirtual + " valor: " + this.Ram.getmRam(leitura.getPaginaVirtual()));
				leitura.setReferenciada(true);
				nru.adicionarRecente(indiceVirtual);
			}else { 	//caso esteja ausente (esta no HD).
				this.liberarEspacoRam();
				this.HDparaRAM(indiceVirtual);
				this.Leitura(indiceVirtual);
         
                        }
     }
     }
     
     public synchronized void Escrita(int indiceVirtual, Integer valor){
                  
         Integer posicaoNaRam = null;
         
        if(mVirtual.getmVirtual(indiceVirtual).existe()){
             System.out.println(" A PAGINA JA EXISTA, FAZENDO UMA ATUALIZACAO");
             
             if(mVirtual.getmVirtual(indiceVirtual).getPresente()){
                 System.out.println("a variavel ja esta na RAM");
                 posicaoNaRam = mVirtual.getmVirtual(indiceVirtual).getPaginaVirtual();   	//pega a posicao q o valor esta na ram
                 mVirtual.getmVirtual(indiceVirtual).setModificada(true);
                 mVirtual.getmVirtual(indiceVirtual).setReferenciada(true);
                 Ram.setmRam(indiceVirtual, valor);
                 
                            
             }else{//CASO O VALOR NAO ESTEJA NA MEMORIA RAM
                 
                System.out.println("O VALOR NAO ESTA NA MEMORIA RAM");
               this.liberarEspacoRam();
               this.HDparaRAM(indiceVirtual);
		int posicaoRam = mVirtual.getmVirtual(indiceVirtual).getPaginaVirtual() ;
		Ram.setmRam(posicaoRam, valor);						//escrevendo valor novo
		nru.adicionarRecente(indiceVirtual);
				
                 
             }
             
             
        }else { //CASO A PAGINA AINDA NAO EXISTA, FAZENDO UMA NOVA INSERCAO
            System.out.println(" PAGINA AINDA NAO EXISTA, FAZENDO UMA NOVA INSERCAO");
            posicaoNaRam = Ram.getIndice();
			
		if(posicaoNaRam != null) { 		// EXISTE ESPACO LIVRE NA RAM!!!
                    mVirtual.getmVirtual(indiceVirtual).setPaginaVirtual(posicaoNaRam);
                    mVirtual.getmVirtual(indiceVirtual).setPresente(true);
                    Ram.setmRam(posicaoNaRam, valor);
				//LRU.adicionarRecente(indiceVirtual);	
         
         
                }else { //CASO NAO EXISTA MEMORIA LIVRE PARA FAZER UMA INSERCAO
				System.out.println("NAO EXISTE MEMORIA LIVRE PARA FAZER UMA INSERCAO");
				this.liberarEspacoRam();
				posicaoNaRam = Ram.getIndice();
				mVirtual.getmVirtual(indiceVirtual).setPaginaVirtual(posicaoNaRam);
				mVirtual.getmVirtual(indiceVirtual).setPresente(true);
				Ram.setmRam(posicaoNaRam, valor);
				
				nru.adicionarRecente(indiceVirtual);
    
                        }
        

     }
         System.out.println("ESCRITA FEITA COM SUCESSO");
}
     
     private void liberarEspacoRam() {
		Integer IndicePagina, IndiceLivreHD, IndiceRam, valorRam;
		IndicePagina = nru.removerUm();												//escolhendo quem vai pro HD
                System.out.println("O algoritmo NRU escolheu a pagina:" + IndicePagina);
		IndiceLivreHD = HD.getIndiceLivre();		//pegando indice livre no HD
		
		IndiceRam = mVirtual.getmVirtual(IndiceLivreHD).getPaginaVirtual();		//pegando a moldura da pagina
		mVirtual.getmVirtual(IndicePagina).setPaginaVirtual(IndiceLivreHD);		//apontando para o HD
		mVirtual.getmVirtual(IndicePagina).setPresente(false);	//setando false(que ta no HD)
		valorRam = Ram.getmRam(IndiceRam);		//pegando valor na ram
		Ram.setmRam(IndiceRam, null);			//setando espaco da ram para null
		HD.setMemoriaHD(IndiceLivreHD, valorRam);
		System.out.println("A pagina " + IndicePagina + " que tinha moduldura " + IndiceRam + " foi para o HD na posicao y" + IndiceLivreHD);
	}
     
   
    private void HDparaRAM(int indiceVirtual) {
		Integer molduraHD, valorHD, indiceLivreRAM;

		molduraHD = mVirtual.getmVirtual(indiceVirtual).getPaginaVirtual();//pegando valor da moldura que esta apontando para o HD
		valorHD = HD.getMemoriaHD(indiceVirtual);			//pegando valor que esta  no HD
		HD.setMemoriaHD(indiceVirtual, null);				//setando espaco do hd para null
		
		indiceLivreRAM = Ram.getIndice(); //COLOCANDO DE VOLTA NA RAM
		Ram.setmRam(indiceLivreRAM, valorHD);
		mVirtual.getmVirtual(indiceVirtual).setPaginaVirtual(indiceLivreRAM);
		mVirtual.getmVirtual(indiceVirtual).setPresente(true);
		
		System.out.print("A pagina " + indiceVirtual +"\n"+
                                " que tinha a moldura: y" + molduraHD + "\n"+
                                " agora foi para RAM em x" +indiceLivreRAM);
	}
 
     
       
}
     

