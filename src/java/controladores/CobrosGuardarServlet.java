/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import mx.gob.qroo.sh.sistemas.ArrayOfPaTributanetGuardarContribucionResult;
import mx.gob.qroo.sh.sistemas.Cobros;
import mx.gob.qroo.sh.sistemas.Forma;
import mx.gob.qroo.sh.sistemas.PaTributanetGuardarContribucion;
import mx.gob.qroo.sh.sistemas.PaTributanetGuardarContribucionResult;
import mx.gob.qroo.sh.sistemas.FormaDetalle;



/**
 *
 * @author rsosa
 */
@WebServlet(name = "CobrosGuardarServlet", urlPatterns = {"/CobrosGuardarServlet"})
public class CobrosGuardarServlet extends HttpServlet {
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    

        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            
            String rfc = request.getParameter("RFC");
            String curp = request.getParameter("CURP");
            String nombre = request.getParameter("Nombre");
            String calle = request.getParameter("Calle");
            String referenciaCalle = request.getParameter("Referencia_Calle");
            String numeroInterior = request.getParameter("Numero_Interior");
            String numeroExterior = request.getParameter("Numero_Exterior");
            String codigoPostal = request.getParameter("Codigo_Postal");
            String colonia = request.getParameter("Colonia");
            String localidad = request.getParameter("Localidad");
            String municipio = request.getParameter("Municipio");
            String pais = request.getParameter("Pais");
            String datosEspecificos = request.getParameter("Datos_Especificos");
            String observaciones = request.getParameter("Observaciones");
            String grupo = request.getParameter("Grupo");
            String total = request.getParameter("Total");
            String fechaVencimiento = request.getParameter("FechaVencimiento");
            
            
            
            
            String[] idConcepto=request.getParameterValues("idConcepto");
            String[] cantidad=request.getParameterValues("cantidad");
            String[] importeManual=request.getParameterValues("importeManual");
            
            
            mx.gob.qroo.sh.sistemas.Forma forma= new mx.gob.qroo.sh.sistemas.Forma();
            
            
            mx.gob.qroo.sh.sistemas.ArrayOfFormaDetalle aDetalle = new mx.gob.qroo.sh.sistemas.ArrayOfFormaDetalle();
            
            
            
            forma.setRfc(rfc);
            forma.setCurp(curp);
            forma.setNombre(nombre);
            forma.setCalle(calle);
            forma.setReferenciaCalle(referenciaCalle);
            forma.setNumeroInterior(numeroInterior);
            forma.setNumeroExterior(numeroExterior);
            forma.setCodigoPostal(codigoPostal);
            forma.setColonia(colonia);
            forma.setLocalidad(localidad);
            forma.setMunicipio(municipio);
            forma.setPais(pais);
            forma.setDatosEspecificos(datosEspecificos);
            forma.setObservaciones(observaciones);
            forma.setGrupo(Integer.parseInt(grupo));
            forma.setTotal(BigDecimal.valueOf(Long.parseLong(total)));
            forma.setFechaVencimiento(fechaVencimiento);
            

           for(int i=0;i<idConcepto.length;i++){
                if(Integer.parseInt(cantidad[i])>0){
                    FormaDetalle detalle = new FormaDetalle();
                   detalle.setIdConcepto(Integer.parseInt(idConcepto[i]));
                   detalle.setCantidad(Integer.parseInt(cantidad[i]));
                   detalle.setImporteManual(BigDecimal.valueOf(Long.parseLong(importeManual[i])));
                   aDetalle.getFormaDetalle().add(detalle);
                }
            }
            
            
            
            forma.setDetalle(aDetalle);
            
            
            PaTributanetGuardarContribucion doc = tributanetGuardarContribucion(forma);
            
