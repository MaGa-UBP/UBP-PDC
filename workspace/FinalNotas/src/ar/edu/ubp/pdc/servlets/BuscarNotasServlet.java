package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.pdc.beans.NotaBean;

/**
 * Servlet implementation class BuscarNotasServlet
 */
@WebServlet("/BuscarNotas.jsp")
public class BuscarNotasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarNotasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn;
		Statement stmt;
		ResultSet result;
		
		LinkedList<NotaBean> notas = new LinkedList<NotaBean>();
		NotaBean n;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			
			stmt = conn.createStatement();
			stmt.executeQuery("select * from dbo.notas");
			/*stmt.executeQuery("select fecha_nota_str = convert(varchar(10), fecha_nota, 103) + ' ' + convert(varchar(10), fecha_nota, 108),"
				      + "texto_nota     = texto_nota,"
				      +" año_nota       = año_nota,"
					   +"nro_nota       = nro_nota"
				  +"from dbo.notas (nolock)"
				 +"order by fecha_nota desc");*/
			
			result = stmt.getResultSet();
			while(result.next()) {
				n = new NotaBean();
				n.setAnoNota(result.getInt("año_nota"));
				n.setFechaNota(result.getString("fecha_nota"));
				n.setRnoNota(result.getInt("nro_nota"));
				n.setTextoNota(result.getString("texto_nota"));

				notas.add(n);
			}
			
			stmt.close();
			conn.close();
			
			request.setAttribute("notas", notas);
			this.gotoPage("/listado_notas.jsp", request, response);
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			this.printError(e.getMessage(), request, response);
		}
	}

	private void printError(String error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("error", error);
		this.gotoPage("/error.jsp", request, response);
	}

	private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
		                  dispatcher.forward(request, response);
	}
}
