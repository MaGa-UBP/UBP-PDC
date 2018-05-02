package ar.edu.ubp.pdc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.pdc.bean.CategoriaVideosBean;
import ar.edu.ubp.pdc.bean.VideoBean;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/buscar.jsp")
public class VideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideosServlet() {
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
        	Connection conn;
            PreparedStatement st;
            ResultSet result;
            Short nroCategoria;
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");            
            conn.setAutoCommit(true);

        	try {
        		LinkedList<CategoriaVideosBean> categorias = new LinkedList<CategoriaVideosBean>();
	        	LinkedList<VideoBean> videos;
	        	CategoriaVideosBean categoria;
	        	VideoBean video;
	
	            st = conn.prepareStatement("select c.nom_categoria, " +
	                                              "v.nro_categoria, " +
	                                              "v.titulo, " +
	                                              "v.cantante, " +
	                                              "v.link_video, " +
	                                              "v.nro_video " +
	                                        "from dbo.videos v (nolock) " +
	                                             "join dbo.categorias_videos c (nolock) " +
	                                               "on v.nro_categoria = c.nro_categoria " +
	                                       "where (? is null " +
	                                          "or  v.nro_categoria = ?) " +
	                                         "and  v.titulo + ' ' + v.cantante + ' ' + v.titulo like '%' + isnull(ltrim(rtrim(?)), '') + '%' " +
	                                       "order by c.nom_categoria, " +
	                                                "v.titulo;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	
                if(request.getParameter("nro_categoria").isEmpty()) {
                	st.setNull(1, Types.TINYINT);
                	st.setNull(2, Types.TINYINT);
                }
                else {
                	st.setShort(1, Short.valueOf(request.getParameter("nro_categoria")));
                	st.setShort(2, Short.valueOf(request.getParameter("nro_categoria")));
                }
                st.setString(3, request.getParameter("string_busqueda"));
	
	            result = st.executeQuery();
	        	result.next();
	            while(result.getRow() > 0) {
	            	categoria = new CategoriaVideosBean();
	            	categoria.setNroCategoria(result.getShort("nro_categoria"));
	            	categoria.setNomCategoria(result.getString("nom_categoria"));
	
	            	videos = new LinkedList<VideoBean>();
	
	            	nroCategoria = result.getShort("nro_categoria");
	            	while(result.getRow() > 0 && nroCategoria == result.getShort("nro_categoria")) {
	                	video = new VideoBean();
	                	video.setNroVideo(result.getInt("nro_video"));
	                	video.setTitulo(result.getString("titulo"));
	                	video.setCantante(result.getString("cantante"));
	                	video.setLinkVideo(result.getString("link_video"));
	                	videos.add(video);
	            		result.next();
	                }
	                categoria.setVideos(videos);
	                categorias.add(categoria);
	            }
	            st.close();
 
	            request.setAttribute("categorias", categorias);
	            this.gotoPage("/listado.jsp", request, response);
        	}
    		catch(SQLException ex) {
                out.println(ex.getMessage());
    		}
    		finally {
    			conn.close();
    		}
        }
        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
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
