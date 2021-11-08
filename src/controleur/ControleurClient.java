package controleur;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DAOFactory;
import dao.Persistance;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Client;

public class ControleurClient {
	@FXML
	private TextField txtNom;
	@FXML
	private TextField txtPrenom;
	@FXML
	private TextField txtNoVoie;
	@FXML
	private TextField txtVoie;
	@FXML
	private TextField txtVille;
	@FXML
	private TextField txtPays;
	@FXML
	private TextField txtCodePostal;
	@FXML
	private TableView<Client> tblClient;
	@FXML
	private Label lblAffichage;
	@FXML
	private Stage vue;
	
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
		
		
			if(nom == null || "".equals(nom)) {
				System.out.println("erreur nom saisi nom");
				afficheAlerte("Veuillez saisir un nom");
				
			}
			else if(!matcherNom.find()) {
				System.out.println("erreur nom invalide");
				afficheAlerte("Nom invalide");
			}
			else if( prenom == null || "".equals(prenom)) {
				System.out.println("erreur prenom");
				afficheAlerte("Veuillez saisir un prenom");
			}
			else if(!matcherPrenom.find()) {
				System.out.println("erreur prenom invalide");
				afficheAlerte("Prenom invalide");
			}
			else if(novoie < 1) {
				System.out.println("erreur no voie inferieure");
				afficheAlerte("N° de voie ne peut être inférieur à 1");
			}
			else if(voie == null || "".equals(voie)) {
				System.out.println("erreur saisie voie");
				afficheAlerte("Veuillez saisir une voie");
			}
			if(ville== null || "".equals(ville)) {
				System.out.println("erreur saisie ville");
				afficheAlerte("Veuillez saisir une ville");
			}
			else if(!matcherVille.find()) {
				System.out.println("erreur ville invalide");
				afficheAlerte("Ville invalide");
			}
			if(pays == null || "".equals(pays)) {
				System.out.println("erreur saisie pays");
				afficheAlerte("Veuillez saisir un pays");
			}
			else if(!matcherPays.find()) {
				System.out.println("erreur pays invalide");
				afficheAlerte("Pays invalide");
			}
			if(codePostal == null || "".equals(codePostal)) {
				System.out.println("erreur saisie code postale");
				afficheAlerte("Veuillez saisir un code postal");
			}
			else if(!matcherCodePostal.find()) {
				System.out.println("erreur code postale invalide");
				afficheAlerte("code postale invalide");
			}
			else { 
				try {
				Client client = new Client(nom, prenom, novoie, voie, codePostal, ville, pays);
				dao.getClientDAO().create(client);
				}catch(Exception sqle) {
					System.out.println("erreur controleur client "+sqle.getMessage());
				}
			}
		
	}

	public void afficheAlerte(String message) {
		System.out.println("alerte"+message);
		
	}
	
	public Stage getVue() {
		return vue;
	}
	public void setVue(Stage vue) {
		this.vue = vue;
	}
	
}
