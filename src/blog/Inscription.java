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
public class Inscription extends JPanel {
	
	public Inscription(Fenetre fenetre) {
		super();
		this.setLayout(null);
		
		JLabel nom_label = new JLabel("Nom");
		nom_label.setBounds(200, 100, 200, 20);
		this.add(nom_label);

		JTextPane nom = new JTextPane();
		nom.setBounds(300, 100, 200, 20);
		this.add(nom);
		
		JLabel prenom_label = new JLabel("Prenom");
		prenom_label.setBounds(190, 150, 200, 20);
		this.add(prenom_label);
		
		JTextPane prenom = new JTextPane();
		prenom.setBounds(300, 150, 200, 20);
		this.add(prenom);
		
		JLabel email_label = new JLabel("Email");
		email_label.setBounds(200, 200, 200, 20);
		this.add(email_label);
		
		JTextPane email = new JTextPane();
		email.setBounds(300, 200, 200, 20);
		this.add(email);
		
		JLabel pass_label = new JLabel("Mot de passe");
		pass_label.setBounds(180, 250, 200, 20);
		this.add(pass_label);
		
		JPasswordField pass = new JPasswordField();
		pass.setBounds(300, 250, 200, 20);
		this.add(pass);
		
		JLabel confirm_label = new JLabel("Confirmation mot de passe");
		confirm_label.setBounds(140, 300, 200, 20);
		this.add(confirm_label);
		
		JPasswordField confirm = new JPasswordField();
		confirm.setBounds(300, 300, 200, 20);
		this.add(confirm);
		
		JButton bouton = new JButton("S'inscrire");
		bouton.setBounds(320, 400, 150, 30);
		this.add(bouton);
		
		bouton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean need_return = false;
				
				if(StringUtils.empty(nom.getText())) {
					nom.setBackground(Color.RED);
					need_return = true;
				} else {
					nom.setBackground(Color.WHITE);
				}
				
				if(StringUtils.empty(prenom.getText())) {
					prenom.setBackground(Color.RED);
					need_return = true;
				} else {
					prenom.setBackground(Color.WHITE);
				}
				
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
				
				if(StringUtils.empty(confirm.getText())) {
					confirm.setBackground(Color.RED);
					need_return = true;
				} else {
					confirm.setBackground(Color.WHITE);
				}
				
				if(need_return) return;
				
				if(!pass.getText().equals(confirm.getText())) {
					JOptionPane.showMessageDialog(null, "Les mots de passe ne correspondent pas");
					return;
				}
				
				if(UserDao.emailExists(email.getText())) {
					JOptionPane.showMessageDialog(null, "Cette adresse email est déjà utilisée");
					return;
				}

				UserDao.createUser(nom.getText(), prenom.getText(),email.getText(), pass.getText());
				
				JOptionPane.showMessageDialog(null, "Inscription effectuée avec succès");
				
				fenetre.changeState(Fenetre.STATE.CONNECTION);
			}
		});
		
		JButton retour = new JButton("Retour");
		retour.setBounds(650, 10, 100, 30);
		this.add(retour);
		
		retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.changeState(Fenetre.STATE.CONNECTION);
			}
		});
	}
}
