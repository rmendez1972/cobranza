/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelo.Gestiondelegaciones;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import javabeans.Delegacion;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael Méndez
 */
@WebServlet(name = "ControladorDelegacion", urlPatterns = {"/controladordelegacion"})
public class ControladorDelegacion extends ControladorBase{
    public void ver(HttpServletRequest request, HttpServletResponse response) throws Exception{
        RequestDispatcher rd=request.getRequestDispatcher("delegaciones.html");
        rd.forward(request,response);
    }
    
    public void getall(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Gestiondelegaciones modelo=new Gestiondelegaciones();
        ArrayList deleg=modelo.listarDelegaciones();
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(deleg));
    }
    
    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean res=false;
        
        try{
            int id_delegacion=Integer.parseInt(request.getParameter("id_delegacion"));
            Gestiondelegaciones modelo=new Gestiondelegaciones();
            res=modelo.eliminar(id_delegacion);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(res));
    }
    
    public void nuevo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean res=false;
        
        Delegacion del=new Delegacion(-1, request.getParameter("descripcion"), request.getParameter("direccion"));
        Gestiondelegaciones modelo=new Gestiondelegaciones();
        res=modelo.nuevo(del);
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(res));
    }
    
    public void editar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean res=false;
        
        Delegacion del=new Delegacion(Integer.parseInt(request.getParameter("id_delegacion")), request.getParameter("descripcion"), request.getParameter("direccion"));
        Gestiondelegaciones modelo=new Gestiondelegaciones();
        res=modelo.editar(del);
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(res));
    }
    
    public void getone(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Delegacion mod=null;
        
        try{
            int id_delegacion=Integer.parseInt(request.getParameter("id_delegacion"));
            Gestiondelegaciones modelo=new Gestiondelegaciones();
            mod=modelo.obtenerPorId(id_delegacion);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().write(gson.toJson(mod));
    }
}
