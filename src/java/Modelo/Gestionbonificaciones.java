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
import javabeans.Bonificaciones;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.math.BigDecimal;
import javabeans.Catprog;
import javabeans.Movdiversos;


public class Gestionbonificaciones 
{
    
     public Gestionbonificaciones () {
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
    public ArrayList listarBonific()
    {
         
        ArrayList bonifics=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select * from cat_bonific";
            rs=st.executeQuery(tsql);
            bonifics=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Bonific mbonific=new Bonific(rs.getString("clave_bonific"),rs.getString("descripcion"),rs.getInt("id_bonific"));
                bonifics.add(mbonific);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(bonifics);
    }
    */
    
    public Bonificaciones ubicaBonificaciones(Integer id_bonificacion)
    {
         
        Bonificaciones bonificaciones=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            
            
            tsql="select b.id_bonificacion,b.id_movedoscta,b.id_benef,b.imp_cap,b.imp_int,b.imp_adm,b.imp_seg,b.imp_osg,b.id_catbonific,b.estatus,b.id_usuario,b.id_autoriza,b.clave_b,b.recibo,b.serie,b.id_movdiversos,c.clave_bonific,c.descripcion,b.id_catprog,b.numcontrato from bonific b left outer join cat_bonific c on b.id_catbonific=c.id_bonific where id_bonificacion='"+id_bonificacion.toString()+"'";
            rs=st.executeQuery(tsql);
            
            //Mensaje y lo añade a la colección ArrayList
            if (rs.next())
            {
                 
                
                bonificaciones = new Bonificaciones(rs.getInt("id_bonificacion"),rs.getInt("id_movedoscta"),rs.getInt("id_benef"),rs.getBigDecimal("imp_cap"),rs.getBigDecimal("imp_int"),rs.getBigDecimal("imp_adm"),rs.getBigDecimal("imp_seg"),rs.getBigDecimal("imp_osg"),rs.getInt("id_catbonific"),rs.getString("estatus"),rs.getInt("id_usuario"),rs.getInt("id_autoriza"),rs.getString("clave_b"),rs.getInt("recibo"),rs.getString("serie"),rs.getInt("id_movdiversos"),rs.getString("clave_bonific"),rs.getString("descripcion"),rs.getInt("id_catprog"),rs.getString("numcontrato"));
                
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){}
        return(bonificaciones);
    }
    
    public ArrayList localizaBonificaciones(String mclave_b)
    {
         
        ArrayList mbonificaciones=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            mbonificaciones=new ArrayList();
            
            tsql="select b.id_bonificacion,b.id_movedoscta,b.id_benef,b.imp_cap,b.imp_int,b.imp_adm,b.imp_seg,b.imp_osg,b.id_catbonific,b.estatus,b.id_usuario,b.id_autoriza,b.clave_b,b.recibo,b.serie,b.id_movdiversos,c.clave_bonific,c.descripcion,b.id_catprog,b.numcontrato from bonific b left outer join cat_bonific c on b.id_catbonific=c.id_bonific  where b.clave_b='"+mclave_b+"'";
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                Bonificaciones bonificaciones=new Bonificaciones(rs.getInt("id_bonificacion"),rs.getInt("id_movedoscta"),rs.getInt("id_benef"),rs.getBigDecimal("imp_cap"),rs.getBigDecimal("imp_int"),rs.getBigDecimal("imp_adm"),rs.getBigDecimal("imp_seg"),rs.getBigDecimal("imp_osg"),rs.getInt("id_catbonific"),rs.getString("estatus"),rs.getInt("id_usuario"),rs.getInt("id_autoriza"),rs.getString("clave_b"),rs.getInt("recibo"),rs.getString("serie"),rs.getInt("id_movdiversos"),rs.getString("clave_bonific"),rs.getString("descripcion"),rs.getInt("id_catprog"),rs.getString("numcontrato"));
                mbonificaciones.add(bonificaciones);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(mbonificaciones);
    }
    
    
    
    public boolean eliminaBonificaciones(Integer mid_bonificacion)
    {
         
        Bonificaciones mbonificaciones=null;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="delete from bonific where id_bonificacion="+mid_bonificacion.toString();
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
     
    
    public String grabaBonificaciones(Bonificaciones mbonificaciones)
    {
        Connection cn;
        Statement st;
        Statement st2;
        ResultSet rs,rs2;
        Boolean exito=false;
        String mclave_b=null;
        
        
        try
        
        {
            
            cn=getConnection();
            st=cn.createStatement();
            st2=cn.createStatement();
            String tsql,tsql2;
            Catprog mcatprog=null;
            
            //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            String mid_catprog = mbonificaciones.getId_catprog().toString();
            String mid_catbonific = mbonificaciones.getId_catbonific().toString();
            String mrecibo = mbonificaciones.getRecibo().toString();
            String mserie = mbonificaciones.getSerie();
            String mimp_cap = mbonificaciones.getImp_cap().toString();
            String mimp_int = mbonificaciones.getImp_int().toString();
            String mimp_adm = mbonificaciones.getImp_adm().toString();
            String mimp_seg = mbonificaciones.getImp_seg().toString();
            String mimp_osg = mbonificaciones.getImp_osg().toString();
            String mestatus = mbonificaciones.getEstatus();
            String mnumcontrato = mbonificaciones.getNumcontrato();
            
            
            tsql2="select c.id_catprog,c.clave,c.descripcion,c.mecanica,c.sub_ini,c.eng_fon,c.eng_inv,c.interes,c.admon,c.seguro,c.costo_m2,c.por_sub,c.por_admon,c.por_sv,c.sub_bp,c.por_os,c.sal_min,c.pago_mes,c.por_eng,c.id_del,c.id_colonia,d.descripcion as delegacion,o.descripcion as colonia,c.anual,c.plazo,c.status,c.por_cap from cat_prog c left outer join delegaciones d on c.id_del=d.id_delegacion left outer join colonias o on c.id_colonia=o.id_colonia  where c.id_catprog="+mid_catprog.toString();
            rs2=st2.executeQuery(tsql2);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs2.next())
            {
                 
                mcatprog=new Catprog(rs2.getInt("id_Catprog"),rs2.getString("clave"),rs2.getString("descripcion"),rs2.getInt("mecanica"),rs2.getBigDecimal("sub_ini"),rs2.getBigDecimal("eng_fon"),rs2.getBigDecimal("eng_inv"),rs2.getBigDecimal("interes"),rs2.getBigDecimal("admon"),rs2.getBigDecimal("seguro"),rs2.getBigDecimal("costo_m2"),rs2.getBigDecimal("por_sub"),rs2.getBigDecimal("por_admon"),rs2.getBigDecimal("por_sv"),rs2.getBigDecimal("sub_bp"),rs2.getBigDecimal("por_os"),rs2.getBigDecimal("sal_min"),rs2.getBigDecimal("pago_mes"),rs2.getBigDecimal("por_eng"),rs2.getInt("id_del"),rs2.getInt("id_colonia"),rs2.getString("delegacion"),rs2.getString("colonia"),rs2.getBigDecimal("anual"),rs2.getInt("plazo"),rs2.getInt("status"),rs2.getBigDecimal("por_cap"));
                //clavemovs.add(mclavemov);
            }
            String mclave=mcatprog.getClave();
            
            mclave_b=mclave+"-"+mnumcontrato;
            
            // verificamos q la clave de mov no exista ya en el catalogo
            tsql="select id_catbonific,numcontrato from bonific where id_catbonific='"+mid_catbonific+"' and numcontrato='"+mnumcontrato+"' and recibo='"+mrecibo+"'";
            rs=st.executeQuery(tsql);
            
            if (!rs.next())
            {    
                tsql="Insert into bonific (id_catprog,numcontrato,id_catbonific,clave_b,imp_cap,imp_int,imp_adm,imp_seg,imp_osg,estatus,recibo,serie) values('";
                tsql+=mid_catprog+"','"+mnumcontrato+"','"+mid_catbonific+"','"+mclave_b+"','"+mimp_cap+"','"+mimp_int+"','"+mimp_adm+"','"+mimp_seg+"','"+mimp_osg+"','"+mestatus+"','"+mrecibo+"','"+mserie+"')";
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
        return (mclave_b);
    }
    
    
    public Boolean modificaBonificaciones(Bonificaciones mbonificaciones)
    {
        Connection cn;
        Statement st;
        ResultSet rs,rsvalida;
        Boolean exito=false;
        
        
        try
        
        {
            cn=getConnection();
            st=cn.createStatement();
            String tsql,tsql2;
            String sql;
            
            //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            
            String mid_bonificacion = mbonificaciones.getId_bonificacion().toString();
            String mid_catbonific = mbonificaciones.getId_catbonific().toString();
            String mrecibo = mbonificaciones.getRecibo().toString();
            String mserie = mbonificaciones.getSerie();
            String mimp_cap = mbonificaciones.getImp_cap().toString();
            String mimp_int = mbonificaciones.getImp_int().toString();
            String mimp_adm = mbonificaciones.getImp_adm().toString();
            String mimp_seg = mbonificaciones.getImp_seg().toString();
            String mimp_osg = mbonificaciones.getImp_osg().toString();
            String mestatus = mbonificaciones.getEstatus();
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            
            
            
            
            tsql="select * from bonific where id_bonificacion='"+mid_bonificacion+"'";
            rs=st.executeQuery(tsql);
            
            if (rs.next())
            {    
                tsql="update bonific set id_catbonific='";
                tsql+=mid_catbonific+"',recibo='"+mrecibo+"',serie='"+mserie+"',imp_cap='"+mimp_cap+"',imp_int='"+mimp_int+"',imp_adm='"+mimp_adm+"',imp_seg='"+mimp_seg+"',imp_osg='"+mimp_osg+"', estatus='"+mestatus+"' where id_bonificacion='"+mid_bonificacion+"'";
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
