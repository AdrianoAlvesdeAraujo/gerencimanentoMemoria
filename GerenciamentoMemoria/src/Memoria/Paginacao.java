
package Memoria;


import Memoria.*;



public class Paginacao{

    private Boolean referenciada;
    private Boolean modificada;
    private Boolean presente;
    private Integer PaginaVirtual;
   
   

    
public Paginacao(){
    
    this.referenciada=false;
    this.modificada=false;
    this.presente=false;
    this.PaginaVirtual=null;
    

}

    public Boolean getReferenciada() {
        return referenciada;
    }

    public void setReferenciada(Boolean referenciada) {
        int count=0;
        this.referenciada = referenciada;
       count++;
        if(count==16){
            referenciada=false;
        }
    }

    public Boolean getModificada() {
        return modificada;
    }

    public void setModificada(Boolean modificada) {
        this.modificada = modificada;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public Integer getPaginaVirtual() {
        return PaginaVirtual;
    }

    public void setPaginaVirtual(Integer PaginaVirtual) {
        this.PaginaVirtual = PaginaVirtual;
    }
    
    public Boolean existe(){
        
        if(PaginaVirtual==null){
            return false;            
        }
        return true;
    }
    
    public void print(){
        
        System.out.println("Referenciada: "+referenciada+ "\n"
                         + " Modificada: "+modificada+ "\n"+
                           "Presente: "+ presente + "\n"+
                          "Página Virtual: "+ PaginaVirtual);
        
    
                            
                
        
        
    }


}

    