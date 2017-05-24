
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
 *         &lt;element name="TributanetGuardarContribucionResult" type="{http://sistemas.sh.qroo.gob.mx/}PaTributanetGuardarContribucion" minOccurs="0"/>
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
    "tributanetGuardarContribucionResult"
})
@XmlRootElement(name = "TributanetGuardarContribucionResponse")
public class TributanetGuardarContribucionResponse {

    @XmlElement(name = "TributanetGuardarContribucionResult")
    protected PaTributanetGuardarContribucion tributanetGuardarContribucionResult;

    /**
     * Obtiene el valor de la propiedad tributanetGuardarContribucionResult.
     * 
     * @return
     *     possible object is
     *     {@link PaTributanetGuardarContribucion }
     *     
     */
    public PaTributanetGuardarContribucion getTributanetGuardarContribucionResult() {
        return tributanetGuardarContribucionResult;
    }

    /**
     * Define el valor de la propiedad tributanetGuardarContribucionResult.
     * 
     * @param value
     *     allowed object is
     *     {@link PaTributanetGuardarContribucion }
     *     
     */
    public void setTributanetGuardarContribucionResult(PaTributanetGuardarContribucion value) {
        this.tributanetGuardarContribucionResult = value;
    }

}
