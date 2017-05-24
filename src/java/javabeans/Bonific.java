/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author Rafael Mendez
 */


public class Bonific
{
    private Integer id_bonific;
    private String clave_bonific;
    private String descripcion;
    
    
    public Bonific(){}
    //constructor que permite crear un objeto
    //Mensaje a partir de los datos del mismo
    public Bonific(String clave_bonific, String descripcion,Integer id_bonific)
    {
        this.clave_bonific=clave_bonific;
        this.descripcion=descripcion;
        this.id_bonific=id_bonific;
                
    }

    public String getClave_bonific() {
        return clave_bonific;
    }

    public void setClave_bonific(String clave_bonific) {
        this.clave_bonific = clave_bonific;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getid_bonific() {
        return id_bonific;
    }

    public void setid_bonific(Integer id_bonific) {
        this.id_bonific = id_bonific;
    }
    
    

}
