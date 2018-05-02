package asdasd;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "cassdadada", targetNamespace = "http://asdasd/")
public interface cassdadada {

	@WebMethod(operationName = "hola", action = "urn:Hola")
	int hola();

}