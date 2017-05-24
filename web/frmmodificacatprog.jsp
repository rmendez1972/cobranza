<%-- 
    Document   : frmmodificacatprog
    Created on : 22/10/2012, 03:10:03 PM
    Author     : Rafael Mendez
--%>



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

        <link href="estilos/estilosiframe.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Modificación de Condiciones Financieras</title>
        
        <script type="text/javascript">
           
           
           function modificastatus()
            {
                if (document.frmcatprog.status2.checked)
                {    
                    
                    document.forms.frmcatprog.estatus.value="1";
                    //alert ("marcado y valor de status "+document.frmcatprog.estatus.value);
                }    
                else
                {    
                    
                    document.frmcatprog.estatus.value="0";
                    //alert ("desmarcado y valor de status "+document.frmcatprog.estatus.value);
                }
            }
            

            $(function()
            {
                
                var estatus=${catprogs.status};    // asignamos el valor de la propiedad status a una variable de javascript
                if (estatus==1)
                {
                    
                    document.frmcatprog.status2.checked=true;
               
                }
                else
                {
                    
                    document.frmcatprog.status2.checked=false;
                }    
                
                //evento change parececido al onchange de javascript que cambia al seleccionar las delegaciones
                $("#id_del").change(function()
                {
                    
                    
                    
                    
                    //Observese que la respuesta viene del servlet Ciudades
                    $.getJSON("controladorcolonias2", ////////En esta parte va el nombre de tu acttion que es el servelet controladorcolonias
                    {
                        //evaluar el id de paises
                        id_del: $(this).val(),     // aqui se agrega al contexto del request un nuevo parametro que se recupera en controladorcolonias2 para hacer el where
                        ajax: 'true'
                        
                    },
                    function(data)
                    {
                                                
                        //limpiar el option value
                        $("#id_colonia").html("");
                        $.each(data.Colonias, function(i,item2){
                            $("#id_colonia").append("<option value='"+item2.id_colonia+"'>"+item2.descripcion+"</option>");
                        });
                    });
                });
                
                
                                
            });

        </script>


    </head>
    
    <!--encapsulamiento de los datos del cpp en el Javabean-->
    <jsp:useBean id="catprog" scope="request" class="javabeans.Catprog"/>

    <%
    if(request.getParameter("clave")!=null)  
    {
        Integer idCatprog = Integer.parseInt(request.getParameter("idCatprog"));
        catprog.setId_Catprog(idCatprog);
        String clave=request.getParameter("clave");
        catprog.setClave(clave);
        String descripcion=request.getParameter("descripcion");
        catprog.setDescripcion(descripcion);
        
        Integer mecanica = Integer.parseInt(request.getParameter("mecanica"));
        catprog.setMecanica(mecanica);
        
        BigDecimal sub_ini;
        if((request.getParameter("sub_ini")!=null) && (request.getParameter("sub_ini")!=""))
        {
            sub_ini = new BigDecimal(request.getParameter("sub_ini"));
        }else
        {
            sub_ini = new BigDecimal(0.00);
        }
        catprog.setSub_ini(sub_ini); 
        
        BigDecimal eng_fon;
        if((request.getParameter("eng_fon")!=null) && (request.getParameter("eng_fon")!=""))
        {
            eng_fon = new BigDecimal(request.getParameter("eng_fon"));
        }else
        {
            eng_fon = new BigDecimal(0.00);
        }
        catprog.setEng_fon(eng_fon);

        BigDecimal eng_inv;
        if((request.getParameter("eng_inv")!=null) && (request.getParameter("eng_inv")!=""))
        {
            eng_inv = new BigDecimal(request.getParameter("eng_inv"));
        }else
        {
            eng_inv = new BigDecimal(0.00);
        }
        catprog.setEng_inv(eng_inv);

        BigDecimal interes;
        if((request.getParameter("interes")!=null) && (request.getParameter("interes")!=""))
        {
            interes = new BigDecimal(request.getParameter("interes"));
        }else
        {
            interes = new BigDecimal(0.00);
        }
        catprog.setInteres(interes);

        BigDecimal admon;
        if((request.getParameter("admon")!=null) && (request.getParameter("admon")!=""))
        {
            admon = new BigDecimal(request.getParameter("admon"));
        }else
        {
            admon = new BigDecimal(0.00);
        }
        catprog.setAdmon(admon);
        
        BigDecimal seguro;
        if((request.getParameter("seguro")!=null) && (request.getParameter("seguro")!=""))
        {
            seguro = new BigDecimal(request.getParameter("seguro"));
        }else
        {
            seguro = new BigDecimal(0.00);
        }
        catprog.setSeguro(seguro);         
        
        BigDecimal costo_m2;
        if((request.getParameter("costo_m2")!=null) && (request.getParameter("costo_m2")!=""))
        {
            costo_m2 = new BigDecimal(request.getParameter("costo_m2"));
        }else
        {
            costo_m2 = new BigDecimal(0.00);
        }
        catprog.setCosto_m2(costo_m2);

        BigDecimal por_sub;
        if((request.getParameter("por_sub")!=null) && (request.getParameter("por_sub")!=""))
        {
            por_sub = new BigDecimal(request.getParameter("por_sub"));
        }else
        {
            por_sub = new BigDecimal(0.00);
        }
        catprog.setPor_sub(por_sub);         
        
        BigDecimal por_admon;
        if((request.getParameter("por_admon")!=null) && (request.getParameter("por_admon")!=""))
        {
            por_admon = new BigDecimal(request.getParameter("por_admon"));
        }else
        {
            por_admon = new BigDecimal(0.00);
        }
        catprog.setPor_admon(por_admon); 
        
        BigDecimal por_sv;
        if((request.getParameter("por_sv")!=null) && (request.getParameter("por_sv")!=""))
        {
            por_sv = new BigDecimal(request.getParameter("por_sv"));
        }else
        {
            por_sv = new BigDecimal(0.00);
        }
        catprog.setPor_sv(por_sv);
        
        BigDecimal por_os;
        if((request.getParameter("por_os")!=null) && (request.getParameter("por_os")!=""))
        {
            por_os = new BigDecimal(request.getParameter("por_os"));
        }else
        {
            por_os = new BigDecimal(0.00);
        }
        catprog.setPor_os(por_os);
        
        BigDecimal sub_bp;
        if((request.getParameter("sub_bp")!=null) && (request.getParameter("sub_bp")!=""))
        {
            sub_bp = new BigDecimal(request.getParameter("sub_bp"));
        }else
        {
            sub_bp = new BigDecimal(0.00);
        }
        catprog.setSub_bp(sub_bp);
        
        BigDecimal sal_min;
        if((request.getParameter("sal_min")!=null) && (request.getParameter("sal_min")!=""))
        {
            sal_min = new BigDecimal(request.getParameter("sal_min"));
        }else
        {
            sal_min = new BigDecimal(0.00);
        }
        catprog.setSal_min(sal_min);
        
        BigDecimal pago_mes;
        if((request.getParameter("pago_mes")!=null) && (request.getParameter("pago_mes")!=""))
        {
            pago_mes = new BigDecimal(request.getParameter("pago_mes"));
        }else
        {
            pago_mes = new BigDecimal(0.00);
        }
        catprog.setPago_mes(pago_mes);
        
        BigDecimal por_eng;
        if((request.getParameter("por_eng")!=null) && (request.getParameter("por_eng")!=""))
        {
            por_eng = new BigDecimal(request.getParameter("por_eng"));
        }else
        {
            por_eng = new BigDecimal(0.00);
        }
        catprog.setPor_eng(por_eng);
        
        BigDecimal anual;
        if((request.getParameter("anual")!=null) && (request.getParameter("anual")!=""))
        {
            anual = new BigDecimal(request.getParameter("anual"));
        }else
        {
            anual = new BigDecimal(0.00);
        }
        catprog.setAnual(anual);
        
        
        Integer plazo = Integer.parseInt(request.getParameter("plazo"));
        catprog.setPlazo(plazo);
        
        BigDecimal por_cap;
        if((request.getParameter("por_cap")!=null) && (request.getParameter("por_cap")!=""))
        {
            por_cap = new BigDecimal(request.getParameter("por_cap"));
        }else
        {
            por_cap = new BigDecimal(0.00);
        }
        catprog.setPor_cap(por_cap);
        
        Integer estatus= Integer.parseInt(request.getParameter("estatus"));
        catprog.setStatus(estatus);
        
        Integer idDelegacion = Integer.parseInt(request.getParameter("id_del"));
        catprog.setId_del(idDelegacion);
        Integer idColonia = Integer.parseInt(request.getParameter("id_colonia"));
        catprog.setId_colonia(idColonia);
    %>
           
        <jsp:forward page="controladorcatprog?operacion=modificar"/>
    <%}%>
    
    <body>
        <center> 
            <h1>Modificación al Catálogo de Condiciones Financieras</h1>
            <form name="frmcatprog" id="frmcatprog" class="catalogo" method="post">
                <br/><br/>
                <table class="fuente8" width="80%" cellspacing=0 cellpadding=3 border=0>
                    <tr>
                        <td width="10%" align="left">Clave:</td>
                        <td width="30%" align="left"><input type="text" name="clave" id="clave" class="cajaPequena" size="5" maxlength="6" onMouseOver="this.style.cursor='crosshair'" value="${catprogs.clave}"><input type="hidden" name="idCatprog" id="idCatprog"  value="${catprogs.id_Catprog}"></td>
                        <td width="10%" align="left">Descripcion:</td>
                        <td width="30%" align="left"><input type="text" name="descripcion" id="descripcion" class="cajaPequena" size="60" maxlength="80" onMouseOver="this.style.cursor='crosshair'" value="${catprogs.descripcion}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Mecánica:</td>
                        <td width="30%" align="left">
                            <select name="mecanica" id="mecanica">
                                
                                
                                <c:forEach  var="mec" items="${requestScope.mecanicass}">
                                    
                                    <OPTION VALUE="${mec.descripcion}" ${catprogs.mecanica == mec.descripcion ? 'selected' : ''}>${mec.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="10%" align="left">Subsicio Inicial:</td>
                        <td width="30%" align="left"> <label for="sub_ini">$</label> <input type="text" name="sub_ini" id="sub_ini" class="cajaPequena" size="10" maxlength="12"  style="text-align:right" onMouseOver="this.style.cursor='crosshair'" value="${catprogs.sub_ini}"> </td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Eng. Fonahpo:</td>
                        <td width="30%" align="left"><label for="eng_fon">$</label><input type="text"  name="eng_fon" id="eng_fon" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.eng_fon}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                        <td width="10%" align="left">Eng. Inviqroo:</td>
                        <td width="30%" align="left"><label for="eng_inv">$</label><input type="text"  name="eng_inv" id="eng_inv" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.eng_inv}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Interes:</td>
                        <td width="30%" align="left"><label for="interes">$</label><input type="text"  name="interes" id="interes" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.interes}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                        <td width="10%" align="left">Admon.</td>
                        <td width="30%" align="left"><label for="admon">$</label><input type="text"  name="admon" id="admon" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.admon}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Seguro:</td>
                        <td width="30%" align="left"><label for="seguro">$</label><input type="text"  name="seguro" id="seguro" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.seguro}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                        <td width="10%" align="left">Costo M2</td>
                        <td width="30%" align="left"><label for="costo_m2">$</label><input type="text"  name="costo_m2" id="costo_m2" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.costo_m2}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    <tr>
                        <td width="10%" align="left">Por_sub:</td>
                        <td width="30%" align="left"><label for="por_sub">$</label><input type="text"  name="por_sub" id="por_sub" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.por_sub}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                        <td width="10%" align="left">Por_admon</td>
                        <td width="30%" align="left"><label for="por_admon">$</label><input type="text"  name="por_admon" id="por_admon" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.por_admon}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    
                     <tr>
                        <td width="10%" align="left">Por_sv:</td>
                        <td width="30%" align="left"><label for="por_sv">$</label><input type="text"  name="por_sv" id="por_sv" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.por_sv}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                        <td width="10%" align="left">Por_os</td>
                        <td width="30%" align="left"><label for="por_os">$</label><input type="text"  name="por_os" id="por_os" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.por_os}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Sub. bp.</td>
                        <td width="30%" align="left"><label for="sub_bp">$</label><input type="text"  name="sub_bp" id="sub_bp" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.sub_bp}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                        <td width="10%" align="left">Salario Min.</td>
                        <td width="30%" align="left"><label for="sal_min">$</label><input type="text"  name="sal_min" id="sal_min" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.sal_min}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Pago Mensual</td>
                        <td width="30%" align="left"><label for="pago_mes">$</label><input type="text"  name="pago_mes" id="pago_mes" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.pago_mes}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                        <td width="10%" align="left">Por. Enganche</td>
                        <td width="30%" align="left"><label for="por_eng">%</label><input type="text"  name="por_eng" id="por_eng" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.por_eng}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Anual</td>
                        <td width="30%" align="left"><label for="anual">$</label><input type="text"  name="anual" id="anual" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.anual}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                        <td width="10%" align="left">Plazo</td>
                        <td width="30%" align="left"><label for="plazo"></label><input type="text"  name="plazo" id="plazo" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.plazo}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Por. Capital</td>
                        <td width="30%" align="left"><label for="por_cap">$</label><input type="text"  name="por_cap" id="por_cap" class="cajaPequena"  size="10" maxlength="12" value="${catprogs.por_cap}" style="text-align:right"  onMouseOver="this.style.cursor='crosshair'"></td>
                        <td width="10%" align="left">Activo</td>
                        <td width="30%" align="left"><input type="checkbox" name="status2" id="status2" onChange="modificastatus()" ><input type="hidden" name="estatus" id="estatus"  value="${catprogs.status}"></td>
                    </tr>
                    
                    <tr>
                        <td width="10%" align="left">Delegacion:</td>
                        <td width="30%" align="left">
                            <select name="id_del" id="id_del">
                                
                                
                                <c:forEach  var="delegaciones" items="${requestScope.delegacioness}">
                                    
                                    <OPTION VALUE="${delegaciones.idDelegacion}" ${catprogs.id_del == delegaciones.idDelegacion ? 'selected' : ''}>${delegaciones.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="10%" align="left">Colonia:</td>
                        <td width="30%" align="left">
                            <select name="id_colonia" id="id_colonia">
                                
                                
                                <c:forEach  var="colonias" items="${requestScope.coloniass}">
                                    
                                    <OPTION VALUE="${colonias.idColonia}" ${catprogs.id_colonia == colonias.idColonia ? 'selected' : ''}>${colonias.descripcion}</OPTION>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    
                </table>
                <br/>
                <input type="submit" class="boton_fb" name="Submit" value="Modificar"  onMouseOver="this.style.cursor='pointer'" >
                <input type="reset" class="boton_fb" value="Deshacer" onMouseOver="this.style.cursor='pointer'">
            </form>
        </center>

    </body>
</html>
