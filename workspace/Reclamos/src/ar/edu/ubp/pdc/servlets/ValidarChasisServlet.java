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

//import ar.edu.ubp.pdc.beans.TipoDocumentoBean;

/**
 * Servlet implementation class ValidarChasisServlet
 */
@WebServlet("/ValidarChasis.jsp")
public class ValidarChasisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarChasisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=iso-8859-1");
		Connection conn;
		//Statement stmt;
		CallableStatement cstmt;
		//ResultSet result;
		
		String chasis;
		
		//LinkedList<TipoDocumentoBean> tiposDoc = new LinkedList<TipoDocumentoBean>();
		//TipoDocumentoBean td;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=pdc", "sa", "36130801");
			conn.setAutoCommit(true);
			
			//para verificar solo el chasis
			cstmt = conn.prepareCall("{call dbo.val_vehiculo (?,?,?)}"); 
            cstmt.setString(1, request.getParameter("chasis"));  
            cstmt.setString(2, ""); 
            cstmt.registerOutParameter(3, java.sql.Types.VARCHAR); 
            cstmt.execute();  
            //System.out.println("existe: " + cstmt.getString(3)); 
            chasis=cstmt.getString(3);
            //System.out.println("existe chasis: " + chasis);
            
			cstmt.close();
			conn.close();
			
			if(chasis.equals("S")){
				this.gotoPage("/chasisVerificado.jsp", request, response);
			}
			else if (chasis.equals("N")){
				this.gotoPage("/chasisNoVerificado.jsp", request, response);	
			}
			//para verificar la patente------------------------------------------------------------

			/*			
			dbConnection = getDBConnection();
			callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);

			callableStatement.setInt(1, 10);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(4, java.sql.Types.DATE);

			// execute getDBUSERByUserId store procedure
			callableStatement.executeUpdate();

			String userName = callableStatement.getString(2);
			String createdBy = callableStatement.getString(3);
			Date createdDate = callableStatement.getDate(4);

			System.out.println("UserName : " + userName);
			System.out.println("CreatedBy : " + createdBy);
			System.out.println("CreatedDate : " + createdDate);*/
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
