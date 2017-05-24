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
import javabeans.Aperturaedoscta;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.math.BigDecimal;


public class Gestionaperturaedoscta 
{
    
     public Gestionaperturaedoscta () {
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
    
    
    
    public ArrayList listarAperturaedoscta()
    {
         
        ArrayList aperturaedosctas=null;
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
    
    
    
    
    public Aperturaedoscta localizaAperturaedoscta(Integer mid_candidato)
    {
         
        Aperturaedoscta maperturaedoscta=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_candidato,c.id_catprog,c.numcontrato,c.clave_elect,c.curp,c.rfc,c.nombre,c.conyuge,c.fecha_cont,p.descripcion,c.mza,c.lte,c.area,c.domicilio,c.clave_cat,c.fecha_ip,c.capital,c.sub_inic,c.enganche,c.interes,c.admon,c.o_seg,c.sub_inf,c.por_eng,c.seguro,c.pagant,c.plazo,c.pago_mes,c.adm_seg,c.costo_m2,c.engacubrir,c.fecha_if,poliza,fecha_pol,clave_b from candidatos c left outer join cat_prog p on c.id_catprog=p.id_catprog where c.id_candidato="+mid_candidato.toString();
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                maperturaedoscta=new Aperturaedoscta(rs.getInt("id_candidato"),rs.getInt("id_catprog"),rs.getString("numcontrato"),rs.getString("clave_elect"),rs.getString("curp"),rs.getString("rfc"),rs.getString("nombre"),rs.getString("conyuge"),rs.getDate("fecha_cont"),rs.getString("descripcion"),rs.getString("mza"),rs.getString("lte"),rs.getBigDecimal("area"),rs.getString("domicilio"),rs.getString("clave_cat"),rs.getDate("fecha_ip"),rs.getBigDecimal("capital"),rs.getBigDecimal("sub_inic"),rs.getBigDecimal("enganche"),rs.getBigDecimal("interes"),rs.getBigDecimal("admon"),rs.getBigDecimal("o_seg"),rs.getBigDecimal("sub_inf"),rs.getBigDecimal("por_eng"),rs.getBigDecimal("seguro"),rs.getBigDecimal("pagant"),rs.getInt("plazo"),rs.getBigDecimal("pago_mes"),rs.getBigDecimal("adm_seg"),rs.getBigDecimal("costo_m2"),rs.getBigDecimal("engacubrir"),rs.getDate("fecha_if"),rs.getString("poliza"),rs.getDate("fecha_pol"),rs.getString("clave_b"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(maperturaedoscta);
    }
    
    
    
    public boolean eliminaAperturaedoscta(Integer mid_candidato)
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
    
    /*
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
    public Boolean modificaAperturaedoscta(Aperturaedoscta maperturaedoscta)
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
            
            String mid_candidato = maperturaedoscta.getId_candidato().toString();
            String mid_catprog=maperturaedoscta.getId_catprog().toString();
            String mnumcontrato=maperturaedoscta.getNumcontrato(); //convertimos a string un tipo date para poder concatenar el sql
            String mclave_elect=maperturaedoscta.getClave_elect().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mcurp=maperturaedoscta.getCurp().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mrfc=maperturaedoscta.getRfc().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mnombre=maperturaedoscta.getNombre().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mconyuge=maperturaedoscta.getConyuge().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_cont=sdf.format(maperturaedoscta.getFecha_cont());
            String mmza=maperturaedoscta.getMza().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mlte=maperturaedoscta.getLte().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String marea=maperturaedoscta.getArea().toString();
            String mdomicilio=maperturaedoscta.getDomicilio().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mclave_cat=maperturaedoscta.getClave_cat().toUpperCase();
            SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_ip=sdf2.format(maperturaedoscta.getFecha_ip());
            
            String mcapital=maperturaedoscta.getCapital().toString();
            String msub_inic=maperturaedoscta.getSub_inic().toString();
            String menganche=maperturaedoscta.getEnganche().toString();
            String minteres=maperturaedoscta.getInteres().toString();
            String madmon=maperturaedoscta.getAdmon().toString();
            String mo_seg=maperturaedoscta.getO_seg().toString();
            String msub_inf=maperturaedoscta.getSub_inf().toString();
            String mpor_eng=maperturaedoscta.getPor_eng().toString();
            String mseguro=maperturaedoscta.getSeguro().toString();
            String mpagant=maperturaedoscta.getPagant().toString();
            String mplazo = maperturaedoscta.getPlazo().toString();
            String mpago_mes = maperturaedoscta.getPago_mes().toString();
            String madm_seg = maperturaedoscta.getAdm_seg().toString();
            String mcosto_m2 = maperturaedoscta.getCosto_m2().toString();
            String mengacubrir = maperturaedoscta.getEngacubrir().toString();
            SimpleDateFormat sdf3= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_if=sdf3.format(maperturaedoscta.getFecha_if());
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            //sql="select id_catprog,numcontrato from candidatos where clave_div='"+clave_div+"' and descripcion='"+descripcion+"' and importe='"+importe+"'";
            //rsvalida=st.executeQuery(sql);
            //Boolean valida = rsvalida.next();
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from candidatos where id_candidato='"+mid_candidato+"'";
            rs=st.executeQuery(tsql);
            
            if (rs.next())
            {    
                tsql="update candidatos set id_catprog='";
                tsql+=mid_catprog+"',numcontrato='"+mnumcontrato+"',clave_elect='"+mclave_elect+"',curp='"+mcurp+"',rfc='"+mrfc+"',nombre='"+mnombre+"',conyuge='"+mconyuge+"',fecha_cont='"+mfecha_cont+"',mza='"+mmza+"',lte='"+mlte+"',area='"+marea+"',domicilio='"+mdomicilio+"',clave_cat='"+mclave_cat+"',fecha_ip='"+mfecha_ip+"',capital='"+mcapital+"',sub_inic='"+msub_inic+"',enganche='"+menganche+"',interes='"+minteres+"',admon='"+madmon+"',o_seg='"+mo_seg+"',sub_inf='"+msub_inf+"',por_eng='"+mpor_eng+"',seguro='"+mseguro+"',pagant='"+mpagant+"',plazo='"+mplazo+"',pago_mes='"+mpago_mes+"',adm_seg='"+madm_seg+"',costo_m2='"+mcosto_m2+"',engacubrir='"+mengacubrir+"',fecha_if='"+mfecha_if+"' where id_candidato='"+mid_candidato+"'";
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
