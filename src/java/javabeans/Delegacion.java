/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author arturo
 */
public class Delegacion {
    
    private int id_delegacion;
    private String descripcion;
    private String direccion;
    
    public Delegacion(){}
    
    public Delegacion(int id_delegacion, String descripcion, String direccion){
        this.id_delegacion=id_delegacion;
        this.descripcion=descripcion;
        this.direccion=direccion;
    }
    
    public int getId_delegacion() {
        return id_delegacion;
    }

    public void setId_delegacion(int id_delegacion) {
        this.id_delegacion = id_delegacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
