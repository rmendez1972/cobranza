<%-- 
    Document   : listarclavediv
    Created on : 23/10/2012, 02:32:54 PM
    Author     : Rafael Mendez
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.tablesorter.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clave de Mov. Diversos</title>
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
            
            $(document).ready(function(){         
                $("#clavediv").tablesorter();     
            }); 
            
        </script>
    </head>
    <body>
        <center> 
        <h2>Catálogo de Claves de Movimientos Diversos (otros ingresos)</h2>
        
        <table border=0 width="70%">
            <tr>
                <td width="70%" align="right"> 
                    <a href="controladorclavediv?operacion=capturar"><img src="imagenes/capturar.png" width="24" height="24" alt="Capturar"/>Capturar</a>
                </td>
            </tr>
             
        </table>
        
        <table id="clavemov"  class="tablesorter" width="80%">
            <thead>
            <tr><th >Clave de Diversos</th><th>Descripción</th><th>Importe</th><th>Modificar</th><th>Eliminar</th></tr>
            </thead>
            <tbody>
                <c:forEach var="clavedivs" items="${requestScope.clavedivs}" varStatus="loop"> 
                    <tr class="${loop.index % 2 == 0 ? 'odd' : 'impar'}"> 
                        <td width="20%"><c:out value="${clavedivs.clave_div}" /></td> <td width="20%"><c:out value="${clavedivs.descripcion}" /></td><td width="20%" align="right"><c:out value="${clavedivs.importe}" /></td> <td width="10%"><a href="controladorclavediv?operacion=localizar&id_clave_div=${clavedivs.id_clave_div}" ><img src="imagenes/editar.png" width="24" height="24" alt="editar" /></a></td><td width="10%"><a href="controladorclavediv?operacion=borrar&id_clave_div=${clavedivs.id_clave_div}"><img src="imagenes/eliminar.png" width="16" height="16" alt="Eliminar" onClick="return confirm('Confirme la eliminacion del registro')" /></td>
                    </tr>

                </c:forEach>
           </tbody>
        </table>

    </center>
    </body>
</html>
