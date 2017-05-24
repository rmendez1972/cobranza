<%-- 
    Document   : frmbonificaciones
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>



<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="javabeans.Movdiversos"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/additional-methods.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jqtransform/jqtransformplugin/jquery.jqtransform.js"></script>

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <link href="js/jqtransform/jqtransformplugin/jqtransform.css" rel="stylesheet" type="text/css">
        <link href="js/jqtransform/jqtransformplugin/jqtransform.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Modificación de Bonificaciones de Movimientos Diversos (otros ingresos)</title>
        
        <script type="text/javascript">
           
           $(function (){
           
                
           
           $('input.datepicker').Zebra_DatePicker();
           
                    
           $("form.jqtransform").jqTransform();
                    
           $("#frmbonificaciones").validate(
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
                        
                        
                        serie:{ 
                                required: true,
                                pattern: /^[A-Z]{1}?$/
                                
                               },
                        recibo:{ 
                                required: true,
                                min: 1
                                
                                
                                },
                        imp_cap:{ 
                                required: true,
                                pattern: /^[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                               },
                      imp_int: {
                                
                                required: true,
                                pattern: /^[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                      imp_adm: {
                                
                                required: true,
                                pattern: /^[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                      imp_seg: {
                                
                                required: true,
                                pattern: /^[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                      imp_osg: {
                                
                                required: true,
                                pattern: /^[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                       estatus:{ 
                                required: true,
                                pattern: /^[A-B]{1}?$/
                                
                               },
                 id_catbonific:{ 
                                required: true,
                                min: 1
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
                        
                        serie:{

                            required: "serie es obligatoria",

                            pattern:   'Solo se aceptan letras de la A-Z'
                               },
                        recibo:{

                            required: "recibo es obligatorio",
                            min: function (p, element) {

                                                            return "el recibo tiene que tener mínimo un valor de 1";

                                                       }
                                
                               },
                       imp_cap:{

                            required: "imp_cap es obligatoria",

                            pattern:   'Solo se aceptan numeros con tres decimales'
                               },      
                       imp_int:{

                            required: "imp_int es obligatorio",

                            pattern:   'Solo se aceptan numeros con tres decimales'
                               },
                       imp_adm:{

                            required: "imp_adm es obligatorio",

                            pattern:   'Solo se aceptan números con tres decimales'
                               },
                       imp_seg:{

                            required: "imp_seg es obligatorio",

                            pattern:   'Solo se aceptan números con tres decimales'
                               },
                       imp_osg:{

                            required: "imp_osg es obligatorio",

                            pattern:   'Solo se aceptan números con tres decimales'
                               },
                       estatus:{

                            required: "estatus es obligatoria",

                            pattern:   'Solo se aceptan letras (A/B)'
                               },
                 id_catbonific:{

                        required: "cat_bonific es obligatoria",

                        min: function (p, element) {

                                                            return "es obligatorio seleccionar una opción del cat. de bonificaciones";

                                                   }
                               }

                       }       

            });
        });

        </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="Bonificaciones" scope="request" class="javabeans.Bonificaciones"/>

    <%
    if((request.getParameter("numcontrato")!=null) && (request.getParameter("serie")!=null) )
    {
        Integer idCatprog = Integer.parseInt(request.getParameter("idCatprog"));
        Bonificaciones.setId_catprog(idCatprog);
        Integer id_catbonific = Integer.parseInt(request.getParameter("id_catbonific"));
        Bonificaciones.setId_catbonific(id_catbonific);
        
        String serie=request.getParameter("serie");
        Bonificaciones.setSerie(serie);
        Integer recibo=Integer.parseInt(request.getParameter("recibo"));
        Bonificaciones.setRecibo(recibo);
               
        BigDecimal imp_cap;
        if((request.getParameter("imp_cap")!=null) && (request.getParameter("imp_cap")!=""))
        {
            imp_cap = new BigDecimal(request.getParameter("imp_cap"));
        }else
        {
            imp_cap = new BigDecimal(0.00);
        }
        Bonificaciones.setImp_cap(imp_cap);
        
        BigDecimal imp_int;
        if((request.getParameter("imp_int")!=null) && (request.getParameter("imp_int")!=""))
        {
            imp_int = new BigDecimal(request.getParameter("imp_int"));
        }else
        {
            imp_int = new BigDecimal(0.00);
        }
        Bonificaciones.setImp_int(imp_int);
        
        BigDecimal imp_adm;
        if((request.getParameter("imp_adm")!=null) && (request.getParameter("imp_adm")!=""))
        {
            imp_adm = new BigDecimal(request.getParameter("imp_adm"));
        }else
        {
            imp_adm = new BigDecimal(0.00);
        }
        Bonificaciones.setImp_adm(imp_adm);
        
        
        BigDecimal imp_seg;
        if((request.getParameter("imp_seg")!=null) && (request.getParameter("imp_seg")!=""))
        {
            imp_seg = new BigDecimal(request.getParameter("imp_seg"));
        }else
        {
            imp_seg = new BigDecimal(0.00);
        }
        Bonificaciones.setImp_seg(imp_seg);
        
        BigDecimal imp_osg;
        if((request.getParameter("imp_osg")!=null) && (request.getParameter("imp_osg")!=""))
        {
            imp_osg = new BigDecimal(request.getParameter("imp_osg"));
        }else
        {
            imp_osg = new BigDecimal(0.00);
        }
        Bonificaciones.setImp_osg(imp_osg);
               
        String estatus=request.getParameter("estatus");
        Bonificaciones.setEstatus(estatus);
        String numcontrato=request.getParameter("numcontrato");
        Bonificaciones.setNumcontrato(numcontrato);
    %>
           
        <jsp:forward page="controladorbonificaciones?operacion=grabar"/>
    <%}%>
    
    <body>
        <center> 
            <h1>Captura de Bonificaciones de Diversos (Otros Ingresos)</h1>
            <form name="frmbonificaciones" id="frmbonificaciones" class="jqtransform" method="post">
                <br/>
                <fieldset style="border: 2px solid #8A0808; width: 800px; ; border-radius: 10px; ">
                <legend align="right"><img src="imagenes/cortecaja.png" width="40" height="40" alt="bonificaciones" />Datos de la Bonificación</legend>
                <table class="fuente8" width="80%" cellspacing="0" cellpadding="3" border="0">
                    <tr>
                        <td width="10%" align="left">Condición Financiera/Programa:</td>
                        <td width="30%" align="left">
                            <select name="idCatprog" id="idCatprog">
                                <OPTION VALUE="0" selected="selected">Selecciona una opción del catálogo...</OPTION>
                                <c:forEach  var="cat" items="${requestScope.catprog}">
                                    <OPTION VALUE="${cat.id_Catprog}">${cat.clave}-${cat.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="10%" align="left">Número de Contrato</td>
                        <td width="30%" align="left"><input type="text" name="numcontrato" id="numcontrato" class="cajaPequena" size="5" maxlength="5"></td>
                    </tr>
                                        
                    <tr>
                        <td width="10%" align="left">Serie</td>
                        <td width="30%" align="left"><input type="text" name="serie" id="serie" class="cajaPequena"  size="2" maxlength="1" > </td>
                        <td width="10%" align="left">Recibo</td>
                        <td width="30%" align="left"><input type="text" name="recibo" id="recibo"   size="6" value="1"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Imp. a Capital</td>
                        <td width="30%" align="left"><label for="imp_cap">$</label><input type="text" name="imp_cap" id="imp_cap" size="12" maxlength="10" value="0.00"  > </td>
                        <td width="10%" align="left">Imp. a Interes</td>
                        <td width="30%" align="left"><label for="imp_int">$</label><input type="text" name="imp_int" id="imp_int" size="12" maxlength="10" value="0.00" > </td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Imp. a Admón.</td>
                        <td width="30%" align="left"><label for="imp_adm">$</label><input type="text" name="imp_adm" id="imp_adm"    size="12" maxlength="10"   value="0.00"> </td>
                        <td width="10%" align="left">Imp. a Seguro</td>
                        <td width="30%" align="left"><label for="imp_seguro">$</label><input type="text" name="imp_seg" id="imp_seg"    size="12"  maxlength="10" value="0.00"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Imp. a Otros seg.</td>
                        <td width="30%" align="left"><label for="imp_osg">$</label><input type="text" name="imp_osg" id="imp_osg"    size="12" maxlength="10"   value="0.00"> </td>
                        <td width="10%" align="left">Estatus</td>
                        <td width="30%" align="left"><input type="text" name="estatus" id="estatus" class="cajaPequena"  size="2"  maxlength="1" value="A"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Clave de Bonificación</td>
                        <td width="30%" align="left">
                            <select name="id_catbonific" id="id_catbonific">
                                <OPTION VALUE="0" selected="selected">Selecciona una opción del catálogo...</OPTION>
                                <c:forEach  var="cat_bonific" items="${requestScope.cat_bonific}">
                                    <OPTION VALUE="${cat_bonific.id_bonific}">${cat_bonific.clave_bonific}-${cat_bonific.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="10%" align="left"></td>
                        <td width="30%" align="left"></td>
                    </tr>
                    
                    
                </table>
                <br/>
                <input type="submit"  name="Submit" value="Grabar"   >
                <input type="reset"  value="Deshacer" >
           </fieldset> 
           </form>
        </center>

    </body>
</html>
