
package mx.gob.qroo.sh.sistemas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PaTributanetConsultarContribucionConceptoResult complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaTributanetConsultarContribucionConceptoResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Concepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tarifa" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Rubro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoCalculo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ImporteManual" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CargarConcepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaTributanetConsultarContribucionConceptoResult", propOrder = {
    "id",
    "nombre",
    "clave",
    "concepto",
    "tipo",
    "tarifa",
    "rubro",
    "tipoCalculo",
    "importeManual",
    "cargarConcepto"
})
public class PaTributanetConsultarContribucionConceptoResult {

    @XmlElement(name = "Id", required = true, type = Long.class, nillable = true)
    protected Long id;
    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "Clave")
    protected String clave;
    @XmlElement(name = "Concepto")
    protected String concepto;
    @XmlElement(name = "Tipo")
    protected String tipo;
    @XmlElement(name = "Tarifa", required = true, nillable = true)
    protected BigDecimal tarifa;
    @XmlElement(name = "Rubro")
    protected String rubro;
    @XmlElement(name = "TipoCalculo", required = true, type = Integer.class, nillable = true)
    protected Integer tipoCalculo;
    @XmlElement(name = "ImporteManual", required = true, nillable = true)
    protected BigDecimal importeManual;
    @XmlElement(name = "CargarConcepto")
    protected String cargarConcepto;

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
     * Obtiene el valor de la propiedad clave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave() {
        return clave;
    }

    /**
     * Define el valor de la propiedad clave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave(String value) {
        this.clave = value;
    }

    /**
     * Obtiene el valor de la propiedad concepto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Define el valor de la propiedad concepto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConcepto(String value) {
        this.concepto = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad tarifa.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTarifa() {
        return tarifa;
    }

    /**
     * Define el valor de la propiedad tarifa.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTarifa(BigDecimal value) {
        this.tarifa = value;
    }

    /**
     * Obtiene el valor de la propiedad rubro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRubro() {
        return rubro;
    }

    /**
     * Define el valor de la propiedad rubro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRubro(String value) {
        this.rubro = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCalculo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTipoCalculo() {
        return tipoCalculo;
    }

    /**
     * Define el valor de la propiedad tipoCalculo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTipoCalculo(Integer value) {
        this.tipoCalculo = value;
    }

    /**
     * Obtiene el valor de la propiedad importeManual.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImporteManual() {
        return importeManual;
    }

    /**
     * Define el valor de la propiedad importeManual.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImporteManual(BigDecimal value) {
        this.importeManual = value;
    }

    /**
     * Obtiene el valor de la propiedad cargarConcepto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCargarConcepto() {
        return cargarConcepto;
    }

    /**
     * Define el valor de la propiedad cargarConcepto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCargarConcepto(String value) {
        this.cargarConcepto = value;
    }

}
