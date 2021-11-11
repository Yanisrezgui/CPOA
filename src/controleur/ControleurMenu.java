package controleur;

import java.net.URL;
import java.util.ResourceBundle;

import dao.DAOFactory;
import dao.Persistance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import vue.VueAbonnement;
import vue.VueClient;
import vue.VuePeriodicite;
import vue.VueRevue;

public class ControleurMenu implements Initializable {
	private Stage vue;
	@FXML 
	private RadioButton rdbMysql;
	@FXML
	private RadioButton rdbListeMemoire;
	@FXML
	private ToggleGroup choixpers; 
	private DAOFactory dao;
	
	
	
	public void lanceRevue() {
		
		if(choixpers.getSelectedToggle() == null) {
			throw new IllegalArgumentException("Selectionner une persistance");
		}
		else {
			if(rdbMysql.isSelected()) {
				 dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
			}
			else {
				rdbMysql.setDisable(true);
				dao = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE); 
			}
			try {
				VueRevue vue = new VueRevue();
				vue.getControleur().setDao(dao);
			} catch(Exception sqle) {
				sqle.printStackTrace();
			}
		}
	}
	
	public void lanceClient() {
		
		if(choixpers.getSelectedToggle() == null) {
			throw new IllegalArgumentException("Selectionner une persistance");
		}
		else {
			if(rdbMysql.isSelected()) {
				 dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
			}
			else {
				rdbMysql.setDisable(true);
				dao = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE); 
			}
			try {
				VueClient vue = new VueClient();
				vue.getControleur().setDao(dao);
			} catch(Exception sqle) {
				sqle.printStackTrace();
			}
		}
	}

	public void lanceAbonnement() {
		
		if(choixpers.getSelectedToggle() == null) {
			throw new IllegalArgumentException("Selectionner une persistance");
		}
		else {
			if(rdbMysql.isSelected()) {
				 dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
			}
			else {
				rdbMysql.setDisable(true);
				dao = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE); 
			}
			try {
				VueAbonnement vue = new VueAbonnement();
				vue.getControleur().setDao(dao);
			} catch(Exception sqle) {
				sqle.printStackTrace();
			}
		}
	}
	
	public void lancePeriodicite() {
		
		if(choixpers.getSelectedToggle() == null) {
			throw new IllegalArgumentException("Selectionner une persistance");
		}
		else {
			if(rdbMysql.isSelected()) {
				 dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
			}
			else {
				rdbMysql.setDisable(true);
				dao = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE); 
			}
			try {
				VuePeriodicite vue = new VuePeriodicite();
				vue.getControleur().setDao(dao);
			} catch(Exception sqle) {
				sqle.printStackTrace();
			}
		}	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

	public Stage getVue() {
		return vue;
	}
	public void setVue(Stage vue) {
		this.vue = vue;
	}
	
	
}
