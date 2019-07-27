/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentomemoria;
import Memoria.*;

public class NRU {
    
    private MemVirtual mVirtual;
    private MemRAM mRam; 
    private MemHD mHD;
    private Paginacao pagina;
    private int tamanho=16;
    private Boolean posicaoReferenciada;
    private Boolean posicaoModificada;
    
    public NRU(MemVirtual mVirtual, MemRAM mRam, MemHD mHD, Paginacao pagina){
        this.mVirtual=mVirtual;
        this.mRam=mRam;
        this.mHD=mHD;
        this.pagina=pagina;
        
    }
    
    public Integer removerUm(){
        
        for(int i=0; i<=tamanho; i++){
       posicaoReferenciada = mVirtual.getmVirtual(i).getReferenciada();
       posicaoModificada = mVirtual.getmVirtual(i).getModificada();
        
        if((posicaoReferenciada == false)&&(posicaoModificada == false)){
                return i;
                
        }
         if((posicaoReferenciada == false)&&(posicaoModificada == true)){
                return i;
         }
         
          if((posicaoReferenciada == true)&&(posicaoModificada == false)){
                return i;
          }
           if((posicaoReferenciada == true)&&(posicaoModificada == true)){
                return i;
           }
        
    }
        
        return null;
    }
    
    public void adicionarRecente(int indiceVirtual){
        
    }
    
    
    
}
