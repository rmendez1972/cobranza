
package mx.gob.qroo.sh.sistemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PaTributanetConsultarContribucionConcepto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaTributanetConsultarContribucionConcepto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Lista" type="{http://sistemas.sh.qroo.gob.mx/}ArrayOfPaTributanetConsultarContribucionConceptoResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaTributanetConsultarContribucionConcepto", propOrder = {
    "lista"
})
public class PaTributanetConsultarContribucionConcepto {

    @XmlElement(name = "Lista")
    protected ArrayOfPaTributanetConsultarContribucionConceptoResult lista;

    /**
     * Obtiene el valor de la propiedad lista.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPaTributanetConsultarContribucionConceptoResult }
     *     
     */
    public ArrayOfPaTributanetConsultarContribucionConceptoResult getLista() {
        return lista;
    }

    /**
     * Define el valor de la propiedad lista.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPaTributanetConsultarContribucionConceptoResult }
     *     
     */
    public void setLista(ArrayOfPaTributanetConsultarContribucionConceptoResult value) {
        this.lista = value;
    }

}
