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
        <h2>Beneficiarios Contratados</h2>
        
        <table border=0 width="70%">
            <tr>
                <td width="70%" align="right"> 
                    <a href="controladorcandidatos?operacion=capturar"><img src="imagenes/capturar.png" width="24" height="24" alt="Capturar"/>Capturar</a>
                </td>
            </tr>
             
        </table>
        
        
        
        <div class="container_12">
        <div id="tablePlaceholder" class="grid_12 alpha omega">
        <table>
            <thead>
                <tr><th widht="20px" >Programa</th><th widht="150px" >Contrato</th><th widht="20px" >Clave de Elect.</th><th widht="20px">Curp</th><th widht="20px" >RFC</th><th widht="20px">Nombre</th><th widht="20px">Conyuge</th> <th widht="20px">Fecha de Contrato</th> <th widht="20px">Manzana</th> <th widht="20px">Lote</th> <th widht="20px">Superficie</th> <th widht="20px">Domicilio</th> <th widht="20px">Clave cat.</th> <th widht="20px">Fecha Ini. Pag.</th>  <th widht="20px">Modificar</th><th widht="20px">Borrrar</th></tr>
            </thead>
            
            <tbody>   
                <c:forEach var="candidatoss" items="${requestScope.candidatoss}" varStatus="loop"> 
                    <tr class="${loop.index % 2 == 0 ? 'odd' : 'impar'}"> 
                        <td  width="20px"><c:out value="${candidatoss.descripcion}" /></td> <td widht="150px" ><c:out value="${candidatoss.numcontrato}" /></td> <td widht="20px"><c:out value="${candidatoss.clave_elect}" /></td> <td widht="20px" ><c:out value="${candidatoss.curp}" /></td> <td widht="20px"><c:out value="${candidatoss.rfc}" /></td> <td widht="20px"><c:out value="${candidatoss.nombre}" /></td> <td widht="20px"><c:out value="${candidatoss.conyuge}" /></td>  <td widht="20px" ><c:out value="${candidatoss.fecha_cont}" /></td> <td widht="20px" ><c:out value="${candidatoss.mza}" /></td> <td widht="20px" ><c:out value="${candidatoss.lte}" /></td> <td widht="20px" ><c:out value="${candidatoss.area}" /></td> <td widht="20px" ><c:out value="${candidatoss.domicilio}" /></td> <td widht="20px" ><c:out value="${candidatoss.clave_cat}" /></td> <td widht="20px" ><c:out value="${candidatoss.fecha_ip}" /></td> <td widht="20px"><a href="controladorcandidatos?operacion=localizar&id_candidato=${candidatoss.id_candidato}" ><img src="imagenes/editar.png" width="24" height="24" alt="editar" /></a></td> <td widht="20px" ><a href="controladorcandidatos?operacion=borrar&id_candidato=${candidatoss.id_candidato}"><img src="imagenes/eliminar.png" width="16" height="16" alt="Eliminar" onClick="return confirm('Confirme la eliminacion del registro')" /></td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
        
    </center>
    </body>
</html>
