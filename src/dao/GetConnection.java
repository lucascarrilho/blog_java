package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public static Connection getConnection() {
		Connection connect = null;
		
		String url ="jdbc:mysql://localhost/";
		String database = "blog";
		String user ="root";
		String password ="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url+database,user,password);
		}catch(Exception e) {
			System.out.println("Connection KO");
			e.printStackTrace();
		}

		return connect;
	}
}
