package ar.edu.ubp.blog.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.LinkedList;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ar.edu.ubp.blog.beans.TemaBean;
import ar.edu.ubp.blog.beans.MensajeBean;

/**
 * Servlet implementation class BlogServlet
 */
@WebServlet("/index.jsp")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=ISO-8859-1");
        
        try {
        	Cookie autorComentarios[] = request.getCookies();
        	if (autorComentarios != null){
        		
        		for (Cookie c: autorComentarios){
            		if (c.getName().equals("autorComentarioBlog")){
            			request.setAttribute("autorComentarioBlog", c.getValue());
            			break;
            		}
            	}
        	}
        	Connection conn;
            CallableStatement st;
            ResultSet result;
            LinkedList<TemaBean> temas = new LinkedList<TemaBean>(); //vamos a necesitar un arreglo para poner los tres temas
            LinkedList<MensajeBean> mensajes = new LinkedList<MensajeBean>(); //vamos a necesitar un arreglo para poner los tres temas
            //creamos un nuevo objeto del tipo "tema"
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); //crea una instancia de la base
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=pdc", "sa", "36130801"); //hace el logueo en la base
            conn.setAutoCommit(true);
            
            if (request.getParameter("tema_elegido") == null ){
            	st = conn.prepareCall("{CALL dbo.get_temas_blog}"); //hace la llamada al procedimiento
            }
            else {
            	st = conn.prepareCall("{CALL dbo.get_temas_blog(?)}"); //hace la llamada al procedimiento
            	st.setString(1, request.getParameter("tema_elegido"));
            }
            
            st.execute(); //ejecuta el procedimiento
            result = st.getResultSet(); //coloca el resultado arrojado en una variable del tipo "resultado"
            while(result.next()) { //mientras sigan habiendo registros de la tabla que genero el procedimiento:
            	TemaBean tema = new TemaBean();
            	//seteamos en un bean todos los atributos de un TemaBean
            	tema.setNroTema(result.getInt("nro_tema"));
            	tema.setFecha_registro(result.getString("fecha_registro"));
            	tema.setTitulo_tema(result.getString("titulo_tema"));
            	tema.setTitulo_res_tema(result.getString("titulo_res_tema"));
            	tema.setTexto_tema(result.getString("texto_tema"));
            	tema.setWeb_publ_tema(result.getString("web_publ_tema"));
            	//tema.setFecha_ini_vig(result.getString("fecha_ini_vig"));
            	//tema.setFecha_fin_vig(result.getString("fecha_fin_vig"));
            	temas.add(tema); //vamos agregando cada uno de los temas
            }
            
        	st = conn.prepareCall("{CALL dbo.get_mensajes_tema_blog(?)}"); //hace la llamada al procedimiento
        	st.setInt(1, temas.get(0).getNroTema());
            st.execute(); //ejecuta el procedimiento
            result = st.getResultSet(); //coloca el resultado arrojado en una variable del tipo "resultado"
        	
            while(result.next()) { //mientras sigan habiendo registros de la tabla que genero el procedimiento:
            	MensajeBean mensaje = new MensajeBean();
            	//seteamos en un bean todos los atributos de un MensajeBean
            	mensaje.setNro_tema(result.getInt("nro_tema"));
            	mensaje.setNro_mensaje(result.getString("nro_mensaje"));
            	mensaje.setFecha_registro(result.getString("fecha_registro"));
            	mensaje.setAutor(result.getString("autor"));
            	mensaje.setEmailAutor(result.getString("e_mail_autor"));
            	mensaje.setTexto_mensaje(result.getString("texto_mensaje"));
            	mensajes.add(mensaje); //vamos agregando cada uno de los temas
            }
            
            st.close();
            conn.close();
            request.setAttribute("mensajes", mensajes);
            request.setAttribute("temas", temas);
            this.gotoPage("/mostrarBlog.jsp", request, response); //Esto es para redireccionar a un archivo JSP, donde se van a mostrar visualmente los datos recuperados acá 
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            this.printMessage(ex.getMessage(), request, response);
		}
	}

	private void printMessage(String message, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("error", message);
    	this.gotoPage("/error.jsp", request, response);
    }

    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
                          dispatcher.forward(request, response);
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
