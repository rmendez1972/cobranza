/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import mx.gob.qroo.sh.sistemas.ArrayOfPaTributanetConsultarContribucionConceptoResult;
import mx.gob.qroo.sh.sistemas.Cobros;
import mx.gob.qroo.sh.sistemas.PaTributanetConsultarContribucionConcepto;
import mx.gob.qroo.sh.sistemas.PaTributanetConsultarContribucionConceptoResult;

/**
 *
 * @author rsosa
 */
@WebServlet(name = "CobrosServlet", urlPatterns = {"/CobrosServlet"})
public class CobrosServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/sistemas.sh.qroo.gob.mx/cobros_ws/cobros.asmx.wsdl")
    private Cobros service;
    
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public CobrosServlet () {
        //super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            
            
                //Get Grupo from the JSP page
            String grupo = request.getParameter("Grupo");
            
                //Initialize WS operation arguments
            java.lang.Integer intGrupo = Integer.parseInt(grupo);
            
                //Process result
            PaTributanetConsultarContribucionConcepto doc = tributanetConsultarContribucionConcepto(intGrupo);
            
            //ArrayOfPaTributanetConsultarContribucionConceptoResult lista = doc.getLista();
            ArrayOfPaTributanetConsultarContribucionConceptoResult lista = doc.getLista();
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CobrosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CobrosServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>Consulta de Conceptos del Grupo: " + grupo + "</h2>");
            
            out.println("<table border='2' cellpadding='3' cellspacing='3'>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Clave</th>");
            out.println("<th>Concepto</th>");
            out.println("<th>Tipo</th>");
            out.println("<th>Tarifa</th>");
            out.println("<th>Rubro</th>");
            out.println("<th>Tipo Calculo</th>");
            out.println("<th>Importe Manual</th>");
            out.println("<th>Cargar Concepto</th>");
            out.println("</tr>");
            //Iterator it = lista.getPaTributanetConsultarContribucionConceptoResult().size();
            //Imprimimos la tabla de conceptos
            for (int i = 0; i < lista.getPaTributanetConsultarContribucionConceptoResult().size(); i++) {
              PaTributanetConsultarContribucionConceptoResult row  = lista.getPaTributanetConsultarContribucionConceptoResult().get(i);
               out.println("<tr>");
               out.println("<td>"+row.getId().toString()+"</td>");
               out.println("<td>"+row.getNombre()+"</td>");
               out.println("<td>"+row.getClave()+"</td>");
               out.println("<td>"+row.getConcepto()+"</td>");
               out.println("<td>"+row.getTipo()+"</td>");
               out.println("<td>"+row.getTarifa().toString()+"</td>");
               out.println("<td>"+row.getRubro()+"</td>");
               out.println("<td>"+row.getTipoCalculo().toString()+"</td>");
               out.println("<td>"+row.getImporteManual().toString()+"</td>");
               out.println("<td>"+row.getCargarConcepto()+"</td>");
               out.println("</tr>");
            }
            
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private PaTributanetConsultarContribucionConcepto tributanetConsultarContribucionConcepto(int grupo) {
        mx.gob.qroo.sh.sistemas.CobrosSoap port = service.getCobrosSoap();
        return port.tributanetConsultarContribucionConcepto(grupo);
    }
}