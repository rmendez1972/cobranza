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
import javabeans.Delegacion;
import javabeans.Delegaciones;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;


public class Gestiondelegaciones extends ModeloBase
{
    
    public boolean nuevo(Delegacion del){
        Object params[]={del.getDescripcion(), del.getDireccion()};
        return Conexion.ejecutar("insert into delegaciones (descripcion,direccion) values (?,?)", params);
    }
    
    public boolean eliminar(int id_delegacion){
        Object params[]={id_delegacion};
        long total=Conexion.ejecutarCount("select count(*) from modulos_recaudacion where id_delegacion=?", params);
        if(total>0)
            return false;
        else
            return Conexion.ejecutar("delete from delegaciones where id_delegacion=?", params);
    }
    
    public boolean editar(Delegacion del){
        Object params[]={del.getDescripcion(), del.getDireccion(), del.getId_delegacion()};
        return Conexion.ejecutar("update delegaciones set descripcion=?, direccion=? where id_delegacion=?", params);
    }
    
    public Delegacion obtenerPorId(int id_delegacion){
        Object params[]={id_delegacion};
        ResultSet rs=Conexion.ejecutarConsulta("select * from delegaciones where id_delegacion=?", params);
        Delegacion del=null;
        try {
            while(rs.next()){
                del=new Delegacion(rs.getInt("id_delegacion"),rs.getString("descripcion"),rs.getString("direccion"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Gestiondelegaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return del;
    }
     
    public ArrayList listarDelegaciones()
    {
         
        ArrayList delegacioness=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from delegaciones order by id_delegacion";
            rs=st.executeQuery(tsql);
            delegacioness=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Delegaciones mdelegaciones=new Delegaciones(rs.getInt("id_delegacion"),rs.getString("descripcion"),rs.getString("direccion"),"");
                delegacioness.add(mdelegaciones);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(delegacioness);
    }
    
    
    public ArrayList listarDelegacionesparaselect()
    {
         
        ArrayList delegacioness=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from delegaciones order by id_delegacion";
            rs=st.executeQuery(tsql);
            delegacioness=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                //Delegaciones mdelegaciones=new Delegaciones(rs.getInt("id_delegacion"),rs.getString("descripcion"));
                delegacioness.add(rs.getString("id_delegacion"));
                delegacioness.add(rs.getString("descripcion"));
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(delegacioness);
    }
    
    /*
    public Clavemov localizaClavemov(Integer mid_clave_mov)
    {
         
        Clavemov mclavemov=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from clave_mov where id_clave_mov="+mid_clave_mov.toString();
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                mclavemov=new Clavemov(rs.getString("clave_mov"),rs.getString("descripcion"),rs.getInt("id_clave_mov"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(mclavemov);
    }
    
    
    
    public boolean eliminaClavemov(Integer mid_clave_mov)
    {
         
        Clavemov mclavemov=null;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="delete from clave_mov where id_clave_mov="+mid_clave_mov.toString();
            st.execute(tsql);
            exito=true;
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(exito);
    }
    
    
    
    public ArrayList imprimirClavemov()
    {
         
        ArrayList clavemovs=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from clavemov ";
            rs=st.executeQuery(tsql);
            clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Clavemov mclavemov=new Clavemov(rs.getString("clave_mov"),rs.getString("descripcion"),rs.getInt("id_clave_mov"));
                clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(clavemovs);
    }
    
    public Boolean grabaClavemov(Clavemov mclavemov)
    {
        Connection cn;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        
        
        try
        
        {
            cn=getConnection();
            st=cn.createStatement();
            String tsql;
            
            //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            String clave_mov=mclavemov.getClave_mov().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            
            // verificamos q la clave de mov no exista ya en el catalogo
            tsql="select clave_mov from clave_mov where clave_mov='"+clave_mov+"'";
            rs=st.executeQuery(tsql);
            
            if (!rs.next())
            {    
                tsql="Insert into  clave_mov (clave_mov,descripcion) values('";
                tsql+=mclavemov.getClave_mov().toUpperCase()+"','"+mclavemov.getDescripcion().toUpperCase()+"')";
                st.execute(tsql);
                exito=true;
            }
            st.close();
            cn.close();
            
            
        }
        catch(Exception e)
        {
           
        }
        return (exito);
    }
    
    public Boolean modificaClavemov(Clavemov mclavemov)
    {
        Connection cn;
        Statement st;
        ResultSet rs,rsvalida;
        Boolean exito=false;
        
        
        try
        
        {
            cn=getConnection();
            st=cn.createStatement();
            String tsql;
            String sql;
            
            //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            Integer id_clave_mov = mclavemov.getId_clave_mov();
            String clave_mov = mclavemov.getClave_mov().toUpperCase();
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            sql="select clave_mov from clave_mov where clave_mov='"+clave_mov+"'";
            rsvalida=st.executeQuery(sql);
            Boolean valida = rsvalida.next();
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from clave_mov where id_clave_mov='"+id_clave_mov.toString()+"'";
            rs=st.executeQuery(tsql);
            
            if ((rs.next()) && (valida==false))
            {    
                tsql="update clave_mov set clave_mov='";
                tsql+=mclavemov.getClave_mov().toUpperCase()+"',descripcion='"+mclavemov.getDescripcion().toUpperCase()+"' where id_clave_mov="+id_clave_mov;
                st.execute(tsql);
                exito=true;
            }
            st.close();
            cn.close();
            
            
        }
        catch(Exception e)
        {
           
        }
        return (exito);
    }
    
    */
}
