/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabeans.ModuloRecaudacion;

/**
 *
 * @author arturo
 */
public class GestionModuloRecaudacion extends ModeloBase {
    public ArrayList<ModuloRecaudacion> listarModulos(){
        ArrayList<ModuloRecaudacion> modulos=new ArrayList();
        ResultSet rs;
        
        try{
            String tsql;
            tsql="select MR.*, D.descripcion as delegacion from modulos_recaudacion MR inner join delegaciones D on MR.id_delegacion=D.id_delegacion order by MR.descripcion";

            rs=Conexion.ejecutarConsulta(tsql, null);
            while(rs.next()){
                ModuloRecaudacion mod=new ModuloRecaudacion(rs.getInt("id_modulo"), rs.getString("descripcion"), rs.getString("direccion"), rs.getInt("id_delegacion"));
                mod.setDelegacion(rs.getString("delegacion"));
                modulos.add(mod);
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return modulos;
    }
    
    public boolean eliminar(int id_modulo){
        Object params[]={id_modulo};
        return Conexion.ejecutar("delete from modulos_recaudacion where id_modulo=?", params);
    }
    
    public boolean nuevo(ModuloRecaudacion mod){
        Object params[]={mod.getDescripcion(), mod.getDireccion(), mod.getId_delegacion()};
        return Conexion.ejecutar("insert into modulos_recaudacion (descripcion, direccion, id_delegacion) values (?,?,?)", params);
    }
    
    public boolean editar(ModuloRecaudacion mod){
        Object params[]={mod.getDescripcion(), mod.getDireccion(), mod.getId_delegacion(), mod.getId_modulo()};
        return Conexion.ejecutar("update modulos_recaudacion set descripcion=?, direccion=?, id_delegacion=? where id_modulo=?", params);
    }
    
    public ModuloRecaudacion obtenerPorId(int id_modulo){
        Object params[]={id_modulo};
        String tsql="select MR.*, D.descripcion as delegacion from modulos_recaudacion MR inner join delegaciones D on MR.id_delegacion=D.id_delegacion where MR.id_modulo=?";
        ResultSet rs=Conexion.ejecutarConsulta(tsql, params);
        ModuloRecaudacion mod=null;
        try {
            while(rs.next()){
                mod=new ModuloRecaudacion(rs.getInt("id_modulo"), rs.getString("descripcion"), rs.getString("direccion"), rs.getInt("id_delegacion"));
                mod.setDelegacion(rs.getString("delegacion"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestionModuloRecaudacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mod;
    }
}
