package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuardarTemp
 */
@WebServlet("/guarTemp.jsp")
public class GuardarTemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarTemp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		String [] descTema = request.getParameterValues("inputDescTema");
		String [] nroGrupo = request.getParameterValues("listGroup");
		String [] checked = request.getParameterValues("checkVigente");
		
		for(int i = 0; i < descTema.length; i++){
			session.setAttribute("inputDescTema-"+ i , descTema[i]);
		}
		
		for(int i = 0; i < nroGrupo.length; i++){
			session.setAttribute("listGroup-"+ i , nroGrupo[i]);
		}
		
		for(int i = 0; i < checked.length; i++){
			session.setAttribute("checked-"+ i , checked[i]);
		}
		
		
	}

}
