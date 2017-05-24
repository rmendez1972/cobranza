/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

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
import javabeans.User;
import javax.servlet.Filter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebFilter;
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

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Rafael Mendez
 */
@WebFilter(filterName = "Filtro", urlPatterns = {"/*"}, initParams = {@WebInitParam(name = "exclude", value = "frmlogin.jsp"),@WebInitParam(name = "frmlogin", value = "intro.jsp"),@WebInitParam(name = "cabecera", value = "header.png")})
public class Filtro implements Filter 
{ 
    public Filtro() {} 
    
    private FilterConfig config;
    private String frmlogin;
    private String exclude;
    private String cabecera;
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequest httpReq = (HttpServletRequest) request; 
        HttpServletResponse httpRes = (HttpServletResponse) response;

        HttpSession session = httpReq.getSession();
        User currentUser = (User)session.getAttribute("currentUser");
        
        
        if ((currentUser == null) && (exclude.equals("frmlogin.jsp")) && (cabecera.equals("header.png"))) 
        {
            RequestDispatcher rd = httpReq.getRequestDispatcher("/"+frmlogin);
            rd.forward(request, response);
            return;
        } 
        else 
        {        
            chain.doFilter(request, response);
        }
    }
    
    public void destroy() 
    {
    }
    
    public void init(FilterConfig config) throws ServletException 
    {
        this.config = config;

        //Tambien se pueden cargar los parametros
        //Configura url desconexión
        this.frmlogin = config.getInitParameter("frmlogin");
        this.exclude = config.getInitParameter("exclude");
        this.cabecera = config.getInitParameter("exclude");
        
        if (frmlogin == null || frmlogin.trim().length() == 0) 
        {
            //Error al cargar la url de login
            throw new ServletException("No se ha configurado URL de login");
        }
    }
}

