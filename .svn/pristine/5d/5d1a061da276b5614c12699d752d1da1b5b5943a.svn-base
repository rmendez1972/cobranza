<%-- 
    Document   : frmmodificamov_edoscta
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>



<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="javabeans.Movedoscta"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/additional-methods.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jqtransform/jqtransformplugin/jquery.jqtransform.js"></script>

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <link href="js/jqtransform/jqtransformplugin/jqtransform.css" rel="stylesheet" type="text/css">
        <link href="js/jqtransform/jqtransformplugin/jqtransform.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Modificación de Movimientos Diversos (otros ingresos)</title>
        
        <script type="text/javascript">
           
           
           $(function (){
           
                
           
           $('input.datepicker').Zebra_DatePicker();
           
           
           $("form.jqtransform").jqTransform();
                    
           $("#frmmodificamov_edoscta").validate(
           {

                rules: {
                       
                        recibo:{ 
                                required: true,
                                min: 0
                                
                                
                                },
                        
                        estatus:{ 
                                required: true,
                                pattern: /^[A-B]{1}?$/
                                
                               },
                         serie:{ 
                                required: true,
                                pattern: /^[A-Z]{1}?$/
                                
                               },
                      capital: {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                      interes: {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                        admon: {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                      seguro : {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                        o_seg: {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                       
                   moratorios: {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                   comisiones: {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               },
                          tit: {
                                
                                required: true,
                                pattern: /^[-]{0,1}[0-9]{1,7}(\.[0-9]{0,3})?$/
                                
                                                               
                               }
                            
                       },
                       
             messages: {
                 
                        
                        recibo:{

                            required: "recibo es obligatorio",
                            min: function (p, element) {

                                                            return "el recibo tiene que tener mínimo un valor de 0";

                                                       }
                                
                               },
                           
                       estatus:{

                            required: "estatus es obligatorio",

                            pattern:   'Solo se aceptan (A/B)'
                               },
                        serie: {

                            required: "serie es obligatorio",

                            pattern:   'Solo se aceptan (A-Z)'
                               },
                         capital:{

                            required: "capital es obligatorio",

                            pattern:   'Solo se aceptan números con tres decimales'
                               },
                       interes:{

                            required: "interes es obligatorio",

                            pattern:   'Solo se aceptan números con tres decimales'
                               },
                         admon:{

                            required: "admon es obligatorio",

                            pattern:   'Solo se aceptan números con tres decimales'
                               },
                        seguro:{

                            required: "seguro es obligatorio",

                            pattern:   'Solo se aceptan números con tres decimales'
                               },
                         o_seg:{

                            required: "o_seg es obligatorio",

                            pattern:   'Solo se aceptan números con tres decimales'
                               },
                    moratorios:{

                            required: "moratorios es obligatorio",

                            pattern:   'Solo se aceptan números con tres decimales'
                               },
                    comisiones:{

                                    required: "interes es obligatorio",

                                    pattern:   'Solo se aceptan números con tres decimales'
                               },
                          tit: {

                                    required: "titulacion es obligatorio",

                                    pattern:   'Solo se aceptan números con tres decimales'
                               }

                       }      


            }); 
        });

        </script>


    </head>
    
     <jsp:useBean id="Movedoscta" scope="request" class="javabeans.Movedoscta"/>

    <%
    if((request.getParameter("recibo")!=null) && (request.getParameter("id_movedoscta")!=null) )
    {
        Integer id_movedoscta = Integer.parseInt(request.getParameter("id_movedoscta"));
        Movedoscta.setId_movedoscta(id_movedoscta);
                       
        String clave_mov=request.getParameter("clave_mov");
        Movedoscta.setClave_mov(clave_mov);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_mov=sdf.parse(request.getParameter("fecha_mov"));
        Movedoscta.setFecha_mov(fecha_mov);
        String poliza=request.getParameter("poliza");
        Movedoscta.setPoliza(poliza);
        Integer recibo = Integer.parseInt(request.getParameter("recibo"));
        Movedoscta.setRecibo(recibo);
        
        BigDecimal capital;
        if((request.getParameter("capital")!=null) && (request.getParameter("capital")!=""))
        {
            capital = new BigDecimal(request.getParameter("capital"));
        }else
        {
            capital = new BigDecimal(0.00);
        }
        Movedoscta.setCapital(capital);
        
        BigDecimal interes;
        if((request.getParameter("interes")!=null) && (request.getParameter("interes")!=""))
        {
            interes = new BigDecimal(request.getParameter("interes"));
        }else
        {
            interes = new BigDecimal(0.00);
        }
        Movedoscta.setInteres(interes);
        
        BigDecimal admon;
        if((request.getParameter("admon")!=null) && (request.getParameter("admon")!=""))
        {
            admon = new BigDecimal(request.getParameter("admon"));
        }else
        {
            admon = new BigDecimal(0.00);
        }
        Movedoscta.setAdmon(admon);
        
        BigDecimal seguro;
        if((request.getParameter("seguro")!=null) && (request.getParameter("seguro")!=""))
        {
            seguro = new BigDecimal(request.getParameter("seguro"));
        }else
        {
            seguro = new BigDecimal(0.00);
        }
        Movedoscta.setSeguro(seguro);
        
        BigDecimal o_seg;
        if((request.getParameter("o_seg")!=null) && (request.getParameter("o_seg")!=""))
        {
            o_seg = new BigDecimal(request.getParameter("o_seg"));
        }else
        {
            o_seg = new BigDecimal(0.00);
        }
        Movedoscta.setO_seg(o_seg);
        
        
        BigDecimal moratorios;
        if((request.getParameter("moratorios")!=null) && (request.getParameter("moratorios")!=""))
        {
            moratorios = new BigDecimal(request.getParameter("moratorios"));
        }else
        {
            moratorios = new BigDecimal(0.00);
        }
        Movedoscta.setMoratorios(moratorios);
        
        BigDecimal comisiones;
        if((request.getParameter("comisiones")!=null) && (request.getParameter("comisiones")!=""))
        {
            comisiones = new BigDecimal(request.getParameter("comisiones"));
        }else
        {
            comisiones = new BigDecimal(0.00);
        }
        Movedoscta.setComisiones(comisiones);
        
        BigDecimal tit;
        if((request.getParameter("tit")!=null) && (request.getParameter("tit")!=""))
        {
            tit = new BigDecimal(request.getParameter("tit"));
        }else
        {
            tit = new BigDecimal(0.00);
        }
        Movedoscta.setTit(tit);
        
        
        String estatus=request.getParameter("estatus");
        Movedoscta.setEstatus(estatus);
        
        String serie=request.getParameter("serie");
        Movedoscta.setSerie(serie);
        
        String numcontrato=request.getParameter("numcontrato");
        Movedoscta.setNumcontrato(numcontrato);
        
        Integer id_catprog = Integer.parseInt(request.getParameter("id_catprog"));
        Movedoscta.setId_catprog(id_catprog);
    %>
           
        <jsp:forward page="controladormov_edoscta?operacion=modificar"/>
    <%}%>
   
    
    <body>
        <center> 
            <h1>Modificación a Movimientos de Edos. de Cuenta </h1>
            <form name="frmmodificamov_edoscta" id="frmmodificamov_edoscta" class="jqtransform" method="post">
                <br/>
                <fieldset style="border: 2px solid #8A0808; width: 800px; ; border-radius: 10px; ">
                <legend align="right"><img src="imagenes/cortecaja.png" width="40" height="40" alt="Mov. Edos. Cta." />Datos del Mov. de Edo. Cta.</legend>
                <table class="fuente8" width="80%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="10%" align="left">Id</td>
                        <td width="30%" align="left"><c:out value="${mov_edoscta.id_movedoscta}" /><input type="hidden" name="id_movedoscta" id="id_movedoscta" value="${mov_edoscta.id_movedoscta}"></td>
                        <td width="10%" align="left">Clave Mov.</td>
                        <td width="30%" align="left">
                            <select name="clave_mov" id="clave_mov">
                               
                                <c:forEach  var="clave_mov" items="${requestScope.clave_mov}">
                                    
                                    <OPTION VALUE="${clave_mov.clave_mov}" ${mov_edoscta.clave_mov == clave_mov.clave_mov ? 'selected' : ''}>${clave_mov.clave_mov}-${clave_mov.descripcion}</OPTION>
                                </c:forEach>
                            </select> 
                        </td>
                    </tr>
                    
                    <tr>
                            <td width="10%" align="left">Fecha Mov.</td>
                            <td width="30%" align="left"><input type="text" name="fecha_mov" id="fecha_mov"  class="datepicker" size="11"   value="${mov_edoscta.fecha_mov}"> </td>
                            <td width="10%" align="left">Poliza</td>
                            <td width="30%" align="left"><input type="text" name="poliza" id="poliza"   size="4"  value="${mov_edoscta.poliza}"> </td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Recibo</td>
                        <td width="30%" align="left"><input type="text" name="recibo" id="recibo"   size="6"   value="${mov_edoscta.recibo}"> </td>
                        <td width="10%" align="left">Capital</td>
                        <td width="30%" align="left"><label for="capital">$</label><input type="text" name="capital" id="capital"    size="12" maxlength="12"   value="${mov_edoscta.capital}"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Interes</td>
                        <td width="30%" align="left"><label for="interes">$</label><input type="text" name="interes" id="interes" size="12" maxlength="12"   value="${mov_edoscta.interes}"> </td>
                        <td width="10%" align="left">Admon.</td>
                        <td width="30%" align="left"><label for="admon">$</label><input type="text" name="admon" id="admon"  size="12" maxlength="12"   value="${mov_edoscta.admon}"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Seguro</td>
                        <td width="30%" align="left"><label for="seguro">$</label><input type="text" name="seguro" id="seguro" size="12" maxlength="12"   value="${mov_edoscta.seguro}"> </td>
                        <td width="10%" align="left">Otros Seg</td>
                        <td width="30%" align="left"><label for="o_seg">$</label><input type="text" name="o_seg" id="o_seg"  size="12" maxlength="12"   value="${mov_edoscta.o_seg}"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Moratorios</td>
                        <td width="30%" align="left"><label for="moratorios">$</label><input type="text" name="moratorios" id="moratorios" size="12" maxlength="12"   value="${mov_edoscta.moratorios}"> </td>
                        <td width="10%" align="left">Comisiones</td>
                        <td width="30%" align="left"><label for="comisiones">$</label><input type="text" name="comisiones" id="comisiones"  size="12" maxlength="12"   value="${mov_edoscta.comisiones}"> </td>
                    </tr>
                   
                    <tr>
                        <td width="10%" align="left">Titulación</td>
                        <td width="30%" align="left"><label for="tit">$</label><input type="text" name="tit" id="seguro" size="12" maxlength="12"   value="${mov_edoscta.tit}"> </td>
                        <td width="10%" align="left">Estatus</td>
                        <td width="30%" align="left"><input type="text" name="estatus" id="estatus" class="cajaPequena"  size="2" maxlength="1"   value="${mov_edoscta.estatus}"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Serie</td>
                        <td width="30%" align="left"><input type="text" name="serie" id="serie" class="cajaPequena" size="2" maxlength="1"   value="${mov_edoscta.serie}"> </td>
                        <td width="10%" align="left">Condición Financiera</td>
                        <td width="30%" align="left">
                            <select name="id_catprog" id="id_catprog">
                               
                                <c:forEach  var="cat_prog" items="${requestScope.cat_prog}">
                                    
                                    <OPTION VALUE="${cat_prog.id_Catprog}" ${mov_edoscta.id_catprog == cat_prog.id_Catprog ? 'selected' : ''}>${cat_prog.clave}-${cat_prog.descripcion}</OPTION>
                                </c:forEach>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Número de Contrato</td>
                        <td width="30%" align="left"><input type="text" name="numcontrato" id="numcontrato" size="5" maxlength="5"   value="${mov_edoscta.numcontrato}"> </td>
                        <td width="10%" align="left"></td>
                        <td width="30%" align="left"></td>
                    </tr>
                    
                    
                </table>
                <br/>
                <input type="submit"  name="Submit" value="Modificar"   >
                <input type="reset"  value="Deshacer" >
           </fieldset> 
           </form>
        </center>

    </body>
</html>
