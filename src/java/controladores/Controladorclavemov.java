/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestionclavemov;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabeans.Clavemov;
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
@WebServlet(name = "Controladorclavemov", urlPatterns = {"/controladorclavemov"})
public class Controladorclavemov extends HttpServlet 
{
    
    public Connection cn;
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        //almacena la operacion que debe gestionar el controlador
        String operacion=request.getParameter("operacion");
        
        //el controlador redirecciona al formulario de captura de cpp
        if(operacion.equals("capturar"))
        {
            response.sendRedirect("frmclavemov.jsp");
        }
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("grabar"))
        {
          Boolean resultado;
          Clavemov mclavemov;   //variable tipo Clavemov en la q recibo el javabean
          mclavemov = (Clavemov)request.getAttribute("clavemov");  //cast para convertir de tipo object a tipo Cpp el javabean
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestionclavemov oper=new Gestionclavemov(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.grabaClavemov(mclavemov); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          //response.sendRedirect("inicio.html"); //despues de realizar la accion en el modelo redirecciono al menu
          ArrayList clavemovs=oper.listarClavemov();
          request.setAttribute("clavemovs",clavemovs);
          
            
          RequestDispatcher rd=request.getRequestDispatcher("listarclavemov.jsp");
          rd.forward(request,response);
        }
        
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("modificar"))
        {
          Boolean resultado;
          Clavemov mclavemov;   //variable tipo Clavemov en la q recibo el javabean
          mclavemov = (Clavemov)request.getAttribute("clavemov");  //cast para convertir de tipo object a tipo Cpp el javabean
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestionclavemov oper=new Gestionclavemov(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.modificaClavemov(mclavemov); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          //response.sendRedirect("inicio.html"); //despues de realizar la accion en el modelo redirecciono al menu
          ArrayList clavemovs=oper.listarClavemov();
          request.setAttribute("clavemovs",clavemovs);
          
            
          RequestDispatcher rd=request.getRequestDispatcher("listarclavemov.jsp");
          rd.forward(request,response);
        }
        
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("localizar"))
        {
          Clavemov clavemovs;
          String midclavemov;   //variable tipo Clavemov en la q recibo el javabean
          midclavemov = request.getParameter("id_clave_mov");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_clave_mov;
          mid_clave_mov=Integer.parseInt(midclavemov);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestionclavemov oper=new Gestionclavemov(); //instancia del objeto Modelo que gestiona las operaciones
          clavemovs = oper.localizaClavemov(mid_clave_mov); // metodo de la clase modelo que se encarga de grabar el cpp
          
          request.setAttribute("clavemovs",clavemovs);
          
            
          RequestDispatcher rd=request.getRequestDispatcher("frmmodificaclavemov.jsp");
          rd.forward(request,response);
        }
        
        
        //eliminacion de un id_clave_mov de clave_mov
        if(operacion.equals("borrar"))
        {
          Boolean resultado;
          ArrayList clavemovs;
          String midclavemov;   //variable tipo Clavemov en la q recibo el javabean
          midclavemov = request.getParameter("id_clave_mov");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_clave_mov;
          mid_clave_mov=Integer.parseInt(midclavemov);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestionclavemov oper=new Gestionclavemov(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.eliminaClavemov(mid_clave_mov); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          
          clavemovs=oper.listarClavemov();
            
          request.setAttribute("clavemovs",clavemovs);
          RequestDispatcher rd=request.getRequestDispatcher("listarclavemov.jsp");
          rd.forward(request,response);
        }
        
        
        //acceso a la página de solicitud de mensajes
        if(operacion.equals("muestra"))
        {    
            response.sendRedirect("mostrar.html");
        }
        
        //acceso a la vista de cpps para mostrar los cpp de la db
        if(operacion.equals("listar"))
        {
            Gestionclavemov oper=new Gestionclavemov();
            ArrayList clavemovs=oper.listarClavemov();
            
            request.setAttribute("clavemovs",clavemovs);
            //request.setAttribute("exito",false);
            
            RequestDispatcher rd=request.getRequestDispatcher("listarclavemov.jsp");
            rd.forward(request,response);
        }
        
        //acceso al reporte jasper que construye el .pdf
        if(operacion.equals("imprimir"))
        {
            Gestionclavemov oper=new Gestionclavemov();
            try {
                 cn=oper.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Controladorcpp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            ServletOutputStream servletOutputStream = response.getOutputStream();
            File reportFile = new File(getServletConfig().getServletContext().getRealPath("/Reportes/clavemov.jasper"));
            
            
            try
            {
                
                byte[] bytes = null;
                //bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),new HashMap(), new JREmptyDataSource());
                bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),new HashMap(), cn);
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
