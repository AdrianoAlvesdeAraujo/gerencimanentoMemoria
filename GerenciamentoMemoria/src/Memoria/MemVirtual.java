
package Memoria;


import gerenciamentomemoria.MMU;
import java.util.ArrayList;


public class MemVirtual {
    
      
    
   private Paginacao[] mVirtual;
   private int tamanho;
   private String[] comando;
   private MMU mmu;
   private MemHD HD;
   private MemRAM Ram;
    
      
      

    public MemVirtual(int tamanho){
       
       
       
       this.tamanho = tamanho;
       for(int i=0; i<=tamanho; i++){
               
       mVirtual = new Paginacao[this.tamanho];
      
      
       }
      
        }
    
    
     
    
    public void MostrarVirtual(){
        
        for(int i=0;i<=mVirtual.length; i++){
            
            System.out.print("Posição da Memória Virtual: "+ i);
            
            if(mVirtual[i] == null ){
                
                 System.out.println("null");
                
            }
              System.out.println(mVirtual[i]);
                
            }
            System.out.println();
            
        }

    public Paginacao getmVirtual(int posicao) {
        return mVirtual[posicao];
    }

   
    
    
    
        
    
    
       
    
   /* 
    
    public int LeituraVirtual(int index){
        
       //ler todos os dados
    if(index <= 7){
        
           if(mmu.Virtual.get(index) == -1){
               
                value = HD.Leitura(index);
                Ram.escritaRAM(index, valor);
                mmu.EscreveMMU(valor);
                              
                
                return value;
            }else{
                value= Ram.leituraRam(index);
          
          // System.out.println("index i: "+ i +" Valor: "+ valor);
            }
            
        

    }else{
             for(int i=8; i<=15; i++){
            
                
           if(mmu.Virtual.get(i) == null){
               
            value = HD.Leitura(index);
            EscritaVirtual(index, value);
           
          // System.out.println("index i: "+ i +" Valor: "+ valor);
          
            return value;
        }
    
    }
    
    }
     return -1;
}

    
    
    public void EscritaVirtual(int index, int valor){
        
    if(index <= 7){
            
       for(int i=0; i<=7; i++)
           
          if(mmu.Virtual.get(i) == null){
              
             mmu.Virtual.add(index);
           
           
           Ram.escritaRAM(index, value);
           
          
         
          }else {
              System.out.println("Memória cheia ");
          }
    }else{
            for(int i=8; i<=15; i++){
          if(mmu.Virtual.get(i) == null){
          mmu.Virtual.add(index);
           Ram.escritaRAM(index, value);
         
          
           
           if(mmu.Virtual.get(index) == null){
              value = HD.Leitura(index);
              Ram.escritaRAM(index, value);
               
           }
         
          }else {
              System.out.println("Memória cheia ");
          }
        
        
           
        
}
    
        }
    }*/
}
    
    
  
      
   
