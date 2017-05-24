<%-- 
    Document   : frmmodificacatprog
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>



<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="javabeans.Catprog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <!-- framework jquery -->
        <script type="text/javascript" language="JavaScript" src="js/jquery-1.7.2.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/additional-methods.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/jquery.maskedinput-1.3.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/zebra_datepicker.js"></script>

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Modificación de Catálogo de Candidatos</title>
        
        <script type="text/javascript">
            

            $(function()
            {
                   
                
           $('input.datepicker').Zebra_DatePicker();
                    
           $("#frmmodificaaperturaedoscta").validate(
           {

                rules: {
                              
                  capital: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           },
                   sub_inic: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           },
                   enganche: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           },
                   interes: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           },
                   admon: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           },
                   o_seg: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           },
                   sub_inf: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           },
                   por_eng: {
                                
                                
                                pattern: /^[0-9]{1,2}?$/
                                
                                
                                
                           },
                   seguro: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           },
                   pagant: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           },
                   plazo: {
                                
                                
                                pattern: /^[0-9]{1,2}?$/
                                
                                
                                
                           },
                 pago_mes: {
                                
                                
                                pattern: /^[0-9]{1,6}(\.[0-9]{0,3})?$/
                                
                                
                                
                           }
                                  

                       },
                       
             messages: {
                 
                         
                capital: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades con tres decimales'
                        
       
                         },
                sub_inic: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades con tres decimales'
                        
       
                         },
                enganche: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades con tres decimales'
                        
       
                         },
                interes: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades con tres decimales'
                        
       
                         },
                  admon: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades con tres decimales'
                        
       
                         },
                  o_seg: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades con tres decimales'
                        
       
                         },
                sub_inf: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades con tres decimales'
                        
       
                         },
                por_eng: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades enteras'
                        
       
                         },
                 seguro: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades con tres decimales'
                        
       
                         },
                 pagant: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades con tres decimales'
                        
       
                         },
                  plazo: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades enteras de dos digitos'
                        
       
                         },
               pago_mes: {
                        
                        
                        
                        pattern:   'Solo se aceptan cantidades enteras de dos digitos'
                        
       
                         }
               

                       }      


            });
                
                
                                
            });

        </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="aperturaedoscta" scope="request" class="javabeans.Aperturaedoscta"/>

    <%
    if((request.getParameter("id_catprog")!=null) && (request.getParameter("numcontrato")!=null))  
    {
        Integer id_candidato = Integer.parseInt(request.getParameter("id_candidato"));
        aperturaedoscta.setId_candidato(id_candidato);
        Integer id_catprog = Integer.parseInt(request.getParameter("id_catprog"));
        aperturaedoscta.setId_catprog(id_catprog);
        String numcontrato=request.getParameter("numcontrato");
        aperturaedoscta.setNumcontrato(numcontrato);
        String clave_elect=request.getParameter("clave_elect");
        aperturaedoscta.setClave_elect(clave_elect);
        String curp=request.getParameter("curp");
        aperturaedoscta.setCurp(curp);
        String rfc=request.getParameter("rfc");
        aperturaedoscta.setRfc(rfc);
        String nombre=request.getParameter("nombre");
        aperturaedoscta.setNombre(nombre);
        String conyuge=request.getParameter("conyuge");
        aperturaedoscta.setConyuge(conyuge);
        
        
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_cont=sdf.parse(request.getParameter("fecha_cont"));
        aperturaedoscta.setFecha_cont(fecha_cont);
        
        String mza=request.getParameter("mza");
        aperturaedoscta.setMza(mza);
        String lte=request.getParameter("lte");
        aperturaedoscta.setLte(lte);
        
        BigDecimal area;
        if((request.getParameter("area")!=null) && (request.getParameter("area")!=""))
        {
            area = new BigDecimal(request.getParameter("area"));
        }else
        {
            area = new BigDecimal(0.00);
        }
        aperturaedoscta.setArea(area);
               
        String domicilio=request.getParameter("domicilio");
        aperturaedoscta.setDomicilio(domicilio);
        
        String clave_cat=request.getParameter("clave_cat");
        aperturaedoscta.setClave_cat(clave_cat);
        
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_ip=sdf2.parse(request.getParameter("fecha_ip"));
        aperturaedoscta.setFecha_ip(fecha_ip);
        
        BigDecimal capital;
        if((request.getParameter("capital")!=null) && (request.getParameter("capital")!=""))
        {
            capital = new BigDecimal(request.getParameter("capital"));
        }else
        {
            capital = new BigDecimal(0.00);
        }
        aperturaedoscta.setCapital(capital);
        
        BigDecimal sub_inic;
        if((request.getParameter("sub_inic")!=null) && (request.getParameter("sub_inic")!=""))
        {
            sub_inic = new BigDecimal(request.getParameter("sub_inic"));
        }else
        {
            sub_inic = new BigDecimal(0.00);
        }
        aperturaedoscta.setSub_inic(sub_inic);
        
        BigDecimal enganche;
        if((request.getParameter("enganche")!=null) && (request.getParameter("enganche")!=""))
        {
            enganche = new BigDecimal(request.getParameter("enganche"));
        }else
        {
            enganche = new BigDecimal(0.00);
        }
        aperturaedoscta.setEnganche(enganche);
        
        BigDecimal interes;
        if((request.getParameter("interes")!=null) && (request.getParameter("interes")!=""))
        {
            interes = new BigDecimal(request.getParameter("interes"));
        }else
        {
            interes = new BigDecimal(0.00);
        }
        aperturaedoscta.setInteres(interes);
        
        BigDecimal admon;
        if((request.getParameter("admon")!=null) && (request.getParameter("admon")!=""))
        {
            admon = new BigDecimal(request.getParameter("admon"));
        }else
        {
            admon= new BigDecimal(0.00);
        }
        aperturaedoscta.setAdmon(admon);
        
        BigDecimal o_seg;
        if((request.getParameter("o_seg")!=null) && (request.getParameter("o_seg")!=""))
        {
            o_seg = new BigDecimal(request.getParameter("o_seg"));
        }else
        {
            o_seg = new BigDecimal(0.00);
        }
        aperturaedoscta.setO_seg(o_seg);
        
        BigDecimal sub_inf;
        if((request.getParameter("sub_inf")!=null) && (request.getParameter("sub_inf")!=""))
        {
            sub_inf = new BigDecimal(request.getParameter("sub_inf"));
        }else
        {
            sub_inf = new BigDecimal(0.00);
        }
        aperturaedoscta.setSub_inf(sub_inf);
        
        BigDecimal por_eng;
        if((request.getParameter("por_eng")!=null) && (request.getParameter("por_eng")!=""))
        {
            por_eng = new BigDecimal(request.getParameter("por_eng"));
        }else
        {
            por_eng = new BigDecimal(0.00);
        }
        aperturaedoscta.setPor_eng(por_eng);
        
        BigDecimal seguro;
        if((request.getParameter("seguro")!=null) && (request.getParameter("seguro")!=""))
        {
            seguro = new BigDecimal(request.getParameter("seguro"));
        }else
        {
            seguro = new BigDecimal(0.00);
        }
        aperturaedoscta.setSeguro(seguro);
        
        BigDecimal pagant;
        if((request.getParameter("pagant")!=null) && (request.getParameter("pagant")!=""))
        {
            pagant = new BigDecimal(request.getParameter("pagant"));
        }else
        {
            pagant = new BigDecimal(0.00);
        }
        aperturaedoscta.setPagant(pagant);
        
        Integer plazo = Integer.parseInt(request.getParameter("plazo"));
        aperturaedoscta.setPlazo(plazo);
        
        BigDecimal pago_mes;
        if((request.getParameter("pago_mes")!=null) && (request.getParameter("pago_mes")!=""))
        {
            pago_mes = new BigDecimal(request.getParameter("pago_mes"));
        }else
        {
            pago_mes = new BigDecimal(0.00);
        }
        aperturaedoscta.setPago_mes(pago_mes);
        
        BigDecimal adm_seg;
        if((request.getParameter("adm_seg")!=null) && (request.getParameter("adm_seg")!=""))
        {
            adm_seg = new BigDecimal(request.getParameter("adm_seg"));
        }else
        {
            adm_seg = new BigDecimal(0.00);
        }
        aperturaedoscta.setAdm_seg(adm_seg);
        
        BigDecimal costo_m2;
        if((request.getParameter("costo_m2")!=null) && (request.getParameter("costo_m2")!=""))
        {
            costo_m2 = new BigDecimal(request.getParameter("costo_m2"));
        }else
        {
            costo_m2 = new BigDecimal(0.00);
        }
        aperturaedoscta.setCosto_m2(costo_m2);
        
        SimpleDateFormat sdf3= new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_if=sdf3.parse(request.getParameter("fecha_if"));
        aperturaedoscta.setFecha_if(fecha_if);
        
        BigDecimal engacubrir;
        if((request.getParameter("engacubrir")!=null) && (request.getParameter("engacubrir")!=""))
        {
            engacubrir = new BigDecimal(request.getParameter("engacubrir"));
        }else
        {
            engacubrir = new BigDecimal(0.00);
        }
        aperturaedoscta.setEngacubrir(engacubrir);
        
    %>
           
        <jsp:forward page="controladoraperturaedoscta?operacion=modificar"/>
    <%}%>
    
    <body>
        <center> 
            <h2>Modificación al Catálogo de Beneficiarios contratados (candidatos a tener Edo. de Cta.)</h2>
            <form name="frmmodificaaperturaedoscta" id="frmmodificaaperturaedoscta" class="catalogo" method="post">
                <br/>
                <fieldset>
                    <legend align="right">Datos de Vivienda</legend>
                <table class="fuente8" width="80%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="10%" align="left">Programa:</td>
                        <td width="30%" align="left">
                            <select name="id_catprog2" id="id_catprog2" disabled="disabled">
                                
                                
                                <c:forEach  var="cat" items="${requestScope.catprogss}">
                                    
                                    <OPTION VALUE="${cat.id_Catprog}" ${aperturaedosctas.id_catprog == cat.id_Catprog ? 'selected' : ''}>${cat.descripcion}</OPTION>
                                </c:forEach>
                            </select><input type="hidden" name="id_catprog" id="id_catprog" value="${aperturaedosctas.id_catprog}">
                        </td>
                        <td width="10%" align="left">Numero de Contrato:</td>
                        <td width="30%" align="left"><input type="text" name="numcontrato2" id="numcontrato2" disabled="disabled" class="cajaPequena" size="4" maxlength="5" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.numcontrato}"><input type="hidden" name="id_candidato" id="id_candidato" value="${aperturaedosctas.id_candidato}"><input type="hidden" name="numcontrato" id="numcontrato" value="${aperturaedosctas.numcontrato}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Clave de Elector:</td>
                        <td width="30%" align="left"><input type="text" name="clave_elect2" id="clave_elect2" disabled="disabled" class="cajaPequena" size="15" maxlength="18" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.clave_elect}"><input type="hidden" name="clave_elect" id="clave_elect" value="${aperturaedosctas.clave_elect}"> </td>
                        <td width="10%" align="left">Curp:</td>
                        <td width="30%" align="left"><input type="text" name="curp2" id="curp2" disabled="disabled" class="cajaPequena" size="16" maxlength="20" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.curp}"><input type="hidden" name="curp" id="curp" value="${aperturaedosctas.curp}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">RFC:</td>
                        <td width="30%" align="left"><input type="text" name="rfc2" id="rfc2" disabled="disabled" class="cajaPequena" size="10" maxlength="13" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.rfc}"> <input type="hidden" name="rfc" id="rfc" value="${aperturaedosctas.rfc}"> </td>
                        <td width="10%" align="left">Nombre del Benef.:</td>
                        <td width="30%" align="left"><input type="text" name="nombre2" id="nombre2" disabled="disabled" class="cajaPequena" size="40" maxlength="50" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.nombre}"> <input type="hidden" name="nombre" id="nombre" value="${aperturaedosctas.nombre}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Conyuge:</td>
                        <td width="30%" align="left"><input type="text" name="conyuge2" id="conyuge2" disabled="disabled" class="cajaPequena" size="40" maxlength="50" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.conyuge}"> <input type="hidden" name="conyuge" id="conyuge" value="${aperturaedosctas.conyuge}"> </td>
                        <td width="10%" align="left">Fecha de Contrato:</td>
                        <td width="30%" align="left"><input type="text" name="fecha_cont2" id="fecha_cont2" disabled="disabled" class="datepicker" size="11"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.fecha_cont}"><input type="hidden" name="fecha_cont" id="fecha_cont" value="${aperturaedosctas.fecha_cont}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Manzana:</td>
                        <td width="30%" align="left"><input type="text" name="mza2" id="mza2" disabled="disabled" class="cajaPequena" size="3" maxlength="3" style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.mza}"><input type="hidden" name="mza" id="mza" value="${aperturaedosctas.mza}"> </td>
                        <td width="10%" align="left">Lote:</td>
                        <td width="30%" align="left"><input type="text" name="lte2" id="lte2" disabled="disabled" class="cajaPequena" size="5" maxlength="6" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.lte}"><input type="hidden" name="lte" id="lte" value="${aperturaedosctas.lte}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Area:</td>
                        <td width="30%" align="left"><input type="text" name="area2" id="area2" disabled="disabled" class="cajaPequena" size="5" maxlength="6" style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.area}"><input type="hidden" name="area" id="area" value="${aperturaedosctas.area}"> </td>
                        <td width="10%" align="left">Domicilio:</td>
                        <td width="30%" align="left"><input type="text" name="domicilio2" id="domicilio2" disabled="disabled" class="cajaPequena" size="40" maxlength="50"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.domicilio}"><input type="hidden" name="domicilio" id="domicilio" value="${aperturaedosctas.domicilio}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Clave Catastral:</td>
                        <td width="30%" align="left"><input type="text" name="clave_cat2" id="clave_cat2"  disabled="disabled" class="cajaPequena" size="15"   onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.clave_cat}"> <input type="hidden" name="clave_cat" id="clave_cat" value="${aperturaedosctas.clave_cat}"> </td>
                        <td width="10%" align="left">Fecha Ip.</td>
                        <td width="30%" align="left"><input type="text" name="fecha_ip2" id="fecha_ip2" disabled="disabled" class="datepicker" size="10"    onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.fecha_ip}"> <input type="hidden" name="fecha_ip" id="fecha_ip" value="${aperturaedosctas.fecha_ip}"> </td>
                    </tr>
                </table>    
                </fieldset> 
                <fieldset>
                    <legend align="right">Datos de Finanzas</legend>
                <table class="fuente8" width="80%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="10%" align="left">Capital:</td>
                        <td width="30%" align="left"><input type="text" name="capital" id="capital" class="cajaPequena" size="6" maxlength="10" style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.capital}"> </td>
                        <td width="10%" align="left">Sub. Inic.</td>
                        <td width="30%" align="left"><input type="text" name="sub_inic" id="sub_inic" class="cajaPequena" size="6" maxlength="10" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.sub_inic}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Enganche:</td>
                        <td width="30%" align="left"><input type="text" name="enganche" id="enganche" class="cajaPequena" size="6" maxlength="10" style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.enganche}"> </td>
                        <td width="10%" align="left">Interes</td>
                        <td width="30%" align="left"><input type="text" name="interes" id="interes" class="cajaPequena" size="6" maxlength="10" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.interes}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Gtos. Admon:</td>
                        <td width="30%" align="left"><input type="text" name="admon" id="admon" class="cajaPequena" size="6" maxlength="10" style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.admon}"> </td>
                        <td width="10%" align="left">Otros seg.</td>
                        <td width="30%" align="left"><input type="text" name="o_seg" id="o_seg" class="cajaPequena" size="6" maxlength="10" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.o_seg}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Sub. SEDUVI:</td>
                        <td width="30%" align="left"><input type="text" name="sub_inf" id="sub_inf" class="cajaPequena" size="6" maxlength="10" style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.sub_inf}"> </td>
                        <td width="10%" align="left">% Enganche:</td>
                        <td width="30%" align="left"><input type="text" name="por_eng" id="por_eng" class="cajaPequena" size="6" maxlength="10" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.por_eng}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Seguro:</td>
                        <td width="30%" align="left"><input type="text" name="seguro" id="seguro" class="cajaPequena" size="6" maxlength="10" style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.seguro}"> </td>
                        <td width="10%" align="left">Pagos Ant.:</td>
                        <td width="30%" align="left"><input type="text" name="pagant" id="pagant" class="cajaPequena" size="6" maxlength="10" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.pagant}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Plazo:</td>
                        <td width="30%" align="left"><input type="text" name="plazo" id="plazo" class="cajaPequena" size="6" maxlength="10" style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.plazo}"> </td>
                        <td width="10%" align="left">Pago Mensual:</td>
                        <td width="30%" align="left"><input type="text" name="pago_mes" id="pago_mes" class="cajaPequena" size="6" maxlength="10" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.pago_mes}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Adm. Seguro:</td>
                        <td width="30%" align="left"><input type="text" name="adm_seg" id="adm_seg" class="cajaPequena" size="6" maxlength="10" style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.adm_seg}"> </td>
                        <td width="10%" align="left">Costo M2:</td>
                        <td width="30%" align="left"><input type="text" name="costo_m2" id="costo_m2" class="cajaPequena" size="6" maxlength="10" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.costo_m2}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Fecha Ini. Finan.:</td>
                        <td width="30%" align="left"><input type="text" name="fecha_if" id="fecha_if" class="datepicker" size="10"   onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.fecha_if}"> </td>
                        <td width="10%" align="left">Eng. a cubrir:</td>
                        <td width="30%" align="left"><input type="text" name="engacubrir" id="engacubrir" class="cajaPequena" size="6" maxlength="10" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'" value="${aperturaedosctas.engacubrir}"></td>
                    </tr>
                    
                </table>
                </fieldset>    
                <br/>
                <input type="submit" class="boton_fb" name="Submit" value="Modificar"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset" class="boton_fb" value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>
