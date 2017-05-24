<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.tablesorter.js"></script>
        <title>Catalogo del CPP</title>
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
                $("#cpp").tablesorter();     
            }); 
            
        </script>
</head>
<body>
    <center> 
        <h1>Tasa del CPP</h1>
        
        <table border=0 width="70%">
            <tr>
                <td width="70%" align="right"> 
                    <a href="controladorcpp?operacion=capturar"><img src="imagenes/capturar.png" width="24" height="24" alt="Capturar"/>Capturar</a>
                </td>
            </tr>
             
        </table>
        
        <table id="cpp" class="tablesorter" width="80%">
            <thead>
            <tr><th>Fecha</th><th>Importe</th><th>Modificar</th><th>Eliminar</th></tr>
            </thead>
            <tbody>
                <c:forEach var="cpps" items="${requestScope.cpps}"> 
                    <tr class="${loop.index % 2 == 0 ? 'odd' : 'impar'}"> 
                        <td width="25%"><c:out value="${cpps.fecha}" /></td> <td width="25%"><c:out value="${cpps.importe}" /></td> <td width="10%"><a href="controladorcpp?operacion=localizar&id_cpp=${cpps.id_cpp}"><img src="imagenes/editar.png" width="24" height="24" alt="editar" /></td width="25%"><td width="10%"><a href="controladorcpp?operacion=borrar&id_cpp=${cpps.id_cpp}"><img src="imagenes/eliminar.png" width="16" height="16" alt="Eliminar" /></td>
                    </tr>

                </c:forEach>
            </tbody>
   
        </table>

    </center>
</body>
</html>

