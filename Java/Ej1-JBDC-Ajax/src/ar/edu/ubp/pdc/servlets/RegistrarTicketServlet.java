package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrarTicketServlet
 */
@WebServlet("/registrarTicket.jsp")
public class RegistrarTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		CallableStatement stmt;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "P@55w0rd");
            conn.setAutoCommit(false);
            
            try {
            	stmt = conn.prepareCall("{CALL dbo.ins_ticket(?, ?, ?, ?)}");
            	
            	stmt.setString(1, request.getParameter("asunto_ticket"));
            	stmt.setString(2, request.getParameter("texto_ticket"));
            	stmt.setString(3, request.getParameter("solicitante"));
            	stmt.setString(4, request.getParameter("email_solicitante"));
            	
            	stmt.execute();
            	
            	
            	Cookie c1 = new Cookie("solicitante", request.getParameter("solicitante"));
            	Cookie c2 = new Cookie("email_solicitante", request.getParameter("email_solicitante"));
            	response.addCookie(c1);
            	response.addCookie(c2);
            	
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}finally {
				conn.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			response.setStatus(400);
			request.setAttribute("error", e.getMessage());
			gotoPage("/error.jsp", request, response);
		}
		
	}
	private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
		                  dispatcher.forward(request, response);
	}

}
