package ar.edu.ubp.das.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.LinkedList;

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
import com.google.gson.reflect.TypeToken;

import ar.edu.ubp.das.beans.FeriadoBean;

@WebServlet("/feriados.jsp")
public class FeriadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeriadosServlet() {
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
        	System.out.println(request.getParameter("ano"));
			URI uri = URI.create("http://localhost:8080/Actividad3Rest/rest/feriados/getFeriados/" + request.getParameter("ano"));            
			    
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
			
			LinkedList<FeriadoBean> feriados = gson.fromJson(restResp, new TypeToken<LinkedList<FeriadoBean>>(){}.getType());
			
			out.println("<tr>");
				out.println("<th align=\"center\">Feriado</th>");
				out.println("<td align=\"center\">Descripcion</td>");
			out.println("</tr>");
			for (int i = 0; i < feriados.size(); i++)
			{
				out.println("<tr id=\"'+i+'\">");
					out.println("<th align=\"right\">" + feriados.get(i).getFeriado() + "</th>");
					out.println("<td>" + feriados.get(i).getDescripcion() + "</td>");
				out.println("</tr>");
			}
			
			response.setStatus(200);
            
        }
        catch(RuntimeException ex) {
        	response.setStatus(400);
        	out.println(ex.getMessage());
        }
        finally {
        	out.close();
        }
	}
}