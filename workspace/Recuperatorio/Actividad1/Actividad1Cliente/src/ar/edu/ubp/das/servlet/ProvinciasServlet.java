package ar.edu.ubp.das.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ar.edu.ubp.das.bean.ProvinciaBean;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/provincias.jsp")
public class ProvinciasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinciasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
                                 nvps.add(new BasicNameValuePair("cod_pais",   request.getParameter("cod_pais")));

			URI uri = URI.create("http://localhost:8080/Actividad1Rest/rest/provincias/getProvincias");            
			            
			HttpPost req = new HttpPost();
			         req.setURI(uri);
		 	         req.setEntity(new UrlEncodedFormEntity(nvps));
			            
			HttpClient client = HttpClientBuilder.create().build();
			       
			HttpResponse resp = client.execute(req);
			
			HttpEntity responseEntity = resp.getEntity();
			StatusLine responseStatus = resp.getStatusLine();
			
			String restResp = EntityUtils.toString(responseEntity);	
			
			if(responseStatus.getStatusCode() != 200) {
				throw new RuntimeException(restResp);
			}
			
			Gson gson = new Gson();
			
			LinkedList<ProvinciaBean> provincias = gson.fromJson(restResp, new TypeToken<LinkedList<ProvinciaBean>>(){}.getType());
			
			out.println("<select name=\"cod_provincia\">");
            out.println("<option value=\"\">Debe seleccionar una provincia</option>");
            
            for (int i = 0; i < provincias.size(); i++)
                out.println("<option value=\"" + provincias.get(i).getCodProvincia() + "\">" + provincias.get(i).getNomProvincia() + "</option>");
            		
            out.println("</select>");
        }
        catch(RuntimeException ex) {
        	response.setStatus(400);
        	out.println(ex.getMessage());
        }
        finally {
        	out.close();
        }
	}

    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
                          dispatcher.forward(request, response);
    }
}
