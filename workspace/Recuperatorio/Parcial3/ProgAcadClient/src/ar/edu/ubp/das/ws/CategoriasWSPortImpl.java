
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package ar.edu.ubp.das.ws;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-11-06T17:38:39.112-03:00
 * Generated source version: 3.1.7
 * 
 */

@javax.jws.WebService(
                      serviceName = "CategoriasWSService",
                      portName = "CategoriasWSPort",
                      targetNamespace = "http://ws.das.ubp.edu.ar/",
                      wsdlLocation = "http://localhost:9090/CategoriasWSPort?wsdl",
                      endpointInterface = "ar.edu.ubp.das.ws.ICategorias")
                      
public class CategoriasWSPortImpl implements ICategorias {

    private static final Logger LOG = Logger.getLogger(CategoriasWSPortImpl.class.getName());

    /* (non-Javadoc)
     * @see ar.edu.ubp.das.ws.ICategorias#getCategorias()*
     */
    public java.util.List<ar.edu.ubp.das.ws.CategoriaBean> getCategorias() throws Exception_Exception   { 
        LOG.info("Executing operation getCategorias");
        try {
            java.util.List<ar.edu.ubp.das.ws.CategoriaBean> _return = new java.util.ArrayList<ar.edu.ubp.das.ws.CategoriaBean>();
            ar.edu.ubp.das.ws.CategoriaBean _returnVal1 = new ar.edu.ubp.das.ws.CategoriaBean();
            _returnVal1.setCodCategoria("CodCategoria2015348826");
            _returnVal1.setDescCategoria("DescCategoria-1327459307");
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

}
