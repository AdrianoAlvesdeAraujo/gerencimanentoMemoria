
package Memoria;



public class MemHD {
    
     
     private Integer[] memoriaHD;
     private final int tamanho=55;
     
    
     
    
     public MemHD(){
        
        this.memoriaHD = new Integer[tamanho];
        
      
    } 

    public Integer getMemoriaHD(int indice) {
           
        return this.memoriaHD[indice];
    }

    public void setMemoriaHD(int indice, Integer valor) {
       
        memoriaHD[indice]= valor;
    }
    
    public Integer getIndiceLivre(){
        
        for(int i=0; i<=tamanho; i++){
            
           if(memoriaHD[i]== null){
               System.out.println("Tem espaço na memória: "+ i);
               return i;
           }
           
            
        }
        System.out.println("Não tem espaço na memória");
        return null;
    }
    
    public void Imprimir(){
        
        System.out.println("Mostrar Toda a memória do HD");
        
        for(int i=0; i<=memoriaHD.length; i++){
            
            if(memoriaHD[i]== null){
                
                System.out.println("Posição livre no HD: "+ i);
                
            }else{
            
                System.out.println("Posição livre no HD: "+ i +" Valor: "+ memoriaHD[i]);
            }
            
        }
    }

   
     

        
}

   
    
    
   


    
    
    

