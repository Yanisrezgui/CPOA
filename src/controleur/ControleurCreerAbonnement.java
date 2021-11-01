package controleur;

import java.time.LocalDate;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import modele.Client;
import modele.Revue;

public class ControleurCreerAbonnement {
	private DatePicker datepicDeb;
	private DatePicker datepicFin;
	private ChoiceBox<Client> cbxClient;
	private ChoiceBox<Revue> cbxRevue;
	
	public void ajouterAbonnement() {
		LocalDate datedeb = this.datepicDeb.getValue();
		LocalDate datefin = this.datepicFin.getValue();
		
		
		
	}
	
	//Overide et Initilize
}
