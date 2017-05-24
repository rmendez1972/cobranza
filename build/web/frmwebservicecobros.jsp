<%-- 
    Document   : frmwebservicecobros
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
                
                $("form.jqtransform").jqTransform();
                
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
            
           <!--
           <fieldset><legend>Consulta de Conceptos</legend>
                <form name="Test" method="post" action="CobrosServlet">
                    <p>Introduzca el Grupo a Consultar:</p>
                    <p>
                    <p><input type="text" value="60" name="Grupo" size="20">
                    <p>
                    <input type="submit" value="Aceptar" name="Aceptar">
                </form>
            </fieldset>-->
           
            

     
     <form name="Test" method="post" class="jqtransform" action="CobrosGuardarServlet">
         <fieldset  style="border: 2px solid #8A0808; width: 800px; border-radius: 10px; ">
                <legend align="right"><img src="imagenes/xprogramas.png" width="40" height="40" alt="Beneficiarios para referencia" />Generales del Beneficiario SEDUVI</legend>
         <table border="0" cellpadding="3" cellspacing="3">
             <tr><td>RFC</td><td><input type="text" value=" XAXX010101000" name="RFC" size="20" readonly="readonly"></td></tr>             
             <tr><td>CURP</td><td><input type="text" value="" name="CURP" size="20" readonly="readonly"></td></tr>             

             <tr><td>Nombre</td><td><input type="text" value="${benefreferencia.nombre}" name="Nombre" size="70" readonly="readonly"></td></tr>
             <tr><td>Calle</td><td><input type="text" value="" name="Calle" size="70" readonly="readonly"></td></tr>             
             <tr><td>Referencia Calle</td><td><input type="text" value="" name="Referencia_Calle" size="50" readonly="readonly"></td></tr>             
             <tr><td>Numero Exterior</td><td><input type="text" value="" name="Numero_Exterior" size="20" readonly="readonly"></td></tr>             
             <tr><td>Numero Interior</td><td><input type="text" value="" name="Numero_Interior" size="20" readonly="readonly"></td></tr>             
             <tr><td>Colonia</td><td><input type="text" value="" name="Colonia" size="50" readonly="readonly"></td></tr>             
             <tr><td>Codigo Postal</td><td><input type="text" value="" name="Codigo_Postal" size="20" readonly="readonly"></td></tr>             
             <tr><td>Localidad</td><td><input type="text" value="${benefreferencia.loc}" name="Localidad" size="50" readonly="readonly"></td></tr>             
             <tr><td>Municipio</td><td><input type="text" value="${benefreferencia.id_mun}" name="Municipio" size="5" readonly="readonly"></td></tr>             
             <tr><td>Pais</td><td><input type="text" value="MEXICO" name="Pais" size="50" readonly="readonly"></td></tr>             
             <tr><td>Datos Especificos</td><td><input type="text" value="|Numero_Orden:${benefreferencia.numero_orden}|Numero_Contrato:${benefreferencia.contrato_seduvi}|" name="Datos_Especificos" size="70" readonly="readonly"></td></tr>
             <tr><td>Observaciones</td><td><input type="text" value="${benefreferencia.obs}" name="Observaciones" size="70" readonly="readonly"></td></tr>
             <tr><td>Grupo</td><td><input type="text" value="60" name="Grupo" size="5" readonly="readonly" ></td></tr>             
             <tr><td>Total</td><td><input type="text" value="${benefreferencia.total}" name="Total" size="5" readonly="readonly" ></td></tr>
             <tr><td>FechaVencimiento</td><td><input type="text" value="${benefreferencia.fecha_vencimiento}" name="FechaVencimiento" size="8"  ></td></tr>             

         </table>
         </fieldset>
          <fieldset  style="border: 2px solid #8A0808; width: 800px; border-radius: 10px; ">
                <legend align="right"><img src="imagenes/xprogramas.png" width="40" height="40" alt="Movimientos del Cobro" />Detalle de Conceptos de Cobro</legend>   
         <table border="0" cellpadding="3" cellspacing="3" width="80%" >
             <tr><th>Id Concepto</th><th>Descripcion Concepto Cobro</th><th>Cantidad</th><th>Importe Manual</th></tr>
             <tr>
                 <td width="10%"><input type="text" value="1500" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Enganche</td>
                 <td width="10%"><input type="text" value="1" name="cantidad" size="5" readonly="readonly"></td>                     
                 <td width="30%"><input type="text" value="${benefreferencia._1_1}" name="importeManual" size="10" readonly="readonly"></td>                     
             </tr>    

             <tr>
                 <td width="10%"><input type="text" value="1501" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Pago de Contado</td>
                 <td width="10%"><input type="text" value="1" name="cantidad" size="5" readonly="readonly"></td>                     
                 <td width="30%"><input type="text" value="${benefreferencia._1_2}" name="importeManual" size="10" readonly="readonly"></td>                     
             </tr>    
             <tr>
                 <td width="10%"><input type="text" value="1503" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Pago a Capital</td>
                 <td width="10%"><input type="text" value="1" name="cantidad" size="5" readonly="readonly"></td>                     
                 <td width="30%"><input type="text" value="${benefreferencia._1_3_1}" name="importeManual" size="10" readonly="readonly"></td>                     
             </tr>    
             <tr>
                 <td width="10%"><input type="text" value="1504" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Pago a Int. x Financiamiento</td>
                 <td width="10%"><input type="text" value="1" name="cantidad" size="5" readonly="readonly"></td>                     
                 <td width="30%"><input type="text" value="${benefreferencia._1_3_2}" name="importeManual" size="10" readonly="readonly"></td>                     
             </tr>    
             <tr>
                 <td width="10%"><input type="text" value="1505" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Pago a Moratorios</td>
                 <td width="10%"><input type="text" value="1" name="cantidad" size="5" readonly="readonly"></td>                     
                 <td width="30%"><input type="text" value="${benefreferencia._1_3_3}" name="importeManual" size="10" readonly="readonly"></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1506" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Pago a Titulación</td>
                 <td width="10%"><input type="text" value="1" name="cantidad" size="5" readonly="readonly"></td>                     
                 <td width="30%"><input type="text" value="${benefreferencia._2}" name="importeManual" size="10" readonly="readonly"></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1508" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Cesión de Terr. Habitacional</td>
                 <td width="10%"><input type="text" value="${benefreferencia._3_1}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1509" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Cesión de Terr. Comercial</td>
                 <td width="10%"><input type="text" value="${benefreferencia._3_2}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1510" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Cesión de Terr. Reserva</td>
                 <td width="10%"><input type="text" value="${benefreferencia._3_3}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1512" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Sus. de Rescisión Habitacional</td>
                 <td width="10%"><input type="text" value="${benefreferencia._4_1}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1513" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Sus. de Rescisión Comercial</td>
                 <td width="10%"><input type="text" value="${benefreferencia._4_2}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1514" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Sus. de Rescisión Reserva</td>
                 <td width="10%"><input type="text" value="${benefreferencia._4_3}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1515" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Acuerdo Administrativo</td>
                 <td width="10%"><input type="text" value="${benefreferencia._5}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1517" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Permuta de Terr. Habitacional</td>
                 <td width="10%"><input type="text" value="${benefreferencia._6_1}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1518" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Permuta de Terr. Comercial</td>
                 <td width="10%"><input type="text" value="${benefreferencia._6_2}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1519" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Permuta de Terr. Reserva</td>
                 <td width="10%"><input type="text" value="${benefreferencia._6_3}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1521" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Reconocimiento de Tit. Habitacional</td>
                 <td width="10%"><input type="text" value="${benefreferencia._7_1}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1522" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Reconocimiento de Tit. Comercial</td>
                 <td width="10%"><input type="text" value="${benefreferencia._7_2}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1523" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Reconocimiento de Tit. Reserva</td>
                 <td width="10%"><input type="text" value="${benefreferencia._7_3}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1524" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Gastos de Cobranza</td>
                 <td width="10%"><input type="text" value="${benefreferencia._8}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1525" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Gastos de Ejecución</td>
                 <td width="10%"><input type="text" value="${benefreferencia._9}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1526" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Convenio Prorroga de Pago</td>
                 <td width="10%"><input type="text" value="${benefreferencia._10}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1527" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Constancia No propiedad</td>
                 <td width="10%"><input type="text" value="${benefreferencia._11}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1528" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Avalúos por rescisión de Lote</td>
                 <td width="10%"><input type="text" value="${benefreferencia._12}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1530" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Deslinde de Terr. Habitacional por M2</td>
                 <td width="10%"><input type="text" value="${benefreferencia._13_1}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1531" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Deslinde de Terr. Comercial por M2</td>
                 <td width="10%"><input type="text" value="${benefreferencia._13_2}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1532" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Deslinde de Terr. Reserva por M2</td>
                 <td width="10%"><input type="text" value="${benefreferencia._13_3}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1533" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Pago Edo. Cuenta</td>
                 <td width="10%"><input type="text" value="${benefreferencia._14}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1534" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Copias Fotostáticas</td>
                 <td width="10%"><input type="text" value="${benefreferencia._15}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1535" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Pago de Inscripción de Concurso</td>
                 <td width="10%"><input type="text" value="${benefreferencia._16}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1537" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Cert. de Copias Iera Hoja d/juego</td>
                 <td width="10%"><input type="text" value="${benefreferencia._17_1}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1538" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Cert. de Copias Hojas Sub. de Juego/hoja</td>
                 <td width="10%"><input type="text" value="${benefreferencia._17_2}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1539" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Reposición de Tarjetones</td>
                 <td width="10%"><input type="text" value="${benefreferencia._18}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1540" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Elaboración de croquis</td>
                 <td width="10%"><input type="text" value="${benefreferencia._19}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             <tr>
                 <td width="10%"><input type="text" value="1541" name="idConcepto" size="5" readonly="readonly"></td>
                 <td width="30%">Fotocopias de documentos de crédito</td>
                 <td width="10%"><input type="text" value="${benefreferencia._20}" name="cantidad" size="5" ></td>                     
                 <td width="30%"><input type="text" value="0" name="importeManual" size="10" ></td>                     
             </tr>
             
         </table>
          </fieldset>
     <p>
     <input type="submit" value="Solicita Referencia a SH" name="Aceptar">
     </form>
     </fieldset>
        </center>
    </body>
</html>
