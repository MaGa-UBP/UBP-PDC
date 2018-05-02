package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.ubp.pdc.beans.TicketsBean;

/**
 * Servlet implementation class BusquedaTicketsServlet
 */
//@WebServlet("/index.jsp")
@WebServlet("/tablaTickets.jsp")
public class BusquedaTicketsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaTicketsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=iso-8859-1");
		Connection conn;
		PreparedStatement stmt;//para con parametros, para procedimiento almacenado se usa otro
		ResultSet result;

		LinkedList<TicketsBean> tickets = new LinkedList<TicketsBean>();
		TicketsBean tkt;
		
		String ordenarSel = (request.getParameter("ordenar") == null ? "" : request.getParameter("ordenar"));

		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			
			//remplazar arrobas con signos de pregunta
			stmt = conn.prepareStatement("select ticket        = convert(varchar(4), t.año_ticket) + '-' + replicate('0', 5 - len(convert(varchar(5), t.nro_ticket))) + convert(varchar(5), t.nro_ticket), " +
       "fecha_ticket  = convert(varchar(10), t.fecha_ticket, 103) + ' ' + convert(varchar(5), t.fecha_ticket, 108), " + 
	   "solicitante   = s.nom_solicitante, " +
	   "asunto_ticket = t.asunto_ticket, " +
	   "texto_ticket  = t.texto_ticket " +
  "from dbo.tickets t (nolock) " +
       "join dbo.solicitantes s (nolock) " +
	     "on t.nro_solicitante = s.nro_solicitante " +
 "where (t.asunto_ticket   like '%' + isnull(ltrim(rtrim(?)), '') + '%' " +
    "or  t.texto_ticket    like '%' + isnull(ltrim(rtrim(?)), '') + '%' " +
  	"or  s.nom_solicitante like '%' + isnull(ltrim(rtrim(?)), '') + '%') " +
 "order by case ? " +
               "when 'F' " +
			   "then convert(varchar(10), t.fecha_ticket, 112) + ' ' + convert(varchar(5), t.fecha_ticket, 108) " +
			   "when 'S' " +
			   "then s.nom_solicitante " +
			   "when 'T' " +
			   "then convert(varchar(4), t.año_ticket) + '-' + replicate('0', 5 - len(convert(varchar(5), t.nro_ticket))) + convert(varchar(5), t.nro_ticket) " +
		 "end");
			
			//setear strings
			//ver que pasa cuando los parametros pueden ser nulos
			/*if(request.getParameter("tipo_persona")==null){
			 * stmt.setNull(1, Types.CHAR);
			 * stmt.setNull(2,Types.CHAR);
			 * }
			 * en el caso de un procedimiento almacenado
			 * execute dbo.del_tipo_documento@dbo.documento="dni"
			 * Callable Statement stmt;
			 * ("{CALL dbo.del_tipo_documento(?)}");
			 * si el parametro permite null
			 * hacer un if e utilizar el metodo setNull
			 * si es una grabacion en l bd usar transacciones (ROLLBACK)
			 * VER COMO SE MANEJAN LAS VARIABLES OUTPUT(que en la logica del procedimiento almacenado toma un valor) usar Callable statement
			 * hay q setear la variable output y cuando ejecutamos el procedimiento trabajar con la posicion
			 *
			 * 
			 * 
			 */
			stmt.setString(1, request.getParameter("busqueda"));
			stmt.setString(2, request.getParameter("busqueda"));
			stmt.setString(3, request.getParameter("busqueda"));
			stmt.setString(4, request.getParameter("ordenar"));
			
			result = stmt.getResultSet();
			while(result.next()) {
				tkt = new TicketsBean();
				tkt.setAño_ticket(result.getInt("año_ticket"));
				tkt.setNro_ticket(result.getString("nro_ticket"));
				tkt.setFecha_ticket(result.getString("fecha_ticket"));
				tkt.setAsunto_ticket(result.getString("asunto_ticket"));
				tkt.setTexto_ticket(result.getString("texto_ticket"));
				tkt.setSolicitante(result.getString("nro_solicitante"));
				tickets.add(tkt);
			}
			
			stmt.close();
			conn.close();
			
			request.setAttribute("tickets", tickets);
			this.gotoPage("/tablaTicketsLista.jsp", request, response);
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
