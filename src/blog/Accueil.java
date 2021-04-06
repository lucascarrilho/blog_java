package blog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.Article;
import dao.ArticleDao;
import dao.User;

@SuppressWarnings("serial")
public class Accueil extends JPanel {
	
	public static User session;
	private ArrayList<Article> articles;
	
	public Accueil(Fenetre fenetre) {
		super();
		this.setLayout(null);
		
		JLabel bonjour = new JLabel("Bonjour " + session.getPrenom() + " id=" + session.getId());
		bonjour.setBounds(10,10,200,20);
		bonjour.setForeground(Color.YELLOW);
		this.add(bonjour);
		
		JButton creer = new JButton("Créer un article");
		creer.setBounds(560, 100, 200, 30);
		this.add(creer);
		
		creer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.changeState(Fenetre.STATE.CREER_ARTICLE);
			}
		});
		
		this.articles = ArticleDao.getArticles();
		
		if(articles.size() == 0) {
			JLabel no_article = new JLabel("Il n'y a d'article");
			no_article.setBounds(10, 100, 100, 20);
			no_article.setForeground(Color.RED);
			this.add(no_article);
		} else {
			for(int i = 0; i < articles.size(); i++) {
				Article a = articles.get(i);
				
				JLabel titre = new JLabel(a.getTitre());
				titre.setBounds(350, 100 + i * 100, 100, 20);
				titre.setForeground(Color.YELLOW);
				this.add(titre);
				
				JLabel resume = new JLabel(a.getResume());
				resume.setBounds(350, 120 + i * 100, 100, 20);
				this.add(resume);
				
				JButton lire = new JButton("Lire");
				lire.setBounds(300, 140 + i * 100, 100, 20);
				this.add(lire);
				
				lire.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						ReadArticle.article = a;
						fenetre.changeState(Fenetre.STATE.LIRE_ARTICLE);
					}
					
				});
				
				JButton supprimer = new JButton("Supprimer");
				supprimer.setBounds(400, 140 + i * 100, 100, 20);
				this.add(supprimer);
				
				supprimer.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						final int confirm = JOptionPane.showConfirmDialog(null, "Voulez-vous raiment supprimer ?");
						
						if(confirm == 0) {
							ArticleDao.deleteArticle(a.getId());
							fenetre.changeState(Fenetre.STATE.ACCUEIL);
						}
					}
				});
			}
		}
		
		JButton deconnection = new JButton("Se déconnecter");
		deconnection.setBounds(600, 10, 150, 30);
		this.add(deconnection);
		
		deconnection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.changeState(Fenetre.STATE.CONNECTION);
			}
		});
	}
}
