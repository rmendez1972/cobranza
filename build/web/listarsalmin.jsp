<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Catalogo de Salarios mínimos</title>
</head>
<body>
<center> 
<h1>Salarios Mínimos</h1>
<table border=1>
<tr><th>Fecha</th><th>Importe</th></tr>

<c:forEach var="salmin" items="${requestScope.salmin}"> 
<tr> 
    <td><c:out value="${salmin.fecha}" /></td> <td><c:out value="${salmin.importe}" /></td> </tr>


</c:forEach>


   
</table>
</center>
</body>
</html>

