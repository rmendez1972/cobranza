<%-- 
    Document   : frmmodificacatprog
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>



<%@page import="java.math.BigDecimal"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="javabeans.Candidatos"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Modificación de Condiciones Financieras</title>
        
        <script type="text/javascript">
           
           
           $(function (){
                    
           $('input.datepicker').Zebra_DatePicker();
                    
           $("#frmcandidatos").validate(
           {

                rules: {
                    idCatprog:{ 
                                required: true,
                                min: 1
                              },
                    numcontrato:{ 
                                required: true,
                                minlength: 5
                              },
                  clave_elect:{ 
                                required: true,
                                minlength: 18
                              },
                 curp:{ 
                                required: true,
                                minlength: 18
                              },
                  

                              
                  capital: {
                                
                                required: true,
                                pattern: /^[0-9]{1,5}(\.[0-9]{0,2})?$/
                                
                                
                                
                           }  

                       },
                       
             messages: {
                 
                  idCatprog:{

                        required: "Condicion Financiera es obligatoria",

                        min: function (p, element) {

                                                            return "es obligatorio seleccionar una opción del cat. de condiciones financieras";

                                                          }
                             },
                   numcontrato:{

                        required: "numero de contrato es obligatorio",

                        minlength: function (p, element) {

                                                            return "numero de contrato tiene que tener una longitud de " + p + " numeros";

                                                          }
                             },                             
                
                clave_elect: {

                        required: "clave de elector es obligatorio",

                        minlength: function (p, element) {

                                                            return "clave de elector tiene que tener " + p + " caracteres";

                                                         }

                            },
               curp: {

                        required: "curp es obligatorio",

                        minlength: function (p, element) {

                                                            return "curp tiene que tener " + p + " caracteres";

                                                         }

                            },
                            
                
                         
                capital: {
                        
                        
                        required:  'El capital es obligatorio',
                        pattern:   'Solo se aceptan numeros enteros con dos decimales'
                        
       
                         }
                            

                       }      


            }); 
        });

        </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="candidatos" scope="request" class="javabeans.Candidatos"/>

    <%
    if((request.getParameter("numcontrato")!=null) && (request.getParameter("clave_elect")!=null) )
    {
        Integer idCatprog = Integer.parseInt(request.getParameter("idCatprog"));
        candidatos.setId_catprog(idCatprog);
        String numcontrato=request.getParameter("numcontrato");
        candidatos.setNumcontrato(numcontrato);
        

    %>
           
        <jsp:forward page="controladorcandidatos?operacion=modificar"/>
    <%}%>
    
    <body>
        <center> 
            <h1>Modificación al Catálogo de Candidatos (Beneficiarios Contratados) a tener Edo. de cuenta)</h1>
            <form name="frmcandidatos" id="frmcandidatos" class="catalogo" method="post">
                <br/><br/>
                <table class="fuente8" width="80%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="10%" align="left">Condición Financiera / Programa:</td>
                        <td width="30%" align="left">
                            <select name="idCatprog" id="idCatprog">
                                
                                
                                <c:forEach  var="cat" items="${requestScope.catprogss}">
                                    
                                    <OPTION VALUE="${cat.id_Catprog}" ${candidatoss.id_catprog == cat.id_Catprog ? 'selected' : ''}>${cat.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="10%" align="left">Número de contrato:</td>
                        <td width="30%" align="left"><input type="text" name="numcontrato" id="numcontrato" class="cajaPequena" size="3" maxlength="5" onMouseOver="this.style.cursor='crosshair'" value="${candidatoss.numcontrato}"></td>
                    </tr>
                    
                    
                    
                </table>
                <br/>
                <input type="submit" class="boton_fb" name="Submit" value="Modificar"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset" class="boton_fb" value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>
