package controleur;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.DAOFactory;
import dao.Persistance;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import modele.Abonnement;
import modele.Client;
import modele.Revue;

public class ControleurAbonnement implements Initializable {
	
	@FXML
	private DatePicker datepicDeb;
	@FXML
	private DatePicker datepicFin;
	@FXML
	private ChoiceBox<Client> cbxClient;
	@FXML
	private ChoiceBox<Revue> cbxRevue;
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
			}
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	public void supprimerAbonnement(Abonnement abonnement) {
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
	
		try {
			dao.getAbonnementDAO().delete(abonnement);
		} catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {

        DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
        try {
			this.cbxClient.setItems(FXCollections.observableArrayList(dao.getClientDAO().findAll()));
			this.cbxRevue.setItems(FXCollections.observableArrayList(dao.getRevueDAO().findAll()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	public Stage getVue() {
		return vue;
	}
	public void setVue(Stage vue) {
		this.vue = vue;
	}
	
}
