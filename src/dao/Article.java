package dao;

public class Article {
	
	private int id;
	private String titre;
	private String resume;
	private String contenu;
	private String date;
	private int auteur;

	public Article() {
		super();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setAuteur(int auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return this.titre;
	}
	
	public String getResume() {
		return this.resume;
	}
	
	public String getContenu() {
		return this.contenu;
	}
	
	public int getId() {
		return this.id;
	}
}
