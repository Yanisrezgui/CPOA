package controleur;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DAOFactory;
import dao.Persistance;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.Client;

public class ControleurClient {
	@FXML
	private TextField txtNom;
	private TextField txtPrenom;
	private TextField txtNoVoie;
	private TextField txtVoie;
	private TextField txtVille;
	private TextField txtPays;
	private TextField txtCodePostal;
	private Label lblAffichage;
	
	public void ajouterClient(){
		String nom = this.txtNom.getText();
		String prenom = this.txtPrenom.getText();
		int novoie = Integer.parseInt(this.txtNoVoie.getText());
		String voie = this.txtVoie.getText();
		String codePostal = this.txtCodePostal.getText();
		String ville = this.txtVille.getText();
		String pays = this.txtPays.getText();
		
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
		Matcher matcherNom = pattern.matcher(nom);
		Matcher matcherPrenom = pattern.matcher(prenom);
		Matcher matcherVille = pattern.matcher(ville);
		Matcher matcherPays = pattern.matcher(pays);
		
		Pattern pattern2 = Pattern.compile("^[0-9]+$");
		Matcher matcherCodePostal = pattern2.matcher(codePostal);
		
		try {
			if(nom == null || "".equals(nom)) {
				throw new IllegalArgumentException("Veuillez saisir un nom");
			}
			else if(!matcherNom.find()) {
				throw new IllegalAccessException("Nom invalide");
			}
			else if( prenom == null || "".equals(prenom)) {
				throw new IllegalArgumentException("Veuillez saisir un prenom");
			}
			else if(!matcherPrenom.find()) {
				throw new IllegalAccessException("Prenom invalide");
			}
			else if(novoie < 1) {
				throw new IllegalAccessException("N° de voie ne peut être inférieur à 1");
			}
			else if(voie == null || "".equals(voie)) {
				throw new IllegalArgumentException("Veuillez saisir une voie");
			}
			if(ville== null || "".equals(ville)) {
				throw new IllegalArgumentException("Veuillez saisir une ville");
			}
			else if(!matcherVille.find()) {
				throw new IllegalAccessException("Ville invalide");
			}
			if(pays == null || "".equals(pays)) {
				throw new IllegalArgumentException("Veuillez saisir un pays");
			}
			else if(!matcherPays.find()) {
				throw new IllegalAccessException("Pays invalide");
			}
			if(codePostal == null || "".equals(codePostal)) {
				throw new IllegalArgumentException("Veuillez saisir un code postal");
			}
			else if(!matcherCodePostal.find()) {
				throw new IllegalAccessException("Pays invalide");
			}
			else {
				Client client = new Client(nom, prenom, novoie, voie, codePostal, ville, pays);
				dao.getClientDAO().create(client);
				this.lblAffichage.setText(client.toString());
			}
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}

}
