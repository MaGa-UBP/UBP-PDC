package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuardarFechaServlet
 */
@WebServlet("/GuardarFecha.jsp")
public class GuardarFechaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarFechaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		CallableStatement stmt;
		//---------------------------------------------------------------
		//LinkedList<String> ultimaSel = new LinkedList<String>();
		/*for(int i=0;i<12;i++){
			String name = String.valueOf(i);
			seleccionadas.add(request.getParameter("seleccionadas"));
			//out.println(seleccionados.get(i));
		}*/
		
		//--------------------------------------------------------------
		HttpSession session = request.getSession(true);
		//String idSesion = session.getId();
		 //Integer[] ius = null;
		if (request.getParameterMap().size()>0&&request.getParameterValues("seleccionadas")!=null){
		 String [] us = request.getParameterValues("seleccionadas");
		 session.setAttribute("ultimaSel", us);}
	
		 
       
		//String [] preferenciaRegistrada = request.getParameter("preferenciaRegistrada").split("-");
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(false);
			
			try
			{
				stmt = conn.prepareCall("{CALL dbo.ins_datos_fecha_examen_it(?, ?, ?, ?, ?)}");
				
				stmt.setInt(1, Integer.parseInt(request.getParameter("carreras")));
				stmt.setInt(2, Integer.parseInt(request.getParameter("seleccionadas")));
				stmt.setString(3, request.getParameter("fechas1").equals("") ? "" : request.getParameter("fechas1"));
				stmt.setString(4, request.getParameter("fechas1").equals("") ? "" : request.getParameter("fechas2"));
				stmt.setString(5, request.getParameter("fecha").equals("") ? "" : request.getParameter("fecha"));
				
				stmt.executeUpdate();
				conn.commit();
				stmt.close();
			}
			catch (SQLException e) {
				conn.rollback();
				this.printError(e.getMessage(), request, response);
			}
			finally
			{
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			this.printError(e.getMessage(), request, response);
		}
		/*
		Cookie cookie = null;
		if(request.getParameter("email") != null && request.getParameter("email") != ""){
			cookie = new Cookie("mail",request.getParameter("email"));
		}
		if(request.getParameter("identifica")!=null&&request.getParameter("identifica").equals("No")){
			cookie = new Cookie("mail", "");
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);*/
	}
	
	private void printError(String error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setStatus(400);
		request.setAttribute("error", error);
		this.gotoPage("/error.jsp", request, response);
	}

	private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
		                  dispatcher.forward(request, response);
	}
}