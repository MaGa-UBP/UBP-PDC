package ar.edu.ubp.das.fds.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.das.fds.cxf.Exception_Exception;
import ar.edu.ubp.das.fds.cxf.ListaObrasSocialesCXF;
import ar.edu.ubp.das.fds.cxf.ListaObrasSocialesCXFService;


/**
 * Servlet implementation class ListaObrasSocialesServlet
 */
@WebServlet("/ListaObrasSocialesServlet.jsp")
public class ListaObrasSocialesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaObrasSocialesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.gotoPage("/listaobrassociales.jsp", request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListaObrasSocialesCXFService service   = new ListaObrasSocialesCXFService();
		ListaObrasSocialesCXF        listaObrasSocialesCXF = service.getListaObrasSocialesCXFPort();
		try {
			request.setAttribute("lista", listaObrasSocialesCXF.getObrasSociales());
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.gotoPage("/listaobrassociales.jsp", request, response);
	}
	private void printMessage(HttpServletResponse response, String message) throws IOException {
        PrintWriter out = response.getWriter();
        out.println(message);
        out.close();
    }

    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
        catch (ServletException ex) {
            this.printMessage(response, ex.getMessage());
        }
    }


}
