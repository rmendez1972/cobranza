<%-- 
    Document   : frmclavemov
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>

<%@page import="javabeans.Clavemov"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Captura de Clave de Mov. de Estados de Cuenta</title>
        
        <script type="text/javascript">

        $(function (){
                    
                    
           $("#frmclave_mov").validate(
           {

                rules: {
                    clave_mov:{ 
                                required: true,
                                minlength: 3
                              },
                  descripcion:{ 
                                required: true,
                                minlength: 3
                              }
                    

                       },
                       
             messages: {
                   clave_mov:{

                        required: "clave de mov es obligatorio",

                        minlength: function (p, element) {

                                                            return "clave de mov tiene que tener " + p + " caracteres";

                                                          }
                             },                             
                
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
    <jsp:useBean id="clavemov" scope="request" class="javabeans.Clavemov"/>

    
    <%
    if((request.getParameter("clave_mov")!=null) && (request.getParameter("descripcion")!=null) )
    {
        String clave_mov=request.getParameter("clave_mov");
        clavemov.setClave_mov(clave_mov);
        String descripcion=request.getParameter("descripcion");
        clavemov.setDescripcion(descripcion); %>
           
        <jsp:forward page="controladorclavemov?operacion=grabar"/>
    <%}%>
    
    <body>
        <center> 
            <h1>Catálogo de Claves de Movimiento de Edos. Cuenta</h1>
            <form name="frmclave_mov" id="frmclave_mov" class="catalogo" method="post">
                <br/><br/>
                <table class="fuente8" width="50%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="15%" align="left">Clave de Mov.:</td>
                        <td width="35%" align="left"><input type="text" name="clave_mov" id="clave_mov" class="cajaPequena" size="3" maxlength="3" onMouseOver="this.style.cursor='crosshair'"></td>
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
