<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.tablesorter.js"></script>
        <title>Cajas Abiertas</title>
        <script>
            /*variable que trae la bandera de exito o fracaso del modelo*/
            var bandera='${requestScope.exito}';
            if (bandera=='false')
            {
                alert ('No se grabo la apertura de caja, por que ya fue abierta la caja por el usuario en este dia / No se borró la caja, por que ya fue realizado un cobro en edos. cta. o en diversos');
            }
            else
            {
                alert ('Registro grabado/modificado/borrado exitosamente');
            }
            
            $(document).ready(function(){         
                $("#cajas").tablesorter();     
            }); 
            
        </script>
</head>
<body>
    <center> 
        <h1>Cajas Abiertas</h1>
        
        <table border="0" width="80%">
            <tr>
                <td width="65%" align="left"> 
                   <img src="imagenes/xprogramas.png" width="24" height="24" alt="Capturar"/>Cajero: <c:out value="${user.usuario}" /> 
                </td>
                
                <td width="15%" align="rigth"> 
                   <a href="controladorcajas?operacion=capturar"><img src="imagenes/capturar.png" width="24" height="24" alt="Capturar"/>Capturar</a>
                </td>
            </tr>
             
        </table>
        
        <table id="cajas" class="tablesorter" width="80%">
            <thead>
            <tr><th>Fecha</th><th>Folio Inicial</th><th>Folio Final</th><th>Poliza</th><th>Monto Inicial</th><th>Modificar</th><th>Eliminar</th></tr>
            </thead>
            <tbody>
                <c:forEach var="cajass" items="${requestScope.cajass}"> 
                    <tr class="${loop.index % 2 == 0 ? 'odd' : 'impar'}"> 
                        <td width="25%"><c:out value="${cajass.fecha}" /></td> <td width="25%"><c:out value="${cajass.folio_inicial}" /></td> <td width="25%"><c:out value="${cajass.folio_final}" /></td> <td width="25%"><c:out value="${cajass.poliza}" /></td> <td width="25%"><c:out value="${cajass.monto_inicial}" /></td> <td width="10%"><a href="controladorcajas?operacion=localizar&id_caja=${cajass.id_caja}"><img src="imagenes/editar.png" width="24" height="24" alt="editar" /></td> <td width="10%"><a href="controladorcajas?operacion=borrar&id_caja=${cajass.id_caja}"><img src="imagenes/eliminar.png" width="16" height="16" alt="Eliminar" /></td>
                    </tr>

                </c:forEach>
            </tbody>
   
        </table>

    </center>
</body>
</html>

