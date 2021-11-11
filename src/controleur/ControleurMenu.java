package controleur;

import dao.Persistance;
import dao.SolutionPersistance;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import vue.VueAbonnement;
import vue.VueClient;
import vue.VuePeriodicite;
import vue.VueRevue;

public class ControleurMenu {
	@FXML 
	CheckBox chxListeMemoire;
	@FXML
	CheckBox chxMysql;
	SolutionPersistance persistance;
	
	
	public void lanceRevue() {
		VueRevue vue = new VueRevue();
	}
	
	public void lanceClient() {
		VueClient vue = new VueClient();
	}

	public void lanceAbonnement() {
		VueAbonnement vue = new VueAbonnement();
	}
	
	public void lancePeriodicite() {
		VuePeriodicite vue = new VuePeriodicite();
	}
	
	public  Persistance choixPersistance() {
		
		if(!chxListeMemoire.isSelected() && !chxMysql.isSelected()) {
			throw new IllegalArgumentException("Selectionner une persistance");
		}
		else if(chxMysql.isSelected()) {
			chxListeMemoire.setDisable(true);
			persistance.setPersistance(Persistance.MYSQL);
		}
		else {
			chxMysql.setDisable(true);
			persistance.setPersistance(Persistance.LISTE_MEMOIRE); 
		}
		
		return persistance.getPersistance();
		
	}
}
