package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

	private static Connection connect = GetConnection.getConnection();
	
	public static boolean emailExists(String email) {
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE email=?");
			req.setString(1, email);
			
			ResultSet rs = req.executeQuery();
			return rs.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static void createUser(String nom, String prenom, String email, String password) {
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO user (nom,prenom,email, password) VALUES (?,?,?,?)");
			
			req.setString(1, nom);
			req.setString(2, prenom);
			req.setString(3, email);
			req.setString(4, password);

			req.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	public static boolean passwordMatch(String email, String password) {
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE email=? AND password=?");
			
			req.setString(1, email);
			req.setString(2, password);
			
			ResultSet rs = req.executeQuery();
			return rs.next();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static User getUser(String email) {
		User user = new User();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE email=?");
			
			req.setString(1, email);
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				user.setPrenom(rs.getString("prenom"));
				user.setNom(rs.getString("nom"));
				user.setEmail(email);
				user.setId(rs.getInt("id"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
