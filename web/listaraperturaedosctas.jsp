<%-- 
    Document   : listaraperturaedoscta
    Created on : 23/10/2012, 02:32:54 PM
    Author     : Rafael Mendez
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        
        <link href="js/Fixed-Header-Table-master/css/defaultTheme.css" rel="stylesheet" media="screen" />
        <link href="js/Fixed-Header-Table-master/demo/css/960.css" rel="stylesheet" media="screen" />
        <link href="js/Fixed-Header-Table-master/demo/css/demo.css" rel="stylesheet" media="screen" />
        
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/additional-methods.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.tablesorter.js"></script>
        <script src="js/jquery.fixedheadertable.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogo de Beneficiarios contratados</title>
        <script>
            /*variable que trae la bandera de exito o fracaso del modelo*/
            //var bandera='$//{request.mensaje}';
            var bandera=<%= request.getAttribute("mensaje") %>;
            
            if (bandera=='uno')
            {
                alert ('Enganche cubierto en diversos y correcto pagos anticipados, aperturado Edo. de cuenta');
            }
            if (bandera=='dos')
            {
                alert ('Enganche cubierto pero incorrecto pagos anticipados');
            }
            if (bandera=='tres')
            {
                alert ('Enganche no cubierto, favor de verificar e intentar de nuevo...');
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
                $('input.datepicker').Zebra_DatePicker();
                
                //alert('dentro de jquery');
                $('#tablePlaceholder table').fixedHeaderTable({ height: '400', altClass: 'odd', themeClass: 'fancyDarkTable' });
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
    
    <!--encapsulamiento de los datos del formulario en el Javabean-->
    <jsp:useBean id="iniciaedocta" scope="request" class="javabeans.Iniciaedocta"/>

    
    <%
    if(request.getParameter("poliza")!=null) 
    {
        Integer id_candidato = Integer.parseInt(request.getParameter("id_candidato"));
        iniciaedocta.setId_candidato(id_candidato);
        String poliza=request.getParameter("poliza");
        iniciaedocta.setPoliza(poliza);
        
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_poliza=sdf.parse(request.getParameter("fecha_poliza"));
        iniciaedocta.setFecha_poliza(fecha_poliza);
        
    %>
           
        <jsp:forward page="controladoriniciaedocta?operacion=iniciar"/>
    <%}%>
    
    <body>
        <center> 
        <h2>Catálogo de Beneficiarios Contratados (candidatos a tener Edo. de Cta.)</h2>
        <form name="frmaperturaedoscta" id="frmaperturaedoscta" method="post">
        <table width="60%" border="0">
                <tr>
                    <td  width="15%">Poliza Diario:</td><td  width="15%"><input type="text" name="poliza" id="poliza" size="2" maxlength="4" value="D001"><td  width="15%">Fecha de Póliza:</td><td  width="15%"><input type="text" name="fecha_poliza" id="fecha_poliza" class="datepicker" size="10" ><input type="hidden" name="id_candidato" id="id_candidato"/></td> <td  width="15%"><a href="javascript:enviar_formulario()" >Apertura Edos. Cta.</a></td>
                </tr>
            
        </table>    
        
        <div class="container_12">
        <div id="tablePlaceholder" class="grid_12 alpha omega">
          
            
                
            
            <table>
                <thead>
                    <tr><th widht="150px" ><a href="#" onclick="marcacheck()">Sel. Todo</a><br><a href="#" onclick="desmarcacheck()">Des. Todo</a></th><th widht="20px" >Programa</th><th widht="150px" >Contrato</th><th widht="20px" >Clave de Elect.</th><th widht="20px">Curp</th><th widht="20px" >RFC</th><th widht="20px">Nombre</th><th widht="20px">Conyuge</th> <th widht="20px">Fecha de Contrato</th> <th widht="20px">Manzana</th> <th widht="20px">Lote</th> <th widht="20px">Area</th> <th widht="20px">Domicilio</th> <th widht="20px">Clave Catastral</th> <th widht="20px">Fecha Ip.</th> <th widht="20px">Capital</th> <th widht="20px">Sub. Inic.</th> <th widht="20px">Enganche</th> <th widht="20px">Interes</th> <th widht="20px">Gastos. Admon.</th> <th widht="20px">Otros seg.</th> <th widht="20px">Subsidio Inf.</th> <th widht="20px">% Enganche</th> <th widht="20px">Seguro</th> <th widht="20px">Pagos Ant.</th> <th widht="20px">Plazo</th> <th widht="20px">Pago Mensual</th> <th widht="20px">Adm. Seguro</th> <th widht="20px">Costo M2.</th> <th widht="20px">Eng. a Cubrir</th> <th widht="20px">Fecha Inicio Finan.</th> <th widht="20px">Modificar</th></tr>
                </thead>

                <tbody>   
                    <c:forEach var="aperturaedosctas" items="${requestScope.aperturaedosctas}" varStatus="loop"> 
                        <tr class="${loop.index % 2 == 0 ? 'odd' : 'impar'}"> 
                            <td  width="150px"><input type="checkbox"  name="<c:out value='${aperturaedosctas.id_candidato}' />" /></td> <td  width="20px"><c:out value="${aperturaedosctas.descripcion}" /></td> <td widht="150px" ><c:out value="${aperturaedosctas.numcontrato}" /></td> <td widht="20px"><c:out value="${aperturaedosctas.clave_elect}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.curp}" /></td> <td widht="20px"><c:out value="${aperturaedosctas.rfc}" /></td> <td widht="20px"><c:out value="${aperturaedosctas.nombre}" /></td> <td widht="20px"><c:out value="${aperturaedosctas.conyuge}" /></td>  <td widht="20px" ><c:out value="${aperturaedosctas.fecha_cont}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.mza}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.lte}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.area}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.domicilio}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.clave_cat}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.fecha_ip}" /></td>  <td widht="20px" ><c:out value="${aperturaedosctas.capital}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.sub_inic}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.enganche}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.interes}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.admon}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.o_seg}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.sub_inf}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.por_eng}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.seguro}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.pagant}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.plazo}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.pago_mes}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.adm_seg}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.costo_m2}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.engacubrir}" /></td> <td widht="20px" ><c:out value="${aperturaedosctas.fecha_if}" /></td> <td widht="20px"><a href="controladoraperturaedoscta?operacion=localizar&id_candidato=${aperturaedosctas.id_candidato}" ><img src="imagenes/editar.png" width="24" height="24" alt="editar" /></a></td>
                        </tr>

                    </c:forEach>

                </tbody>
            </table>
        
        
       
    </div>
    </div>
        
    
    </form>
    </center>
    </body>
</html>
