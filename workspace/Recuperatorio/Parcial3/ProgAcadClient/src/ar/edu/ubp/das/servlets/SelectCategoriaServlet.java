package ar.edu.ubp.das.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.das.ws.CategoriasWSService;
import ar.edu.ubp.das.ws.Exception_Exception;
import ar.edu.ubp.das.ws.ICategorias;

/**
 * Servlet implementation class SelectCategoria
 */
@WebServlet("/index.jsp")
public class SelectCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCategoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
        
		CategoriasWSService service   = new CategoriasWSService();
		ICategorias         categorias = service.getCategoriasWSPort();
		
		try {
			request.setAttribute("categorias", categorias.getCategorias());
			this.gotoPage("/select-categoria.jsp", request, response);
		} catch (Exception_Exception e) {
        	response.setStatus(400);
        	printMessage(response, e.toString());
		}
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

