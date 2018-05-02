
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

    private final static QName _GetPaises_QNAME = new QName("http://ws.das.ubp.edu.ar/", "getPaises");
    private final static QName _GetPaisesResponse_QNAME = new QName("http://ws.das.ubp.edu.ar/", "getPaisesResponse");
    private final static QName _Test_QNAME = new QName("http://ws.das.ubp.edu.ar/", "test");
    private final static QName _TestResponse_QNAME = new QName("http://ws.das.ubp.edu.ar/", "testResponse");
    private final static QName _Exception_QNAME = new QName("http://ws.das.ubp.edu.ar/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ar.edu.ubp.das.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPaises }
     * 
     */
    public GetPaises createGetPaises() {
        return new GetPaises();
    }

    /**
     * Create an instance of {@link GetPaisesResponse }
     * 
     */
    public GetPaisesResponse createGetPaisesResponse() {
        return new GetPaisesResponse();
    }

    /**
     * Create an instance of {@link Test }
     * 
     */
    public Test createTest() {
        return new Test();
    }

    /**
     * Create an instance of {@link TestResponse }
     * 
     */
    public TestResponse createTestResponse() {
        return new TestResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link PaisBean }
     * 
     */
    public PaisBean createPaisBean() {
        return new PaisBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPaises }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.das.ubp.edu.ar/", name = "getPaises")
    public JAXBElement<GetPaises> createGetPaises(GetPaises value) {
        return new JAXBElement<GetPaises>(_GetPaises_QNAME, GetPaises.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPaisesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.das.ubp.edu.ar/", name = "getPaisesResponse")
    public JAXBElement<GetPaisesResponse> createGetPaisesResponse(GetPaisesResponse value) {
        return new JAXBElement<GetPaisesResponse>(_GetPaisesResponse_QNAME, GetPaisesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Test }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.das.ubp.edu.ar/", name = "test")
    public JAXBElement<Test> createTest(Test value) {
        return new JAXBElement<Test>(_Test_QNAME, Test.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.das.ubp.edu.ar/", name = "testResponse")
    public JAXBElement<TestResponse> createTestResponse(TestResponse value) {
        return new JAXBElement<TestResponse>(_TestResponse_QNAME, TestResponse.class, null, value);
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
