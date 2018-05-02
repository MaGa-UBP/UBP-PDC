package ar.edu.ubp.das.fds.servlet;

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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;



/**
 * Servlet implementation class AfiliadosServlet
 */
@WebServlet("/AfiliadosServlet.jsp")
public class AfiliadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfiliadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=ISO-8859-1");
		URI uri = URI.create("http://localhost:8080/RecuperatorioRestServer/rest/afiliados/getAfiliados/" + request.getParameter("obra_social"));            
        
		HttpRequestBase req = new HttpGet();
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
		AfiliadoBean[] afiliados = gson.fromJson(restResp, AfiliadoBean[].class);
		request.setAttribute("afiliados", afiliados);
        this.gotoPage("/afiliados-result.jsp", request, response);
		
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
