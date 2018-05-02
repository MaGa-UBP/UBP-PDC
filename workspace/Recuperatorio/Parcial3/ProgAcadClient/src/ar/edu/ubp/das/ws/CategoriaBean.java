
package ar.edu.ubp.das.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para categoriaBean complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="categoriaBean"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codCategoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descCategoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categoriaBean", propOrder = {
    "codCategoria",
    "descCategoria"
})
public class CategoriaBean {

    protected String codCategoria;
    protected String descCategoria;

    /**
     * Obtiene el valor de la propiedad codCategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCategoria() {
        return codCategoria;
    }

    /**
     * Define el valor de la propiedad codCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCategoria(String value) {
        this.codCategoria = value;
    }

    /**
     * Obtiene el valor de la propiedad descCategoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescCategoria() {
        return descCategoria;
    }

    /**
     * Define el valor de la propiedad descCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescCategoria(String value) {
        this.descCategoria = value;
    }

}
