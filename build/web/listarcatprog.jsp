<%-- 
    Document   : listarcatprog
    Created on : 23/10/2012, 02:32:54 PM
    Author     : Rafael Mendez
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        
        <link href="js/Fixed-Header-Table-master/css/defaultTheme.css" rel="stylesheet" media="screen" />
        <link href="js/Fixed-Header-Table-master/demo/css/960.css" rel="stylesheet" media="screen" />
        <link href="js/Fixed-Header-Table-master/demo/css/demo.css" rel="stylesheet" media="screen" />
        
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.tablesorter.js"></script>
        <script src="js/jquery.fixedheadertable.js"></script>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogos de condiciones financieras</title>
        <script>
            /*variable que trae la bandera de exito o fracaso del modelo*/
            var bandera='${requestScope.exito}';
            if (bandera=='false')
            {
                alert ('No se grabo por que registro ya existe');
            }
            else
            {
                alert ('Registro grabado/modificado/borrado exitosamente');
            }
            
            /*$(document).ready(function(){         
                $("#catprog").tablesorter();     
            });*/ 
            
            
            $(document).ready(function()
            {
                //alert('dentro de jquery');
                $('#tablePlaceholder table').fixedHeaderTable({ height: '400', altClass: 'odd', themeClass: 'fancyDarkTable' });
            });
            
        </script>
    </head>
    <body>
        <center> 
        <h2>Catálogo de Condiciones Financieras</h2>
        
        <table border=0 width="70%">
            <tr>
                <td width="70%" align="right"> 
                    <a href="controladorcatprog?operacion=capturar"><img src="imagenes/capturar.png" width="24" height="24" alt="Capturar"/>Capturar</a>
                </td>
            </tr>
             
        </table>
        
        
        
        <div class="container_12">
        <div id="tablePlaceholder" class="grid_12 alpha omega">
        <table>
            <thead>
                <tr><th widht="20px" >Clave de Programa</th><th widht="150px" >Descripcion</th><th widht="20px" >Mecánica Cálculo</th><th widht="20px">Sub_ini</th><th widht="20px" >Eng. Fon.</th><th widht="20px">Eng. Inv.</th><th widht="20px">Interes</th><th widht="20px">Gtos. Admon.</th><th widht="20px">Seguro</th><th widht="20px">Costo M2</th><th widht="20px">Por. sub.</th><th widht="20px">Por. Admon.</th> <th widht="20px">Por. S.V.</th> <th widht="20px">Por. Oseg.</th> <th widht="20px">Sub. Bp.</th> <th widht="20px">Salario Min.</th> <th widht="20px">Pago Mensual</th> <th widht="20px">% Enganche</th>  <th widht="20px">Delegación</th> <th widht="20px">Colonia</th> <th widht="20px">Anualidad</th> <th widht="20px">Plazo</th> <th widht="20px">Estatus</th> <th widht="20px">Por. Capital</th>  <th widht="20px">Modificar</th><th widht="20px">Borrrar</th></tr>
            </thead>
            
            <tbody>   
                <c:forEach var="catprogs" items="${requestScope.catprogs}" varStatus="loop"> 
                    <tr class="${loop.index % 2 == 0 ? 'odd' : 'impar'}"> 
                        <td  width="20px"><c:out value="${catprogs.clave}" /></td> <td widht="150px" ><c:out value="${catprogs.descripcion}" /></td> <td widht="20px"><c:out value="${catprogs.mecanica}" /></td> <td widht="20px" ><c:out value="${catprogs.sub_ini}" /></td> <td widht="20px"><c:out value="${catprogs.eng_fon}" /></td> <td widht="20px"><c:out value="${catprogs.eng_inv}" /></td> <td widht="20px"><c:out value="${catprogs.interes}" /></td> <td widht="20px" ><c:out value="${catprogs.admon}" /></td><td widht="20px" ><c:out value="${catprogs.seguro}" /></td><td widht="20px" ><c:out value="${catprogs.costo_m2}" /></td> <td widht="20px" ><c:out value="${catprogs.por_sub}" /></td> <td widht="20px"><c:out value="${catprogs.por_admon}" /></td> <td widht="20px" ><c:out value="${catprogs.por_sv}" /></td> <td widht="20px" ><c:out value="${catprogs.por_os}" /></td>  <td widht="20px" ><c:out value="${catprogs.sub_bp}" /></td> <td widht="20px" ><c:out value="${catprogs.sal_min}" /></td> <td widht="20px" ><c:out value="${catprogs.pago_mes}" /></td>  <td widht="20px" ><c:out value="${catprogs.por_eng}" /></td> <td widht="20px" ><c:out value="${catprogs.delegacion}" /></td>  <td widht="20px" ><c:out value="${catprogs.colonia}" /></td>  <td widht="20px" ><c:out value="${catprogs.anual}" /></td>    <td widht="20px" ><c:out value="${catprogs.plazo}" /></td>  <td widht="20px" ><c:out value="${catprogs.status}" /></td>  <td widht="20px" ><c:out value="${catprogs.por_cap}" /></td>  <td widht="20px"><a href="controladorcatprog?operacion=localizar&id_catprog=${catprogs.id_Catprog}" ><img src="imagenes/editar.png" width="24" height="24" alt="editar" /></a></td> <td widht="20px" ><a href="controladorcatprog?operacion=borrar&id_catprog=${catprogs.id_Catprog}"><img src="imagenes/eliminar.png" width="16" height="16" alt="Eliminar" onClick="return confirm('Confirme la eliminacion del registro')" /></td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
        
    </center>
    </body>
</html>
