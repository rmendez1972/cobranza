/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestionuser;
import java.util.ArrayList;
import javabeans.User;
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
@WebServlet(name = "ControladorUsuarios", urlPatterns = {"/controladorusuarios"})
public class ControladorUsuarios extends ControladorBase{
    public void ver(HttpServletRequest request, HttpServletResponse response) throws Exception{
        RequestDispatcher rd=request.getRequestDispatcher("/Public/usuarios/vistas/usuarios.html");
        rd.forward(request,response);
    }
    
    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean res=false;
        
        try{
            int id_usuario=Integer.parseInt(request.getParameter("idusuario"));
            Gestionuser modelo=new Gestionuser();
            res=modelo.eliminar(id_usuario);
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
        
        User usuario=new User(Integer.parseInt(request.getParameter("id_usuario")),request.getParameter("usuario"), request.getParameter("password"), Integer.parseInt(request.getParameter("id_nivel")), Integer.parseInt(request.getParameter("id_del")), request.getParameter("serie"), request.getParameter("nombre"), request.getParameter("cargo"), request.getParameter("direccion"));
        Gestionuser modelo=new Gestionuser();
        res=modelo.editar(usuario);
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(res));
    }
    
    
    public void nuevo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean res=false;
        
        User usuario=new User(-1, request.getParameter("usuario"), request.getParameter("password"), Integer.parseInt(request.getParameter("id_nivel")), Integer.parseInt(request.getParameter("id_delegacion")), request.getParameter("serie"), request.getParameter("nombre"), request.getParameter("cargo"), request.getParameter("direccion") );
        Gestionuser modelo=new Gestionuser();
        res=modelo.nuevo(usuario);
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(res));
    }
    
    public void getone(HttpServletRequest request, HttpServletResponse response) throws Exception{
        User usuario=null;
        
        try{
            int id_usuario=Integer.parseInt(request.getParameter("idusuario"));
            Gestionuser modelo=new Gestionuser();
            usuario=modelo.obtenerPorId(id_usuario);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(usuario));
    }
    
    public void getall(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Gestionuser modelo=new Gestionuser();
        ArrayList<User> usuarios=modelo.listarUsuarios();
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(usuarios));
    }
    
    
    public void reporte(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map param = new HashMap();
        param.put("titulo", "Reporte de Usuarios del Sistema de CxC de la SEDUVI");
        param.put("sql", "");
        generarReporte("ReporteUsuarios.jasper", param, request, response);
    }
}
