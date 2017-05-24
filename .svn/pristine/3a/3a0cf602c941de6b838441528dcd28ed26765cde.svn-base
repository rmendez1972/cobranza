<%-- 
    Document   : frmlogin
    Created on : 28/06/2012, 03:10:28 PM
    Author     : Rafael Mendez
--%>


<%@page import="javabeans.Cpp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Captura de CPP</title>
        
        <script type="text/javascript">

        $(function (){
           
           $("form.jqtransform").jqTransform();
           
           
        });

        </script>
        
        
    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="user" scope="request" class="javabeans.User"/>

    
    <%
    if((request.getParameter("usuario")!=null) && (request.getParameter("password")!=null) )
    {
        String usuario=request.getParameter("usuario");
        user.setUsuario(usuario.toUpperCase());
        String password=request.getParameter("password");
        user.setPassword(password.toUpperCase());
    %>
           
        <jsp:forward page="controladorlogincajas?operacion=validacaja"/>
    <%}%>
    
    
    
    <body>
        <center> 
            <h2>Autorización para abrir cajas anteriores</h2>
            <form name="frmlogin" id="frmlogin" class="jqtransform" method="post">
                <br/><br/>
                <table  width="50%" cellspacing=0 cellpadding=3 border="0">
                    <tr >
                        <td width="15%" align="left">Usuario:</td>
                        <td width="35%" align="left"><input type="text" name="usuario" id="usuario"  size="10"></td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Contraseña:</td>
                        <td width="35%" align="left"><input type="text" name="password" id="password"  size="10"  ></td>
                    </tr>
                </table>
                <br/>
                <input type="submit" name="Submit" class="boton_fb" value="Grabar"onMouseOver="this.style.cursor='pointer'">
                <input type="reset" value="Reset" class="boton_fb" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>
    </body>
</html>
