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
import javabeans.Cpp;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import Modelo.conectaMysql;

public class Gestioncpp 
{
    //método común para la obtención
    //de conexiones
    /*public Connection getConnection() throws ServletException, SQLException
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
    }*/
    
    
    
    public ArrayList listarCpp()
    {
         
        ArrayList cpps=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=conectaMysql.getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from cpp ";
            rs=st.executeQuery(tsql);
            cpps=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Cpp mcpp=new Cpp(rs.getDate("fecha"),rs.getBigDecimal("importe"),rs.getInt("id_cpp"));
                cpps.add(mcpp);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(cpps);
    }
    
    public ArrayList imprimirCpp()
    {
         
        ArrayList cpps=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=conectaMysql.getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from cpp ";
            rs=st.executeQuery(tsql);
            cpps=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Cpp mcpp=new Cpp(rs.getDate("fecha"),rs.getBigDecimal("importe"),rs.getInt("id_cpp"));
                cpps.add(mcpp);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(cpps);
    }
    
    public Boolean grabaCpp(Cpp mcpp)
    {
        Connection cn;
        Statement st;
        ResultSet rs,rsvalida;
        Boolean exito=false;
        
        
        try
        
        {
            cn=conectaMysql.getConnection();
            st=cn.createStatement();
            String tsql,sql;
            
            //Integer id_cpp = mcpp.getId_cpp();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String fecha=sdf.format(mcpp.getFecha()); //convertimos a string un tipo date para poder concatenar el sql
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            sql="select fecha from cpp where fecha="+fecha;
            rsvalida=st.executeQuery(sql);
            Boolean valida = rsvalida.next();
            
            if (valida==false)
            { 
                tsql="Insert into  cpp (fecha,importe) values('";
                tsql+=fecha+"','"+mcpp.getImporte().toString()+"')";
                st.execute(tsql);
            }
            st.close();
            cn.close();
            exito=true;
            
        }
        catch(Exception e)
        {
           
        }
        return (exito);
    }
    
    public Cpp localizaCpp(Integer mid_cpp)
    {
         
        Cpp mcpp=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=conectaMysql.getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from cpp where id_cpp="+mid_cpp.toString();
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                mcpp=new Cpp(rs.getDate("fecha"),rs.getBigDecimal("importe"),rs.getInt("id_cpp"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(mcpp);
    }
    
    
    public boolean eliminaCpp(Integer mid_cpp)
    {
         
        Cpp mcpp=null;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        
        try
        {
            Connection cn=conectaMysql.getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="delete from cpp where id_cpp="+mid_cpp.toString();
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
    
    
    public Boolean modificaCpp(Cpp mcpp)
    {
        Connection cn;
        Statement st;
        ResultSet rs,rsvalida;
        Boolean exito=false;
        
        
        try
        
        {
            cn=conectaMysql.getConnection();
            st=cn.createStatement();
            String tsql;
            String sql;
            
            //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            Integer id_cpp = mcpp.getId_cpp();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String fecha=sdf.format(mcpp.getFecha());
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            sql="select fecha from cpp where fecha='"+fecha+"' and id_cpp<>"+id_cpp.toString();
            rsvalida=st.executeQuery(sql);
            Boolean valida = rsvalida.next();
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from cpp where id_cpp='"+id_cpp.toString()+"'";
            rs=st.executeQuery(tsql);
            
            if ((rs.next()) && (valida==false))
            {    
                tsql="update cpp set fecha='";
                tsql+=fecha+"',importe='"+mcpp.getImporte().toString()+"' where id_cpp="+id_cpp.toString();
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


