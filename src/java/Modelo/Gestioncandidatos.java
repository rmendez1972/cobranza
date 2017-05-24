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
import javabeans.Candidatos;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.math.BigDecimal;


public class Gestioncandidatos 
{
    
     public Gestioncandidatos () {
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
    
    
    
    public ArrayList listarCandidatos()
    {
         
        ArrayList candidatoss=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_candidato,c.id_catprog,c.numcontrato,c.clave_elect,c.curp,c.rfc,c.nombre,c.conyuge,c.fecha_cont,p.descripcion,c.mza,c.lte,c.area,c.domicilio,c.clave_cat,c.fecha_ip from candidatos c left outer join cat_prog p on c.id_catprog=p.id_catprog";
            rs=st.executeQuery(tsql);
            candidatoss=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Candidatos mcandidatos=new Candidatos(rs.getInt("id_candidato"),rs.getInt("id_catprog"),rs.getString("numcontrato"),rs.getString("clave_elect"),rs.getString("curp"),rs.getString("rfc"),rs.getString("nombre"),rs.getString("conyuge"),rs.getDate("fecha_cont"),rs.getString("descripcion"),rs.getString("mza"),rs.getString("lte"),rs.getBigDecimal("area"),rs.getString("domicilio"),rs.getString("clave_cat"),rs.getDate("fecha_ip"));
                candidatoss.add(mcandidatos);  // array de beans
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e)
        { 
            e.printStackTrace();
        }
        return(candidatoss);
    }
    
    
    
    
    public Candidatos localizaCandidatos(Integer mid_candidato)
    {
         
        Candidatos mcandidatos=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_candidato,c.id_catprog,c.numcontrato,c.clave_elect,c.curp,c.rfc,c.nombre,c.conyuge,c.fecha_cont,p.descripcion,c.mza,c.lte,c.domicilio,c.clave_cat,c.fecha_cont from candidatos c left outer join cat_prog p on c.id_catprog=p.id_catprog where c.id_candidato="+mid_candidato.toString();
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                mcandidatos=new Candidatos(rs.getInt("id_candidato"),rs.getInt("id_catprog"),rs.getString("numcontrato"),rs.getString("clave_elect"),rs.getString("curp"),rs.getString("rfc"),rs.getString("nombre"),rs.getString("conyuge"),rs.getDate("fecha_cont"),rs.getString("descripcion"),rs.getString("mza"),rs.getString("lte"),rs.getBigDecimal("area"),rs.getString("domicilio"),rs.getString("clave_cat"),rs.getDate("fecha_ip"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(mcandidatos);
    }
    
    
    
    public boolean eliminaCandidato(Integer mid_candidato)
    {
         
        //Candidatos mcandidato=null;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="delete from candidatos where id_candidato="+mid_candidato.toString();
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
    
    public Boolean grabaCandidatos(Candidatos mcandidatos)
    {
        Connection cn;
        Statement st,st2;
        ResultSet rs,rs2;
        Boolean exito=false;
        
        
        try
        
        {
            cn=getConnection();
            st=cn.createStatement();
            st2=cn.createStatement();
            String tsql,tsql2;
            String mclave_b=null;
            
            //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            String mid_catprog=mcandidatos.getId_catprog().toString();
            String mnumcontrato=mcandidatos.getNumcontrato(); //convertimos a string un tipo date para poder concatenar el sql
            String mclave_elect=mcandidatos.getClave_elect().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mcurp=mcandidatos.getCurp().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mrfc=mcandidatos.getRfc().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mnombre=mcandidatos.getNombre().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mconyuge=mcandidatos.getConyuge().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            /*String mcapital=mcandidatos.getCapital().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String msub_inic=mcandidatos.getSub_inic().toString(); //convertimos a string un tipo date para poder concatenar el sql 
            String menganche=mcandidatos.getEnganche().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String minteres=mcandidatos.getInteres().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String madmon=mcandidatos.getAdmon().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mo_seg=mcandidatos.getO_seg().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String msub_inf=mcandidatos.getSub_inf().toString(); //convertimos a string un tipo date para poder concatenar el sql*/
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_cont=sdf.format(mcandidatos.getFecha_cont());
            String mmza=mcandidatos.getMza().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mlte=mcandidatos.getLte().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String marea=mcandidatos.getArea().toString();
            String mdomicilio=mcandidatos.getDomicilio().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mclave_cat=mcandidatos.getClave_cat().toUpperCase();
            SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_ip=sdf2.format(mcandidatos.getFecha_ip());
            
            tsql2="select clave from cat_prog where id_catprog='"+mid_catprog+"'";
            rs2=st2.executeQuery(tsql2);
            if(rs2.next())
            {
                String mclave=rs2.getString("clave"); //convertimos a string un tipo date para poder concatenar el sql
                mclave_b=mclave+"-"+mnumcontrato;
            }   
            
            // verificamos q la clave de mov no exista ya en el catalogo
            tsql="select id_catprog,numcontrato from candidatos where id_catprog='"+mid_catprog+"' and numcontrato='"+mnumcontrato+"'";
            rs=st.executeQuery(tsql);
            
            if (!rs.next())
            {    
                tsql="Insert into  candidatos (id_catprog,numcontrato,clave_elect,curp,rfc,nombre,conyuge,fecha_cont,mza,lte,area,domicilio,clave_cat,fecha_ip,clave_b) values('";
                tsql+=mid_catprog+"','"+mnumcontrato+"','"+mclave_elect+"','"+mcurp+"','"+mrfc+"','"+mnombre+"','"+mconyuge+"','"+mfecha_cont+"','"+mmza+"','"+mlte+"','"+marea+"','"+mdomicilio+"','"+mclave_cat+"','"+mfecha_ip+"','"+mclave_b+"')";
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
    
    /*
    public Boolean modificaCandidatos(Candidatos mcandidato)
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
            
            Integer id_clave_div = mcandidato.getId_clave_div();
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
     */
    
}
