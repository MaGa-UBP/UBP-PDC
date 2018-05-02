package ar.edu.ubp.das.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/factorial")
@Produces(MediaType.APPLICATION_JSON)
public class FactorialResource {
	
	@GET
	public String getMessage() {
		return "Hola mundo!";
	}
	
	@GET
	@Path("/mensaje2")
	public String getMessage2() {
		return "Hola mundo 2!";
	}
	
	@POST
	@Path("/{nro}")
	public Response getFactorial(@PathParam("nro") int nro) {
		long[] factorial = new long[nro + 1];
		for(int i = 0, l = nro; i <= l; i++) {
			factorial[i] = this.fact(i); 
		}
		return Response.status(Response.Status.OK).entity(factorial).build();
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
