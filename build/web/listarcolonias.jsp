<%-- 
    Document   : listarcolonias
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
        <title>Catalogo de Colonias</title>
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
                $("#colonias").tablesorter();     
            }); 
            
        </script>
    </head>
    <body>
        <center> 
        <h2>Catálogo de Colonias por Delegacion</h2>
        
        <table border=0 width="70%">
            <tr>
                <td width="70%" align="right"> 
                    <a href="controladorcolonias?operacion=capturar"><img src="imagenes/capturar.png" width="24" height="24" alt="Capturar"/>Capturar</a>
                </td>
            </tr>
             
        </table>
        
        <table id="colonias"  class="tablesorter" width="70%">
            <thead>
            <tr><th >Delegacion</th><th>Descripción</th><th>Modificar</th><th>Eliminar</th></tr>
            </thead>
            <tbody>
                <c:forEach var="coloniass" items="${requestScope.coloniass}" varStatus="loop"> 
                    <tr class="${loop.index % 2 == 0 ? 'odd' : 'impar'}"> 
                        <td width="25%"><c:out value="${coloniass.delegacion}" /></td> <td width="25%"><c:out value="${coloniass.descripcion}" /></td> <td width="10%"><a href="controladorcolonias?operacion=localizar&id_colonia=${coloniass.idColonia}" ><img src="imagenes/editar.png" width="24" height="24" alt="editar" /></a></td><td width="10%"><a href="controladorcolonias?operacion=borrar&id_colonia=${coloniass.idColonia}"><img src="imagenes/eliminar.png" width="16" height="16" alt="Eliminar" onClick="return confirm('Confirme la eliminacion del registro')" /></td>
                    </tr>

                </c:forEach>
           </tbody>
        </table>

    </center>
    </body>
</html>
