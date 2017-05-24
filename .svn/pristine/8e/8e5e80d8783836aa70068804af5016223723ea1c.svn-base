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


public class Gestioniniciamec29 
{
    
     public Gestioniniciamec29 () {
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
    
    
    
    
    public Boolean Aperturaedoscta(Aperturaedoscta maperturaedoscta)
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
