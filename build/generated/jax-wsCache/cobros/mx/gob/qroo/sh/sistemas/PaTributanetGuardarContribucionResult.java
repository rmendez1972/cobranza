
package mx.gob.qroo.sh.sistemas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para PaTributanetGuardarContribucionResult complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaTributanetGuardarContribucionResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rfc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Domicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalPagar" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="IdDecContribucionTipo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DatosEspecificosContribucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AltaFecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AltaHora" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PagoUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PagoMunicipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PagoRecaudadora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PagoCaja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PagoFecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PagoHora" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PagoRecibo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PagoNoOperacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Activado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Impreso" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NoOperacionImpresion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Municipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Historial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CabeceraImpresion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaTributanetGuardarContribucionResult", propOrder = {
    "id",
    "referencia",
    "folio",
    "rfc",
    "nombre",
    "domicilio",
    "totalPagar",
    "idDecContribucionTipo",
    "datosEspecificosContribucion",
    "altaFecha",
    "altaHora",
    "pagoUsuario",
    "pagoMunicipio",
    "pagoRecaudadora",
    "pagoCaja",
    "pagoFecha",
    "pagoHora",
    "pagoRecibo",
    "pagoNoOperacion",
    "status",
    "activado",
    "impreso",
    "noOperacionImpresion",
    "municipio",
    "observaciones",
    "historial",
    "cabeceraImpresion",
    "fechaVencimiento"
})
public class PaTributanetGuardarContribucionResult {

