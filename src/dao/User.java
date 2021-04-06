package dao;

public class User {
	
	private String prenom;
	private String nom;
	private String email;
	private int id;
	
	public User() {
		super();
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getId() {
		return this.id;
	}

}
