package ar.edu.ubp.das.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ar.edu.ubp.das.bean.CriterioBean;
import ar.edu.ubp.das.db.Bean;
import ar.edu.ubp.das.db.Dao;
import ar.edu.ubp.das.db.DaoFactory;

@Path("/videos")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class VideosResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response getVideos(@FormParam("nro_categoria") short nroCategoria, 
			                  @FormParam("string_busqueda") String stringBusqueda) {
        try {
        	CriterioBean criterio = new CriterioBean();
        	             criterio.setNroCategoria(nroCategoria);
        	             criterio.setStringBusqueda(stringBusqueda);
        	
        	Dao dao = DaoFactory.getDao("Videos", "ar.edu.ubp.das");
        	List<Bean> categorias = dao.select(criterio);        	
        	
        	return Response.status(Response.Status.OK).entity(categorias).build();
        }
        catch(SQLException ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
	}

	@POST
	@Path("/sin_grupo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response getVideosSinAgrupar(@FormParam("nro_categoria") short nroCategoria, 
			                            @FormParam("string_busqueda") String stringBusqueda) {
        try {
        	CriterioBean criterio = new CriterioBean();
        	             criterio.setNroCategoria(nroCategoria);
        	             criterio.setStringBusqueda(stringBusqueda);
        	
        	Dao dao = DaoFactory.getDao("VideosSinGrp", "ar.edu.ubp.das");
        	List<Bean> videos = dao.select(criterio);        	
        	
        	return Response.status(Response.Status.OK).entity(videos).build();
        }
        catch(SQLException ex) {
			return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
	}
	
}
