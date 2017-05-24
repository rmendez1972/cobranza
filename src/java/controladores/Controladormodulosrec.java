/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.GestionModuloRecaudacion;
import java.util.ArrayList;
import javabeans.ModuloRecaudacion;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author arturo
 */
@WebServlet(name = "Controladormodulosrec", urlPatterns = {"/controladormodulosrec"})
public class Controladormodulosrec extends ControladorBase{
    public void ver(HttpServletRequest request, HttpServletResponse response) throws Exception{
        RequestDispatcher rd=request.getRequestDispatcher("modulos_recaudacion.html");
        rd.forward(request,response);
    }
    
    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean res=false;
        
        try{
            int id_modulo=Integer.parseInt(request.getParameter("idmodulo"));
            GestionModuloRecaudacion modelo=new GestionModuloRecaudacion();
            res=modelo.eliminar(id_modulo);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(res));
    }
    
    public void editar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean res=false;
        
        ModuloRecaudacion mod=new ModuloRecaudacion(Integer.parseInt(request.getParameter("id_modulo")), request.getParameter("descripcion"), request.getParameter("direccion"), Integer.parseInt(request.getParameter("id_delegacion")));
        GestionModuloRecaudacion modelo=new GestionModuloRecaudacion();
        res=modelo.editar(mod);
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(res));
    }
    
    public void nuevo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean res=false;
        
        ModuloRecaudacion mod=new ModuloRecaudacion(-1, request.getParameter("descripcion"), request.getParameter("direccion"), Integer.parseInt(request.getParameter("id_delegacion")));
        GestionModuloRecaudacion modelo=new GestionModuloRecaudacion();
        res=modelo.nuevo(mod);
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(res));
    }
    
    public void getone(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModuloRecaudacion mod=null;
        
        try{
            int id_modulo=Integer.parseInt(request.getParameter("idmodulo"));
            GestionModuloRecaudacion modelo=new GestionModuloRecaudacion();
            mod=modelo.obtenerPorId(id_modulo);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(mod));
    }
    
    public void getall(HttpServletRequest request, HttpServletResponse response) throws Exception{
        GestionModuloRecaudacion modelo=new GestionModuloRecaudacion();
        ArrayList<ModuloRecaudacion> modulos=modelo.listarModulos();
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(modulos));
    }
    
    public void reporte(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map param = new HashMap();
        param.put("titulo", "Reporte de Módulos de Recaudación de la SEDUVI");
        param.put("sql", "");
        generarReporte("ReporteModulorec.jasper", param, request, response);
    }
}
