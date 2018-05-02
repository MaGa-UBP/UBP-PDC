package ar.edu.ubp.das.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "yyyyy", targetNamespace = "http://ws.das.ubp.edu.ar/")
public interface yyyyy {

	@WebMethod(operationName = "getFactorial", action = "urn:GetFactorial")
	long[] getFactorial(@WebParam(name = "arg0") int nro);

}