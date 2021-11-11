package controleur;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.DAOFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modele.Abonnement;
import modele.Client;
import modele.Revue;

public class ControleurAbonnement implements Initializable, ChangeListener<Abonnement> {
	
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
	@FXML
	private TableView<Abonnement> tblAbonnement;
	@FXML
	private TableColumn<Abonnement, Integer> id;
	@FXML
	private TableColumn<Abonnement, LocalDate> datedeb;
	@FXML
	private TableColumn<Abonnement, LocalDate> datefin;
	@FXML
	private TableColumn<Abonnement, Client> client;
	@FXML
	private TableColumn<Abonnement, Revue> revue;
	@FXML
	private Button btnSupprimer;
	private static ControleurMenu controleurMenu;
	
	public void ajouterAbonnement() {
		LocalDate datedeb = this.datepicDeb.getValue();
		LocalDate datefin = this.datepicFin.getValue();
		Client client = this.cbxClient.getValue();
		Revue revue = this.cbxRevue.getValue();
		
		DAOFactory dao = DAOFactory.getDAOFactory(controleurMenu.choixPersistance());
		
		
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
				try {
					Abonnement abonnement = new Abonnement(datedeb, datefin, client, revue);
					dao.getAbonnementDAO().create(abonnement);
					this.tblAbonnement.getItems().add(abonnement);
				}catch(Exception sqle) {
					System.out.println(sqle.getMessage());
				}
			}

	}

	public void supprimerAbonnement(Abonnement abonnement) {
		DAOFactory dao = DAOFactory.getDAOFactory(controleurMenu.choixPersistance());
	
		try {
			dao.getAbonnementDAO().delete(abonnement);
			this.tblAbonnement.getItems().remove(abonnement);
		} catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	
	
	public void voirAbonnement() {
		DAOFactory dao = DAOFactory.getDAOFactory(controleurMenu.choixPersistance());
		
		try {			
			id.setCellValueFactory(new PropertyValueFactory<Abonnement, Integer>("idAbonnement"));
			datedeb.setCellValueFactory(new PropertyValueFactory<Abonnement, LocalDate>("datedeb"));
			datefin.setCellValueFactory(new PropertyValueFactory<Abonnement, LocalDate>("datefin"));
			client.setCellValueFactory(new PropertyValueFactory<Abonnement, Client>("client"));
			revue.setCellValueFactory(new PropertyValueFactory<Abonnement, Revue>("revue"));
			
			this.tblAbonnement.getColumns().setAll(id,datedeb,datefin,client,revue);
			this.tblAbonnement.getItems().addAll(dao.getAbonnementDAO().findAll());
			this.tblAbonnement.getSelectionModel().selectedItemProperty().addListener(this);
			
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
		
	}
	
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		this.voirAbonnement();

        DAOFactory dao = DAOFactory.getDAOFactory(controleurMenu.choixPersistance());
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

	@Override
	public void changed(ObservableValue<? extends Abonnement> observable, Abonnement oldValue, Abonnement newValue) {
		this.btnSupprimer.setDisable(newValue == null);	
	}
	
}
