package ar.edu.ubp.das.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import ar.edu.ubp.das.bean.CriterioBean;
import ar.edu.ubp.das.bean.VideoBean;
import ar.edu.ubp.das.db.Bean;
import ar.edu.ubp.das.db.DaoImpl;

public class MSVideosSinGrpDao extends DaoImpl {

	@Override
	public Bean make(ResultSet result) throws SQLException {
    	VideoBean video = new VideoBean();
    	          video.setNroCategoria(result.getShort("nro_categoria"));
    	          video.setNomCategoria(result.getString("nom_categoria"));
    			  video.setNroVideo(result.getInt("nro_video"));
    	          video.setTitulo(result.getString("titulo"));
    	          video.setCantante(result.getString("cantante"));
    	          video.setLinkVideo(result.getString("link_video"));
        return video;    	          
	}

	@Override
	public void insert(Bean bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Bean bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Bean bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bean> select(Bean bean) throws SQLException {
    	CriterioBean criterio = (CriterioBean) bean;
		List<Bean>   videos;
    	
    	this.connect();
    	
		this.setProcedure("dbo.get_videos(?,?)");
        if(criterio.getNroCategoria() == 0) {
        	this.setNull(1, Types.TINYINT);
        }
        else {
        	this.setParameter(1, Short.valueOf(criterio.getNroCategoria()));
        }
        this.setParameter(2, criterio.getStringBusqueda());
        
        videos = this.executeQuery();
        
        this.disconnect();
        
        return videos;
	}

	@Override
	public boolean valid(Bean bean) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
