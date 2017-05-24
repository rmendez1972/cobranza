/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestionbenefreferencia;
import Modelo.Gestionclavemov;

import javabeans.Benefreferencia;
import javabeans.Movedoscta;
import Modelo.Gestionbonificaciones;
import Modelo.Gestionmov_edoscta;
import Modelo.Gestionbenef;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import Modelo.Gestioncatprog;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javabeans.Benef;
import javabeans.Criteriobusqueda;


/**
 *
 * @author Rafael Mendez
 */
@WebServlet(name = "Controladorreferencia", urlPatterns = {"/controladorreferencia"})
public class Controladorreferencia extends HttpServlet 
{
    public Controladorreferencia () {
        //super();
    }
    
    public Connection cn;
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        //almacena la operacion que debe gestionar el controlador
        String operacion=request.getParameter("operacion");
        String mensaje=request.getParameter("mensaje");
        
        
        if(operacion.equals("capturar"))
        {
          ArrayList catemisor,catprog;
            
            
          //seleccionamos el cat. de claves div.
          //Gestioncatemisor oper=new Gestioncatemisor(); //instancia del objeto Modelo que gestiona las operaciones
          //catemisor = oper.listarCatemisor();
          
           //seleccionamos el cat. de claves div.
          Gestioncatprog oper2=new Gestioncatprog(); //instancia del objeto Modelo que gestiona las operaciones
          catprog = oper2.listarCatprog();
          
          request.setAttribute("catprog",catprog);
          //request.setAttribute("catemisor",catemisor);
            
          RequestDispatcher rd=request.getRequestDispatcher("frmmov_edoscta.jsp");
          rd.forward(request,response);
        }
        
        
        //el controlador redirecciona al formulario de captura de cpp
        if(operacion.equals("consultar"))
        {
                       
            RequestDispatcher rd=request.getRequestDispatcher("frmlocalizabenefreferencia.jsp");
            rd.forward(request,response);
        }
        
        /*
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
        */
        
        if(operacion.equals("ubicar"))
        {
          Movedoscta mov_edoscta;
          ArrayList clave_mov,cat_prog;
          String midmovedoscta;   //variable tipo Clavemov en la q recibo el javabean
          midmovedoscta = request.getParameter("id_movedoscta");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_movedoscta;
          mid_movedoscta=Integer.parseInt(midmovedoscta);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestionmov_edoscta oper=new Gestionmov_edoscta(); //instancia del objeto Modelo que gestiona las operaciones
          mov_edoscta = oper.ubicaMov_edoscta(mid_movedoscta); // metodo de la clase modelo que se encarga de grabar el cpp
          
          //seleccionamos el cat. de claves div.
          Gestionclavemov oper2=new Gestionclavemov(); //instancia del objeto Modelo que gestiona las operaciones
          clave_mov = oper2.listarClavemov();
          
          Gestioncatprog oper3=new Gestioncatprog(); //instancia del objeto Modelo que gestiona las operaciones
          cat_prog = oper3.listarCatprog();
          
          request.setAttribute("mov_edoscta",mov_edoscta);
          request.setAttribute("clave_mov",clave_mov);
          request.setAttribute("cat_prog",cat_prog);
          
            
          RequestDispatcher rd=request.getRequestDispatcher("frmmodificamov_edoscta.jsp");
          rd.forward(request,response);
        }
        
