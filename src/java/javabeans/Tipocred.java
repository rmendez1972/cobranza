/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javabeans;

/**
 *
 * @author Rafael Mendez
 */
public class Tipocred 
{
    private Integer idTipocred;
    private String descripcion;
        
    public Tipocred(){}
    //constructor que permite crear un objeto
    //Mensaje a partir de los datos del mismo
    public Tipocred( Integer idTipocred, String descripcion)
    {
        this.idTipocred=idTipocred;
        this.descripcion=descripcion;
        
        
    }
    
    
    
    
    
    public Integer getidTipocred() {
        return idTipocred;
    }

    public void setidTipocred(Integer idTipocred) {
        this.idTipocred = idTipocred;
    }
    
            
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
           
}
