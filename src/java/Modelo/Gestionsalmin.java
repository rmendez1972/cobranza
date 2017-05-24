/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



/**
 *
 * @Ismael García Hernández
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javabeans.Salmin;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class Gestionsalmin 
{
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
    
    
    
    public ArrayList listarSalmin()
    {
         
        ArrayList salmin=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from salmin";
            rs=st.executeQuery(tsql);
            salmin=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Salmin msalmin=new Salmin(rs.getDate("fecha"),rs.getBigDecimal("importe"));
                salmin.add(msalmin);
            }
            st.close();
            cn.close();
        }
        catch(Exception e){}
        return(salmin);
    }
    
    public Boolean grabaSalmin(Salmin msalmin)
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
            
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            String fecha=sdf.format(msalmin.getFecha()); //convertimos a string un tipo date para poder concatenar el sql
            
            
            tsql="Insert into  salmin (fecha,importe) values('";
            tsql+=fecha+"','"+msalmin.getImporte().toString()+"')";
            st.execute(tsql);
            st.close();
            cn.close();
            exito=true;
            
        }
        catch(Exception e)
        {
           
        }
        return (exito);
    }
}


