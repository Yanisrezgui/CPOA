package controleur;

import java.time.LocalDate;

import dao.DAOFactory;
import dao.Persistance;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modele.Abonnement;
import modele.Client;
import modele.Revue;

public class ControleurAbonnement {
	
	@FXML
	private DatePicker datepicDeb;
	@FXML
	private DatePicker datepicFin;
	@FXML
	private ChoiceBox<Client> cbxClient;
	@FXML
	private ChoiceBox<Revue> cbxRevue;
	@FXML
	private Label lblAffichage;
	@FXML
	private Stage vue;
	
	public void ajouterAbonnement() {
		LocalDate datedeb = this.datepicDeb.getValue();
		LocalDate datefin = this.datepicFin.getValue();
		Client client = this.cbxClient.getValue();
		Revue revue = this.cbxRevue.getValue();
		
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		try {
			if(datedeb == null) {
				throw new IllegalArgumentException("Selectionner une date de début");
			}
			else if(datedeb.isAfter(datefin)) {
				throw new IllegalArgumentException("Date de début non valide");
			}
			else if(datefin == null) {
				throw new IllegalArgumentException("Selectionner une date de fin");
			}
			else if(datefin.isBefore(datedeb)) {
				throw new IllegalArgumentException("Date de fin non valide");
			}
			else if(client == null) {
				throw new IllegalArgumentException("Selectionner un client");
			}
			else if(revue == null) {
				throw new IllegalArgumentException("Selectionner une revue");
			}
			else {
				Abonnement abonnement = new Abonnement(datedeb, datefin, client, revue);
				dao.getAbonnementDAO().create(abonnement);
				this.lblAffichage.setText(abonnement.toString());
			}
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	
	//Overide et Initilize
	
	
	public Stage getVue() {
		return vue;
	}
	public void setVue(Stage vue) {
		this.vue = vue;
	}
	
}
