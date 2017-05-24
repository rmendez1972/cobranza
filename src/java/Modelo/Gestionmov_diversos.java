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


public class Gestionmov_diversos 
{
    
     public Gestionmov_diversos () 
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
    
    public Movdiversos ubicaMov_diversos(Integer id_movdiversos)
    {
         
        Movdiversos mov_diversos=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            
            
            tsql="select * from mov_diversos where id_movdiversos='"+id_movdiversos.toString()+"'";
            rs=st.executeQuery(tsql);
            
            //Mensaje y lo añade a la colección ArrayList
            if (rs.next())
            {
                 
                
                mov_diversos = new Movdiversos(rs.getInt("id_movdiversos"),rs.getInt("id_bendiv"),rs.getString("clave_div"),rs.getDate("fecha_div"),rs.getString("poliza"),rs.getInt("recibo"),rs.getBigDecimal("cargo"),rs.getBigDecimal("abono"),rs.getBigDecimal("moratorios"),rs.getBigDecimal("otros"),rs.getDate("fecha_pol"),rs.getString("estatus"),rs.getInt("id_usuario"),rs.getBoolean("aplicado"),rs.getString("descripcion"),rs.getInt("id_catprog"),rs.getBigDecimal("bonificacion"),rs.getString("serie"),rs.getString("poliza_apli"),rs.getDate("fecha_apli"),rs.getBigDecimal("interes"),rs.getBigDecimal("seguro"),rs.getInt("id_emisor"),rs.getString("clave_b"),rs.getString("numcontrato"));
                
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(mov_diversos);
    }
    
    
    public ArrayList localizaMov_diversos(String mclave_b)
    {
         
        ArrayList mmov_diversos=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            mmov_diversos=new ArrayList();
            
            tsql="select id_movdiversos,clave_div,fecha_div,poliza,recibo,cargo,abono,moratorios,otros,fecha_pol,estatus,aplicado,descripcion,bonificacion,serie,poliza_apli,fecha_apli,clave_b,descripcion from mov_diversos where clave_b='"+mclave_b+"'";
            rs=st.executeQuery(tsql);
            
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Movdiversos mov_diversos=new Movdiversos(rs.getInt("id_movdiversos"),rs.getString("clave_div"),rs.getDate("fecha_div"),rs.getString("poliza"),rs.getInt("recibo"),rs.getBigDecimal("cargo"),rs.getBigDecimal("abono"),rs.getBigDecimal("moratorios"),rs.getBigDecimal("otros"),rs.getDate("fecha_pol"),rs.getString("estatus"),rs.getBoolean("aplicado"),rs.getString("descripcion"),rs.getBigDecimal("bonificacion"),rs.getString("serie"),rs.getString("poliza_apli"),rs.getDate("fecha_apli"));
                mmov_diversos.add(mov_diversos);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(mmov_diversos);
    }
    
    
    
    public boolean eliminaMov_diversos(Integer mid_movdiversos)
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
            tsql="delete from mov_diversos where id_movdiversos="+mid_movdiversos.toString();
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
    
    
    public String grabaMov_diversos(Movdiversos mmovdiversos)
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
            
            String mid_catprog = mmovdiversos.getId_catprog().toString();
            String mnumcontrato=mmovdiversos.getNumcontrato();
            String mclave_div=mmovdiversos.getClave_div(); //convertimos a string un tipo date para poder concatenar el sql
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_div=sdf.format(mmovdiversos.getFecha_div());
            String mpoliza=mmovdiversos.getPoliza().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mrecibo=mmovdiversos.getRecibo().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mcargo=mmovdiversos.getCargo().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mabono=mmovdiversos.getAbono().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mmoratorios=mmovdiversos.getMoratorios().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String motros=mmovdiversos.getOtros().toString(); //convertimos a string un tipo date para poder concatenar el sql
            SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_pol=sdf2.format(mmovdiversos.getFecha_pol());
            String mpoliza_apli=mmovdiversos.getPoliza_apli().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mestatus=mmovdiversos.getEstatus().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            Boolean maplicado=mmovdiversos.getAplicado(); //convertimos a string un tipo date para poder concatenar el sql
            String mdescripcion=mmovdiversos.getDescripcion().toUpperCase();
            
            tsql2="select clave from cat_prog where id_catprog='"+mid_catprog+"'";
            rs=st.executeQuery(tsql2);
            if (rs.next())
            {
                String mclave=rs.getString("clave");
                mclave_b=mclave+"-"+mnumcontrato;
            }    
            
                tsql="Insert into  mov_diversos (id_catprog,numcontrato,clave_div,fecha_div,poliza,recibo,cargo,abono,moratorios,otros,fecha_pol,poliza_apli,estatus,aplicado,clave_b,descripcion) values('";
                tsql+=mid_catprog+"','"+mnumcontrato+"','"+mclave_div+"','"+mfecha_div+"','"+mpoliza+"','"+mrecibo+"','"+mcargo+"','"+mabono+"','"+mmoratorios+"','"+motros+"','"+mfecha_pol+"','"+mpoliza_apli+"','"+mestatus+"',"+maplicado+",'"+mclave_b+"','"+mdescripcion+"')";
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
    
    
    public Boolean modificaMovdiversos(Movdiversos mmovdiversos)
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
            
            String mid_movdiversos = mmovdiversos.getId_movdiversos().toString();
            String mid_bendiv=mmovdiversos.getId_bendiv().toString();
            String mclave_div=mmovdiversos.getClave_div(); //convertimos a string un tipo date para poder concatenar el sql
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_div=sdf.format(mmovdiversos.getFecha_div());
                        
            String mpoliza=mmovdiversos.getPoliza().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mrecibo=mmovdiversos.getRecibo().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mcargo=mmovdiversos.getCargo().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mabono=mmovdiversos.getAbono().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String mmoratorios=mmovdiversos.getMoratorios().toString(); //convertimos a string un tipo date para poder concatenar el sql
            String motros=mmovdiversos.getOtros().toString();
            
            SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
            String mfecha_pol=sdf2.format(mmovdiversos.getFecha_pol());
            String mpoliza_apli=mmovdiversos.getPoliza_apli().toUpperCase();
            String mestatus=mmovdiversos.getEstatus().toUpperCase();
            String maplicado=mmovdiversos.getAplicado().toString();
            String mdescripcion=mmovdiversos.getDescripcion().toUpperCase();
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from mov_diversos where id_movdiversos='"+mid_movdiversos+"'";
            rs=st.executeQuery(tsql);
            
            if (rs.next())
            {    
                tsql="update mov_diversos set clave_div='";
                tsql+=mclave_div+"',fecha_div='"+mfecha_div+"',poliza='"+mpoliza+"',recibo='"+mrecibo+"',cargo='"+mcargo+"',abono='"+mabono+"',moratorios='"+mmoratorios+"',otros='"+motros+"', fecha_pol='"+mfecha_pol+"', poliza_apli='"+mpoliza_apli+"', estatus='"+mestatus+"', aplicado="+maplicado+", descripcion='"+mdescripcion+"' where id_movdiversos='"+mid_movdiversos+"'";
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
