<%-- 
    Document   : frmcajas
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>



<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="javabeans.Cajas"%>

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
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Apertura de Cajas</title>
        
        <script type="text/javascript">
           
           
           $(function (){
           
                
           
           $('input.datepicker').Zebra_DatePicker();
           
           
           $("form.jqtransform").jqTransform();
                    
           $("#frmcajas").validate(
           {

                rules: {
                       
                  folio_inicial:{ 
                                required: true,
                                min: 1
                                
                                
                                },
                    folio_final:{ 
                                required: true,
                                min: 0
                                
                                
                                },
                         poliza:{ 
                                required: true,
                                pattern: /^[I]{1}(\d{3})?$/
                                
                                },   
                        
                 monto_inicial: {
                                
                                required: true,
                                pattern: /^[0-9]{1,7}(\.[0-9]{0,2})?$/
                                
                                                               
                               }
                                                  
                       },
                       
             messages: {
                 
                        
                 folio_inicial:{

                            required: "folio_inicial es obligatorio",
                            min: function (p, element) {

                                                            return "el folio inicial tiene que tener mínimo un valor de 1";

                                                       }
                                
                               },
                               
                   folio_final:{

                            required: "folio_final es obligatorio",
                            min: function (p, element) {

                                                            return "el folio final tiene que tener mínimo un valor de 0";

                                                       }
                                
                               },
                           
                        poliza:{

                            required: "poliza es obligatoria",

                            pattern:   'Solo se aceptan pólizas de Ingreso (I000)'
                               },
                        
                 monto_inicial:{

                            required: "monto inicial es obligatorio",

                            pattern:   'Solo se aceptan números con dos decimales'
                               }
                       

                       }      


            }); 
        });

        </script>


    </head>
    
     <jsp:useBean id="cajas" scope="request" class="javabeans.Cajas"/>

    <%
    if((request.getParameter("folio_inicial")!=null) && (request.getParameter("folio_final")!=null))
    {
                               
        
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=sdf.parse(request.getParameter("fecha"));
        cajas.setFecha(fecha);
        String poliza=request.getParameter("poliza");
        cajas.setPoliza(poliza);
        Integer folio_inicial = Integer.parseInt(request.getParameter("folio_inicial"));
        cajas.setFolio_inicial(folio_inicial);
        Integer folio_final = Integer.parseInt(request.getParameter("folio_final"));
        cajas.setFolio_final(folio_final);
        BigDecimal monto_inicial;
        if((request.getParameter("monto_inicial")!=null) && (request.getParameter("monto_inicial")!=""))
        {
            monto_inicial = new BigDecimal(request.getParameter("monto_inicial"));
        }else
        {
            monto_inicial = new BigDecimal(0.00);
        }
        cajas.setMonto_inicial(monto_inicial);
        
        
    %>
           
        <jsp:forward page="controladorcajas?operacion=grabar"/>
    <%}%>
   
    
    <body>
        <center> 
            <h1>Apertura de Caja </h1>
            <form name="frmcajas" id="frmcajas" class="jqtransform" method="post">
                <br/>
                <fieldset style="border: 2px solid #8A0808; width: 800px; ; border-radius: 10px; ">
                <legend align="right"><img src="imagenes/cortecaja.png" width="40" height="40" alt="Apertura Caja" />Apertura de Cajas</legend>
                <table class="fuente8" width="80%" cellspacing="0" cellpadding="3" border="0">
                    <tr>
                        
                        
                        <td width="40%" align="left" >
                            <label for="fecha">Fecha:</label> <input type="text" name="fecha" id="fecha"  class="datepicker" size="11"   >
                        </td>
                        
                        <td width="40%" align="left">
                            <label for="folio_inicial">Folio Inicial:</label><input type="text" name="folio_inicial" id="folio_inicial" size="5" maxlength="5"   value="1"> 
                        </td>    
                    </tr>
                    
                    <tr>
                                                
                        <td width="40%" align="left">
                            <label for="folio_final">Folio Final:</label><input type="text" name="folio_final" id="folio_final" size="5" maxlength="5" value="0"> 
                        </td>
                        <td width="40%" align="left">
                            <label for="poliza">Póliza:</label><input type="text" name="poliza" id="poliza"   size="4"  value="I000">
                        </td>
                    </tr>
                    
                    <tr>
                                                
                        <td width="40%" align="right">
                            <label for="monto_inicial">Monto Inicial:</label><input type="text" name="monto_inicial" id="monto_inicial" size="8" maxlength="10" value="000.00" style="text-align:right"> 
                        </td>
                        <td width="40%" align="left">
                            
                        </td>
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