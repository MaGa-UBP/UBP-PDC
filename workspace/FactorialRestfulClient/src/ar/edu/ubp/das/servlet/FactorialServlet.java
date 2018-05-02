package ar.edu.ubp.das.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");

        URI uri = URI.create("http://localhost:8080/FactorialRestful/rest/factorial/" + request.getParameter("nro"));            
        
		HttpRequestBase req = new HttpPost();
                        req.setURI(uri);
    	
		HttpClient client = HttpClientBuilder.create().build();
    		            
        HttpResponse resp = client.execute(req);
        
        HttpEntity responseEntity = resp.getEntity();
        StatusLine responseStatus = resp.getStatusLine();

        String restResp = EntityUtils.toString(responseEntity);	

        if(responseStatus.getStatusCode() != 200) {
        	throw new RuntimeException(restResp);
        }
        
		Gson gson = new Gson();
		long[] nros = gson.fromJson(restResp, long[].class);

		request.setAttribute("factorial", nros);
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
