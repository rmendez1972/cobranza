/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestionaperturaedoscta;
import Modelo.Gestioncatprog;
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
import javabeans.Aperturaedoscta;
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
@WebServlet(name = "Controladoraperturaedoscta", urlPatterns = {"/controladoraperturaedoscta"})
public class Controladoraperturaedoscta extends HttpServlet 
{
    public Controladoraperturaedoscta () {
        super();
    }
    
    public Connection cn;
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        //almacena la operacion que debe gestionar el controlador
        String operacion=request.getParameter("operacion");
        String mensaje=request.getParameter("mensaje");
        
        /*
        //el controlador redirecciona al formulario de captura de cpp
        if(operacion.equals("capturar"))
        {
            Gestioncatprog oper=new Gestioncatprog();
            ArrayList catprogs=oper.listarCatprog();
            
            request.setAttribute("catprogs",catprogs);
            //request.setAttribute("exito",false);
            
            RequestDispatcher rd=request.getRequestDispatcher("frmcandidatos.jsp");
            rd.forward(request,response);
        }
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("grabar"))
        {
          Boolean resultado;
          Candidatos mcandidatos;   //variable tipo Clavemov en la q recibo el javabean
          mcandidatos = (Candidatos)request.getAttribute("candidatos");  //cast para convertir de tipo object a tipo Cpp el javabean
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncandidatos oper=new Gestioncandidatos(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.grabaCandidatos(mcandidatos); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          //response.sendRedirect("inicio.html"); //despues de realizar la accion en el modelo redirecciono al menu
          ArrayList candidatoss=oper.listarCandidatos();
          request.setAttribute("candidatoss",candidatoss);
          
            
          RequestDispatcher rd=request.getRequestDispatcher("listarcandidatos.jsp");
          rd.forward(request,response);
        }
        
        */
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("modificar"))
        {
            Boolean resultado;
            Aperturaedoscta maperturaedoscta;   //variable tipo Clavemov en la q recibo el javabean
            maperturaedoscta = (Aperturaedoscta)request.getAttribute("aperturaedoscta");  //cast para convertir de tipo object a tipo Cpp el javabean
            //creamos una instancia de la clase del modelo q manipula los datos
            Gestionaperturaedoscta oper=new Gestionaperturaedoscta(); //instancia del objeto Modelo que gestiona las operaciones
            resultado = oper.modificaAperturaedoscta(maperturaedoscta); // metodo de la clase modelo que se encarga de grabar el cpp
            request.setAttribute("exito",resultado);
            //response.sendRedirect("inicio.html"); //despues de realizar la accion en el modelo redirecciono al menu
            ArrayList aperturaedosctas=oper.listarAperturaedoscta();
            request.setAttribute("aperturaedosctas",aperturaedosctas);
          
            
            RequestDispatcher rd=request.getRequestDispatcher("listaraperturaedosctas.jsp");
            rd.forward(request,response);
        }
        
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("localizar"))
        {
          Aperturaedoscta aperturaedoscta;
          String midcandidato;   //variable tipo Clavemov en la q recibo el javabean
          midcandidato = request.getParameter("id_candidato");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_candidato;
          mid_candidato=Integer.parseInt(midcandidato);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestionaperturaedoscta oper=new Gestionaperturaedoscta(); //instancia del objeto Modelo que gestiona las operaciones
          aperturaedoscta = oper.localizaAperturaedoscta(mid_candidato); // metodo de la clase modelo que se encarga de grabar el cpp
          
          request.setAttribute("aperturaedosctas",aperturaedoscta);
          
          Gestioncatprog oper2=new Gestioncatprog();
          ArrayList catprogss=oper2.listarCatprog();
            
          request.setAttribute("catprogss",catprogss);
          
          RequestDispatcher rd=request.getRequestDispatcher("frmmodificaaperturaedoscta.jsp");
          rd.forward(request,response);
        }
        
        /*
        //eliminacion de un id_clave_mov de clave_mov
        if(operacion.equals("borrar"))
        {
          Boolean resultado;
          ArrayList candidatoss;
          String midcandidato;   //variable tipo Clavemov en la q recibo el javabean
          midcandidato = request.getParameter("id_candidato");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_candidato;
          mid_candidato=Integer.parseInt(midcandidato);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncandidatos oper=new Gestioncandidatos(); //instancia del objeto Modelo que gestiona las operaciones
          resultado = oper.eliminaCandidato(mid_candidato); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          
          candidatoss=oper.listarCandidatos();
            
          request.setAttribute("candidatoss",candidatoss);
          RequestDispatcher rd=request.getRequestDispatcher("listarcandidatos.jsp");
          rd.forward(request,response);
        }
        */
       
        
        //acceso a la vista de cpps para mostrar los cpp de la db
        if(operacion.equals("listar"))
        {
            
            Gestionaperturaedoscta oper=new Gestionaperturaedoscta();
            ArrayList aperturaedosctas=oper.listarAperturaedoscta();
            
            request.setAttribute("aperturaedosctas",aperturaedosctas);
            request.setAttribute("mensaje", mensaje);
            RequestDispatcher rd=request.getRequestDispatcher("listaraperturaedosctas.jsp");
            rd.forward(request,response);
        }
        
        
        /*
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

            
        }*/
    } 
}
