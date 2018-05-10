package ar.edu.ubp.das.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import ar.edu.ubp.das.bean.CategoriaVideosBean;
import ar.edu.ubp.das.bean.CriterioBean;
import ar.edu.ubp.das.bean.VideoBean;
import ar.edu.ubp.das.db.Bean;
import ar.edu.ubp.das.db.DaoImpl;

public class MSVideosDao extends DaoImpl {

	@Override
	public Bean make(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Bean form) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Bean form) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Bean form) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bean> select(Bean bean) throws SQLException {
    	List<Bean>            categorias = new LinkedList<Bean>();
    	LinkedList<VideoBean> videos;

    	CriterioBean        criterio = (CriterioBean) bean;
    	CategoriaVideosBean categoria;
    	VideoBean     		video;
    	short         		nroCategoria;
		
		this.connect();
		
		this.setProcedure("dbo.get_videos(?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        if(criterio.getNroCategoria() == 0) {
        	this.setNull(1, Types.TINYINT);
        }
        else {
        	this.setParameter(1, Short.valueOf(criterio.getNroCategoria()));
        }
        this.setParameter(2, criterio.getStringBusqueda());
        
        ResultSet result = this.getStatement().executeQuery();
    	result.next();
        while(result.getRow() > 0) {
        	categoria = new CategoriaVideosBean();
        	categoria.setNroCategoria(result.getShort("nro_categoria"));
        	categoria.setNomCategoria(result.getString("nom_categoria"));

        	videos = new LinkedList<VideoBean>();

        	nroCategoria = result.getShort("nro_categoria");
        	while(result.getRow() > 0 && nroCategoria == result.getShort("nro_categoria")) {
            	video = new VideoBean();
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
	public boolean valid(Bean form) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
