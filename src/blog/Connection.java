package blog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

import dao.UserDao;

@SuppressWarnings("serial")
public class Connection extends JPanel {
	
	public Connection(Fenetre fenetre) {
		super();
		this.setLayout(null);
		
		JLabel label_email = new JLabel("Adresse email");
		label_email.setBounds(200, 100, 200, 20);
		this.add(label_email);
		
		JTextPane email = new JTextPane();
		email.setBounds(300, 100, 200, 20);
		this.add(email);
		
		JLabel label_pass = new JLabel("Mot de passe");
		label_pass.setBounds(200, 150, 200, 20);
		this.add(label_pass);
		
		JPasswordField pass = new JPasswordField();
		pass.setBounds(300, 150, 200, 20);
		this.add(pass);
		
		JButton connexion = new JButton("Se connecter");
		connexion.setBounds(320, 250, 150, 30);
		this.add(connexion);
		
		connexion.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean need_return = false;
				
				if(StringUtils.empty(email.getText())) {
					email.setBackground(Color.RED);
					need_return = true;
				} else {
					email.setBackground(Color.WHITE);
				}
				
				if(StringUtils.empty(pass.getText())) {
					pass.setBackground(Color.RED);
					need_return = true;
				} else {
					pass.setBackground(Color.WHITE);
				}
				
				if(need_return) return;
				
				if(!UserDao.emailExists(email.getText())) {
					JOptionPane.showMessageDialog(null, "Cet email n'est pas utilisé");
					return;
				} else if(!UserDao.passwordMatch(email.getText(), pass.getText())) {
					JOptionPane.showMessageDialog(null, "Mauvais mot de passe");
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Connecté avec succès !");
				
				Accueil.session = UserDao.getUser(email.getText());
				
				fenetre.changeState(Fenetre.STATE.ACCUEIL);
			}
		});

		JButton inscription = new JButton("Inscription");
		inscription.setBounds(320, 300, 150, 30);
		this.add(inscription);

		inscription.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.changeState(Fenetre.STATE.INSCRIPTION);
			}
		});
	}
}
