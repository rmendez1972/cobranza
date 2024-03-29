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
import javabeans.Clavediv;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.math.BigDecimal;


public class Gestionclavediv 
{
    
     public Gestionclavediv () {
        super();
    }
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
    
    
    
    public ArrayList listarClavediv()
    {
         
        ArrayList clavedivs=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from clave_div ";
            rs=st.executeQuery(tsql);
            clavedivs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Clavediv mclavediv=new Clavediv(rs.getString("clave_div"),rs.getString("descripcion"),rs.getBigDecimal("importe"),rs.getInt("id_clave_div"));
                clavedivs.add(mclavediv);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(clavedivs);
    }
    
    
    public Clavediv localizaClavediv(Integer mid_clave_div)
    {
         
        Clavediv mclavediv=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from clave_div where id_clave_div="+mid_clave_div.toString();
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                mclavediv=new Clavediv(rs.getString("clave_div"),rs.getString("descripcion"),rs.getBigDecimal("importe"),rs.getInt("id_clave_div"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(mclavediv);
    }
    
    
    
    public boolean eliminaClavediv(Integer mid_clave_div)
    {
         
        Clavediv mclavediv=null;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="delete from clave_div where id_clave_div="+mid_clave_div.toString();
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
    
    public Boolean grabaClavediv(Clavediv mclavediv)
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
            
            String mclave_div=mclavediv.getClave_div().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mdescripcion=mclavediv.getDescripcion().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mimporte=mclavediv.getimporte().toString(); //convertimos a string un tipo date para poder concatenar el sql
            
            // verificamos q la clave de mov no exista ya en el catalogo
            tsql="select clave_div from clave_div where clave_div='"+mclave_div+"'";
            rs=st.executeQuery(tsql);
            
            if (!rs.next())
            {    
                tsql="Insert into  clave_div (clave_div,descripcion,importe) values('";
                tsql+=mclave_div+"','"+mdescripcion+"','"+mimporte+"')";
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
    
    
    public Boolean modificaClavediv(Clavediv mclavediv)
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
            
            Integer id_clave_div = mclavediv.getId_clave_div();
            String clave_div = mclavediv.getClave_div().toUpperCase();
            String descripcion = mclavediv.getDescripcion().toUpperCase();
            String importe = mclavediv.getimporte().toString();
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            sql="select clave_div,descripcion,importe from clave_div where clave_div='"+clave_div+"' and descripcion='"+descripcion+"' and importe='"+importe+"'";
            rsvalida=st.executeQuery(sql);
            Boolean valida = rsvalida.next();
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from clave_div where id_clave_div='"+id_clave_div.toString()+"'";
            rs=st.executeQuery(tsql);
            
            if ((rs.next()) && (valida==false))
            {    
                tsql="update clave_div set clave_div='";
                tsql+=clave_div+"',descripcion='"+mclavediv.getDescripcion().toUpperCase()+"',importe='"+mclavediv.getimporte().toString()+"' where id_clave_div="+mclavediv.getId_clave_div().toString();
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
