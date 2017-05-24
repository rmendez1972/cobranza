<%-- 
    Document   : frmlocalizabenef_div
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="javabeans.Catprog"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/additional-methods.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.maskedinput-1.3.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jqtransform/jqtransformplugin/jquery.jqtransform.js"></script>
        
        <!--<script type="text/javascript" language="JavaScript" src="js/jquery.maskedinput-1.3.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>-->

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <link href="js/jqtransform/jqtransformplugin/jqtransform.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Localización de Benef. diverso</title>
        
        <script type="text/javascript">
            
        $(function (){
                    
           $("form.jqtransform").jqTransform();
           
           $("#frmlocalizabenef_div").validate(
           {

                rules: {
                        campo:{ 
                                required: true,
                                min: 1
                              },
                        valor:{ 
                                required: true,
                                minlength: 12
                              }
                    

                       },
                       
             messages: {
                 
                       campo:{

                            required: "seleccionar un criterio es obligatorio",

                            min: function (p, element) {

                                                            return "es obligatorio seleccionar una opción del cat. de criterios de búsqueda";

                                                       }
                             },
                       valor:{

                        required: "ingresar un criterio de búsqueda es obligatorio",

                        minlength: function (p, element) {

                                                            return "la descripción del criterio de búsqueda tiene que tener una longitud mínima de " + p + " caracteres";

                                                          }
                             }                             
                
                       }      


           });
        });

        

        </script>


        </head>
    
        <!--encapsulamiento de los datos del cpp en el Javabean-->
        <jsp:useBean id="criteriobusqueda" scope="request" class="javabeans.Criteriobusqueda"/>

    
    <%
    if(request.getParameter("valor")!=null )
    {
        String campo=request.getParameter("campo");
        criteriobusqueda.setCampo(campo);
        
        String valor=request.getParameter("valor");
        criteriobusqueda.setValor(valor);
        
    %>
        <jsp:forward page="controladormtomovdiv?operacion=localizar"/>
        
    <%}%>
    
    <body>
        <center> 
            <h3>Localiza un Beneficiario Diverso y sus Movimientos (Otros Ingresos)</h3>
            <form name="frmlocalizabenef_div" id="frmlocalizabenef_div" class="jqtransform" method="post">
                <br/><br/>
                <table  width="90%" cellspacing=0 cellpadding=3 border=0>
                    
                    <tr>
                        <td width="55%" align="left"><div class="rowElem"><label for="campo">Benef. Div. por</label> <select name="campo" id="campo">
                                <OPTION VALUE="0" selected="selected">Selecciona un criterio de búsqueda...</OPTION>
                                <OPTION VALUE="1" >Clave SEDUVI</OPTION>
                                <OPTION VALUE="2" >Nombre de Beneficiario Diverso</OPTION>
                                </select></div></td>
                        <td width="35%" align="left"><div class="rowElem"> <input type="text"  name="valor" id="valor" class="cajaPequena"  size="40" maxlength="60"  style="text-align:left" ></div></td>
                        
                    </tr>
                    
                    
                    
                    
                </table>
                <br/>
                <input type="submit"  name="Submit" value="Localizar"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset"  value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
            
            
        </center>

    </body>
</html>