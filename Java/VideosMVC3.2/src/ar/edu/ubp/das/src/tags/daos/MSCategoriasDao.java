package ar.edu.ubp.das.src.tags.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.db.DaoImpl;

public class MSCategoriasDao extends DaoImpl {

	@Override
	public DynaActionForm make(ResultSet result) throws SQLException {
		DynaActionForm form = new DynaActionForm();
		               form.setItem("nom_categoria", result.getString("nom_categoria"));
		               form.setItem("nro_categoria", String.valueOf(result.getInt("nro_categoria")));
		return form;
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
		List<DynaActionForm> list;
		
		this.connect();
		
		this.setProcedure("dbo.get_categorias_videos_x_idioma(?)");
		this.setParameter(1, form.getItem("lang"));
		
		list = this.executeQuery();
		
		this.disconnect();
		
		return list;
	}

	@Override
	public boolean valid(DynaActionForm form) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
