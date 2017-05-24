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
import javabeans.Colonias;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;


public class Gestioncolonias 
{

    public Gestioncolonias () {
        //super();
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
    
    
    
    public ArrayList listarColonias()
    {
         
        ArrayList coloniass=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_colonia,c.id_delegacion,d.descripcion as delegacion,c.descripcion as colonia from colonias c left outer join delegaciones d on c.id_delegacion=d.id_delegacion order by c.id_delegacion,c.descripcion ";
            //tsql="select * from colonias order by id_delegacion,descripcion";
            rs=st.executeQuery(tsql);
            coloniass=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Colonias mcolonias=new Colonias(rs.getInt("id_colonia"),rs.getString("delegacion"),rs.getString("colonia"));
                //Colonias mcolonias=new Colonias(rs.getInt("id_colonia"),rs.getInt("id_delegacion"),rs.getString("descripcion"));
                coloniass.add(mcolonias);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(coloniass);
    }
    
    public ArrayList listarColoniasparaselect(Integer id_del)
    {
         
        ArrayList coloniass=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_colonia,c.id_delegacion,d.descripcion as delegacion,c.descripcion as colonia from colonias c left outer join delegaciones d on c.id_delegacion=d.id_delegacion  where c.id_delegacion='"+id_del.toString()+"' order by c.id_colonia ";
            //tsql="select * from colonias order by id_delegacion,descripcion";
            rs=st.executeQuery(tsql);
            coloniass=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                //Colonias mcolonias=new Colonias(rs.getInt("id_colonia"),rs.getString("delegacion"),rs.getString("colonia"));
                
                coloniass.add(rs.getString("id_colonia"));
                coloniass.add(rs.getString("colonia"));
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(coloniass);
    }
    
    
    public Colonias localizaColonias(Integer mid_colonia)
    {
         
        Colonias mcolonias=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_colonia,c.id_delegacion,d.descripcion as delegacion,c.descripcion as colonia from colonias c left outer join delegaciones d on c.id_delegacion=d.id_delegacion  where c.id_colonia="+mid_colonia.toString();
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                mcolonias=new Colonias(rs.getInt("id_colonia"),rs.getInt("id_delegacion"),rs.getString("delegacion"),rs.getString("colonia"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){e.printStackTrace();}
        return(mcolonias);
    }
    
   
    
    public boolean eliminaColonias(Integer mid_colonia)
    {
         
        Colonias mcolonias=null;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="delete from colonias where id_colonia="+mid_colonia.toString();
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
    
    public Boolean grabaColonias(Colonias mcolonias)
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
            
            String idDelegacion=mcolonias.getidDelegacion().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String descripcion=mcolonias.getDescripcion().toUpperCase();
            
            // verificamos q la clave de mov no exista ya en el catalogo
            tsql="select id_delegacion,descripcion from colonias where id_delegacion='"+idDelegacion+"' and descripcion='"+descripcion+"'";
            rs=st.executeQuery(tsql);
            
            if (!rs.next())
            {    
                tsql="Insert into  colonias (id_delegacion,descripcion) values('";
                tsql+=idDelegacion+"','"+descripcion+"')";
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
    
    
    
    public Boolean modificaColonias(Colonias mcolonias)
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
            
            Integer idColonia = mcolonias.getidColonia();
            Integer idDelegacion = mcolonias.getidDelegacion();
            String descripcion = mcolonias.getDescripcion().toUpperCase();
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            sql="select descripcion from colonias where descripcion='"+descripcion+"' and id_delegacion='"+idDelegacion+"'";
            rsvalida=st.executeQuery(sql);
            Boolean valida = rsvalida.next();
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from colonias where id_colonia='"+idColonia.toString()+"'";
            rs=st.executeQuery(tsql);
            
            if ((rs.next()) && (valida==false))
            {    
                tsql="update colonias set id_delegacion='";
                tsql+=idDelegacion+"',descripcion='"+descripcion+"' where id_colonia="+idColonia;
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
