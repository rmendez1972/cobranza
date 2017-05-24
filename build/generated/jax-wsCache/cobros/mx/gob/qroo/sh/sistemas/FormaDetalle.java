
package mx.gob.qroo.sh.sistemas;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FormaDetalle complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FormaDetalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id_Concepto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ImporteManual" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormaDetalle", propOrder = {
    "idConcepto",
    "cantidad",
    "importeManual"
})
public class FormaDetalle {

    @XmlElement(name = "Id_Concepto", required = true, type = Integer.class, nillable = true)
    protected Integer idConcepto;
    @XmlElement(name = "Cantidad", required = true, type = Integer.class, nillable = true)
    protected Integer cantidad;
    @XmlElement(name = "ImporteManual", required = true, nillable = true)
    protected BigDecimal importeManual;

    /**
     * Obtiene el valor de la propiedad idConcepto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdConcepto() {
        return idConcepto;
    }

    /**
     * Define el valor de la propiedad idConcepto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdConcepto(Integer value) {
        this.idConcepto = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidad(Integer value) {
        this.cantidad = value;
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

}
