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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javabeans.Cajas;
import javabeans.User;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class Gestioncajas 
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
    
    
    
    public ArrayList listarCajas(User user)
    {
         
        ArrayList cajass=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            Integer id_usuario=null;
            id_usuario=user.getId_usuario();
            
            String tsql;
            tsql="select * from cajas where id_usuario='"+id_usuario+"' order by fecha";
            rs=st.executeQuery(tsql);
            cajass=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            
            while(rs.next())
            {
                 
                Cajas cajas=new Cajas(rs.getInt("id_caja"),rs.getDate("fecha"),rs.getInt("folio_inicial"),rs.getInt("folio_final"),rs.getString("poliza"),rs.getBigDecimal("monto_inicial"),rs.getInt("id_usuario"));
                cajass.add(cajas);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(cajass);
    }
   
    /*
    public ArrayList imprimirCpp()
    {
         
        ArrayList cpps=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
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
    
    */
    
    public Boolean grabaCajas(Cajas mcajas, User user)
    {
        Connection cn;
        Statement st;
        ResultSet rs,rsvalida;
        Boolean exito=false;
        
        
        try
        
        {
            cn=getConnection();
            st=cn.createStatement();
            String tsql,sql;
            
            //Integer id_cpp = mcpp.getId_cpp();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String fecha=sdf.format(mcajas.getFecha()); //convertimos a string un tipo date para poder concatenar el sql
            
            Integer id_usuario=null;
            id_usuario=user.getId_usuario();
            
            // verificamos q la caja no halla sido abierta en esta fecha por el usuario
            sql="select * from cajas where fecha='"+fecha+"' and id_usuario='"+id_usuario+"'";
            rsvalida=st.executeQuery(sql);
            Boolean valida = rsvalida.next();
            
            if (valida==false)
            { 
                tsql="Insert into  cajas (fecha,folio_inicial,folio_final,poliza,monto_inicial,id_usuario) values('";
                tsql+=fecha+"','"+mcajas.getFolio_inicial()+"','"+mcajas.getFolio_final()+"','"+mcajas.getPoliza()+"','"+mcajas.getMonto_inicial()+"','"+id_usuario+"')";
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
    
    
    public Cajas localizaCajas(Integer mid_caja)
    {
         
        Cajas mcaja=null;
        Statement st;
        ResultSet rs;
        java.util.Date fecha =null;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from cajas where id_caja='"+mid_caja+"'";
            rs=st.executeQuery(tsql);
            
                
            
            if(rs.next())
            {
                 
                mcaja=new Cajas(rs.getInt("id_caja"),rs.getDate("fecha"),rs.getInt("folio_inicial"),rs.getInt("folio_final"),rs.getString("poliza"),rs.getBigDecimal("monto_inicial"),rs.getInt("id_usuario"));
                
            }
            //fecha=mcaja.getFecha();
            //Calendar c =new GregorianCalendar();
            //c.setTime(fecha);
            //c.set(Calendar.HOUR_OF_DAY, 0);
            
            //Date x= c.getTime();
            
            //Date hoy =new Date();
            
            //Calendar c2 =new GregorianCalendar();
            //c2.setTime(hoy);
            //c2.set(Calendar.HOUR_OF_DAY, 0);
            //c2.set(Calendar.MINUTE, 0);
            //c2.set(Calendar.SECOND, 0);
            //c2.set(Calendar.MILLISECOND, 0); 
            
            //Date y= c2.getTime();
            
            st.close();
            cn.close();
            
           
        }
        catch(Exception e){}
        return(mcaja);
    }
    
    
    public Boolean validaCajas(Integer mid_caja)
    {
         
        Cajas mcaja=null;
        Statement st;
        ResultSet rs;
        java.util.Date fecha =null;
        Boolean validafecha = false;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from cajas where id_caja='"+mid_caja+"'";
            rs=st.executeQuery(tsql);
            
                
            
            if(rs.next())
            {
                 
                mcaja=new Cajas(rs.getInt("id_caja"),rs.getDate("fecha"),rs.getInt("folio_inicial"),rs.getInt("folio_final"),rs.getString("poliza"),rs.getBigDecimal("monto_inicial"),rs.getInt("id_usuario"));
                
            }
            fecha=mcaja.getFecha();
            Calendar c =new GregorianCalendar();
            c.setTime(fecha);
            c.set(Calendar.HOUR_OF_DAY, 0);
            
            Date x= c.getTime();
            
            Date hoy =new Date();
            
            Calendar c2 =new GregorianCalendar();
            c2.setTime(hoy);
            c2.set(Calendar.HOUR_OF_DAY, 0);
            c2.set(Calendar.MINUTE, 0);
            c2.set(Calendar.SECOND, 0);
            c2.set(Calendar.MILLISECOND, 0); 
            
            Date y= c2.getTime();
            
            if (x.compareTo(y)==0)
            {
                validafecha=true;
            }
                
            
            st.close();
            cn.close();
            
           
        }
        catch(Exception e){}
        return(validafecha);
    }
    
    
    
    public boolean eliminaCajas(Integer mid_caja)
    {
         
        Cajas mcaja=null;
        Statement st;
        ResultSet rs,rsvalidamovedoscta,rsvalidamovdiversos;
        Boolean exito=false;
        String sql,sql2;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            
            sql="select * from mov_edoscta where id_caja='"+mid_caja+"'";
            rsvalidamovedoscta=st.executeQuery(sql);
            Boolean validamovedoscta = rsvalidamovedoscta.next();
            
            sql2="select * from mov_diversos where id_caja='"+mid_caja+"'";
            rsvalidamovdiversos=st.executeQuery(sql2);
            Boolean validamovdiversos = rsvalidamovdiversos.next();
            
            if (validamovedoscta==false  && validamovdiversos==false)
            {
                String tsql;
            
                tsql="delete from cajas where id_caja='"+mid_caja+"'";
                st.execute(tsql);
                exito=true;
            }
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(exito);
    }
    
    
    public Boolean modificaCajas(Cajas mcajas, User user)
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
            
            Integer id_usuario = user.getId_usuario();
            
            Integer id_caja = mcajas.getId_caja();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String fecha=sdf.format(mcajas.getFecha());
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            sql="select fecha from cajas where fecha='"+fecha+"' and id_caja<>'"+id_caja+"'";
            rsvalida=st.executeQuery(sql);
            Boolean valida = rsvalida.next();
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from cajas where id_caja='"+id_caja+"'";
            rs=st.executeQuery(tsql);
            
            if ((rs.next()) && (valida==false))
            {    
                tsql="update cajas set fecha='";
                tsql+=fecha+"',folio_inicial='"+mcajas.getFolio_inicial()+"', folio_final='"+mcajas.getFolio_final()+"', poliza='"+mcajas.getPoliza()+"', monto_inicial='"+mcajas.getMonto_inicial()+"' where id_caja='"+id_caja+"'";
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


