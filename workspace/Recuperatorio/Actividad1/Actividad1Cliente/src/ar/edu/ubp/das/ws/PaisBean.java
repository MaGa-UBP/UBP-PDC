
package ar.edu.ubp.das.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para paisBean complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="paisBean"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nomPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paisBean", propOrder = {
    "codPais",
    "nomPais"
})
public class PaisBean {

    protected String codPais;
    protected String nomPais;

    /**
     * Obtiene el valor de la propiedad codPais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPais() {
        return codPais;
    }

    /**
     * Define el valor de la propiedad codPais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPais(String value) {
        this.codPais = value;
    }

    /**
     * Obtiene el valor de la propiedad nomPais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomPais() {
        return nomPais;
    }

    /**
     * Define el valor de la propiedad nomPais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomPais(String value) {
        this.nomPais = value;
    }

}
