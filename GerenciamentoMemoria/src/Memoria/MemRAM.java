
package Memoria;





public class MemRAM {
    
    
    
   
   
    private Integer[] mRam;
    private int tamanho;
   
    
    
    public MemRAM(int tamanho){
        
        this.tamanho=tamanho;       
        
    this.mRam = new Integer[this.tamanho];
        
            
    }

    public Integer getmRam(int indice) {
        return mRam[indice];
    }

    public void setmRam(int indice, Integer valor) {
        this.mRam[indice]= valor;
    }
    
    public Integer getIndice(){
        
        for(int i=0; i<=mRam.length; i++){
            
            if(mRam[i]== null){
                
                System.out.println("A posição livre é: "+ i);
            }
            
                  
        }
         System.out.println("Não há posição livre");
        return null;
    }
    
    
    
}
  
        
        
     
        
    
    
