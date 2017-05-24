
package mx.gob.qroo.sh.sistemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfPaTributanetGuardarContribucionResult complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPaTributanetGuardarContribucionResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaTributanetGuardarContribucionResult" type="{http://sistemas.sh.qroo.gob.mx/}PaTributanetGuardarContribucionResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPaTributanetGuardarContribucionResult", propOrder = {
    "paTributanetGuardarContribucionResult"
})
public class ArrayOfPaTributanetGuardarContribucionResult {

    @XmlElement(name = "PaTributanetGuardarContribucionResult", nillable = true)
    protected List<PaTributanetGuardarContribucionResult> paTributanetGuardarContribucionResult;

    /**
     * Gets the value of the paTributanetGuardarContribucionResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paTributanetGuardarContribucionResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaTributanetGuardarContribucionResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaTributanetGuardarContribucionResult }
     * 
     * 
     */
    public List<PaTributanetGuardarContribucionResult> getPaTributanetGuardarContribucionResult() {
        if (paTributanetGuardarContribucionResult == null) {
            paTributanetGuardarContribucionResult = new ArrayList<PaTributanetGuardarContribucionResult>();
        }
        return this.paTributanetGuardarContribucionResult;
    }

}
