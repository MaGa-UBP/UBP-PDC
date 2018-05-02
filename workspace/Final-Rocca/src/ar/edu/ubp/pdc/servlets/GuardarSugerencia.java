package ar.edu.ubp.pdc.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuardarSugerencia
 */
@WebServlet("/guardar.jsp")
public class GuardarSugerencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuardarSugerencia() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String dbConnString = "jdbc:sqlserver://BILBO;databaseName=pdc"; 
			String dbUser = "iroccalada";
			String dbPassword = "37575567";
			Class.forName(dbDriver).newInstance();
			Connection con = DriverManager.getConnection(dbConnString, dbUser, dbPassword);
			con.setAutoCommit( false );
			
			String statement = "execute dbo.ins_sugerencia @cod_tipo_servicio=?, @nro_tema=?, @e_mail=?, @sugerencia=?";		
			
			CallableStatement stmtConsulta = con.prepareCall(statement);
			stmtConsulta.setString( 1 , request.getParameter("cod_tipo_servicio") );
			stmtConsulta.setString( 2 , request.getParameter("nro_tema") );
			stmtConsulta.setString( 3 , request.getParameter("e_mail") );
			stmtConsulta.setString( 4 , request.getParameter("sugerencia") );
			
			stmtConsulta.execute();		
			con.commit();

			stmtConsulta.close();
			con.setAutoCommit( true );
			
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
	        ex.printStackTrace();
		}
	}
}
