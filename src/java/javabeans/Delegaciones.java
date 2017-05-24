/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javabeans;



/**
 *
 * @author Rafael Mendez
 */
public class Delegaciones 
{
    private Integer idDelegacion;
    private String descripcion;
    private String idMecanica;
    private String direccion;
    
    
    public Delegaciones(){}
    //constructor que permite crear un objeto
    //Mensaje a partir de los datos del mismo
    public Delegaciones( Integer idDelegacion, String descripcion)
    {
        this.idDelegacion=idDelegacion;
        this.descripcion=descripcion;
        
    }
    
    public Delegaciones( Integer idDelegacion, String descripcion, String direccion, String idMecanica)
    {
        this.idDelegacion=idDelegacion;
        this.descripcion=descripcion;
        this.direccion=direccion;
        this.idMecanica=idMecanica;
        
    }
    
    public Delegaciones( Integer idDelegacion, String descripcion, String idMecanica)
    {
        this.idDelegacion=idDelegacion;
        this.descripcion=descripcion;
        this.idMecanica=idMecanica;
        
        
    }

    
    public Integer getidDelegacion() {
        return idDelegacion;
    }

    public void setidDelegacion(Integer idDelegacion) {
        this.idDelegacion = idDelegacion;
    }
    
    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getidMecanica() {
        return idMecanica;
    }

    public void setidMecanica(String idMecanica) {
        this.idMecanica = idMecanica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
       
}
