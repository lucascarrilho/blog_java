package blog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import dao.ArticleDao;

@SuppressWarnings("serial")
public class NewArticle extends JPanel {
	
	public NewArticle(Fenetre fenetre) {
		super();
		this.setLayout(null);
		
		JLabel titre_label = new JLabel("Titre");
		titre_label.setBounds(380, 20, 100, 20);
		this.add(titre_label);
		
		JTextPane titre = new JTextPane();
		titre.setBounds(300, 50, 200, 20);
		this.add(titre);
		
		JLabel contenu_label = new JLabel("Contenu");
		contenu_label.setBounds(370, 100, 100, 20);
		this.add(contenu_label);
		
		JTextPane contenu = new JTextPane();
		contenu.setBounds(200, 130, 400, 300);
		this.add(contenu);
		
		JButton creer = new JButton("Creer");
		creer.setBounds(350, 450, 100, 30);
		this.add(creer);
		
		creer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean need_return = false;
				
				if(StringUtils.empty(titre.getText())) {
					titre.setBackground(Color.RED);
					need_return = true;
				} else {
					titre.setBackground(Color.WHITE);
				}
				
				if(StringUtils.empty(contenu.getText())) {
					contenu.setBackground(Color.RED);
					need_return = true;
				} else {
					contenu.setBackground(Color.WHITE);
				}
				
				if(need_return) return;
				
				final int min = Math.min(contenu.getText().length(), 100);
				final String resume = contenu.getText().substring(0, min) + "...";
				
				ArticleDao.createArticle(titre.getText(), resume, contenu.getText(), Accueil.session.getId());
				
				JOptionPane.showMessageDialog(null, "Article créé avec succès");
				
				fenetre.changeState(Fenetre.STATE.ACCUEIL);
			}
		});
		
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
