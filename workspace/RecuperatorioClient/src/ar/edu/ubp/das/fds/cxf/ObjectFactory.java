
package ar.edu.ubp.das.fds.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ar.edu.ubp.das.fds.cxf package. 
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

    private final static QName _GetObrasSociales_QNAME = new QName("http://cxf.fds.das.ubp.edu.ar/", "getObrasSociales");
    private final static QName _GetObrasSocialesResponse_QNAME = new QName("http://cxf.fds.das.ubp.edu.ar/", "getObrasSocialesResponse");
    private final static QName _Exception_QNAME = new QName("http://cxf.fds.das.ubp.edu.ar/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ar.edu.ubp.das.fds.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetObrasSociales }
     * 
     */
    public GetObrasSociales createGetObrasSociales() {
        return new GetObrasSociales();
    }

    /**
     * Create an instance of {@link GetObrasSocialesResponse }
     * 
     */
    public GetObrasSocialesResponse createGetObrasSocialesResponse() {
        return new GetObrasSocialesResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetObrasSociales }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.fds.das.ubp.edu.ar/", name = "getObrasSociales")
    public JAXBElement<GetObrasSociales> createGetObrasSociales(GetObrasSociales value) {
        return new JAXBElement<GetObrasSociales>(_GetObrasSociales_QNAME, GetObrasSociales.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetObrasSocialesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.fds.das.ubp.edu.ar/", name = "getObrasSocialesResponse")
    public JAXBElement<GetObrasSocialesResponse> createGetObrasSocialesResponse(GetObrasSocialesResponse value) {
        return new JAXBElement<GetObrasSocialesResponse>(_GetObrasSocialesResponse_QNAME, GetObrasSocialesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.fds.das.ubp.edu.ar/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
