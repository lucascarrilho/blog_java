package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArticleDao {
	
	private static Connection connect = GetConnection.getConnection();
	
	public static void createArticle(String titre, String resume, String contenu, int user) {
		try {
			PreparedStatement req = connect.prepareStatement(
					"INSERT INTO article (titre,resume,contenu,created_at,auteur) VALUES (?,?,?,?,?)");

			req.setString(1, titre);
			req.setString(2, resume);
			req.setString(3, contenu);
			req.setDate(4, new Date(0));
			req.setInt(5, user);

			req.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteArticle(int id) {
		try {
			PreparedStatement req = connect.prepareStatement(
					"DELETE FROM article WHERE id=?");

			req.setInt(1, id);
			req.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static ArrayList<Article> getArticles() {
		ArrayList<Article> liste = new ArrayList<Article>();
		
		try {
			
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Article article = new Article();
				
				article.setId(rs.getInt("id"));
				article.setTitre(rs.getString("titre"));
				article.setResume(rs.getString("resume"));
				article.setContenu(rs.getString("contenu"));
				article.setDate(rs.getString("created_at"));
				article.setAuteur(rs.getInt("auteur"));
				
				liste.add(article);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return liste;
	}
}