    @XmlElement(name = "Id", required = true, type = Long.class, nillable = true)
    protected Long id;
    @XmlElement(name = "Referencia")
    protected String referencia;
    @XmlElement(name = "Folio")
    protected String folio;
    @XmlElement(name = "Rfc")
    protected String rfc;
    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "Domicilio")
    protected String domicilio;
    @XmlElement(name = "TotalPagar", required = true, nillable = true)
    protected BigDecimal totalPagar;
    @XmlElement(name = "IdDecContribucionTipo", required = true, type = Integer.class, nillable = true)
    protected Integer idDecContribucionTipo;
    @XmlElement(name = "DatosEspecificosContribucion")
    protected String datosEspecificosContribucion;
    @XmlElement(name = "AltaFecha", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar altaFecha;
    @XmlElement(name = "AltaHora", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar altaHora;
    @XmlElement(name = "PagoUsuario")
    protected String pagoUsuario;
    @XmlElement(name = "PagoMunicipio")
    protected String pagoMunicipio;
    @XmlElement(name = "PagoRecaudadora")
    protected String pagoRecaudadora;
    @XmlElement(name = "PagoCaja")
    protected String pagoCaja;
    @XmlElement(name = "PagoFecha", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pagoFecha;
    @XmlElement(name = "PagoHora", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pagoHora;
    @XmlElement(name = "PagoRecibo")
    protected String pagoRecibo;
    @XmlElement(name = "PagoNoOperacion")
    protected String pagoNoOperacion;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "Activado")
    protected String activado;
    @XmlElement(name = "Impreso", required = true, type = Boolean.class, nillable = true)
    protected Boolean impreso;
    @XmlElement(name = "NoOperacionImpresion")
    protected String noOperacionImpresion;
    @XmlElement(name = "Municipio")
    protected String municipio;
    @XmlElement(name = "Observaciones")
    protected String observaciones;
    @XmlElement(name = "Historial")
    protected String historial;
    @XmlElement(name = "CabeceraImpresion")
    protected String cabeceraImpresion;
    @XmlElement(name = "FechaVencimiento", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaVencimiento;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad referencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Define el valor de la propiedad referencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencia(String value) {
        this.referencia = value;
    }

    /**
     * Obtiene el valor de la propiedad folio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Define el valor de la propiedad folio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolio(String value) {
        this.folio = value;
    }

    /**
     * Obtiene el valor de la propiedad rfc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Define el valor de la propiedad rfc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfc(String value) {
        this.rfc = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad domicilio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Define el valor de la propiedad domicilio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomicilio(String value) {
        this.domicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad totalPagar.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPagar() {
        return totalPagar;
    }

    /**
     * Define el valor de la propiedad totalPagar.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPagar(BigDecimal value) {
        this.totalPagar = value;
    }

    /**
     * Obtiene el valor de la propiedad idDecContribucionTipo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdDecContribucionTipo() {
        return idDecContribucionTipo;
    }

    /**
     * Define el valor de la propiedad idDecContribucionTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdDecContribucionTipo(Integer value) {
        this.idDecContribucionTipo = value;
    }

    /**
     * Obtiene el valor de la propiedad datosEspecificosContribucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatosEspecificosContribucion() {
        return datosEspecificosContribucion;
    }

    /**
     * Define el valor de la propiedad datosEspecificosContribucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatosEspecificosContribucion(String value) {
        this.datosEspecificosContribucion = value;
    }

    /**
     * Obtiene el valor de la propiedad altaFecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAltaFecha() {
        return altaFecha;
    }

    /**
     * Define el valor de la propiedad altaFecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAltaFecha(XMLGregorianCalendar value) {
        this.altaFecha = value;
    }

    /**
     * Obtiene el valor de la propiedad altaHora.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAltaHora() {
        return altaHora;
    }

    /**
     * Define el valor de la propiedad altaHora.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAltaHora(XMLGregorianCalendar value) {
        this.altaHora = value;
    }

    /**
     * Obtiene el valor de la propiedad pagoUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagoUsuario() {
        return pagoUsuario;
    }

    /**
     * Define el valor de la propiedad pagoUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagoUsuario(String value) {
        this.pagoUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad pagoMunicipio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagoMunicipio() {
        return pagoMunicipio;
    }

    /**
     * Define el valor de la propiedad pagoMunicipio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagoMunicipio(String value) {
        this.pagoMunicipio = value;
    }

    /**
     * Obtiene el valor de la propiedad pagoRecaudadora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagoRecaudadora() {
        return pagoRecaudadora;
    }

    /**
     * Define el valor de la propiedad pagoRecaudadora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagoRecaudadora(String value) {
        this.pagoRecaudadora = value;
    }

    /**
     * Obtiene el valor de la propiedad pagoCaja.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagoCaja() {
        return pagoCaja;
    }

    /**
     * Define el valor de la propiedad pagoCaja.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagoCaja(String value) {
        this.pagoCaja = value;
    }

    /**
     * Obtiene el valor de la propiedad pagoFecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPagoFecha() {
        return pagoFecha;
    }

    /**
     * Define el valor de la propiedad pagoFecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPagoFecha(XMLGregorianCalendar value) {
        this.pagoFecha = value;
    }

    /**
     * Obtiene el valor de la propiedad pagoHora.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPagoHora() {
        return pagoHora;
    }

    /**
     * Define el valor de la propiedad pagoHora.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPagoHora(XMLGregorianCalendar value) {
        this.pagoHora = value;
    }

    /**
     * Obtiene el valor de la propiedad pagoRecibo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagoRecibo() {
        return pagoRecibo;
    }

    /**
     * Define el valor de la propiedad pagoRecibo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagoRecibo(String value) {
        this.pagoRecibo = value;
    }

    /**
     * Obtiene el valor de la propiedad pagoNoOperacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagoNoOperacion() {
        return pagoNoOperacion;
    }

    /**
     * Define el valor de la propiedad pagoNoOperacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagoNoOperacion(String value) {
        this.pagoNoOperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad activado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivado() {
        return activado;
    }

    /**
     * Define el valor de la propiedad activado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivado(String value) {
        this.activado = value;
    }

    /**
     * Obtiene el valor de la propiedad impreso.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isImpreso() {
        return impreso;
    }

    /**
     * Define el valor de la propiedad impreso.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setImpreso(Boolean value) {
        this.impreso = value;
    }

    /**
     * Obtiene el valor de la propiedad noOperacionImpresion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOperacionImpresion() {
        return noOperacionImpresion;
    }

    /**
     * Define el valor de la propiedad noOperacionImpresion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOperacionImpresion(String value) {
        this.noOperacionImpresion = value;
    }

    /**
     * Obtiene el valor de la propiedad municipio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Define el valor de la propiedad municipio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipio(String value) {
        this.municipio = value;
    }

    /**
     * Obtiene el valor de la propiedad observaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Define el valor de la propiedad observaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad historial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHistorial() {
        return historial;
    }

    /**
     * Define el valor de la propiedad historial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHistorial(String value) {
        this.historial = value;
    }

    /**
     * Obtiene el valor de la propiedad cabeceraImpresion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCabeceraImpresion() {
        return cabeceraImpresion;
    }

    /**
     * Define el valor de la propiedad cabeceraImpresion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCabeceraImpresion(String value) {
        this.cabeceraImpresion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaVencimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Define el valor de la propiedad fechaVencimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaVencimiento(XMLGregorianCalendar value) {
        this.fechaVencimiento = value;
    }

}
