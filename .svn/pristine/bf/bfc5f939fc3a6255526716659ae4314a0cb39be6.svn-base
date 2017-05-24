<%-- 
    Document   : frmclavemov
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>




<%@page import="javabeans.Cpp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Modificación de Tasas de CPP</title>
        
        <script type="text/javascript">

        $(function (){
           $('input.datepicker').Zebra_DatePicker();         
                    
           $("#frmcpp").validate(
           {

                rules: {
                        fecha:{ 
                                required: true
                                
                              },
                        importe:{ 
                                required: true,
                                min:1
                                
                              }
                    

                       },
                       
             messages: {
                                                   
                    fecha: {

                        required: "fecha de mov es obligatorio"

                        
                            },
                    importe:  "importe es obligatorio y debe ser un monto mayaor a 1"

                    
                       }
            }); 
        });

        </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="cpp" scope="request" class="javabeans.Cpp"/>

    
    <%
    if((request.getParameter("fecha")!=null) && (request.getParameter("importe")!=null) )
    {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=sdf.parse(request.getParameter("fecha"));
        cpp.setFecha(fecha);
        BigDecimal importe = new BigDecimal(request.getParameter("importe"));
        cpp.setImporte(importe); 
        Integer id_cpp = Integer.parseInt(request.getParameter("id_cpp"));
        cpp.setId_cpp(id_cpp);
    %>
           
        <jsp:forward page="controladorcpp?operacion=modificar"/>
    <%}%>
    
    <body>
        <center> 
            <h1>Modificación al Catálogo de Tasas de CPP</h1>
            <form name="frmcpp" id="frmcpp" class="catalogo" method="post">
                <br/><br/>
                <table  width="50%" cellspacing=0 cellpadding=3 border="0">
                    <tr >
                        <td width="15%" align="left">Ingresa la Fecha:</td>
                        <td width="35%" align="left"><input type="text" name="fecha" id="fecha" class="datepicker" size="11" value="${cpps.fecha}" ><input type="hidden" name="id_cpp" id="id_cpp"  value="${cpps.id_cpp}"></td>
                    </tr>
                    <tr>
                        <td width="15%" align="left">Ingresa el importe:</td>
                        <td width="35%" align="left"><input type="text" name="importe" id="importe" class="cajaPequena" size="10" value="${cpps.importe}"  onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                </table>
                <br/>
                <input type="submit" name="Submit" class="boton_fb" value="Modificar"onMouseOver="this.style.cursor='pointer'">
                <input type="reset" value="Reset" class="boton_fb" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>
