<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">


<html>
    <head>
        <!--<script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jqtransform/jqtransformplugin/jquery.jqtransform.js"></script>
        <link href="js/jqtransform/jqtransformplugin/jqtransform.css" rel="stylesheet" type="text/css">
        -->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        
       <title>Login</title>
     
        <style type="text/css">   
            * { 
                margin:0px; 
                padding: 0px; 
            }
            a{color: #fff;}

            body {
                /*background-image: url(imagenes/seduvi.png);*/   
                margin: 0;
                font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
                font-size: 14px;
                line-height: 20px;
                color: #333;
                background-color: #fff;

            }

            #contenedor{width: 900px;margin: auto; 
                        position: relative; background-color: #FFF; 
                        box-shadow: 2px 4px 4px 2px #666;

            }
            header{height: 50px;background-image: url(header.png); border-bottom: 5px solid red;}
            nav{}
            aside{}
            section{background-image: url(fondo900x600.png);height: 400px;background-position-y: -200px;}

            footer{background-color:#014400;background-image: url(footer3.png); 
                   background-repeat:no-repeat;color: #fff;padding-top: 65px;height: 125px;
                   font: 14px Tahoma, Helvetica, Arial, Sans-Serif;
            }
            #columna1{width: 380px;float: left;padding: 10px; }
            #columna2{width: 160px;float: left;padding: 10px;}
            #columna3{width: 300px;float: left;padding: 10px;}

            form{
                /*background: #333333;
                background:#014400 ;*/
                /*background-color: rgba(0, 128, 0, 0.8);*/
                /*opacity: 0.8;*/
                width: 450px;
                /*border: 1px solid #4e4d4d;*/
                border: 1px solid #014400;
                border-radius: 6px;
                -moz-border-radius: 6px;
                -webkit-border-radius: 6px;
                box-shadow: 0 0 10px #014400;/*000;*/
                margin: auto;
                margin-top: 50px;
                background-image: url(LogIn.png); 
                background-repeat:no-repeat;
                background-size: 100px 80px;
            }

            form h1 {
                text-align: center;
                color: #999;
                font-weight: normal;
                font-size: 40px;
                margin: 10px 0px;
                font: 60px Helvetica, Arial, Sans-Serif; letter-spacing: -5px;  
            }

            form h2 {
                font: 30px Tahoma, Helvetica, Arial, Sans-Serif;
                text-align: center;
                margin-top: 20px;
                color: #222; text-shadow: 0px 2px 3px #555;
            }

            form input {
                width: 280px;
                height: 35px;
                padding: 0px 10px;
                margin: 10px 75px;
                color:#000;
                text-align: center;
                text-transform: uppercase;
                border-radius: 6px;
                -moz-border-radius: 6px;
                -webkit-border-radius: 6px;
                font: 20px Helvetica, Arial, Sans-Serif; letter-spacing: 0px;  
                background-color: rgba(255, 255, 255, 0.2);
            }

            form button {
                width: 135px;
                margin: 20px 0px 30px 75px;
                height: 50px;
                font: 20px  Helvetica, Arial, Sans-Serif;
                color: #fff;
                background-color: rgba(255, 255, 255, 0.2);
                border: 1px solid #FFF;/*#232323;*/
                color:#000;
                box-shadow: 2px 2px 2px 2px#000;
                -moz-box-shadow: 2px 2px 2px 2px#000;
                -webkit-box-shadow: 2px 2px 2px 2px#000;
                border-radius: 6px;
                -moz-border-radius: 6px;
                -webkit-border-radius: 6px;
            }
            form button:hover{
                background-color: rgba(255, 255, 255, 0.5);
                box-shadow: inset 0px 0px 2px 2px #000;
                -moz-box-shadow: inset 0px 0px 2px 2px #000;
                -webkit-box-shadow: inset 0px 0px 2px 2px #000;
                /*background: #3a3a3a;*/
            }

            form button:active{
                background: #2a2828; /* Old browsers */
                background: -moz-linear-gradient(top,  #2a2828 0%, #3c3c3c 100%); /* FF3.6+ */
                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#2a2828), color-stop(100%,#3c3c3c)); /* Chrome,Safari4+ */
                background: -webkit-linear-gradient(top,  #2a2828 0%,#3c3c3c 100%); /* Chrome10+,Safari5.1+ */
                background: -o-linear-gradient(top,  #2a2828 0%,#3c3c3c 100%); /* Opera 11.10+ */
                background: -ms-linear-gradient(top,  #2a2828 0%,#3c3c3c 100%); /* IE10+ */
                background: linear-gradient(to bottom,  #2a2828 0%,#3c3c3c 100%); /* W3C */
                filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#2a2828', endColorstr='#3c3c3c',GradientType=0 ); /* IE6-9 */
            }
        </style>

</head>

<!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="user" scope="request" class="javabeans.User"/>

    
    <%
    if((request.getParameter("usuario")!=null) && (request.getParameter("password")!=null) )
    {
        String usuario=request.getParameter("usuario");
        user.setUsuario(usuario.toUpperCase());
        String password=request.getParameter("password");
        user.setPassword(password.toUpperCase());
    %>
           
        <jsp:forward page="controladorlogin?operacion=iniciar"/>
    <%}%>
    
    
<body>
    <div id="contenedor">
        <header></header>
        <nav></nav>
        <aside></aside>
        <section>
            <form name="frmlogin" id="frmlogin" class="jqtransform" method="post">
                <h2>Inicio de sesión<br></br></h2>
                <input  type="text"     name="usuario" id="usuario" maxlength="20" placeholder="Ingrese su usuario"/>
                <input  type="password" name="password" id="password" maxlength="20" placeholder="Ingrese su password"/>
                <button type="reset"    name="Reset">Limpiar</button>
                <button type="submit"   name="Submit" value="Login">Iniciar sesión</button>

            </form> 
        </section>
        
        <footer> <!--Pie de pagina-->
            <div id="columna1"><b><big>
                        Secretaría de Desarrollo Urbano y Vivienda</big></b><br>
                        Gobierno del Estado de Quintana Roo<br>
                        Administración 2011-2016<br>
                        Av. Alvaro Obregón No. 474 Col. Centro C.P. 77000<br>
                        Chetumal, Quintana Roo, México<br>
                        <a href="http://seduvi.qroo.gob.mx">http://seduvi.qroo.gob.mx</a>
            </div>
            <div id="columna2"></div>
            <div id="columna3"><b><big>
                        Contacto:</big></b><br>
                        Dirección de Informática<br>
                        Departamento de Sistemas<br>
                        Ex. 211.<br></br></div>
        </footer>
    </div> <!--fin del contenedor-->
        
</body>

</html>
