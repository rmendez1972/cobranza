<%-- 
    Document   : frmbonific
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>


<%@page import="javabeans.Bonific"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/additional-methods.js"></script>
        

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Captura de Claves de Bonificacion</title>
        
        <script type="text/javascript">

        $(function (){
                    
           
           $("#frmbonificacion").validate(
           {
                        
                rules: {
                    clave_bonific:{ 
                                required: true,
                                minlength: 5,
                                pattern: /^(bon|BON)+(\d{2})$/
                              },
                  descripcion:{ 
                                required: true,
                                minlength: 5
                              }
                    
                       },
                       
             messages: {
                   clave_bonific:{

                        required: "clave de mov es obligatorio",

                        minlength: function (p, element) {

                                                            return "clave de mov tiene que tener " + p + "  caracteres";

                                                          },
                        pattern:   'clave de bonificacion debe tener la estructura BON99'
                             },                             
                
                descripcion: {

                        required: "descripcion es obligatorio",

                        minlength: function (p, element) {

                                                            return "descripcion tiene que tener minimo " + p + "  caracteres";

                                                         }

                            }

                       }      


            }); 
        });

    </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="bonific" scope="request" class="javabeans.Bonific"/>

    
    <%
    if((request.getParameter("clave_bonific")!=null) && (request.getParameter("descripcion")!=null) )
    {
        String clave_bonific=request.getParameter("clave_bonific");
        bonific.setClave_bonific(clave_bonific);
        String descripcion=request.getParameter("descripcion");
        bonific.setDescripcion(descripcion);
         
    %>
           
        <jsp:forward page="controladorbonific?operacion=grabar"/>
    <%}%>
    
    <body>
        <center> 
            <h2>Catálogo de Claves de Bonificación</h2>
            <form name="frmbonificacion" id="frmbonificacion" class="catalogo" method="post">
                <br/><br/>
                <table class="fuente8" width="50%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="15%" align="left">Clave de Bonificacion:</td>
                        <td width="35%" align="left"><input type="text" name="clave_bonific" id="clave_bonific" class="cajaPequena" size="3" maxlength="5" onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Descripcion:</td>
                        <td width="35%" align="left"><input type="text" name="descripcion" id="descripcion" class="cajaPequena" size="40" maxlength="50" onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                   
                </table>
                <br/>
                <input type="submit" class="boton_fb" name="Submit" value="Grabar"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset" class="boton_fb" value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>
