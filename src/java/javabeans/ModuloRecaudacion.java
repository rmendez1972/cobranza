/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author arturo
 */
public class ModuloRecaudacion {
    private int id_modulo;
    private String descripcion, direccion, delegacion;
    private int id_delegacion;
    
    public ModuloRecaudacion(){}
    
    public ModuloRecaudacion(int id_modulo, String descripcion, String direccion, int id_delegacion){
        this.id_modulo=id_modulo;
        this.descripcion=descripcion;
        this.direccion=direccion;
        this.id_delegacion=id_delegacion;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
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

    public int getId_delegacion() {
        return id_delegacion;
    }

    public void setId_delegacion(int id_delegacion) {
        this.id_delegacion = id_delegacion;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }
}
