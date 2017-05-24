<%-- 
    Document   : frmcandidatos
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="javabeans.Delegaciones"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/additional-methods.js"></script>
        <!--<script type="text/javascript" language="JavaScript" src="js/jquery.maskedinput-1.3.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>-->

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Captura de Condiciones Financieras</title>
        
        <script type="text/javascript">
        
          $(function (){
                    
           $("#frmrepcatprog").validate(
           {

                rules: {
                    
                 id_delegacion:{ 
                                required: true,
                                min: 1
                          }
                                                       
                       },
               
              
                       
             messages: {
                 
                    
           id_delegacion:{

                        required: "delegacion es obligatoria",

                        min: function (p, element) {

                                                            return "es obligatorio seleccionar una opción del cat. de delegaciones";

                                                   }
                          }
                 
                            
                                  
               

                       }      

            }); 
        });
            
        

        </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="delegaciones" scope="request" class="javabeans.Delegaciones"/>

    
    <%
    if(request.getParameter("id_delegacion")!=null )
    {
        
        
        Integer id_delegacion = Integer.parseInt(request.getParameter("id_delegacion"));
        delegaciones.setidDelegacion(id_delegacion);
        String descripcion=request.getParameter("descripcion");
        delegaciones.setdescripcion(descripcion);
        String mecanica = request.getParameter("id_mecanica");
        delegaciones.setidMecanica(mecanica);
        
    %>
           
        <jsp:forward page="controladorcatprog?operacion=imprimir"/>
    <%}%>
    
    <body>
        <center> 
            <h3>Reporte de Condiciones Financieras por Oficina de la SEDUVI</h3>
            <form name="frmrepcatprog" id="frmrepcatprog" class="catalogo" method="post">
                <br/><br/>
                <table class="fuente8" width="60%" cellspacing=0 cellpadding=3 border=0>
                    
                                       
                    <tr>
                        <td width="20%" align="left">Selecciona una Oficina:</td>
                        <td width="40%" align="left">
                            <select name="id_delegacion" id="id_delegacion">
                                <OPTION VALUE="0" selected="selected">Selecciona una oficina del catálogo...</OPTION>
                                <c:forEach  var="del" items="${requestScope.delegacioness}">
                                    <OPTION VALUE="${del.idDelegacion}">${del.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td width="20%" align="left">Selecciona una Mecánica de Cálculo:</td>
                        <td width="40%" align="left">
                            <select name="id_mecanica" id="id_mecanica">
                                <OPTION VALUE="0" selected="selected">Todas las Mecánicas del Catálaggo...</OPTION>
                                <c:forEach  var="mec" items="${requestScope.mecanicass}">
                                    <OPTION VALUE="${mec.descripcion}">${mec.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>    
                    
                    
                </table>
                <br/>
                <input type="submit" class="boton_fb" name="Submit" value="Imprimir"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset" class="boton_fb" value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>