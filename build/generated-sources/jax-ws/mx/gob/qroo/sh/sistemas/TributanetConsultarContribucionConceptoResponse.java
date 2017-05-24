
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
 *         &lt;element name="TributanetConsultarContribucionConceptoResult" type="{http://sistemas.sh.qroo.gob.mx/}PaTributanetConsultarContribucionConcepto" minOccurs="0"/>
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
    "tributanetConsultarContribucionConceptoResult"
})
@XmlRootElement(name = "TributanetConsultarContribucionConceptoResponse")
public class TributanetConsultarContribucionConceptoResponse {

    @XmlElement(name = "TributanetConsultarContribucionConceptoResult")
    protected PaTributanetConsultarContribucionConcepto tributanetConsultarContribucionConceptoResult;

    /**
     * Obtiene el valor de la propiedad tributanetConsultarContribucionConceptoResult.
     * 
     * @return
     *     possible object is
     *     {@link PaTributanetConsultarContribucionConcepto }
     *     
     */
    public PaTributanetConsultarContribucionConcepto getTributanetConsultarContribucionConceptoResult() {
        return tributanetConsultarContribucionConceptoResult;
    }

    /**
     * Define el valor de la propiedad tributanetConsultarContribucionConceptoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link PaTributanetConsultarContribucionConcepto }
     *     
     */
    public void setTributanetConsultarContribucionConceptoResult(PaTributanetConsultarContribucionConcepto value) {
        this.tributanetConsultarContribucionConceptoResult = value;
    }

}
