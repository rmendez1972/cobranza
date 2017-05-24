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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.math.BigDecimal;

import javabeans.Benef_div;
import javabeans.Movdiversos;
import javabeans.Movedoscta;


public class Gestionmov_edoscta 
{
    
     public Gestionmov_edoscta () 
     {
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
    */
    
    public Movedoscta ubicaMov_edoscta(Integer id_movedoscta)
    {
         
        Movedoscta mov_edoscta=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            
            
            tsql="select * from mov_edoscta where id_movedoscta='"+id_movedoscta.toString()+"'";
            rs=st.executeQuery(tsql);
            
            //Mensaje y lo añade a la colección ArrayList
            if (rs.next())
            {
                 
                
                mov_edoscta = new Movedoscta(rs.getInt("id_movedoscta"),rs.getInt("id_benef"),rs.getString("clave_mov"),rs.getDate("fecha_mov"),rs.getString("poliza"),rs.getInt("recibo"),rs.getBigDecimal("capital"),rs.getBigDecimal("interes"),rs.getBigDecimal("admon"),rs.getBigDecimal("seguro"),rs.getBigDecimal("o_seg"),rs.getBigDecimal("moratorios"),rs.getBigDecimal("otrosm"),rs.getBigDecimal("comisiones"),rs.getBigDecimal("tit"),rs.getDate("fecha_pol"),rs.getString("estatus"),rs.getInt("id_usuario"),rs.getString("serie"),rs.getBoolean("puntual"),rs.getInt("id_bonific"),rs.getString("clave_b"),rs.getInt("id_catprog"),rs.getString("numcontrato"));
                
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(mov_edoscta);
    }
    
    
    public ArrayList localizaMov_edoscta(String mclave_b)
    {
         
        ArrayList mmov_edoscta=null;
        Statement st;
        ResultSet rs;
        Movedoscta movedoscta;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            mmov_edoscta=new ArrayList();
            
            
            tsql="select id_movedoscta,clave_mov,fecha_mov,poliza,recibo,capital,interes,admon,seguro,o_seg,comisiones,tit,moratorios,otrosm,estatus,serie,clave_b from mov_edoscta where clave_b='"+mclave_b+"'";
            rs=st.executeQuery(tsql);
            
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                movedoscta=new Movedoscta(rs.getInt("id_movedoscta"),rs.getString("clave_mov"),rs.getDate("fecha_mov"),rs.getString("poliza"),rs.getInt("recibo"),rs.getBigDecimal("capital"),rs.getBigDecimal("interes"),rs.getBigDecimal("admon"),rs.getBigDecimal("seguro"),rs.getBigDecimal("o_seg"),rs.getBigDecimal("comisiones"),rs.getBigDecimal("tit"),rs.getBigDecimal("moratorios"),rs.getBigDecimal("otrosm"),rs.getString("estatus"),rs.getString("serie"),rs.getString("clave_b"));
                mmov_edoscta.add(movedoscta);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(mmov_edoscta);
    }
    
    
    
    public boolean eliminaMov_edoscta(Integer mid_movedoscta)
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
            tsql="delete from mov_edoscta where id_movedoscta="+mid_movedoscta.toString();
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
    
    
    public String grabaMov_edoscta(Movedoscta mmovedoscta)
    {
        Connection cn;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        String mclave_b=null;
        
        
        try
        
        {
            cn=getConnection();
            st=cn.createStatement();
            String tsql,tsql2;
            
            //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            String mid_catprog = mmovedoscta.getId_catprog().toString();
            String mnumcontrato=mmovedoscta.getNumcontrato();
            String mclave_mov=mmovedoscta.getClave_mov(); //convertimos a string un tipo date para poder concatenar el sql
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_mov=sdf.format(mmovedoscta.getFecha_mov());
            String mpoliza=mmovedoscta.getPoliza().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mrecibo=mmovedoscta.getRecibo().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mcapital=mmovedoscta.getCapital().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String minteres=mmovedoscta.getInteres().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String madmon=mmovedoscta.getAdmon().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mseguro=mmovedoscta.getSeguro().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mo_seg=mmovedoscta.getO_seg().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mcomisiones=mmovedoscta.getComisiones().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mmoratorios=mmovedoscta.getMoratorios().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mtit=mmovedoscta.getTit().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mestatus=mmovedoscta.getEstatus().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mserie=mmovedoscta.getSerie().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            
            tsql2="select clave from cat_prog where id_catprog='"+mid_catprog+"'";
            rs=st.executeQuery(tsql2);
            if (rs.next())
            {
                String mclave=rs.getString("clave");
                mclave_b=mclave+"-"+mnumcontrato;
            }    
            
                tsql="Insert into  mov_edoscta (id_catprog,numcontrato,clave_mov,fecha_mov,poliza,recibo,capital,interes,admon,seguro,o_seg,comisiones,tit,estatus,serie,moratorios,clave_b) values('";
                tsql+=mid_catprog+"','"+mnumcontrato+"','"+mclave_mov+"','"+mfecha_mov+"','"+mpoliza+"','"+mrecibo+"','"+mcapital+"','"+minteres+"','"+madmon+"','"+mseguro+"','"+mo_seg+"','"+mcomisiones+"','"+mtit+"','"+mestatus+"','"+mserie+"','"+mmoratorios+"','"+mclave_b+"')";
                st.execute(tsql);
                exito=true;
            
            st.close();
            cn.close();
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return (mclave_b);
    }
    
    
    public Boolean modificaMovedoscta(Movedoscta mmovedoscta)
    {
        Connection cn;
        Statement st;
        ResultSet rs,rs2,rsvalida;
        Boolean exito=false;
        String mclave_b=null ;
        
        
        try
        
        {
            cn=getConnection();
            st=cn.createStatement();
            String tsql,tsql2;
            String sql,sql2;
            
            //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            String mid_movedoscta = mmovedoscta.getId_movedoscta().toString();
            
            String mclave_mov=mmovedoscta.getClave_mov(); //convertimos a string un tipo date para poder concatenar el sql
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_mov=sdf.format(mmovedoscta.getFecha_mov());
                        
            String mpoliza=mmovedoscta.getPoliza().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mrecibo=mmovedoscta.getRecibo().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mcapital=mmovedoscta.getCapital().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String minteres=mmovedoscta.getInteres().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String madmon=mmovedoscta.getAdmon().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mseguro=mmovedoscta.getSeguro().toString();
            String mo_seg=mmovedoscta.getO_seg().toString();
            String mmoratorios=mmovedoscta.getMoratorios().toString();
            String mcomisiones=mmovedoscta.getComisiones().toString();
            String mtit=mmovedoscta.getTit().toString();
            String mestatus=mmovedoscta.getEstatus().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mserie=mmovedoscta.getSerie().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mnumcontrato=mmovedoscta.getNumcontrato().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mid_catprog = mmovedoscta.getId_catprog().toString();
            
            tsql2="select clave from cat_prog where id_catprog='"+mid_catprog+"'";
            rs2=st.executeQuery(tsql2);
            if (rs2.next())
            {
                String mclave=rs2.getString("clave");
                mclave_b=mclave+"-"+mnumcontrato;
            }
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from mov_edoscta where id_movedoscta='"+mid_movedoscta+"'";
            rs=st.executeQuery(tsql);
            
            if (rs.next())
            {    
                tsql="update mov_edoscta set clave_mov='";
                tsql+=mclave_mov+"',fecha_mov='"+mfecha_mov+"',poliza='"+mpoliza+"',recibo='"+mrecibo+"',capital='"+mcapital+"',interes='"+minteres+"',admon='"+madmon+"',seguro='"+mseguro+"',o_seg='"+mo_seg+"',moratorios='"+mmoratorios+"',comisiones='"+mcomisiones+"',tit='"+mtit+"', estatus='"+mestatus+"', serie='"+mserie+"', numcontrato='"+mnumcontrato+"', id_catprog='"+mid_catprog+"', clave_b='"+mclave_b+"' where id_movedoscta='"+mid_movedoscta+"'";
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
