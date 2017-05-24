/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



/**
 *
 * @author Rafael Mendez
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabeans.ModuloRecaudacion;
import javabeans.User;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class Gestionuser  extends ModeloBase
{
    //método común para la obtención
    //de conexiones
    public Connection getConnection() throws ServletException, SQLException
    {
        
        
        DataSource pool;
        
        try 
        {
            Context env = (Context) new InitialContext().lookup("java:comp/env");
            pool = (DataSource) env.lookup("jdbc/cobranza");
            if (pool == null) 
            {
                throw new ServletException("No se encontró el DataSource");
            }
        }
        catch (NamingException ne) 
        {
            throw new ServletException(ne.getMessage());
        }
        
        Connection cn = pool.getConnection();
        return cn;
    }
    
    
    
    
    
    
    
    
    
    public User localizauser(User user)
    {
         
        User muser=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            
            String musuario = user.getUsuario();
            String mpassword = user.getPassword();
            String tsql;
            tsql="select * from usuarios where usuario='"+musuario+"' and password='"+mpassword+"'";
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                muser=new User(rs.getInt("id_usuario"),rs.getString("usuario"),rs.getString("password"),rs.getInt("id_nivel"),rs.getInt("id_del"),rs.getString("serie"), rs.getString("nombre"), rs.getString("cargo"), rs.getString("direccion"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(muser);
    }
    
    
    
    public ArrayList<User> listarUsuarios(){
        ArrayList<User> usuarios=new ArrayList();
        ResultSet rs;
        
        try{
            String tsql;
            tsql="select UR.*, D.descripcion as delegacion, N.descripcion as nivel from usuarios UR inner join delegaciones D on UR.id_del=D.id_delegacion  inner join niveles N on UR.id_nivel=N.id_nivel order by UR.id_del";

            rs=Conexion.ejecutarConsulta(tsql, null);
            while(rs.next()){
                User usuario=new User(rs.getInt("id_usuario"), rs.getString("usuario"), rs.getString("password"), rs.getInt("id_nivel"), rs.getInt("id_del"), rs.getString("serie"), rs.getString("nombre"), rs.getString("cargo"), rs.getString("direccion"));
                usuario.setDelegacion(rs.getString("delegacion"));
                usuario.setNivel(rs.getString("nivel"));
                usuarios.add(usuario);
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
    public boolean eliminar(int id_usuario){
        Object params[]={id_usuario};
        return Conexion.ejecutar("delete from usuarios where id_usuario=?", params);
    }
    
    public boolean nuevo(User usuario){
        Object params[]={usuario.getUsuario(), usuario.getPassword(),usuario.getId_nivel(),usuario.getId_del(),usuario.getSerie(),usuario.getNombre(),usuario.getCargo(),usuario.getDireccion()};
        return Conexion.ejecutar("insert into usuarios (usuario, password, id_nivel, id_del,serie,nombre,cargo,direccion) values (?,?,?,?,?,?,?,?)", params);
    }
    
    
    public boolean editar(User usuario){
        Object params[]={usuario.getUsuario(), usuario.getPassword(),usuario.getId_nivel(),usuario.getId_del(),usuario.getSerie(),usuario.getNombre(),usuario.getCargo(),usuario.getDireccion(),usuario.getId_usuario()};
        return Conexion.ejecutar("update usuarios set usuario=?, password=?, id_nivel=?, id_del=?, serie=?, nombre=?, cargo=?, direccion=? where id_usuario=?", params);
    }
    
    
    public User obtenerPorId(int id_usuario){
        Object params[]={id_usuario};
        String tsql="select UR.*, D.descripcion as delegacion from usuarios UR inner join delegaciones D on UR.id_del=D.id_delegacion where UR.id_usuario=?";
        ResultSet rs=Conexion.ejecutarConsulta(tsql, params);
        User usuario=null;
        try {
            while(rs.next()){
                usuario=new User(rs.getInt("id_usuario"), rs.getString("usuario"), rs.getString("password"), rs.getInt("id_nivel"), rs.getInt("id_del"), rs.getString("serie"), rs.getString("nombre"), rs.getString("cargo"), rs.getString("direccion"));
                usuario.setDelegacion(rs.getString("delegacion"));
                usuario.setNivel(rs.getString("nivel"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestionModuloRecaudacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
    
    
    
}


