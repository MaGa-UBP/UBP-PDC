
package ar.edu.ubp.das.fds;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebService;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-11-06T19:08:10.818-03:00
 * Generated source version: 3.1.7
 * 
 */
public final class ServicioCategoriasWS_ServicioCategoriasPort_Client {

    private static final QName SERVICE_NAME = new QName("http://fds.das.ubp.edu.ar/", "ServicioCategoriasService");

    private ServicioCategoriasWS_ServicioCategoriasPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ServicioCategoriasService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ServicioCategoriasService ss = new ServicioCategoriasService(wsdlURL, SERVICE_NAME);
        ServicioCategoriasWS port = ss.getServicioCategoriasPort();  
        

        System.exit(0);
    }

}
