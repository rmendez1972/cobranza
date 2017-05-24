
package mx.gob.qroo.sh.sistemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Declaracion" type="{http://sistemas.sh.qroo.gob.mx/}Forma" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "declaracion"
})
@XmlRootElement(name = "TributanetGuardarContribucion")
public class TributanetGuardarContribucion {

    @XmlElement(name = "Declaracion")
    protected Forma declaracion;

    /**
     * Obtiene el valor de la propiedad declaracion.
     * 
     * @return
     *     possible object is
     *     {@link Forma }
     *     
     */
    public Forma getDeclaracion() {
        return declaracion;
    }

    /**
     * Define el valor de la propiedad declaracion.
     * 
     * @param value
     *     allowed object is
     *     {@link Forma }
     *     
     */
    public void setDeclaracion(Forma value) {
        this.declaracion = value;
    }

}
