<%-- 
    Document   : listaredoctamovdiversos
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
        <title>Estado de cuenta de Movimientos Diversos (otros ingresos)</title>
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
            
            function marcacheck()
            {
                
                for (i=0;i<document.frmaperturaedoscta.elements.length;i++)	
	
	
 		if(document.frmaperturaedoscta.elements[i].type == "checkbox")
		{
                    document.frmaperturaedoscta.elements[i].checked=true;
   		   
                }


            } 
            
            
            function desmarcacheck()
            {
                
                for (i=0;i<document.frmaperturaedoscta.elements.length;i++)	
	
	
 		if(document.frmaperturaedoscta.elements[i].type == "checkbox")
		{
                    document.frmaperturaedoscta.elements[i].checked=false;
   		   
                }


            }
            
            function enviar_formulario()
            { 
                for (i=0;i<document.forms.frmaperturaedoscta.elements.length;i++)	
	
	
 		if(document.frmaperturaedoscta.elements[i].type == "checkbox")
		{
	
   		   if (document.frmaperturaedoscta.elements[i].disabled==false && document.forms.frmaperturaedoscta.elements[i].checked==true)
                   {

                        
	
                        id_candidato=document.forms.frmaperturaedoscta.elements[i].name;
	
	
                        
		   }
                }
                
                
                
                
                
                document.frmaperturaedoscta.id_candidato.value=id_candidato;
                alert('id_candidato '+document.frmaperturaedoscta.id_candidato.value+' poliza '+document.frmaperturaedoscta.poliza.value+' fecha poliza '+document.frmaperturaedoscta.fecha_poliza.value);
                document.frmaperturaedoscta.submit() 
            } 
            
            
            $(document).ready(function()
            {
                
                $("form.jqtransform").jqTransform();
                $('input.datepicker').Zebra_DatePicker();
                
                
                //alert('dentro de jquery');
                $('#tablePlaceholder table').fixedHeaderTable({ height: '200', altClass: 'odd', themeClass: 'fancyDarkTable' });
                $("#frmaperturaedoscta").validate(
           {

                rules: {
                              
                  poliza: {
                                
                                
                                pattern: /^[D]{1}(\d{3})?$/
                                
                                
                                
                           }
                   
                                  

                       },
                       
             messages: {
                 
                         
                poliza: {
                        
                        
                        
                        pattern:   'Solo se aceptan Polizas de Diario de la forma (D001)'
                        
       
                         }
                
               

                       }      


            });
                
            });
            
        </script>
    </head>
    
        
    <body>
        <center> 
        <h2>Mto. a Estados de Cuenta de Movimientos Diversos (otros ingresos)</h2>
        <form name="mov_diversos" id="mov_diversos" class="jqtransform" method="post">
            <br>
            
            <fieldset  style="border: 2px solid #8A0808; width: 800px; border-radius: 10px; ">
                <legend align="right"><img src="imagenes/xprogramas.png" width="40" height="40" alt="Benef. Diversos" />Generales del Benef. Diverso</legend>
                
                <table  width="90%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="10%" align="left">Curp:</td>
                        <td width="20%" align="left"><c:out value="${benef_div.curp}" /></td>
                        <td width="10%" align="left">Clave Elector:</td>
                        <td width="20%" align="left"><c:out value="${benef_div.clave_elect}" /></td>
                        <td width="10%" align="left">Manzana:</td>
                        <td width="20%" align="left"><c:out value="${benef_div.mza}" /></td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Clave SEDUVI:</td>
                        <td width="20%" align="left"><c:out value="${benef_div.clave_b}" /></td>
                        <td width="10%" align="left">Nombre:</td>
                        <td width="20%" align="left"><c:out value="${benef_div.nombre}" /></td>
                        <td width="10%" align="left">Lote:</td>
                        <td width="20%" align="left"><c:out value="${benef_div.lte}" /></td>
                    </tr>
                    
                    
                </table>    
            </fieldset> 
            
            <fieldset style="border: 2px solid #8A0808; width: 800px; ; border-radius: 10px; ">
            <legend align="right"><img src="imagenes/cortecaja.png" width="40" height="40" alt="Movimientos" />Movimientos Diversos</legend>
            <a href="controladormtomovdiv?operacion=capturar" align="right" ><img src="imagenes/capturar.png" width="24" height="24" alt="capturar" />Agregar</a>
            <div class="container_12">
            <div id="tablePlaceholder" class="grid_12 alpha omega">
          
                <table>
                    <thead>
                        <tr><th widht="30px" >Editar</th><th widht="30px" >Eliminar</th><th widht="30px" >Clave Div.</th><th widht="20px" >Fecha de Mov.</th><th widht="30px" >Poliza</th><th widht="30px">Recibo</th><th widht="30px" >Cargo</th><th widht="30px">Abono</th><th widht="30px">Moratorios</th> <th widht="30px">Otros</th> <th widht="10px">Fecha de Apli.</th> <th widht="10px">Poliza de Apli.</th> <th widht="10px">Estatus del Mov.</th><th widht="10px">Aplicado Edo. Cta.</th> <th widht="50px">Descripción de Mov.</th> </tr>
                    </thead>

                    <tbody>   
                        <c:forEach var="diversos" items="${requestScope.mov_diversos}" varStatus="loop"> 
                            <tr class="${loop.index % 2 == 0 ? 'odd':'imp'}"> 
                                <td  width="30px"><a href="controladormtomovdiv?operacion=ubicar&id_movdiversos=${diversos.id_movdiversos}" ><img src="imagenes/editar.png" width="24" height="24" alt="editar" /></a></td><td  width="30px"><a href="controladormtomovdiv?operacion=borrar&id_movdiversos=${diversos.id_movdiversos}" ><img src="imagenes/eliminar.png" width="24" height="24" alt="editar" /></a></td> <td  width="30px"><c:out value="${diversos.clave_div}" /></td> <td widht="20px" ><c:out value="${diversos.fecha_div}" /></td> <td widht="30px"><c:out value="${diversos.poliza}" /></td> <td widht="30px"><c:out value="${diversos.recibo}" /></td> <td widht="30px"><c:out value="${diversos.cargo}" /></td> <td widht="30px"><c:out value="${diversos.abono}" /></td> <td widht="30px"><c:out value="${diversos.moratorios}" /></td> <td widht="30px"><c:out value="${diversos.otros}" /></td> <td widht="20px"><c:out value="${diversos.fecha_pol}" /></td><td widht="20px"><c:out value="${diversos.poliza_apli}" /></td><td widht="20px"><c:out value="${diversos.estatus}" /></td><td widht="20px"><c:out value="${diversos.aplicado}" /></td><td widht="20px"><c:out value="${diversos.descripcion}" /></td> 
                            </tr>

                        </c:forEach>

                    </tbody>
                </table>
             
            </div>
            </div>
            </fieldset>
                    
            <fieldset style="border: 2px solid #8A0808; width: 800px; ; border-radius: 10px; ">
            <legend align="right"><img src="imagenes/cortecaja.png" width="40" height="40" alt="Bonificaciones" />Bonificaciones a Movimientos Diversos</legend>    
            <a href="controladorbonificaciones?operacion=capturar" align="right" ><img src="imagenes/capturar.png" width="24" height="24" alt="capturar" />Agregar</a>
                <div class="container_12">
                <div id="tablePlaceholder" class="grid_12 alpha omega">
          
                <table>
                    <thead>
                        <tr><th widht="30px" >Editar</th><th widht="30px" >Eliminar</th><th widht="100px" >Clave SEDUVI</th><th widht="30px" >Recibo</th><th widht="30px" >Serie</th> <th widht="30px" >Importe Cap.</th><th widht="30px" >Importe Int.</th><th widht="30px" >Importe Admon.</th><th widht="30px" >Importe Seguro</th><th widht="30px" >Importe Otros Seg.</th><th widht="30px" >Estatus</th><th widht="30px" >Clave Bonif.</th> <th widht="30px" >Descripción Bonif.</th></tr> 
                    </thead>

                    <tbody>   
                        <c:forEach var="bonificaciones" items="${requestScope.bonificaciones}" varStatus="loop"> 
                            <tr class="${loop.index % 2 == 0 ? 'odd':'imp'}"> 
                                <td  width="30px"><a href="controladormtomovdiv?operacion=ubicarbonificaciones&id_bonificacion=${bonificaciones.id_bonificacion}" ><img src="imagenes/editar.png" width="24" height="24" alt="editar" /></a></td><td  width="30px"><a href="controladorbonificaciones?operacion=borrar&id_bonificacion=${bonificaciones.id_bonificacion}" ><img src="imagenes/eliminar.png" width="24" height="24" alt="editar" /></a></td><td  width="100px"><c:out value="${bonificaciones.clave_b}" /></td> <td widht="30px" ><c:out value="${bonificaciones.recibo}" /></td> <td widht="30px"><c:out value="${bonificaciones.serie}" /></td> <td widht="30px"><c:out value="${bonificaciones.imp_cap}" /></td> <td widht="30px"><c:out value="${bonificaciones.imp_int}" /></td> <td widht="30px"><c:out value="${bonificaciones.imp_adm}" /></td> <td widht="30px"><c:out value="${bonificaciones.imp_seg}" /></td> <td widht="30px"><c:out value="${bonificaciones.imp_osg}" /></td> <td widht="30px"><c:out value="${bonificaciones.estatus}" /></td><td widht="30px"><c:out value="${bonificaciones.clave_bonific}" /></td> <td widht="30px"><c:out value="${bonificaciones.descripcion}" /></td> 
                             </tr>

                         </c:forEach>

                    </tbody>
                </table>
             
                </div>
                </div>
            </fieldset>
        </form>
    </center>
    </body>
</html>
