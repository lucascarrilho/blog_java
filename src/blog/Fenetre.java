package blog;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {
	
	public static enum STATE {
		CONNECTION,
		INSCRIPTION,
		ACCUEIL,
		CREER_ARTICLE,
		LIRE_ARTICLE
	}

	public Fenetre() {
		super();
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		changeState(STATE.CONNECTION);
	}
	
	public void changeState(STATE state) {
		if(state == STATE.CONNECTION) {
			setContentPane(new Connection(this));
		} else if(state == STATE.INSCRIPTION) {
			setContentPane(new Inscription(this));
		} else if(state == STATE.ACCUEIL) {
			setContentPane(new Accueil(this));
		} else if(state == STATE.CREER_ARTICLE) {
			setContentPane(new NewArticle(this));
		} else if(state == STATE.LIRE_ARTICLE) {
			setContentPane(new ReadArticle(this));
		}
		
		this.getContentPane().setBackground(Color.CYAN);
		this.revalidate();
	}
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new Fenetre();
			}
		});
	}
}
