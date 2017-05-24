/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rafael Mendez
 */

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javabeans.Catprog;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;


public class Gestioncatprog 
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
    
    
    
    public ArrayList listarCatprog()
    {
         
        ArrayList catprogs=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_catprog,c.clave,c.descripcion,c.mecanica,c.sub_ini,c.eng_fon,c.eng_inv,c.interes,c.admon,c.seguro,c.costo_m2,c.por_sub,c.por_admon,c.por_sv,c.sub_bp,c.por_os,c.sal_min,c.pago_mes,c.por_eng,d.descripcion as delegacion,o.descripcion as colonia,c.anual,c.plazo,c.status,c.por_cap from cat_prog c left outer join delegaciones d on c.id_del=d.id_delegacion left outer join colonias o on c.id_colonia=o.id_colonia order by c.id_del,clave ";
            //tsql="select * from colonias order by id_delegacion,descripcion";
            rs=st.executeQuery(tsql);
            catprogs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            while(rs.next())
            {
                 
                //Catprog mcatprog=new Catprog(rs.getInt("idCatprog"), rs.getString("clave"), rs.getString("descripcion"), rs.getBigDecimal("sub_ini"), rs.getBigDecimal("eng_fon"), rs.getBigDecimal("eng_inv"), rs.getBigDecimal("interes"), rs.getBigDecimal("admon"), rs.getBigDecimal("seguro"), rs.getBigDecimal("costo_m2"), rs.getBigDecimal("por_sub"), rs.getBigDecimal("por_ga"), rs.getBigDecimal("por_sv"), rs.getBigDecimal("por_os"), rs.getBigDecimal("sal_min"), rs.getBigDecimal("pago_mes"), rs.getBigDecimal("por_eng"), rs.getBigDecimal("anual"), rs.getInt("plazo"), rs.getBigDecimal("por_cap"), rs.getBoolean("status"), rs.getInt("mecanica"), rs.getInt("id_del"), rs.getInt("id_tipocred"), rs.getBigDecimal("mensual"), rs.getBigDecimal("sub_bp"), rs.getBigDecimal("apor_fij"), rs.getBigDecimal("por_pm"), rs.getBigDecimal("por_pf"), rs.getString("clave_ant"), rs.getInt("id_colonia"), rs.getInt("dias_gracia"));
                Catprog mcatprog=new Catprog(rs.getInt("id_Catprog"),rs.getString("clave"),rs.getString("descripcion"),rs.getInt("mecanica"),rs.getBigDecimal("sub_ini"),rs.getBigDecimal("eng_fon"),rs.getBigDecimal("eng_inv"),rs.getBigDecimal("interes"),rs.getBigDecimal("admon"),rs.getBigDecimal("seguro"),rs.getBigDecimal("costo_m2"),rs.getBigDecimal("por_sub"),rs.getBigDecimal("por_admon"),rs.getBigDecimal("por_sv"),rs.getBigDecimal("sub_bp"),rs.getBigDecimal("por_os"),rs.getBigDecimal("sal_min"),rs.getBigDecimal("pago_mes"),rs.getBigDecimal("por_eng"),rs.getString("delegacion"),rs.getString("colonia"),rs.getBigDecimal("anual"),rs.getInt("plazo"),rs.getInt("status"),rs.getBigDecimal("por_cap"));
                //Colonias mcolonias=new Colonias(rs.getInt("id_colonia"),rs.getInt("id_delegacion"),rs.getString("descripcion"));
                catprogs.add(mcatprog);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){ e.printStackTrace();}
        return(catprogs);
    }
    
    
    public Catprog localizaCatprog(Integer mid_catprog)
    {
         
        Catprog mcatprog=null;
        Statement st;
        ResultSet rs;
        
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="select c.id_catprog,c.clave,c.descripcion,c.mecanica,c.sub_ini,c.eng_fon,c.eng_inv,c.interes,c.admon,c.seguro,c.costo_m2,c.por_sub,c.por_admon,c.por_sv,c.sub_bp,c.por_os,c.sal_min,c.pago_mes,c.por_eng,c.id_del,c.id_colonia,d.descripcion as delegacion,o.descripcion as colonia,c.anual,c.plazo,c.status,c.por_cap from cat_prog c left outer join delegaciones d on c.id_del=d.id_delegacion left outer join colonias o on c.id_colonia=o.id_colonia  where c.id_catprog="+mid_catprog.toString();
            rs=st.executeQuery(tsql);
            //clavemovs=new ArrayList();
            //para cada mensaje encontrado crea un objeto
            //Mensaje y lo añade a la colección ArrayList
            if(rs.next())
            {
                 
                mcatprog=new Catprog(rs.getInt("id_Catprog"),rs.getString("clave"),rs.getString("descripcion"),rs.getInt("mecanica"),rs.getBigDecimal("sub_ini"),rs.getBigDecimal("eng_fon"),rs.getBigDecimal("eng_inv"),rs.getBigDecimal("interes"),rs.getBigDecimal("admon"),rs.getBigDecimal("seguro"),rs.getBigDecimal("costo_m2"),rs.getBigDecimal("por_sub"),rs.getBigDecimal("por_admon"),rs.getBigDecimal("por_sv"),rs.getBigDecimal("sub_bp"),rs.getBigDecimal("por_os"),rs.getBigDecimal("sal_min"),rs.getBigDecimal("pago_mes"),rs.getBigDecimal("por_eng"),rs.getInt("id_del"),rs.getInt("id_colonia"),rs.getString("delegacion"),rs.getString("colonia"),rs.getBigDecimal("anual"),rs.getInt("plazo"),rs.getInt("status"),rs.getBigDecimal("por_cap"));
                //clavemovs.add(mclavemov);
            }
            st.close();
            cn.close();
           
        }
        catch(Exception e){e.printStackTrace();}
        return(mcatprog);
    }
    
   
    
    public boolean eliminaCatprog(Integer mid_catprog)
    {
         
        Catprog mcatprog=null;
        Statement st;
        ResultSet rs;
        Boolean exito=false;
        
        try
        {
            Connection cn=getConnection();
            st=cn.createStatement();
            String tsql;
            tsql="delete from cat_prog where id_catprog="+mid_catprog.toString();
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
    
    
    public Boolean grabaCatprog(Catprog mcatprog)
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
            
            
            String clave=mcatprog.getClave().toUpperCase();
            String descripcion=mcatprog.getDescripcion().toUpperCase(); //convertimos a string un tipo date para poder concatenar el sql
            String mecanica=mcatprog.getMecanica().toString();
            String sub_ini=mcatprog.getSub_ini().toString();
            String eng_fon=mcatprog.getEng_fon().toString();
            String eng_inv=mcatprog.getEng_inv().toString();
            String interes=mcatprog.getInteres().toString();
            String admon=mcatprog.getAdmon().toString();
            String seguro=mcatprog.getSeguro().toString();
            String costo_m2=mcatprog.getCosto_m2().toString();
            String por_sub=mcatprog.getPor_sub().toString();
            String por_admon=mcatprog.getPor_admon().toString();
            String por_sv=mcatprog.getPor_sv().toString();
            String sub_bp=mcatprog.getSub_bp().toString();
            String por_os=mcatprog.getPor_os().toString();
            String sal_min=mcatprog.getSal_min().toString();
            String pago_mes=mcatprog.getPago_mes().toString();
            String por_eng=mcatprog.getPor_eng().toString();
            String id_del=mcatprog.getId_del().toString();
            String id_colonia=mcatprog.getId_colonia().toString();
            String anual=mcatprog.getAnual().toString();
            String plazo=mcatprog.getPlazo().toString();
            String status=mcatprog.getStatus().toString();
            String por_cap=mcatprog.getPor_cap().toString();
            
            
            // verificamos q la clave de mov no exista ya en el catalogo
            tsql="select id_catprog,clave,descripcion from cat_prog where clave='"+clave+"'";
            rs=st.executeQuery(tsql);
            
            if (!rs.next())
            {    
                tsql="Insert into cat_prog (clave,descripcion,mecanica,sub_ini,eng_fon,eng_inv,interes,admon,seguro,costo_m2,por_sub,por_admon,por_sv,sub_bp,por_os,sal_min,pago_mes,por_eng,id_del,id_colonia,anual,plazo,status,por_cap) values('";
                tsql+=clave+"','"+descripcion+"','"+mecanica+"','"+sub_ini+"','"+eng_fon+"','"+eng_inv+"','"+interes+"','"+admon+"','"+seguro+"','"+costo_m2+"','"+por_sub+"','"+por_admon+"','"+por_sv+"','"+sub_bp+"','"+por_os+"','"+sal_min+"','"+pago_mes+"','"+por_eng+"','"+id_del+"','"+id_colonia+"','"+anual+"','"+plazo+"','"+status+"','"+por_cap+"')";
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
    
    
    
    public Boolean modificaCatprog(Catprog mcatprog)
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
            
            Integer id_catprog = mcatprog.getId_Catprog();
            String clave = mcatprog.getClave().toUpperCase();
            String descripcion = mcatprog.getDescripcion().toUpperCase();
            String mecanica=mcatprog.getMecanica().toString();
            String sub_ini=mcatprog.getSub_ini().toString();
            String eng_fon=mcatprog.getEng_fon().toString();
            String eng_inv=mcatprog.getEng_inv().toString();
            String interes=mcatprog.getInteres().toString();
            String admon=mcatprog.getAdmon().toString();
            String seguro=mcatprog.getSeguro().toString();
            String costo_m2=mcatprog.getCosto_m2().toString();
            String por_sub=mcatprog.getPor_sub().toString();
            String por_admon=mcatprog.getPor_admon().toString();
            String por_sv=mcatprog.getPor_sv().toString();
            String por_os=mcatprog.getPor_os().toString();
            String sub_bp=mcatprog.getSub_bp().toString();
            String sal_min=mcatprog.getSal_min().toString();
            String pago_mes=mcatprog.getPago_mes().toString();
            String por_eng=mcatprog.getPor_eng().toString();
            String anual=mcatprog.getAnual().toString();
            String plazo=mcatprog.getPlazo().toString();
            String status=mcatprog.getStatus().toString();
            String por_cap=mcatprog.getPor_cap().toString();
            
            Integer id_del = mcatprog.getId_del();
            Integer id_colonia = mcatprog.getId_colonia();
            
            // verificamos q la clavemov que queremos modificar no exista en el catalogo
            //sql="select clave,id_del from catprog where clave='"+clave+"' and id_del='"+id_del+"'";
            //rsvalida=st.executeQuery(sql);
            //Boolean valida = rsvalida.next();
            
            // verificamos q el id que estamos modificando exista en el catalogo
            tsql="select * from cat_prog where id_catprog='"+id_catprog.toString()+"'";
            rs=st.executeQuery(tsql);
            
            if (rs.next()) 
            {    
                tsql="update cat_prog set clave='";
                tsql+=clave+"',descripcion='"+descripcion+"',mecanica='"+mecanica+"',sub_ini='"+sub_ini+"',eng_fon='"+eng_fon+"',eng_inv='"+eng_inv+"',interes='"+interes+"',admon='"+admon+"',seguro='"+seguro+"',costo_m2='"+costo_m2+"',por_sub='"+por_sub+"',por_admon='"+por_admon+"',por_sv='"+por_sv+"',por_os='"+por_os+"',sub_bp='"+sub_bp+"',sal_min='"+sal_min+"',pago_mes='"+pago_mes+"',por_eng='"+por_eng+"',anual='"+anual+"',plazo='"+plazo+"',status='"+status+"',por_cap='"+por_cap+"',id_del='"+id_del+"',id_colonia='"+id_colonia+"' where id_catprog="+id_catprog;
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
