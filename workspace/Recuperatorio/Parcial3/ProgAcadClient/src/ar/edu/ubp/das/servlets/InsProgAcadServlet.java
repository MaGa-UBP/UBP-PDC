package ar.edu.ubp.das.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * Servlet implementation class SelectCategoria
 */
@WebServlet("/ins-prog-acad.jsp")
public class InsProgAcadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsProgAcadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("cod_categoria",   request.getParameter("cod_categoria")));
        nvps.add(new BasicNameValuePair("desc_categoria", request.getParameter("desc_categoria")));
        
		URI uri = URI.create("http://localhost:8080/ProgAcadRestful/rest/progacad");            
        
		HttpPost req = new HttpPost();
		         req.setURI(uri);
	 	         req.setEntity(new UrlEncodedFormEntity(nvps));
		            
		HttpClient client = HttpClientBuilder.create().build();
		       
		HttpResponse resp = client.execute(req);
		
		HttpEntity responseEntity = resp.getEntity();
		StatusLine responseStatus = resp.getStatusLine();
		
		if(responseStatus.getStatusCode() != 200) {
			String restResp = EntityUtils.toString(responseEntity);	
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		/*
		Gson gson = new Gson();
		LinkedList<CategoriaVideosBean> categorias = gson.fromJson(restResp, new TypeToken<LinkedList<CategoriaVideosBean>>(){}.getType());
		*/
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

