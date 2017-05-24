/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestioncajas;
import Modelo.Gestioncpp;
import Modelo.Gestionuser;
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
import javabeans.Cajas;
import javabeans.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@WebServlet(name = "Controladorcajas", urlPatterns = {"/controladorcajas"})
public class Controladorcajas extends HttpServlet 
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
            response.sendRedirect("frmcajas.jsp");
        }
        
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("grabar"))
        {
          Boolean resultado;
          Cajas mcajas;   //variable tipo Cpp en la q recibo el javabean
          mcajas = (Cajas)request.getAttribute("cajas");  //cast para convertir de tipo object a tipo Cpp el javabean
          
          HttpSession session = request.getSession();
          User user=(User)session.getAttribute("currentUser");
          Gestioncajas oper=new Gestioncajas(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.grabaCajas(mcajas,user); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          //response.sendRedirect("inicio.html"); //despues de realizar la accion en el modelo redirecciono al menu
          ArrayList cajass=oper.listarCajas(user);
          request.setAttribute("cajass",cajass);
          request.setAttribute("user",user);
            
          RequestDispatcher rd=request.getRequestDispatcher("listarcajas.jsp");
          rd.forward(request,response);
        }
        
        
        /*
        //acceso a la página de solicitud de mensajes
        if(operacion.equals("muestra"))
        {    
            response.sendRedirect("mostrar.html");
        }
        
        */
        //acceso a la vista de cpps para mostrar los cpp de la db
        if(operacion.equals("listar"))
        {
            //Cajas mcajas;   //variable tipo Cpp en la q recibo el javabean
            //mcajas = (Cajas)request.getAttribute("cajas");  //cast para convertir de tipo object a tipo Cpp el javabean
          
            HttpSession session = request.getSession();
            User user=(User)session.getAttribute("currentUser");
            
            Gestioncajas oper=new Gestioncajas();
            ArrayList cajass=oper.listarCajas(user);
            
            request.setAttribute("cajass",cajass);
            request.setAttribute("user",user);
            
            RequestDispatcher rd=request.getRequestDispatcher("listarcajas.jsp");
            rd.forward(request,response);
        }
        
        
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("localizar"))
        {
          
          Cajas cajass;
          String midcaja;   //variable tipo Clavemov en la q recibo el javabean
          midcaja = request.getParameter("id_caja");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_caja;
          mid_caja=Integer.parseInt(midcaja);
          Boolean validacajas;
          ServletContext contexto = request.getServletContext();
          Boolean autorizado = (Boolean)contexto.getAttribute("autorizado");
          //request.getAttribute("cajas");
          
          HttpSession session = request.getSession();
          User user=(User)session.getAttribute("currentUser");
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncajas oper=new Gestioncajas(); //instancia del objeto Modelo que gestiona las operaciones
          validacajas = oper.validaCajas(mid_caja); // metodo de la clase modelo que se encarga de grabar el cpp
          cajass = oper.localizaCajas(mid_caja); // metodo de la clase modelo que se encarga de grabar el cpp
          
          request.setAttribute("cajass",cajass);
          request.setAttribute("user",user);
          
          if (validacajas==true || autorizado!=null)
          {
            RequestDispatcher rd=request.getRequestDispatcher("frmmodificacajas.jsp");
            rd.forward(request,response);
          }
          else
          { 
              // pide autorizacion
            RequestDispatcher rd=request.getRequestDispatcher("frmlogin2.jsp");
            rd.forward(request,response);
          }
        }
        
        
        if(operacion.equals("validacaja"))
        {
            User usuario;
            usuario = (User)request.getAttribute("user");
            String usua = null;
            String pass = null;
            Integer id_usuario= null;
            Integer id_nivel= null;
            String nombre=null;
            
            // verificando la existencia del usuario en la db
            Gestionuser oper=new Gestionuser(); //instancia del objeto Modelo que gestiona las operaciones
            usuario = oper.localizauser(usuario);
            
            if (usuario!=null)
            {    
                /*usua = usuario.getUsuario();
                pass = usuario.getPassword();
                id_usuario= usuario.getId_usuario();
                id_nivel= usuario.getId_nivel();
            
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", usuario);*/
                ServletContext contexto = request.getServletContext();
                contexto.setAttribute("autorizado", true);
                
                RequestDispatcher rd=request.getRequestDispatcher("frmmodificacajas.jsp");
                rd.forward(request,response);
                
            }
            else
            {
               // response.sendRedirect("frmlogin.jsp");
            }    
                
        }
        
        
         //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("modificar"))
        {
          Boolean resultado;
          Cajas mcajas;   //variable tipo Clavemov en la q recibo el javabean
          mcajas = (Cajas)request.getAttribute("cajas");  //cast para convertir de tipo object a tipo Cpp el javabean
          
          HttpSession session = request.getSession();
          User user=(User)session.getAttribute("currentUser");
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncajas oper=new Gestioncajas(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.modificaCajas(mcajas,user); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          //response.sendRedirect("inicio.html"); //despues de realizar la accion en el modelo redirecciono al menu
          ArrayList cajass=oper.listarCajas(user);
            
          request.setAttribute("cajass",cajass);
          request.setAttribute("user",user);
            
          RequestDispatcher rd=request.getRequestDispatcher("listarcajas.jsp");
          rd.forward(request,response);
        }
        
        
        
        //eliminacion de un id_clave_mov de clave_mov
        if(operacion.equals("borrar"))
        {
          Boolean resultado;
          ArrayList cajass;
          String midcaja;   //variable tipo Clavemov en la q recibo el javabean
          midcaja = request.getParameter("id_caja");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_caja;
          mid_caja=Integer.parseInt(midcaja);
          
          HttpSession session = request.getSession();
          User user=(User)session.getAttribute("currentUser");
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncajas oper=new Gestioncajas(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.eliminaCajas(mid_caja); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          
          
          cajass=oper.listarCajas(user);
            
          request.setAttribute("cajass",cajass);
          request.setAttribute("user",user);
          RequestDispatcher rd=request.getRequestDispatcher("listarcajas.jsp");
          rd.forward(request,response);
        }
        
        /*
        
        //acceso al reporte jasper que construye el .pdf
        if(operacion.equals("imprimir"))
        {
            Gestioncpp oper=new Gestioncpp();
            try {
                 cn=oper.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Controladorcpp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            ServletOutputStream servletOutputStream = response.getOutputStream();
            File reportFile = new File(getServletConfig().getServletContext().getRealPath("/Reportes/cpp.jasper"));
            
            
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

            
        }*/
    } 
}

