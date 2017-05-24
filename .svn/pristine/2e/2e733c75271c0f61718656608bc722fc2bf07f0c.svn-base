/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestioncatprog;
import Modelo.Gestionmecanica;
import Modelo.Gestiondelegaciones;
import Modelo.Gestioncolonias;
import Modelo.Gestionmecanica;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabeans.Catprog;
import javabeans.Delegaciones;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Rafael Mendez
 */
@WebServlet(name = "Controladorcatprog", urlPatterns = {"/controladorcatprog"})
public class Controladorcatprog extends HttpServlet 
{
    public Controladorcatprog () {
        super();
    }
    public Connection cn;
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        //almacena la operacion que debe gestionar el controlador
        String operacion=request.getParameter("operacion");
        
        //el controlador redirecciona al formulario de captura de cpp
        if(operacion.equals("capturar"))
        {
            Gestionmecanica oper=new Gestionmecanica();
            ArrayList mecanicas=oper.listarmecanica();
            
            request.setAttribute("mecanicas",mecanicas);
            //request.setAttribute("exito",false);
            
            RequestDispatcher rd=request.getRequestDispatcher("frmcatprog.jsp");
            rd.forward(request,response);
        }
        
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("grabar"))
        {
          Boolean resultado;
          Catprog mcatprog;   //variable tipo Clavemov en la q recibo el javabean
          mcatprog = (Catprog)request.getAttribute("catprog");  //cast para convertir de tipo object a tipo Cpp el javabean
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncatprog oper=new Gestioncatprog(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.grabaCatprog(mcatprog); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          //response.sendRedirect("inicio.html"); //despues de realizar la accion en el modelo redirecciono al menu
          ArrayList catprogs=oper.listarCatprog();
          request.setAttribute("catprogs",catprogs);
          
            
          RequestDispatcher rd=request.getRequestDispatcher("listarcatprog.jsp");
          rd.forward(request,response);
        }
        
        
        //modifica un catprog
        if(operacion.equals("modificar"))
        {
          Boolean resultado;
          Catprog mcatprog;   //variable tipo Clavemov en la q recibo el javabean
          mcatprog = (Catprog)request.getAttribute("catprog");  //cast para convertir de tipo object a tipo Cpp el javabean
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncatprog oper=new Gestioncatprog(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.modificaCatprog(mcatprog); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          //response.sendRedirect("inicio.html"); //despues de realizar la accion en el modelo redirecciono al menu
          ArrayList catprogs=oper.listarCatprog();
          request.setAttribute("catprogs",catprogs);
          
            
          RequestDispatcher rd=request.getRequestDispatcher("listarcatprog.jsp");
          rd.forward(request,response);
        }
        
        
        //modificacion de una condicion financiera
        if(operacion.equals("localizar"))
        {
          Catprog catprogs;
          String midCatprog;   //variable tipo Clavemov en la q recibo el javabean
          midCatprog = request.getParameter("id_catprog");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_catprog;
          mid_catprog=Integer.parseInt(midCatprog);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncatprog oper=new Gestioncatprog(); //instancia del objeto Modelo que gestiona las operaciones
          catprogs = oper.localizaCatprog(mid_catprog); // metodo de la clase modelo que se encarga de grabar el cpp
          
          request.setAttribute("catprogs",catprogs);
          
          Gestiondelegaciones oper2=new Gestiondelegaciones();
          ArrayList delegacioness=oper2.listarDelegaciones();
            
          request.setAttribute("delegacioness",delegacioness);
          
          Gestioncolonias oper3=new Gestioncolonias();
          
          ArrayList coloniass=oper3.listarColonias();
            
          request.setAttribute("coloniass",coloniass);
          
          Gestionmecanica oper4=new Gestionmecanica();
          
          ArrayList mecanicass=oper4.listarmecanica();
            
          request.setAttribute("mecanicass",mecanicass);
            
          RequestDispatcher rd=request.getRequestDispatcher("frmmodificacatprog.jsp");
          rd.forward(request,response);
        }
        
        
        //eliminacion de un id_clave_mov de clave_mov
        if(operacion.equals("borrar"))
        {
          Boolean resultado;
          ArrayList catprogs;
          String id_catprog;   //variable tipo Clavemov en la q recibo el javabean
          id_catprog = request.getParameter("id_catprog");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_catprog;
          mid_catprog=Integer.parseInt(id_catprog);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncatprog oper=new Gestioncatprog(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.eliminaCatprog(mid_catprog); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          
          catprogs=oper.listarCatprog();
            
          request.setAttribute("catprogs",catprogs);
          RequestDispatcher rd=request.getRequestDispatcher("listarcatprog.jsp");
          rd.forward(request,response);
        }
        
        
         
       
        //acceso a la vista de cpps para mostrar los cpp de la db
        if(operacion.equals("listar"))
        {
            Gestioncatprog oper=new Gestioncatprog();
            ArrayList catprogs=oper.listarCatprog();
            
            request.setAttribute("catprogs",catprogs);
            //request.setAttribute("exito",false);
            
            RequestDispatcher rd=request.getRequestDispatcher("listarcatprog.jsp");
            rd.forward(request,response);
        }
        
        
        
        //acceso al reporte jasper que construye el .pdf
        if(operacion.equals("prepararimprimir"))
        {
            Gestiondelegaciones oper=new Gestiondelegaciones();
            ArrayList delegacioness=oper.listarDelegaciones();
            
            request.setAttribute("delegacioness",delegacioness);
            
            Gestionmecanica oper2=new Gestionmecanica();
            ArrayList mecanicass=oper2.listarmecanica();
            
            request.setAttribute("mecanicass",mecanicass);
            //request.setAttribute("exito",false);
            
            RequestDispatcher rd=request.getRequestDispatcher("frmrepcatprog.jsp");
            rd.forward(request,response);

            
        }
        
        
        //acceso al reporte jasper que construye el .pdf
        if(operacion.equals("imprimir"))
        {
            Gestioncatprog oper=new Gestioncatprog();
            try {
                 cn=oper.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Controladorcatprog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            /* verificamos si hay o no registros q cumplan con las condiciones del reporte
            Statement st = null;
            ResultSet rs;
            
            try {
                st=cn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Controladorcatprog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String tsql;
            tsql="select c.clave,c.descripcion,c.mecanica,c.costo_m2,c.interes,c.admon,c.seguro,c.plazo,c.sub_ini,d.descripcion as delegacion from cat_prog c left outer join delegaciones d on c.id_del=d.id_delegacion where id_del='"+id_delegacion+"' order by c.id_del,c.descripcion; ";
            try {
                //tsql="select * from colonias order by id_delegacion,descripcion";
                rs=st.executeQuery(tsql);
            } catch (SQLException ex) {
                Logger.getLogger(Controladorcatprog.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
            
            
            
            ServletOutputStream servletOutputStream = response.getOutputStream();
            File reportFile = new File(getServletConfig().getServletContext().getRealPath("/Reportes/catprog.jasper"));
            
            
            try
            {
                
                Delegaciones mdelegacion;   //variable tipo Clavemov en la q recibo el javabean
                mdelegacion = (Delegaciones)request.getAttribute("delegaciones");  //cast para convertir de tipo object a tipo Cpp el javabean
                String id_delegacion = mdelegacion.getidDelegacion().toString();
                String id_mecanica = mdelegacion.getidMecanica();
                
                Map param = new HashMap(); //inicializo un objeto HashMap variable,valor
                //param.put("id_delegacion", id_delegacion);
                //param.put("id_mecanica", id_mecanica);
                if (id_mecanica.equals("0"))
                {    
                    param.put("sql","where id_del='"+id_delegacion+"'");
                }else
                {
                    param.put("sql","where id_del='"+id_delegacion+"' and mecanica='"+id_mecanica+"'");
                    
                }
                         
                
                param.put("titulo", "Reporte del Catálogo de Condiciones Financieras para la Oficina: ");
                
                byte[] bytes = null;
                //bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),new HashMap(), new JREmptyDataSource());
                //bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),new HashMap(), cn);
                bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),param, cn);  //el segundo parametro es un hashmap para el paso de parametros al jasperreport
                response.setContentType("application/pdf");
                
                response.setContentLength(bytes.length);
                servletOutputStream.write(bytes, 0, bytes.length);
                
                servletOutputStream.flush();
                servletOutputStream.close();
            }
            catch (JRException e)
            {
                // display stack trace in the browser
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);
                response.setContentType("text/plain");
                response.getOutputStream().print(stringWriter.toString());
            }

            
        }
        
    } 
}
