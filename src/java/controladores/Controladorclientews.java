/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestioncolonias;
import Modelo.Gestionvencidos;
import hello.service.Helloservice_Service;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
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
@WebServlet(name = "Controladorclientews", urlPatterns = {"/controladorclientews"})
public class Controladorclientews extends HttpServlet 
{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/helloservice/helloservice.wsdl")
    private Helloservice_Service service;
    
    public Controladorclientews () 
    {
        super();
    }
    
    String lista = "";
    public Connection cn;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, Exception {
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                //Gestionvencidos vencidos = new Gestionvencidos();
                //acceder al metodo buscaPaises
                
                String id = request.getParameter("id");
                String nombre = request.getParameter("nombre");
                
                String allcontent  = hola("valores enviados id:"+id+" nombre: "+nombre);
                //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                //Date fecha_corte=sdf.parse(request.getParameter("fecha_corte"));
                
                
                
                //ArrayList fechas = vencidos.localizaFechasparaJson (clave_b,fecha_corte);
                //ArrayList jurs = vencidos.localizaMovJurparaJson (clave_b);
                //ArrayList movss = vencidos.localizaMovCanparaJson (clave_b);
                //ArrayList vencidoss = vencidos.listarVencidosparaJson(clave_b);
                ArrayList vencidoss = null;
                lista = "\"" + "Vencidos" + "\":" + "[";
                lista += "{" + "\"" + "referencia" + "\"" + ":" + " \""+ allcontent + " \""  + "}" ;
                
          /*     
          if ((movss !=null) && (movss.size() != 0))
          {    
                    lista = "\"" + "Vencidos" + "\":" + "[";
                    for (int x = 0; x < movss.size(); x=x+10) 
                    {
                        lista += "{" + "\"" + "fecha" + "\"" + ":" + " \"" + movss.get(x) + "\""+ ","+ "\"" + "letra" + "\"" + ":" + " \"" + movss.get(x+1) + " \"" + "," +"\"" + "capital" + "\"" + ":" + " \"" + movss.get(x+2)+ " \""+ "," +"\"" + "interes" + "\"" + ":" + " \""  + movss.get(x+3) + " \""+ "," +"\"" + "seguro" + "\"" + ":" + " \""  + movss.get(x+4) + " \""+ "," +"\"" + "admon" + "\"" + ":" + " \""  + movss.get(x+5) + " \""+ "," +"\"" + "oseg" + "\"" + ":" + " \""  + movss.get(x+6) + " \""+ "," +"\"" + "com" + "\"" + ":" + " \""  + movss.get(x+7) + " \""+ "," +"\"" + "tit" + "\"" + ":" + " \""  + movss.get(x+8) + " \""+ "," +"\"" + "mor" + "\"" + ":" + " \""  + movss.get(x+9) + " \""  + "}" + ",";
                        //formar la cadena en formato JSON para enviarlo a la vista con jquery
                    }
                    //quitar la ultima coma para parsear la cadena JSON
                    lista = lista.substring(0, lista.length() - 1);
                    
          }
          else
          {
             if ((jurs !=null) && (jurs.size() != 0))
             {    
                    lista = "\"" + "Vencidos" + "\":" + "[";
                    for (int x = 0; x < jurs.size(); x=x+10) 
                    {
                        lista += "{" + "\"" + "fecha" + "\"" + ":" + " \"" + jurs.get(x) + "\""+ ","+ "\"" + "letra" + "\"" + ":" + " \"" + jurs.get(x+1) + " \"" + "," +"\"" + "capital" + "\"" + ":" + " \"" + jurs.get(x+2)+ " \""+ "," +"\"" + "interes" + "\"" + ":" + " \""  + jurs.get(x+3) + " \""+ "," +"\"" + "seguro" + "\"" + ":" + " \""  + jurs.get(x+4) + " \""+ "," +"\"" + "admon" + "\"" + ":" + " \""  + jurs.get(x+5) + " \""+ "," +"\"" + "oseg" + "\"" + ":" + " \""  + jurs.get(x+6) + " \""+ "," +"\"" + "com" + "\"" + ":" + " \""  + jurs.get(x+7) + " \""+ "," +"\"" + "tit" + "\"" + ":" + " \""  + jurs.get(x+8) + " \""+ "," +"\"" + "mor" + "\"" + ":" + " \""  + jurs.get(x+9) + " \""  + "}" + ",";
                        //formar la cadena en formato JSON para enviarlo a la vista con jquery
                    }
                    //quitar la ultima coma para parsear la cadena JSON
                    lista = lista.substring(0, lista.length() - 1);
                    
             }
             else
             {    
                if ((fechas !=null) && (fechas.size() != 0))
                {    
                    lista = "\"" + "Vencidos" + "\":" + "[";
                    for (int x = 0; x < fechas.size(); x=x+10) 
                    {
                        lista += "{" + "\"" + "fecha" + "\"" + ":" + " \"" + fechas.get(x) + "\""+ ","+ "\"" + "letra" + "\"" + ":" + " \"" + fechas.get(x+1) + " \"" + "," +"\"" + "capital" + "\"" + ":" + " \"" + fechas.get(x+2)+ " \""+ "," +"\"" + "interes" + "\"" + ":" + " \""  + fechas.get(x+3) + " \""+ "," +"\"" + "seguro" + "\"" + ":" + " \""  + fechas.get(x+4) + " \""+ "," +"\"" + "admon" + "\"" + ":" + " \""  + fechas.get(x+5) + " \""+ "," +"\"" + "oseg" + "\"" + ":" + " \""  + fechas.get(x+6) + " \""+ "," +"\"" + "com" + "\"" + ":" + " \""  + fechas.get(x+7) + " \""+ "," +"\"" + "tit" + "\"" + ":" + " \""  + fechas.get(x+8) + " \""+ "," +"\"" + "mor" + "\"" + ":" + " \""  + fechas.get(x+9) + " \""  + "}" + ",";
                        //formar la cadena en formato JSON para enviarlo a la vista con jquery
                    }
                    //quitar la ultima coma para parsear la cadena JSON
                    lista = lista.substring(0, lista.length() - 1);
                    
                }
                else 
                {
                    if (vencidoss.size() != 0) 
                    {
                        lista = "\"" + "Vencidos" + "\":" + "[";
                            for (int x = 0; x < vencidoss.size(); x=x+3) 
                            {
                                lista += "{" + "\"" + "capital" + "\"" + ":" + vencidoss.get(x).toString() + "," +"\"" + "interes" + "\"" + ":" + " \"" + vencidoss.get(x+1)+ " \""+ "," +"\"" + "admon" + "\"" + ":" + " \""  + vencidoss.get(x+2)+ " \""  + "}" + ",";
                                //formar la cadena en formato JSON para enviarlo a la vista con jquery
                            }
                            //quitar la ultima coma para parsear la cadena JSON
                            lista = lista.substring(0, lista.length() - 1);
                    } else 
                    {
                        out.println("No se logro obtener datos");
                    }
                }
             }
           }*/
          
            }    
               
            
            finally 
            { 
                    out.println("{" + lista + "]}");
                    System.out.println("{" + lista + "]}");
                    out.close();
            } 
}    
    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
            processRequest(request, response);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(Controladorclientews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    try {
            processRequest(request, response);
        } catch (Exception ex) 
        {
            Logger.getLogger(Controladorclientews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>

    private String hola(java.lang.String nombre) {
        hello.service.Helloservice port = service.getHelloservicePort();
        return port.hola(nombre);
    }
    
}
