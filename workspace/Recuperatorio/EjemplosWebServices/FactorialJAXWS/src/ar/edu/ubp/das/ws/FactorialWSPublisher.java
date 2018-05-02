package ar.edu.ubp.das.ws;

import javax.xml.ws.Endpoint;
import com.sun.xml.internal.ws.server.ServerRtException;

public class FactorialWSPublisher {

	public static void main(String[] args) {
		try {
			//netstat -ao (Buscar SPID asociado al puerto) si se requiere recompilar
			
			Endpoint.publish("http://localhost:8091/FactorialJAXWS/FactorialWS", new FactorialWS()); 
			System.out.println("OK");
		}
		catch(ServerRtException ex) {
			System.out.println(ex);
		}
	}
	
}
