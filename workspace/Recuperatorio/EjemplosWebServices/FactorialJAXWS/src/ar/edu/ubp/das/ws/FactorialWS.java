package ar.edu.ubp.das.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService 
@SOAPBinding(style=Style.DOCUMENT)
public class FactorialWS {
	
	@WebMethod 
	public long[] getFactorial(@WebParam(name="nro") int nro) {
		long[] factorial = new long[nro + 1];
		for(int i = 0, l = nro; i <= l; i++) {
			factorial[i] = this.fact(i); 
		}
		return factorial;
	}	
	
	private long fact(long nro) {
		if(nro == 0) {
			return 1;
		}
		else {
			return nro * fact(nro - 1);
		}
	} 
	
}
