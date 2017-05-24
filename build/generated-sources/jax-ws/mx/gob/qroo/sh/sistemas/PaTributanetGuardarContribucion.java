
package mx.gob.qroo.sh.sistemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PaTributanetGuardarContribucion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaTributanetGuardarContribucion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Lista" type="{http://sistemas.sh.qroo.gob.mx/}ArrayOfPaTributanetGuardarContribucionResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaTributanetGuardarContribucion", propOrder = {
    "lista"
})
public class PaTributanetGuardarContribucion {

    @XmlElement(name = "Lista")
    protected ArrayOfPaTributanetGuardarContribucionResult lista;

    /**
     * Obtiene el valor de la propiedad lista.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPaTributanetGuardarContribucionResult }
     *     
     */
    public ArrayOfPaTributanetGuardarContribucionResult getLista() {
        return lista;
    }

    /**
     * Define el valor de la propiedad lista.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPaTributanetGuardarContribucionResult }
     *     
     */
    public void setLista(ArrayOfPaTributanetGuardarContribucionResult value) {
        this.lista = value;
    }

}
