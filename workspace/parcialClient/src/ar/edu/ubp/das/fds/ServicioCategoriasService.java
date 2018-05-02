package ar.edu.ubp.das.fds;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-11-06T19:08:10.880-03:00
 * Generated source version: 3.1.7
 * 
 */
@WebServiceClient(name = "ServicioCategoriasService", 
                  wsdlLocation = "http://localhost:9090/ServicioCategoriasPort?wsdl",
                  targetNamespace = "http://fds.das.ubp.edu.ar/") 
public class ServicioCategoriasService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://fds.das.ubp.edu.ar/", "ServicioCategoriasService");
    public final static QName ServicioCategoriasPort = new QName("http://fds.das.ubp.edu.ar/", "ServicioCategoriasPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:9090/ServicioCategoriasPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ServicioCategoriasService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:9090/ServicioCategoriasPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ServicioCategoriasService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServicioCategoriasService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioCategoriasService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ServicioCategoriasService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ServicioCategoriasService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ServicioCategoriasService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ServicioCategoriasWS
     */
    @WebEndpoint(name = "ServicioCategoriasPort")
    public ServicioCategoriasWS getServicioCategoriasPort() {
        return super.getPort(ServicioCategoriasPort, ServicioCategoriasWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioCategoriasWS
     */
    @WebEndpoint(name = "ServicioCategoriasPort")
    public ServicioCategoriasWS getServicioCategoriasPort(WebServiceFeature... features) {
        return super.getPort(ServicioCategoriasPort, ServicioCategoriasWS.class, features);
    }

}