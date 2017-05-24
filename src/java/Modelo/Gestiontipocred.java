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
import javabeans.Tipocred;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;


public class Gestiontipocred 
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
    
    
    
    public ArrayList listarTipocred()
    {
         
        ArrayList tipocreds=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from tipo_credito";
            rs=st.executeQuery(tsql);
            tipocreds=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Tipocred mtipocred=new Tipocred(rs.getInt("id_tipocredito"),rs.getString("descripcion"));
                tipocreds.add(mtipocred);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(tipocreds);
    }
    
    
    public Tipocred localizaTipocred(Integer mid_tipocredito)
    {
         
        Tipocred mtipocred=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from tipo_credito where id_tipocredito="+mid_tipocredito.toString();
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                mtipocred=new Tipocred(rs.getInt("id_tipocredito"),rs.getString("descripcion"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(mtipocred);
    }
    
    
    
    public boolean eliminaTipocred(Integer mid_tipocredito)
    {
         
        Tipocred mtipocred=null;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="delete from tipo_credito where id_tipocredito="+mid_tipocredito.toString();
            st.execute(tsql);
            exito=true;
            
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(exito);
    }
    
    
    /*
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
    
    */
    
    public Boolean grabaTipocred(Tipocred mtipocred)
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
            
            String descripcion=mtipocred.getDescripcion().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            
            // verificamos q la clave de mov no exista ya en el catalogo
            tsql="select descripcion from tipo_credito where descripcion='"+descripcion+"'";
            rs=st.executeQuery(tsql);
            
            if (!rs.next())
            {    
                tsql="Insert into tipo_credito (descripcion) values('";
                tsql+=descripcion+"')";
                st.execute(tsql);
                exito=true;
            }
            st.close();
            cn.close();
            
            
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        return (exito);
    }
    
    
    public Boolean modificaTipocred(Tipocred mtipocred)
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
            
            String mdescripcion = mtipocred.getDescripcion().toUpperCase();
            Integer mid_tipocredito=mtipocred.getidTipocred();
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            sql="select descripcion from tipo_credito where descripcion='"+mdescripcion+"'";
            rsvalida=st.executeQuery(sql);
            Boolean valida = rsvalida.next();
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from tipo_credito where id_tipocredito='"+mid_tipocredito.toString()+"'";
            rs=st.executeQuery(tsql);
            
            if ((rs.next()) && (valida==false))
            {    
                tsql="update tipo_credito set descripcion='";
                tsql+=mdescripcion+"' where id_tipocredito="+mid_tipocredito.toString();
                st.execute(tsql);
                exito=true;
            }
            st.close();
            cn.close();
            
            
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        return (exito);
    }
    
}
