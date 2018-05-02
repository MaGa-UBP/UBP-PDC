
package ar.edu.ubp.das.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ar.edu.ubp.das.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCategorias_QNAME = new QName("http://ws.das.ubp.edu.ar/", "getCategorias");
    private final static QName _GetCategoriasResponse_QNAME = new QName("http://ws.das.ubp.edu.ar/", "getCategoriasResponse");
    private final static QName _Exception_QNAME = new QName("http://ws.das.ubp.edu.ar/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ar.edu.ubp.das.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCategorias }
     * 
     */
    public GetCategorias createGetCategorias() {
        return new GetCategorias();
    }

    /**
     * Create an instance of {@link GetCategoriasResponse }
     * 
     */
    public GetCategoriasResponse createGetCategoriasResponse() {
        return new GetCategoriasResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link CategoriaBean }
     * 
     */
    public CategoriaBean createCategoriaBean() {
        return new CategoriaBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategorias }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.das.ubp.edu.ar/", name = "getCategorias")
    public JAXBElement<GetCategorias> createGetCategorias(GetCategorias value) {
        return new JAXBElement<GetCategorias>(_GetCategorias_QNAME, GetCategorias.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoriasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.das.ubp.edu.ar/", name = "getCategoriasResponse")
    public JAXBElement<GetCategoriasResponse> createGetCategoriasResponse(GetCategoriasResponse value) {
        return new JAXBElement<GetCategoriasResponse>(_GetCategoriasResponse_QNAME, GetCategoriasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.das.ubp.edu.ar/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
