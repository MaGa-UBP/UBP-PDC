package ar.edu.ubp.das.src.videos.actions;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.das.mvc.action.Action;
import ar.edu.ubp.das.mvc.action.ActionMapping;
import ar.edu.ubp.das.mvc.action.DynaActionForm;
import ar.edu.ubp.das.mvc.config.ForwardConfig;

public class VerAction implements Action {

	@Override
	public ForwardConfig execute(ActionMapping mapping, DynaActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, RuntimeException {
        response.setContentType("text/html;charset=ISO-8859-1");
        response.addCookie(new Cookie("V" + request.getParameter("nroVideo"), request.getParameter("nroVideo")));
		return mapping.getForwardByName("success");
	}

}
