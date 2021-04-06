package blog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.Article;

@SuppressWarnings("serial")
public class ReadArticle extends JPanel {
	
	public static Article article;
	
	public ReadArticle(Fenetre fenetre) {
		super();
		this.setLayout(null);
		
		JLabel titre_label = new JLabel(article.getTitre());
		titre_label.setBounds(400, 50, 200, 20);
		titre_label.setForeground(Color.YELLOW);
		this.add(titre_label);
		
		JLabel contenu_label = new JLabel(article.getContenu());
		contenu_label.setBounds(100, 100, 200, 200);
		this.add(contenu_label);
		
		JButton retour = new JButton("Retour");
		retour.setBounds(650, 10, 100, 30);
		this.add(retour);
		
		retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.changeState(Fenetre.STATE.ACCUEIL);
			}
			
		});
		
	}
}
