
package gerenciamentomemoria;

import Memoria.MemVirtual;






public class Processos extends Thread {
    
   
   
  
   private String[] comando;
   private int id;
   int tamanho=16;
   private MemVirtual mVirtual;
   private MMU Mmu;
   
   

  public Processos(int id, MMU mmu, String[] comando){
      this.id=id;
      this.comando=comando;
      this.Mmu=mmu;
               
     
     
     
       
        }
  
  public void enviar() {
            
		for(String g : this.comando) {
			System.out.println("Processo: " + this.id + " ACORDOU!@##@!!");
			Mmu.acessarSequencia(g,this.id);
			System.out.println(g);
			try {
				System.out.println("Processo: " + this.id + " Dormiu\n\n");
				Thread.sleep(id * 1900l); //
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("Processo: " + this.id + " Acabou\n");
  }
   
   
 
   
    
    @Override
    public void run(){
        
      
        
       
           
        System.out.println("começando...");
      
       
        enviar();
        
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
          
           e.printStackTrace();
       }
         
          
       } 
          
        
      
         
         
      
    }    
           
       


        
               
      
        
            
            
            
                
              
         
         
         
            
            
            
        
            
             
    
    

    

    

      
            
        
        
        
    
    
    

