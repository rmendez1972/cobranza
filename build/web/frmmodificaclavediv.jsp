<%-- 
    Document   : frmclavemov
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>




<%@page import="javabeans.Clavediv"%>
<%@page import="java.math.BigDecimal"%>
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
        <title>Formulario de Modificación de Clave de Mov. Diversos</title>
        
        <script type="text/javascript">

        $(function (){
                    
                    
           $("#frmclave_div").validate(
           {

                rules: {
                    clave_div:{ 
                                required: true,
                                minlength: 3
                              },
                  descripcion:{ 
                                required: true,
                                minlength: 3
                              },
                    importe: {
                                
                                required: true,
                                pattern: /^[0-9]{1,5}(\.[0-9]{0,2})?$/
                                
                                
                                
                             }  
                    

                       },
                       
             messages: {
                   clave_div:{

                        required: "clave de div es obligatorio",

                        minlength: function (p, element) {

                                                            return "clave de mov tiene que tener " + p + " caracteres";

                                                          }
                             },                             
                
                descripcion: {

                        required: "descripcion es obligatorio",

                        minlength: function (p, element) {

                                                            return "descripcion tiene que tener minimo" + p + " caracteres";

                                                         }

                            },
                   importe: {
                        
                        
                                required:  'El importe es obligatorio',
                                pattern:   'Solo se aceptan numeros con la estructura 99999.99'
                        
       
                            }
                            

                       }      


            }); 
        });

    </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="clavediv" scope="request" class="javabeans.Clavediv"/>

    
    <%
    //Clavemov mclavemov;
    //mclavemov=(Clavemov)request.("clavemovs");
    if((request.getParameter("clave_div")!=null) && (request.getParameter("descripcion")!=null) )
    {
        
        Integer id_clave_div = Integer.parseInt(request.getParameter("id_clave_div"));
        clavediv.setId_clave_div(id_clave_div);
        String clave_div=request.getParameter("clave_div");
        clavediv.setClave_div(clave_div);
        String descripcion=request.getParameter("descripcion");
        clavediv.setDescripcion(descripcion);
        BigDecimal importe;
        if((request.getParameter("importe")!=null) && (request.getParameter("importe")!=""))
        {
            importe = new BigDecimal(request.getParameter("importe"));
        }else
        {
            importe=new BigDecimal(0.00);
        }
        clavediv.setimporte(importe); 
    %>
           
        <jsp:forward page="controladorclavediv?operacion=modificar"/>
    <%}%>
    
    <body>
        <center> 
            <h1>Modificación al Catálogo de Claves de Diversos</h1>
            <form name="frmclave_div" id="frmclave_div" class="catalogo" method="post">
                <br/><br/>
                <table class="fuente8" width="50%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="15%" align="left">Clave de Div.:</td>
                        <td width="35%" align="left"><input type="text" name="clave_div" id="clave_mov" class="cajaPequena" size="3" maxlength="3" onMouseOver="this.style.cursor='crosshair'" value="${clavedivs.clave_div}"><input type="hidden" name="id_clave_div" id="id_clave_div"  value="${clavedivs.id_clave_div}"></td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Descripción:</td>
                        <td width="35%" align="left"><input type="text" name="descripcion" id="descripcion" class="cajaPequena" size="25" maxlength="30" onMouseOver="this.style.cursor='crosshair'" value="${clavedivs.descripcion}"></td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Importe:</td>
                        <td width="35%" align="left"><label for="importe">$</label><input type="text" name="importe" id="importe" class="cajaPequena" size="25" maxlength="30" onMouseOver="this.style.cursor='crosshair'" value="${clavedivs.importe}" style="text-align:right"></td>
                    </tr>
                </table>
                <br/>
                <input type="submit" class="boton_fb" name="Submit" value="Modificar"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset" class="boton_fb" value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>
