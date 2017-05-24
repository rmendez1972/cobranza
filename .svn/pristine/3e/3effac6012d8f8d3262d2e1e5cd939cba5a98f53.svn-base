<%-- 
    Document   : frmmodificacatprog
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
        <title>Formulario de Modificación de Movimientos Diversos (otros ingresos)</title>
        
        <script type="text/javascript">
           
           function modificaaplicado()
            {
                if (document.frmmodificamov_diversos.aplicado2.checked)
                {    
                    
                    document.forms.frmmodificamov_diversos.aplicado.value="true";
                    
                }    
                else
                {    
                    
                    document.frmmodificamov_diversos.aplicado.value="false";
                    
                }
            }
           
           
           $(function (){
           
                
           
           $('input.datepicker').Zebra_DatePicker();
           
           
           
           var aplicado=${mov_diversos.aplicado};    // asignamos el valor de la propiedad status a una variable de javascript
           if (aplicado==true)
           {
                    
                    document.frmmodificamov_diversos.aplicado2.checked=true;
               
           }
           else
           {
                    
                    document.frmmodificamov_diversos.aplicado2.checked=false;
           }    
           
           $("form.jqtransform").jqTransform();
                    
           $("#frmmodificamov_diversos").validate(
           {

                rules: {
                        poliza:{ 
                                required: true,
                                pattern: /^[I]{1}(\d{3})?$/
                                
                               },
                        recibo:{ 
                                required: true,
                                min: 0
                                
                                
                                },
                        poliza_apli:{ 
                                required: true,
                                pattern: /^[D]{1}(\d{3})?$/
                                
                               },
                        estatus:{ 
                                required: true,
                                pattern: /^[A-B]{1}?$/
                                
                               },
                        cargo: {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,2})?$/
                                
                                                               
                               },
                        abono: {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,2})?$/
                                
                                                               
                               }
                       },
                       
             messages: {
                 
                        poliza:{

                            required: "poliza es obligatoria",

                            pattern:   'Solo se aceptan poliza de la forma I999'
                               },
                        recibo:{

                            required: "recibo es obligatorio",
                            min: function (p, element) {

                                                            return "el recibo tiene que tener mínimo un valor de 0";

                                                       }
                                
                               },
                   poliza_apli:{

                            required: "poliza_apli es obligatoria",

                            pattern:   'Solo se aceptan poliza de la forma D999'
                               },      
                      estatus:{

                            required: "estatus es obligatorio",

                            pattern:   'Solo se aceptan (A/B)'
                               },
                         cargo:{

                            required: "cargo es obligatorio",

                            pattern:   'Solo se aceptan números con dos decimales'
                               },
                         abono:{

                            required: "abono es obligatorio",

                            pattern:   'Solo se aceptan números con dos decimales'
                               }
                            

                       }      


            }); 
        });

        </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="Movdiversos" scope="request" class="javabeans.Movdiversos"/>

    <%
    if((request.getParameter("clave_div")!=null) && (request.getParameter("fecha_div")!=null) )
    {
        Integer id_movdiversos = Integer.parseInt(request.getParameter("id_movdiversos"));
        Movdiversos.setId_movdiversos(id_movdiversos);
        Integer id_bendiv = Integer.parseInt(request.getParameter("id_bendiv"));
        Movdiversos.setId_bendiv(id_bendiv);
        
        String clave_div=request.getParameter("clave_div");
        Movdiversos.setClave_div(clave_div);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_div=sdf.parse(request.getParameter("fecha_div"));
        Movdiversos.setFecha_div(fecha_div);
        String poliza=request.getParameter("poliza");
        Movdiversos.setPoliza(poliza);
        Integer recibo = Integer.parseInt(request.getParameter("recibo"));
        Movdiversos.setRecibo(recibo);
        
        BigDecimal cargo;
        if((request.getParameter("cargo")!=null) && (request.getParameter("cargo")!=""))
        {
            cargo = new BigDecimal(request.getParameter("cargo"));
        }else
        {
            cargo = new BigDecimal(0.00);
        }
        Movdiversos.setCargo(cargo);
        
        BigDecimal abono;
        if((request.getParameter("abono")!=null) && (request.getParameter("abono")!=""))
        {
            abono = new BigDecimal(request.getParameter("abono"));
        }else
        {
            abono = new BigDecimal(0.00);
        }
        Movdiversos.setAbono(abono);
        
        BigDecimal moratorios;
        if((request.getParameter("moratorios")!=null) && (request.getParameter("moratorios")!=""))
        {
            moratorios = new BigDecimal(request.getParameter("moratorios"));
        }else
        {
            moratorios = new BigDecimal(0.00);
        }
        Movdiversos.setMoratorios(moratorios);
        
        BigDecimal otros;
        if((request.getParameter("otros")!=null) && (request.getParameter("otros")!=""))
        {
            otros = new BigDecimal(request.getParameter("otros"));
        }else
        {
            otros = new BigDecimal(0.00);
        }
        Movdiversos.setOtros(otros);
        
        String clave_b=request.getParameter("clave_b");
        Movdiversos.setClave_b(clave_b);
        
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_pol=sdf2.parse(request.getParameter("fecha_pol"));
        Movdiversos.setFecha_pol(fecha_pol);
        
        String poliza_apli=request.getParameter("poliza_apli");
        Movdiversos.setPoliza_apli(poliza_apli);
        
        String estatus=request.getParameter("estatus");
        Movdiversos.setEstatus(estatus);
        
        Boolean aplicado = Boolean.parseBoolean(request.getParameter("aplicado"));
        Movdiversos.setAplicado(aplicado);
        
        String descripcion=request.getParameter("descripcion");
        Movdiversos.setDescripcion(descripcion);
    %>
           
        <jsp:forward page="controladormov_diversos?operacion=modificar"/>
    <%}%>
    
    <body>
        <center> 
            <h1>Modificación a Movimientos Diversos (Otros Ingresos)</h1>
            <form name="frmmodificamov_diversos" id="frmmodificamov_diversos" class="jqtransform" method="post">
                <br/>
                <fieldset style="border: 2px solid #8A0808; width: 800px; ; border-radius: 10px; ">
                <legend align="right"><img src="imagenes/cortecaja.png" width="40" height="40" alt="Mov. Diverso" />Datos del Mov. Diverso</legend>
                <table class="fuente8" width="80%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="10%" align="left">Id</td>
                        <td width="30%" align="left"><c:out value="${mov_diversos.id_movdiversos}" /><input type="hidden" name="id_movdiversos" value="${mov_diversos.id_movdiversos}"></td>
                        <td width="10%" align="left">Id Ben. Div.</td>
                        <td width="30%" align="left"><c:out value="${mov_diversos.id_bendiv}" /><input type="hidden" name="id_bendiv" value="${mov_diversos.id_bendiv}"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Clave Div.</td>
                        <td width="30%" align="left">
                            <select name="clave_div" id="clave_div">
                                
                                
                                <c:forEach  var="clave_div" items="${requestScope.clave_div}">
                                    
                                    <OPTION VALUE="${clave_div.clave_div}" ${mov_diversos.clave_div == clave_div.clave_div ? 'selected' : ''}>${clave_div.clave_div}-${clave_div.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="10%" align="left">Fecha Mov.</td>
                            <td width="30%" align="left"><input type="text" name="fecha_div" id="fecha_div"  class="datepicker" size="11"   value="${mov_diversos.fecha_div}"> </td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Poliza</td>
                        <td width="30%" align="left"><input type="text" name="poliza" id="poliza"   size="4"  value="${mov_diversos.poliza}"> </td>
                        <td width="10%" align="left">Recibo</td>
                        <td width="30%" align="left"><input type="text" name="recibo" id="recibo"   size="6"   value="${mov_diversos.recibo}"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Cargo</td>
                        <td width="30%" align="left"><label for="cargo">$</label><input type="text" name="cargo" id="cargo"    size="12" maxlength="10"   value="${mov_diversos.cargo}"> </td>
                        <td width="10%" align="left">Abono</td>
                        <td width="30%" align="left"><label for="abono">$</label><input type="text" name="abono" id="abono"    size="12" maxlength="10"   value="${mov_diversos.abono}"> </td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Moratorios</td>
                        <td width="30%" align="left"><label for="moratorios">$</label><input type="text" name="moratorios" id="moratorios"    size="12" maxlength="10"   value="${mov_diversos.moratorios}"> </td>
                        <td width="10%" align="left">Otros</td>
                        <td width="30%" align="left"><label for="otros">$</label><input type="text" name="otros" id="otros"    size="12"  maxlength="10"   value="${mov_diversos.otros}"> </td>
                    </tr>
                    <tr>
                        
                        <td width="10%" align="left">Fecha de Aplicacion</td>
                        <td width="30%" align="left"><input type="text" name="fecha_pol" id="fecha_pol"  class="datepicker" size="11"   value="${mov_diversos.fecha_pol}"> </td>
                        <td width="10%" align="left">Poliza de Aplicacion</td>
                        <td width="30%" align="left"><input type="text" name="poliza_apli" id="poliza_apli"   size="4"   value="${mov_diversos.poliza_apli}"> </td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Estatus del Movimiento</td>
                        <td width="30%" align="left"><input type="text" name="estatus" id="estatus"    size="2" maxlength="1"   value="${mov_diversos.estatus}"><input type="hidden" name="clave_b" id="clave_b"    size="10" maxlength="12"   value="${mov_diversos.clave_b}"> </td>
                        <td width="10%" align="left">Aplicado al Edo. de Cuenta</td>
                        <td width="30%" align="left"><input type="checkbox" name="aplicado2" id="aplicado2" onChange="modificaaplicado()" ><input type="hidden" name="aplicado" id="aplicado"  value="${mov_diversos.aplicado}"> </td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Descripcion del Mov.</td>
                        <td width="30%" align="left"><textarea name="descripcion" id="descripcion" style="text-transform: uppercase"  maxlength="120" rows="3" cols="40" ><c:out value="${mov_diversos.descripcion}" /> </textarea></td>
                        <td width="10%" align="left"></td>
                        <td width="30%" align="left"> </td>
                    </tr>
                    
                </table>
                <br/>
                <input type="submit"  name="Submit" value="Modificar"   >
                <input type="reset"  value="Deshacer" >
           </fieldset> 
           </form>
        </center>

    </body>
</html>
