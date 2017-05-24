/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestionbenef_div;
import Modelo.Gestionbonificaciones;
import Modelo.Gestioncandidatos;
import Modelo.Gestioncatprog;
import Modelo.Gestionmov_diversos;
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
import javabeans.Benef_div;
import javabeans.Candidatos;
import javabeans.Criteriobusqueda;
import javabeans.Movdiversos;
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
@WebServlet(name = "Controladormov_diversos", urlPatterns = {"/controladormov_diversos"})
public class Controladormov_diversos extends HttpServlet 
{
    public Controladormov_diversos () {
        super();
    }
    
    public Connection cn;
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        //almacena la operacion que debe gestionar el controlador
        String operacion=request.getParameter("operacion");
        
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
        */
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("grabar"))
        {
          Movdiversos movdiversos;
          Benef_div benef_div;
          Boolean resultado;
          String mclave_b;
          ArrayList mmov_diversos,mbonificaciones;
          Movdiversos mmovdiversos;   //variable tipo Clavemov en la q recibo el javabean
          mmovdiversos = (Movdiversos)request.getAttribute("Movdiversos");  //cast para convertir de tipo object a tipo Cpp el javabean
          
          
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestionmov_diversos oper=new Gestionmov_diversos(); //instancia del objeto Modelo que gestiona las operaciones
          mclave_b = oper.grabaMov_diversos(mmovdiversos); // metodo de la clase modelo que se encarga de grabar el cpp
          //response.sendRedirect("inicio.html"); //despues de realizar la accion en el modelo redirecciono al menu
          Criteriobusqueda mcriteriobusqueda = new Criteriobusqueda();
          mcriteriobusqueda.setCampo("clave_b");
          mcriteriobusqueda.setValor(mclave_b);
          //recuremos los campos de benef_div
          Gestionbenef_div oper5=new Gestionbenef_div(); //instancia del objeto Modelo que gestiona las operaciones
          benef_div = oper5.localizaBenef_div(mcriteriobusqueda); // metodo de la clase modelo que se encarga de grabar el cpp
            
          
          //recuperamos los movimientos diversos de un benef_div en particular
          Gestionmov_diversos oper6=new Gestionmov_diversos(); //instancia del objeto Modelo que gestiona las operaciones
          mmov_diversos = oper6.localizaMov_diversos(mclave_b);
          
          //recuperamos las bonificaciones de un benef_div en particular
          Gestionbonificaciones oper7=new Gestionbonificaciones(); //instancia del objeto Modelo que gestiona las operaciones
          mbonificaciones = oper7.localizaBonificaciones(mclave_b);
          
          request.setAttribute("benef_div",benef_div);
          request.setAttribute("mov_diversos",mmov_diversos);
          request.setAttribute("bonificaciones",mbonificaciones);
          
          
          
          RequestDispatcher rd=request.getRequestDispatcher("listaredoctamovdiversos.jsp");
          rd.forward(request,response);
        }
        
        
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("modificar"))
        {
            Movdiversos movdiversos;
            Benef_div benef_div;
            Boolean resultado;
            ArrayList mmov_diversos,mbonificaciones;
            Movdiversos mmovdiversos;   //variable tipo Clavemov en la q recibo el javabean
            mmovdiversos = (Movdiversos)request.getAttribute("Movdiversos");  //cast para convertir de tipo object a tipo Cpp el javabean
            String mclave_b = mmovdiversos.getClave_b().toUpperCase();
            
            //creamos una instancia de la clase del modelo q manipula los datos
            Gestionmov_diversos oper=new Gestionmov_diversos(); //instancia del objeto Modelo que gestiona las operaciones
            resultado = oper.modificaMovdiversos(mmovdiversos); // metodo de la clase modelo que se encarga de grabar el cpp
            request.setAttribute("exito",resultado);
            
            Criteriobusqueda mcriteriobusqueda = new Criteriobusqueda();
            mcriteriobusqueda.setCampo("clave_b");
            mcriteriobusqueda.setValor(mclave_b);
            //recuremos los campos de benef_div
            Gestionbenef_div oper5=new Gestionbenef_div(); //instancia del objeto Modelo que gestiona las operaciones
            benef_div = oper5.localizaBenef_div(mcriteriobusqueda); // metodo de la clase modelo que se encarga de grabar el cpp
            
          
            //recuperamos los movimientos diversos de un benef_div en particular
            Gestionmov_diversos oper6=new Gestionmov_diversos(); //instancia del objeto Modelo que gestiona las operaciones
            mmov_diversos = oper6.localizaMov_diversos(mclave_b);
          
            //recuperamos las bonificaciones de un benef_div en particular
            Gestionbonificaciones oper7=new Gestionbonificaciones(); //instancia del objeto Modelo que gestiona las operaciones
            mbonificaciones = oper7.localizaBonificaciones(mclave_b);
          
          request.setAttribute("benef_div",benef_div);
          request.setAttribute("mov_diversos",mmov_diversos);
          request.setAttribute("bonificaciones",mbonificaciones);
          
          
          
          RequestDispatcher rd=request.getRequestDispatcher("listaredoctamovdiversos.jsp");
          rd.forward(request,response);
        }
        
        /*
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("localizar"))
        {
          Candidatos candidatoss;
          String midcandidato;   //variable tipo Clavemov en la q recibo el javabean
          midcandidato = request.getParameter("id_candidato");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_candidato;
          mid_candidato=Integer.parseInt(midcandidato);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestioncandidatos oper=new Gestioncandidatos(); //instancia del objeto Modelo que gestiona las operaciones
          candidatoss = oper.localizaCandidatos(mid_candidato); // metodo de la clase modelo que se encarga de grabar el cpp
          
          request.setAttribute("candidatoss",candidatoss);
          
          Gestioncatprog oper2=new Gestioncatprog();
          ArrayList catprogss=oper2.listarCatprog();
            
          request.setAttribute("catprogss",catprogss);
          
          RequestDispatcher rd=request.getRequestDispatcher("frmmodificacandidatos.jsp");
          rd.forward(request,response);
        }
        
        
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
        
       
        
        //acceso a la vista de cpps para mostrar los cpp de la db
        if(operacion.equals("listar"))
        {
            Gestioncandidatos oper=new Gestioncandidatos();
            ArrayList candidatoss=oper.listarCandidatos();
            
            request.setAttribute("candidatoss",candidatoss);
            //request.setAttribute("exito",false);
            
            RequestDispatcher rd=request.getRequestDispatcher("listarcandidatos.jsp");
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
