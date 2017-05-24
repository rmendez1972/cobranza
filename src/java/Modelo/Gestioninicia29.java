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
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.Date;


public class Gestioninicia29 
{
    
     public Gestioninicia29 () {
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
    
    public void aperturaedoctamec29(Integer mid_benef,String mclave_b, BigDecimal msub_inic, BigDecimal mcosto_m2, BigDecimal marea, BigDecimal mengancheacubrir, String mpoliza, String mfecha_pol, BigDecimal mpagosant )
    {
        Connection cn;
           
        try
        
        {
            cn=getConnection();
                     
            // acumulamos todos los pagos realizados de enganche (E02) en mov_diversos
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = cn.prepareCall(" CALL sp_aperturaedoctamec29(?,?,?,?,?,?,?,?,?) ");
            //se cargan los parametros de entrada
            proc.setInt("id_benef", mid_benef);
            proc.setString("clave_b", mclave_b);
            proc.setBigDecimal("sub_inic", msub_inic);
            proc.setBigDecimal("costo_m2", mcosto_m2);
            proc.setBigDecimal("area", marea);
            proc.setBigDecimal("engancheacubrir", mengancheacubrir);
            proc.setString("poliza", mpoliza);
            proc.setString("fecha_mov", mfecha_pol);
            proc.setBigDecimal("pagosant", mpagosant);
            
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
                              
            
            cn.close();
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    
    public void aplicadivenganche(String mclave_b, Date mfecha, String mpoliza, BigDecimal msuma )
    {
        Connection cn;
           
        try
        
        {
            cn=getConnection();
                     
            // acumulamos todos los pagos realizados de enganche (E02) en mov_diversos
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = cn.prepareCall(" CALL sp_aplicaengdiv(?,?,?,?) ");
            //se cargan los parametros de entrada
            proc.setString("clave", mclave_b);
            proc.setString("fecha", mfecha.toString());
            proc.setString("poliza", mpoliza);
            proc.setString("suma", msuma.toString());
            
            // parametros de salida
            //proc.registerOutParameter("suma", Types.DECIMAL);//Tipo decimal
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            //sumaenganche = proc.getBigDecimal("suma");
                      
            
            cn.close();
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    public BigDecimal sumaenganche(String mclave_b)
    {
        Connection cn;
        Statement st;
        ResultSet rs,rs2,rsvalida;
        BigDecimal sumaenganche=null;
        
        
        try
        
        {
            cn=getConnection();
            st=cn.createStatement();
            String tsql,tsql2;
            String sql;
            
            
                      
            // acumulamos todos los pagos realizados de enganche (E02) en mov_diversos
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = cn.prepareCall(" CALL sp_sumadivenganche(?,?) ");
            //se cargan los parametros de entrada
            proc.setString("clave_b", mclave_b);//Tipo String
            
            // parametros de salida
            proc.registerOutParameter("suma", Types.DECIMAL);//Tipo decimal
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            sumaenganche = proc.getBigDecimal("suma");
                      
                        
                                  
            st.close();
            cn.close();
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return (sumaenganche);
    }
     
    
}
