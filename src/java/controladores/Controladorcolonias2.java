/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestioncolonias;
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
@WebServlet(name = "Controladorcolonias2", urlPatterns = {"/controladorcolonias2"})
public class Controladorcolonias2 extends HttpServlet 
{
    public Controladorcolonias2 () 
    {
        //super();
    }
    String lista = "";
    public Connection cn;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                Gestioncolonias colonias = new Gestioncolonias();
                //acceder al metodo buscaPaises
                
                Integer id_del = Integer.parseInt(request.getParameter("id_del").toString());
                ArrayList coloniass = colonias.listarColoniasparaselect(id_del);
                if (coloniass.size() != 0) 
                {
                    lista = "\"" + "Colonias" + "\":" + "[";
                        for (int x = 0; x < coloniass.size(); x=x+2) 
                        {
                            lista += "{" + "\"" + "id_colonia" + "\"" + ":" + coloniass.get(x).toString() + "," +"\"" + "descripcion" + "\"" + ":" + " \"" + coloniass.get(x+1) + "\"" + "}" + ",";
                            //formar la cadena en formato JSON para enviarlo a la vista con jquery
                        }
                        //quitar la ultima coma para parsear la cadena JSON
                        lista = lista.substring(0, lista.length() - 1);
                } else 
                {
                    out.println("No se logro obtener datos");
                }
            } finally 
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
            Logger.getLogger(Controladorcolonias2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    try {
            processRequest(request, response);
        } catch (Exception ex) 
        {
            Logger.getLogger(Controladorcolonias2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>
    
}
