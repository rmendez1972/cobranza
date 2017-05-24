/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author Rafael Mendez
 */
public class Mecanica 
{
    private Integer id_mecanica;
    private String descripcion;
    
    public Mecanica () {
        super();
    }
    //constructor que permite crear un objeto
    //Mensaje a partir de los datos del mismo
    public Mecanica(Integer id_mecanica,String descripcion )
    {
        
        this.descripcion=descripcion;
        this.id_mecanica=id_mecanica;
        
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getId_mecanica() {
        return id_mecanica;
    }

    public void setId_mecanica(Integer id_mecanica) {
        this.id_mecanica = id_mecanica;
    }

}
