package ar.edu.ubp.das.src.videos.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.DaoImpl;
import ar.edu.ubp.das.src.videos.forms.CategoriaForm;
import ar.edu.ubp.das.src.videos.forms.VideoForm;

public class MSVideosDao extends DaoImpl {

	@Override
	public DynaActionForm make(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
    	return null;
	}

	@Override
	public void insert(DynaActionForm form) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DynaActionForm form) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DynaActionForm form) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DynaActionForm> select(DynaActionForm form) throws SQLException {
    	List<DynaActionForm>  categorias = new LinkedList<DynaActionForm>();
    	LinkedList<VideoForm> videos;

    	CategoriaForm categoria;
    	VideoForm     video;
    	short         nroCategoria;
		
		this.connect();
		
		this.setProcedure("dbo.get_videos(?,?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        if(form.getItem("nro_categoria").isEmpty()) {
        	this.setNull(1, Types.TINYINT);
        }
        else {
        	this.setParameter(1, Short.valueOf(form.getItem("nro_categoria")));
        }
        this.setParameter(2, form.getItem("idioma"));
        this.setParameter(3, form.getItem("string_busqueda"));
        
        ResultSet result = this.getStatement().executeQuery();
    	result.next();
        while(result.getRow() > 0) {
        	categoria = new CategoriaForm();
        	categoria.setNroCategoria(result.getShort("nro_categoria"));
        	categoria.setNomCategoria(result.getString("nom_categoria"));

        	videos = new LinkedList<VideoForm>();

        	nroCategoria = result.getShort("nro_categoria");
        	while(result.getRow() > 0 && nroCategoria == result.getShort("nro_categoria")) {
            	video = new VideoForm();
            	video.setNroVideo(result.getInt("nro_video"));
            	video.setTitulo(result.getString("titulo"));
            	video.setCantante(result.getString("cantante"));
            	video.setLinkVideo(result.getString("link_video"));
            	videos.add(video);
        		result.next();
            }
            categoria.setVideos(videos);
            categorias.add(categoria);
        }
        
		this.disconnect();
		
		return categorias;
	}

	@Override
	public boolean valid(DynaActionForm form) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
