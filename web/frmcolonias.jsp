<%-- 
    Document   : frmclavemov
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="javabeans.Colonias"%>
<%@page import="javabeans.Delegaciones"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Captura de Colonias por Delegacion</title>
        
        <script type="text/javascript">

        $(function (){
                    
                    
           $("#frmcolonias").validate(
           {

                rules: {
                    
                  descripcion:{ 
                                required: true,
                                minlength: 3
                              }
                    

                       },
                       
             messages: {
                                                
                
                descripcion: {

                        required: "descripcion es obligatorio",

                        minlength: function (p, element) {

                                                            return "descripcion tiene que tener minimo" + p + " caracteres";

                                                         }

                            }

                       }      


            }); 
        });

    </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="colonias" scope="request" class="javabeans.Colonias"/>

    
    <%
    if((request.getParameter("idDelegacion")!=null) && (request.getParameter("descripcion")!=null) )
    {
        Integer idDelegacion = Integer.parseInt(request.getParameter("idDelegacion"));
        colonias.setidDelegacion(idDelegacion);
        String descripcion=request.getParameter("descripcion");
        colonias.setDescripcion(descripcion); %>
           
        <jsp:forward page="controladorcolonias?operacion=grabar"/>
    <%}%>
    
    <body>
        <center> 
            <h1>Catálogo de Colonias por Delegacion</h1>
            <form name="frmcolonias" id="frmcolonias" class="catalogo" method="post">
                <br/><br/>
                <table class="fuente8" width="50%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="15%" align="left">Delegacion:</td>
                        <td width="35%" align="left">
                            <select name="idDelegacion" id="idDelegacion">
                                <c:forEach  var="delegacion" items="${requestScope.delegacioness}">
                                    <OPTION VALUE="${delegacion.idDelegacion}">${delegacion.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Descripción:</td>
                        <td width="35%" align="left"><input type="text" name="descripcion" id="descripcion" class="cajaPequena" size="25" maxlength="30" onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                </table>
                <br/>
                <input type="submit" class="boton_fb" name="Submit" value="Grabar"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset" class="boton_fb" value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>
