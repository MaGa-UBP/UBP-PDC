package ar.edu.ubp.das.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.das.ws.Exception_Exception;
import ar.edu.ubp.das.ws.PaisBean;
import ar.edu.ubp.das.ws.PaisesWS;
import ar.edu.ubp.das.ws.PaisesWSService;

@WebServlet("/paises.jsp")
public class PaisesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaisesServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		try
		{
			PaisesWSService service   = new PaisesWSService();
			PaisesWS       paisesWs = service.getPaisesWSPort();
			
			LinkedList<PaisBean> paises = null;
			try 
			{
				paises = paisesWs.getPaises();
				
				out.println("<select name=\"cod_pais\" onchange=\"jPaises.getProvincias()\">");
		        out.println("<option value=\"\">Debe seleccionar un pa&iacute;s</option>");
		        
		        for (int i = 0; i < paises.size(); i++)
		            out.println("<option value=\"" + paises.get(i).getCodPais() + "\">" + paises.get(i).getNomPais() + "</option>");
		        
		        out.println("</select>");
			} 
			catch (Exception_Exception e) 
			{
				response.setStatus(400);
				System.out.println(e.toString());
			}
		}
		finally {            
            out.close();
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