            ArrayOfPaTributanetGuardarContribucionResult lista=doc.getLista();
           
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CobrosGuardarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            /*out.println("<table border='2' cellpadding='3' cellspacing='3'>");
            
            out.println("<tr>");
            out.println("<th>RFC</th><td>"+rfc+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<th>CURP</th><td>"+curp+"</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<th>Nombre</th><td>"+nombre+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<th>Calle</th><td>"+calle+"</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<th>Referencia Calle</th><td>"+referenciaCalle+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<th>Numero Interior</th><td>"+numeroInterior+"</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<th>Numero Exterior</th><td>"+numeroExterior+"</td>");
            out.println("</tr>");


            out.println("<tr>");
            out.println("<th>Colonia</th><td>"+colonia+"</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<th>Codigo Postal</th><td>"+codigoPostal+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<th>Localidad</th><td>"+localidad+"</td>");
            out.println("</tr>");

            
            out.println("<tr>");
            out.println("<th>Municipio</th><td>"+municipio+"</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<th>Pais</th><td>"+pais+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<th>Datos Especificos</th><td>"+datosEspecificos+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<th>Observaciones</th><td>"+observaciones+"</td>");
            out.println("</tr>");

            
            out.println("<tr>");
            out.println("<th>Grupo</th><td>"+grupo+"</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<th>Total</th><td>"+total+"</td>");
            out.println("</tr>");
            
            
            out.println("</table>");
            
            out.println("<table border='1' cellpadding='3' cellspacing='3'>");
            out.println("<tr><th>Id Concepto</th><th>Cantidad</th><th>Importe Manual</th></tr>");
            
            
            
            
            for(int i=0;i<idConcepto.length;i++){
       
            out.println("<tr>");
            out.println("<td>"+idConcepto[i]+"</td>");
            out.println("<td>"+cantidad[i]+"</td>");
            out.println("<td>"+importeManual[i]+"</td>");
            
            
            out.println("</tr>");               
                
                
            }
            
            
            
            
            out.println("</table>");*/

            out.println("<center>");
            out.println("<fieldset  style=\'border: 2px solid #8A0808; width: 800px; border-radius: 10px; \'>");
            out.println("<legend align='right'><img src='imagenes/actualizacion.png' width='40' height='40' alt='Referencia Devuelta' />Referencia Devuelta por Web Service de SH</legend>");
            out.println("<br>");
            out.println("<table border='2' cellpadding='3' cellspacing='3'>");

            out.println("<tr><th colspan='6'>Respuesta del Web Service</th></tr>");

            out.println("<tr>");

            out.println("<th>Id</th>");
            out.println("<th>RFC</th>");
            out.println("<th>Referencia</th>");
            out.println("<th>Nombre de Beneficiario</th>");
            out.println("<th>Total a Pagar</th>");
            out.println("<th>Accion</th>");
            out.println("</tr>");

            for (int i = 0; i < lista.getPaTributanetGuardarContribucionResult().size(); i++) {
               PaTributanetGuardarContribucionResult row  = lista.getPaTributanetGuardarContribucionResult().get(i);
               out.println("<tr>");
               out.println("<td>"+row.getId().toString()+"</td>");               
               out.println("<td>"+row.getRfc()+"</td>");
               out.println("<td>"+row.getReferencia()+"</td>");
               out.println("<td>"+row.getNombre()+"</td>");
               out.println("<td>"+row.getTotalPagar().toString()+"</td>");
               out.println("<td><a href='https://shacienda.qroo.gob.mx/ingresos2_125/erecauda/contribucion/dec_contribucion_control.php?Referencia="+row.getReferencia()+"&opcion=imprimir'>Imprimir Formato</a></td>");
               
               
               out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br>");
            out.println("</fileldset>");
            out.println("</center>");
            // out.println(formaToXml(forma));
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    private String formaToXml(Forma forma) {
        String result="";
        
        result+="<encabezado><DatosEspecificos>"+forma.getDatosEspecificos()+"</DatosEspecificos><RFC>" + forma.getRfc() + "</RFC><Domicilio>|Domicilio:" + forma.getCalle() + ", Ref:" + forma.getReferenciaCalle() + "|Municipio:" + forma.getMunicipio() + "|Ciudad:" + forma.getLocalidad() + "|Colonia:" + forma.getColonia() + "|CP:" + forma.getCodigoPostal() + "</Domicilio><Municipio>" + forma.getMunicipio() + "</Municipio><Nombre>" + forma.getNombre() + "</Nombre><Observaciones>" + forma.getObservaciones() + "</Observaciones><Grupo>" + forma.getGrupo() + "</Grupo></encabezado>";
        
        for(FormaDetalle det :forma.getDetalle().getFormaDetalle())
        {
            
            result+=  "<detalle><id>"+det.getIdConcepto()+"</id><cantidad>"+det.getCantidad()+"</cantidad><importemanual>" + det.getImporteManual()+"</importemanual></detalle>";
            
        }
    
        return result;
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

   private PaTributanetGuardarContribucion tributanetGuardarContribucion(mx.gob.qroo.sh.sistemas.Forma declaracion) {
        mx.gob.qroo.sh.sistemas.CobrosSoap port = service.getCobrosSoap();
        return port.tributanetGuardarContribucion(declaracion);
    }

    
   

}