        /*
        
        if(operacion.equals("ubicarbonificaciones"))
        {
          Bonificaciones bonificaciones;
          ArrayList bonific;
          String midbonificacion;   //variable tipo Clavemov en la q recibo el javabean
          midbonificacion = request.getParameter("id_bonificacion");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_bonificacion;
          mid_bonificacion=Integer.parseInt(midbonificacion);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestionbonificaciones oper=new Gestionbonificaciones(); //instancia del objeto Modelo que gestiona las operaciones
          bonificaciones = oper.ubicaBonificaciones(mid_bonificacion); // metodo de la clase modelo que se encarga de grabar el cpp
          
          //seleccionamos el cat. de claves bonific
          Gestionbonific oper2=new Gestionbonific(); //instancia del objeto Modelo que gestiona las operaciones
          bonific = oper2.listarBonific();
          
          request.setAttribute("bonificaciones",bonificaciones);
          request.setAttribute("cat_bonific",bonific);
          
          
            
          RequestDispatcher rd=request.getRequestDispatcher("frmmodificabonificaciones.jsp");
          rd.forward(request,response);
        }
        
        
        */
        //grabación de un nuevo registro de cpp en el modelo
        if(operacion.equals("localizar"))
        {
          Benefreferencia benefreferencia;
          
          String mcampo,mcampo2;
          String mvalor;   //variable tipo Clavemov en la q recibo el javabean
          mcampo=null;
          Criteriobusqueda mcriteriobusqueda;   //variable tipo Clavemov en la q recibo el javabean
          mcriteriobusqueda = (Criteriobusqueda)request.getAttribute("criteriobusqueda");  //cast para convertir de tipo object a tipo Cpp el javabean
                             
          //recuremos los campos de benef_div
          Gestionbenefreferencia oper=new Gestionbenefreferencia(); //instancia del objeto Modelo que gestiona las operaciones
          benefreferencia = oper.localizaBenefreferencia(mcriteriobusqueda); // metodo de la clase modelo que se encarga de grabar el cpp
                    
          request.setAttribute("benefreferencia",benefreferencia);
          
          RequestDispatcher rd=request.getRequestDispatcher("frmwebservicecobros.jsp");
          rd.forward(request,response);
        }
        
        
        
        //eliminacion de un id_clave_mov de clave_mov
        if(operacion.equals("borrar"))
        {
          Movedoscta mov_edoscta;
          Benef benef;
          ArrayList mbonificaciones;
          ArrayList mmov_edoscta;
                      
          Boolean resultado;
          ArrayList candidatoss;
          String midmovedoscta;   //variable tipo Clavemov en la q recibo el javabean
          midmovedoscta = request.getParameter("id_movedoscta");  //cast para convertir de tipo object a tipo Cpp el javabean
          Integer mid_movedoscta;
          mid_movedoscta=Integer.parseInt(midmovedoscta);
          //creamos una instancia de la clase del modelo q manipula los datos
          Gestionmov_edoscta oper=new Gestionmov_edoscta(); //instancia del objeto Modelo que gestiona las operaciones
          mov_edoscta = oper.ubicaMov_edoscta(mid_movedoscta);
          String mclave_b=mov_edoscta.getClave_b();
          resultado = oper.eliminaMov_edoscta(mid_movedoscta); // metodo de la clase modelo que se encarga de grabar el cpp
          request.setAttribute("exito",resultado);
          
                    
          Criteriobusqueda mcriteriobusqueda = new Criteriobusqueda();
          mcriteriobusqueda.setCampo("clave_b");
          mcriteriobusqueda.setValor(mclave_b);
          
          //recuremos los campos de benef_div
          Gestionbenef oper2=new Gestionbenef(); //instancia del objeto Modelo que gestiona las operaciones
          benef = oper2.localizaBenef(mcriteriobusqueda); // metodo de la clase modelo que se encarga de grabar el cpp
          //String mclave_b=benef_div.getClave_b();
          
          //recuperamos los movimientos diversos de un benef_div en particular
          Gestionmov_edoscta oper3=new Gestionmov_edoscta(); //instancia del objeto Modelo que gestiona las operaciones
          mmov_edoscta = oper3.localizaMov_edoscta(mclave_b);
          
          //recuperamos las bonificaciones de un benef_div en particular
          Gestionbonificaciones oper4=new Gestionbonificaciones(); //instancia del objeto Modelo que gestiona las operaciones
          mbonificaciones = oper4.localizaBonificaciones(mclave_b);
          
          request.setAttribute("benef",benef);
          request.setAttribute("mov_edoscta",mmov_edoscta);
          request.setAttribute("bonificaciones",mbonificaciones);
          
          
          
          RequestDispatcher rd=request.getRequestDispatcher("listaredocta.jsp");
          rd.forward(request,response);
          
          
        }
        
       
        /*
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