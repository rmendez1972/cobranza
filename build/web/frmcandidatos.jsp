<%-- 
    Document   : frmcandidatos
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="javabeans.Candidatos"%>



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

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Captura de Candidatos</title>
        
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
        String clave_elect=request.getParameter("clave_elect");
        candidatos.setClave_elect(clave_elect);
        String curp=request.getParameter("curp");
        candidatos.setCurp(curp);
        String rfc=request.getParameter("rfc");
        candidatos.setRfc(rfc);
        String nombre=request.getParameter("nombre");
        candidatos.setNombre(nombre);
        String conyuge=request.getParameter("conyuge");
        candidatos.setConyuge(conyuge);
        
        
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_cont=sdf.parse(request.getParameter("fecha_cont"));
        candidatos.setFecha_cont(fecha_cont);
        
        String mza=request.getParameter("mza");
        candidatos.setMza(mza);
        String lte=request.getParameter("lte");
        candidatos.setLte(lte);
        
        BigDecimal area;
        if((request.getParameter("area")!=null) && (request.getParameter("area")!=""))
        {
            area = new BigDecimal(request.getParameter("area"));
        }else
        {
            area = new BigDecimal(0.00);
        }
        candidatos.setArea(area);
               
        String domicilio=request.getParameter("domicilio");
        candidatos.setDomicilio(domicilio);
        
        String clave_cat=request.getParameter("clave_cat");
        candidatos.setClave_cat(clave_cat);
        
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_ip=sdf2.parse(request.getParameter("fecha_ip"));
        candidatos.setFecha_ip(fecha_ip);
        
        
    %>
           
        <jsp:forward page="controladorcandidatos?operacion=grabar"/>
    <%}%>
    
    <body>
        <center> 
            <h3>Catálogo de Candidatos (Beneficiarios contratados) a tener Edo. de cuenta</h3>
            <form name="frmcandidatos" id="frmcandidatos" class="catalogo" method="post">
                <br/><br/>
                <table class="fuente8" width="50%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="15%" align="left">Condición Financiera / Programa:</td>
                        <td width="35%" align="left">
                            <select name="idCatprog" id="idCatprog">
                                <OPTION VALUE="0" selected="selected">Selecciona una opción del catálogo...</OPTION>
                                <c:forEach  var="cat" items="${requestScope.catprogs}">
                                    <OPTION VALUE="${cat.id_Catprog}">${cat.clave}/${cat.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Número de Contrato:</td>
                        <td width="35%" align="left"><input type="text" name="numcontrato" id="numcontrato" class="cajaPequena" size="3" maxlength="5" onMouseOver="this.style.cursor='crosshair'"> </td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Clave de Elector:</td>
                        <td width="35%" align="left"><input type="text" name="clave_elect" id="clave_elect" class="cajaPequena" size="15" maxlength="18" onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Curp:</td>
                        <td width="35%" align="left"><input type="text" name="curp" id="curp" class="cajaPequena" size="16" maxlength="20" onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Rfc:</td>
                        <td width="35%" align="left"><input type="text" name="rfc" id="rfc" class="cajaPequena" size="10" maxlength="13" onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Nombre del Benef:</td>
                        <td width="35%" align="left"><input type="text" name="nombre" id="nombre" class="cajaPequena" size="40" maxlength="50" onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Conyuge:</td>
                        <td width="35%" align="left"> <input type="text" name="conyuge" id="conyuge" class="cajaPequena" size="40" maxlength="50" onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    
                    <tr>
                        <td width="15%" align="left">Fecha de Contrato:</td>
                        <td width="35%" align="left"><input type="text"  name="fecha_cont" id="fecha_cont" class="datepicker" size="11"</td>
                        
                    </tr>
                    <tr>
                        <td width="15%" align="left">Manzana:</td>
                        <td width="35%" align="left"><input type="text"  name="mza" id="mza"  class="cajaPequena" size="3" maxlength="3"</td>
                        
                    </tr>
                    
                    <tr>
                        <td width="15%" align="left">Lote:</td>
                        <td width="35%" align="left"><input type="text"  name="lte" id="lte" class="cajaPequena"  size="5" maxlength="6"</td>
                        
                    </tr>
                    
                    <tr>
                        <td width="15%" align="left">Area:</td>
                        <td width="35%" align="left"><input type="text"  name="area" id="area" class="cajaPequena"  size="5" maxlength="6"</td>
                        
                    </tr>
                    
                    <tr>
                        <td width="15%" align="left">Domicilio:</td>
                        <td width="35%" align="left"><input type="text"   name="domicilio" id="domicilio" class="cajaPequena"  size="40" maxlength="50"</td>
                        
                    </tr>
                    
                    <tr>
                        <td width="15%" align="left">Clave catastral:</td>
                        <td width="35%" align="left"><input type="text"   name="clave_cat" id="clave_cat" class="cajaPequena"  size="12" maxlength="15"</td>
                        
                    </tr>
                    
                    <tr>
                        <td width="15%" align="left">Fecha Ini. Pag.:</td>
                        <td width="35%" align="left"><input type="text"  name="fecha_ip" id="fecha_ip"  size="10" class="datepicker" </td>
                        
                    </tr>
                    
                </table>
                <br/>
                <input type="submit" class="boton_fb" name="Submit" value="Grabar"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset" class="boton_fb" value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>
