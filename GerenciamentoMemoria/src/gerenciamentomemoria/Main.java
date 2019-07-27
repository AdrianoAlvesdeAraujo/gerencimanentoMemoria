
package gerenciamentomemoria;

import Memoria.*;








public class Main {
    
       
    
    
    
    
    public static void main(String[] args) {
        int Tam_Virtual = 16;
        final int thread = 3;  
        
        MemRAM Ram=new MemRAM(Tam_Virtual/2);
        MemVirtual mVirtual=new MemVirtual(Tam_Virtual);
        MemHD HD=new MemHD();
        MMU mmu=new MMU(Ram, mVirtual, HD);
        
        try {
            
            for(int i=1; i <= thread; i++){
             
            String SUA_ENTRADA = new FabricaDeEntradas(Tam_Virtual).getNewEntrada();	
            String comandos [] = SUA_ENTRADA.split(",");
            new Processos(i, mmu, comandos).start();
                     
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        
    }

    
}
