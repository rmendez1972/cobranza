<%-- 
    Document   : frmcpp
    Created on : 28/06/2012, 03:10:28 PM
    Author     : Rafael Mendez
--%>

<%@page import="javabeans.Salmin"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Captura de Salarios mínimos</title>
    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="salmin" scope="request" class="javabeans.Salmin"/>

    
    <%
    if((request.getParameter("fecha")!=null) && (request.getParameter("importe")!=null) )
    {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=sdf.parse(request.getParameter("fecha"));
        salmin.setFecha(fecha);
        BigDecimal importe = new BigDecimal(request.getParameter("importe"));
        salmin.setImporte(importe); %>
           
        <jsp:forward page="controladorsalmin?operacion=grabar"/>
    <%}%>
    
    
    
    <body>
        <center> 
            <h1>Salarios Mínimos</h1>
            <form name="frmsalmin" method="post">
                <br/><br/>
                <table>
                    <tr>
                        <td>Ingresa la Fecha:</td>
                        <td><input type="text" name="fecha"></td>
                    </tr>
                    <tr>
                        <td>Ingresa el importe:</td>
                        <td><input type="text" name="importe"></td>
                    </tr>
                </table>
                <br/>
                <input type="submit" name="Submit" value="Grabar">
                <input type="reset" value="Reset">
            </form>
        </center>
    </body>
</html>
