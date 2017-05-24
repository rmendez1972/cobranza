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
import javabeans.Iniciaedocta;
import javabeans.Aperturaedoscta;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.math.BigDecimal;


public class Gestioniniciaedocta 
{
    
     public Gestioniniciaedocta () {
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
    
    
    /*
    public ArrayList listarInicioedoscta()
    {
         
        ArrayList iniciaedocta=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_candidato,c.id_catprog,c.numcontrato,c.clave_elect,c.curp,c.rfc,c.nombre,c.conyuge,c.fecha_cont,p.descripcion,c.mza,c.lte,c.area,c.domicilio,c.clave_cat,c.fecha_ip,c.capital,c.sub_inic,c.enganche,c.interes,c.admon,c.o_seg,c.sub_inf,c.por_eng,c.seguro,c.pagant,c.plazo,c.pago_mes,c.adm_seg,c.costo_m2,c.engacubrir,c.fecha_if from candidatos c left outer join cat_prog p on c.id_catprog=p.id_catprog";
            rs=st.executeQuery(tsql);
            aperturaedosctas=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Aperturaedoscta maperturaedoscta=new Aperturaedoscta(rs.getInt("id_candidato"),rs.getInt("id_catprog"),rs.getString("numcontrato"),rs.getString("clave_elect"),rs.getString("curp"),rs.getString("rfc"),rs.getString("nombre"),rs.getString("conyuge"),rs.getDate("fecha_cont"),rs.getString("descripcion"),rs.getString("mza"),rs.getString("lte"),rs.getBigDecimal("area"),rs.getString("domicilio"),rs.getString("clave_cat"),rs.getDate("fecha_ip"),rs.getBigDecimal("capital"),rs.getBigDecimal("sub_inic"),rs.getBigDecimal("enganche"),rs.getBigDecimal("interes"),rs.getBigDecimal("admon"),rs.getBigDecimal("o_seg"),rs.getBigDecimal("sub_inf"),rs.getBigDecimal("por_eng"),rs.getBigDecimal("seguro"),rs.getBigDecimal("pagant"),rs.getInt("plazo"),rs.getBigDecimal("pago_mes"),rs.getBigDecimal("adm_seg"),rs.getBigDecimal("costo_m2"),rs.getBigDecimal("engacubrir"),rs.getDate("fecha_if"));
                aperturaedosctas.add(maperturaedoscta);  // array de beans
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e)
        { 
            e.printStackTrace();
        }
        return(aperturaedosctas);
    }
    
    
    
    
    public Iniciaedocta localizaIniciaedocta(Integer mid_candidato)
    {
         
        Iniciaedocta miniciaedocta=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_candidato,c.id_catprog,c.numcontrato,c.clave_elect,c.curp,c.rfc,c.nombre,c.conyuge,c.fecha_cont,p.descripcion,c.mza,c.lte,c.area,c.domicilio,c.clave_cat,c.fecha_ip,c.capital,c.sub_inic,c.enganche,c.interes,c.admon,c.o_seg,c.sub_inf,c.por_eng,c.seguro,c.pagant,c.plazo,c.pago_mes,c.adm_seg,c.costo_m2,c.engacubrir,c.fecha_if from candidatos c left outer join cat_prog p on c.id_catprog=p.id_catprog where c.id_candidato="+mid_candidato.toString();
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                maperturaedoscta=new Aperturaedoscta(rs.getInt("id_candidato"),rs.getInt("id_catprog"),rs.getString("numcontrato"),rs.getString("clave_elect"),rs.getString("curp"),rs.getString("rfc"),rs.getString("nombre"),rs.getString("conyuge"),rs.getDate("fecha_cont"),rs.getString("descripcion"),rs.getString("mza"),rs.getString("lte"),rs.getBigDecimal("area"),rs.getString("domicilio"),rs.getString("clave_cat"),rs.getDate("fecha_ip"),rs.getBigDecimal("capital"),rs.getBigDecimal("sub_inic"),rs.getBigDecimal("enganche"),rs.getBigDecimal("interes"),rs.getBigDecimal("admon"),rs.getBigDecimal("o_seg"),rs.getBigDecimal("sub_inf"),rs.getBigDecimal("por_eng"),rs.getBigDecimal("seguro"),rs.getBigDecimal("pagant"),rs.getInt("plazo"),rs.getBigDecimal("pago_mes"),rs.getBigDecimal("adm_seg"),rs.getBigDecimal("costo_m2"),rs.getBigDecimal("engacubrir"),rs.getDate("fecha_if"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(maperturaedoscta);
    }
    
    
    /*
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
    
     
    
    
    public Boolean grabaCandidatos(Candidatos mcandidatos)
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
            
            String mid_catprog=mcandidatos.getId_catprog().toString();
            String mnumcontrato=mcandidatos.getNumcontrato(); //convertimos a string un tipo date para poder concatenar el sql
            String mclave_elect=mcandidatos.getClave_elect().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mcurp=mcandidatos.getCurp().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mrfc=mcandidatos.getRfc().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mnombre=mcandidatos.getNombre().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mconyuge=mcandidatos.getConyuge().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_cont=sdf.format(mcandidatos.getFecha_cont());
            String mmza=mcandidatos.getMza().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mlte=mcandidatos.getLte().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mdomicilio=mcandidatos.getDomicilio().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            
            // verificamos q la clave de mov no exista ya en el catalogo
            tsql="select id_catprog,numcontrato from candidatos where id_catprog='"+mid_catprog+"' and numcontrato='"+mnumcontrato+"'";
            rs=st.executeQuery(tsql);
            
            if (!rs.next())
            {    
                tsql="Insert into  candidatos (id_catprog,numcontrato,clave_elect,curp,rfc,nombre,conyuge,fecha_cont,mza,lte,domicilio) values('";
                tsql+=mid_catprog+"','"+mnumcontrato+"','"+mclave_elect+"','"+mcurp+"','"+mrfc+"','"+mnombre+"','"+mconyuge+"','"+mfecha_cont+"','"+mmza+"','"+mlte+"','"+mdomicilio+"')";
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
    public Boolean modificaIniciaedocta(Iniciaedocta miniciaedocta)
    {
        Connection cn;
        Statement st,st2;
        ResultSet rs,rs2,rsvalida;
        Boolean exito=false;
        
        
        try
        
        {
            cn=getConnection();
            st=cn.createStatement();
            st2=cn.createStatement();
            String tsql,tsql2;
            String sql,sql2;
            
            //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            String mid_candidato = miniciaedocta.getId_candidato().toString();
            String mpoliza=miniciaedocta.getPoliza(); //convertimos a string un tipo date para poder concatenar el sql
                        
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_poliza=sdf.format(miniciaedocta.getFecha_poliza());
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            //sql="select id_catprog,numcontrato from candidatos where clave_div='"+clave_div+"' and descripcion='"+descripcion+"' and importe='"+importe+"'";
            //rsvalida=st.executeQuery(sql);
            //Boolean valida = rsvalida.next();
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from candidatos where id_candidato='"+mid_candidato+"'";
            rs=st.executeQuery(tsql);
            
            if (rs.next())
            {    
                tsql="update candidatos set poliza='";
                tsql+=mpoliza+"',fecha_pol='"+mfecha_poliza+"' where id_candidato='"+mid_candidato+"'";
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
