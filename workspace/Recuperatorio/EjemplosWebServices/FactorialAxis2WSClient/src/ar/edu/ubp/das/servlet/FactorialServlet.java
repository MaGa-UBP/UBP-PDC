package ar.edu.ubp.das.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.das.ws.FactorialWSStub;
import ar.edu.ubp.das.ws.FactorialWSStub.GetFactorial;
import ar.edu.ubp.das.ws.FactorialWSStub.GetFactorialResponse;

/**
 * Servlet implementation class FactorialServlet
 */
@WebServlet("/factorial.jsp")
public class FactorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FactorialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
    		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		FactorialWSStub      stub = new FactorialWSStub();
		GetFactorial         req  = new GetFactorial();
		                     req.setNro(Integer.valueOf(request.getParameter("nro")));
		GetFactorialResponse resp = stub.getFactorial(req);
		             
		request.setAttribute("factorial", resp.get_return());
        this.gotoPage("/factorial-result.jsp", request, response);
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
