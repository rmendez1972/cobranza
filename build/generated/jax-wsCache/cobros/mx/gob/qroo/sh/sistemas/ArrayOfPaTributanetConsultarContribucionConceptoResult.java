
package mx.gob.qroo.sh.sistemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfPaTributanetConsultarContribucionConceptoResult complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPaTributanetConsultarContribucionConceptoResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaTributanetConsultarContribucionConceptoResult" type="{http://sistemas.sh.qroo.gob.mx/}PaTributanetConsultarContribucionConceptoResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPaTributanetConsultarContribucionConceptoResult", propOrder = {
    "paTributanetConsultarContribucionConceptoResult"
})
public class ArrayOfPaTributanetConsultarContribucionConceptoResult {

    @XmlElement(name = "PaTributanetConsultarContribucionConceptoResult", nillable = true)
    protected List<PaTributanetConsultarContribucionConceptoResult> paTributanetConsultarContribucionConceptoResult;

    /**
     * Gets the value of the paTributanetConsultarContribucionConceptoResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paTributanetConsultarContribucionConceptoResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaTributanetConsultarContribucionConceptoResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaTributanetConsultarContribucionConceptoResult }
     * 
     * 
     */
    public List<PaTributanetConsultarContribucionConceptoResult> getPaTributanetConsultarContribucionConceptoResult() {
        if (paTributanetConsultarContribucionConceptoResult == null) {
            paTributanetConsultarContribucionConceptoResult = new ArrayList<PaTributanetConsultarContribucionConceptoResult>();
        }
        return this.paTributanetConsultarContribucionConceptoResult;
    }

}
