
package ar.edu.ubp.das.ws;

import javax.xml.ws.Endpoint;

import com.sun.xml.internal.ws.server.ServerRtException;

/**
 * This class was generated by Apache CXF 3.1.3
 * 2015-10-12T19:29:03.211-03:00
 * Generated source version: 3.1.3
 * 
 */
 
public class IFactorialWSServer {

    public static void main(String args[]) throws Exception { 
		try {
			//netstat -ao (Buscar SPID asociado al puerto) si se requiere recompilar
			Endpoint.publish("http://localhost:9090/FactorialCXFWS/services", new FactorialWS()); 
			System.out.println("OK");
		}
		catch(ServerRtException ex) {
			System.out.println(ex);
		}
    }
    
}
 
 