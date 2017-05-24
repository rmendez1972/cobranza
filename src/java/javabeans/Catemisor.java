/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author Rafael Mendez
 */
public class Catemisor 
{
    private Integer id_emisor;
    private String descripcion;
        
    public Catemisor () {
        super();
    }
    //constructor que permite crear un objeto
    //Mensaje a partir de los datos del mismo
    public Catemisor(Integer id_emisor, String descripcion)
    {
        
        this.descripcion=descripcion;
        this.id_emisor=id_emisor;
        
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getId_emisor() {
        return id_emisor;
    }

    public void setId_emisor(Integer id_emisor) {
        this.id_emisor = id_emisor;
    }

}
