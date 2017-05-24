<%-- 
    Document   : listarbenefreferencia
    Created on : 23/10/2012, 02:32:54 PM
    Author     : Rafael Mendez
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javabeans.Movdiversos"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        
        <link href="js/Fixed-Header-Table-master/css/defaultTheme.css" rel="stylesheet" media="screen" />
        <link href="js/Fixed-Header-Table-master/demo/css/960.css" rel="stylesheet" media="screen" />
        <link href="js/Fixed-Header-Table-master/demo/css/demo.css" rel="stylesheet" media="screen" />
        <link href="js/jqtransform/jqtransformplugin/jqtransform.css" rel="stylesheet" type="text/css">
        
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/additional-methods.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.tablesorter.js"></script>
        <script src="js/jquery.fixedheadertable.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jqtransform/jqtransformplugin/jquery.jqtransform.js"></script>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beneficiario con Orden de Cobro Generada para Solicitar Referencia a SH</title>
        <script>
            /*variable que trae la bandera de exito o fracaso del modelo*/
            //var bandera='$//{request.mensaje}';
            var bandera='${requestScope.exito}';
            if (bandera=='false')
            {
                alert ('No se grabo por que registro ya existe');
            }
            else
            {
                alert ('Registro grabado/localizado/modificado/borrado exitosamente');
            }
            
           
            
             $(function()
            {
                
                $('input.datepicker').Zebra_DatePicker();
                
                //$("form.jqtransform").jqTransform();
                
                
                
                $('#tablePlaceholder table').fixedHeaderTable({ height: '200', altClass: 'odd', themeClass: 'fancyDarkTable' });
                
                //llamando al controlador servlet que llama al cliente ws
                $("#calcular").click(function()
                {
                    alert('solicitando referencia a ws de SH para id '+$(this).val());
                    //Observese que la respuesta viene del servlet
                    $.getJSON("controladorclientews", ////////En esta parte va el nombre de tu acttion que es el servelet controladorcolonias
                    {
                        //evaluar el id de paises
                        id: $(this).val(),     // aqui se agrega al contexto del request un nuevo parametro que se recupera en controladorcolonias2 para hacer el where
                        nombre: document.forms.benefreferencia.nombre.value,
                        ajax: 'true'
                        
                    },
                    function(data)
                    {
                                                
                        //limpiar el option value
                        
                        $("#referencia").html("");
                        
                        //$("#referencia").append("<table border='1'>");
                        //$("#referencia").append("<thead><tr><th widht='30px' >Fecha</th><th widht='30px' >Letra</th><th widht='30px' >P.Capital</th><th widht='40px'>P.Interes</th><th widht='40px'>P.Admon</th><th widht='40px'>P.Seguro</th><th widht='40px'>P.Otros Seg.</th><th widht='40px'>P.Comisiones</th><th widht='40px'>P.Titulación</th><th widht='40px'>P.Moratorios</th>  </tr></thead>");
                        //$("#referencia").append("<tbody>");
                        $.each(data.Vencidos, function(i,item2){
                            $("#referencia").append(item2.referencia);
                        });
                        //$("#referencia").append("</tbody>");
                        //$("#referencia").append("</table>");
                        
                    });
                });
                
                
                
            });
            
        </script>
    </head>
    
        
    <body>
        <center> 
        <h2>Beneficiario con Orden de Cobro Generada para Solicitar Referencia de SH</h2>
        <form name="benefreferencia" id="benefreferencia" class="jqtransform" method="post">
            <br>
            
            <fieldset  style="border: 2px solid #8A0808; width: 800px; border-radius: 10px; ">
                <legend align="right"><img src="imagenes/xprogramas.png" width="40" height="40" alt="Beneficiarios para referencia" />Generales de la Orden de Cobro Generada desde sistema de Cobranza</legend>
                
                <table  width="80%" cellspacing="0" cellpadding="3" border="0">
                    <tr>
                        <td width="10%" align="left">Id:</td>
                        <td width="30%" align="left" style="font-size:12px"><c:out value="${benefreferencia.id}" /></td>
                        <td width="10%" align="left">Referencia SH:</td>
                        <td width="30%" align="left" style="font-size:12px"><div name="referencia" id="referencia"> </div></td>
                        
                    </tr>
                    <tr>
                        <td width="10%" align="left">Nombre de Beneficiario:</td>
                        <td width="30%" align="left" style="font-size:12px"><c:out value="${benefreferencia.nombre}" /><input type="hidden" name="nombre" value="${benefreferencia.nombre}"></td>
                        <td width="10%" align="left">Contrato SEDUVI:</td>
                        <td width="30%" align="left" style="font-size:12px"><c:out value="${benefreferencia.contrato_seduvi}" /><input type="hidden" name="contrato_seduvi" value="${benefreferencia.contrato_seduvi}"></td>
                        
                    </tr>
                    <tr>
                        <td width="10%" align="left">Fecha de Vencimiento:</td>
                        <td width="30%" align="left" style="font-size:12px"><c:out value="${benefreferencia.fecha_vencimiento}" /><input type="hidden" name="fecha_vencimiento" value="${benefreferencia.fecha_vencimiento}"></td>
                        <td width="10%" align="left">Monto de Enganche:</td>
                        <td width="30%" align="left" style="font-size:12px"><c:out value="${benefreferencia._1_1}" /><input type="hidden" name="_1_1" value="${benefreferencia._1_1}"></td>
                     </tr>
                    
                </table>  
                <table  width="80%" cellspacing="0" cellpadding="3" border="0">
                    <tr>
                        <td width="50%" align="right"></td><td width="30%"> Solicita Referencia a SH <button type="button" name="calcular" id="calcular" title="solicita referencia a SH" value="${benefreferencia.id}" ><img src="imagenes/actualizacion.png"  width="30" height="30" alt="solicita referencia" /></button></td>
                    </tr>
                                
                </table>        
            </fieldset> 
            
        </form>
    </center>
    </body>
</html>
