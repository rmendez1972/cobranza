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
import javabeans.Clavemov;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;


public class Gestionclavemov 
{
    
     public Gestionclavemov () {
        super();
    }
        //método común para la obtención
    //de conexiones
    public Connection getConnection() throws ServletException, SQLException
    {
        /*Connection cn=null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cobranza","root","admin");
        }
        catch(Exception e)
        {
            
        }
        return cn;
        */
        
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
    
    
    
    public ArrayList listarClavemov()
    {
         
        ArrayList clavemovs=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from clave_mov ";
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
            String descripcion = mclavemov.getDescripcion().toUpperCase();
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            sql="select clave_mov from clave_mov where clave_mov='"+clave_mov+"' and descripcion='"+descripcion+"'";
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
    
}
