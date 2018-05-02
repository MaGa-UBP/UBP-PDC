package oniet;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {
	public static Connection connection = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	try {
		connection=DBConnection.getConnection("jdbc:mysql://localhost/oniet", "root", "root");
		
		usuario u=ABM.getPunto3(connection,"MOCKED_USER_403945577" );
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	}

	
	
}
