/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author Rafael Mendez
 */
public class Clavemov 
{
    private Integer id_clave_mov;
    private String clave_mov;
    private String descripcion;
    
    public Clavemov () {
        
    }
    //constructor que permite crear un objeto
    //Mensaje a partir de los datos del mismo
    public Clavemov(String clave_mov, String descripcion, Integer id_clave_mov)
    {
        this.clave_mov=clave_mov;
        this.descripcion=descripcion;
        this.id_clave_mov=id_clave_mov;
        
    }

    public String getClave_mov() {
        return clave_mov;
    }

    public void setClave_mov(String clave_mov) {
        this.clave_mov = clave_mov;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getId_clave_mov() {
        return id_clave_mov;
    }

    public void setId_clave_mov(Integer id_clave_mov) {
        this.id_clave_mov = id_clave_mov;
    }

}
