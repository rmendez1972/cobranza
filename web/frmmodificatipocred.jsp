<%-- 
    Document   : frmtipocred
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>




<%@page import="javabeans.Tipocred"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Modificación al Catálogo de Tipos de Crédito</title>
        
        <script type="text/javascript">

        $(function (){
                    
                    
           $("#frmtipocred").validate(
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
    <jsp:useBean id="tipocred" scope="request" class="javabeans.Tipocred"/>

    
    <%
    //Clavemov mclavemov;
    //mclavemov=(Clavemov)request.("clavemovs");
    if( (request.getParameter("descripcion")!=null) )
    {
        Integer idTipocred = Integer.parseInt(request.getParameter("idTipocred"));
        tipocred.setidTipocred(idTipocred);
        String descripcion=request.getParameter("descripcion");
        tipocred.setDescripcion(descripcion);
        
    %>
           
        <jsp:forward page="controladortipocred?operacion=modificar"/>
    <%}%>
    
    <body>
        <center> 
            <h1>Modificación al Catálogo de Tipos de Crédito</h1>
            <form name="frmtipocred" id="frmtipocred" class="catalogo" method="post">
                <br/><br/>
                <table class="fuente8" width="50%" cellspacing=0 cellpadding=3 border=0>
                    
                    <tr>
                        <td width="15%" align="left">Descripción:</td>
                        <td width="35%" align="left"><input type="text" name="descripcion" id="descripcion" class="cajaPequena" size="40" maxlength="50" onMouseOver="this.style.cursor='crosshair'" value="${tipocreds.descripcion}"><input type="hidden" name="idTipocred" id="idTipocred"  value="${tipocreds.idTipocred}"></td>
                    </tr>
                </table>
                <br/>
                <input type="submit" class="boton_fb" name="Submit" value="Modificar"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset" class="boton_fb" value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>
