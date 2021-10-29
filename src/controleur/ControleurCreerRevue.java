package controleur;

import dao.DAOFactory;
import dao.Persistance;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modele.Periodicite;
import modele.Revue;

public class ControleurCreerRevue {
	@FXML
	private TextField txtTitre;
	private TextArea txtDescription;
	private TextField txtTarif;
	private ComboBox<Periodicite> cboxPeriodicite;
	
	
	
	public void ajouterRevue() {
		String titre = this.txtTitre.getText();
		String description = this.txtDescription.getText();
		String tarif = this.txtTarif.getText();
		String visuel;
		Periodicite periodicite = this.cboxPeriodicite.getSelectionModel().getSelectedItem();
		
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		try {
			if(titre == null || "".equals(titre)) {
				throw new IllegalArgumentException("Veuillez saisir un titre");
			}
			else if(description == null || "".equals(description)) {
				throw new IllegalArgumentException("Veuillez saisir une description");
			}
			else if(tarif == null || "".equals(tarif) || Integer.parseInt(tarif) <= 0){
				throw new IllegalArgumentException("Veuillez saisir un prix");
			}
			else if(visuel == null) {
				throw new IllegalAccessException("Veuillez donner un visuel");
			}
			else if(periodicite == null ) {
				throw new IllegalArgumentException("Veuillez selectionner une périodicité");
			}
			else {
				Revue revue = new Revue(titre, description, Integer.parseInt(tarif), null, periodicite);
				dao.getRevueDAO().create(revue);							
			}
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	
	//TODO Voir où mettre ca 
//	public void supprimerRevue(Revue revue) {
//		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
//		
//		try {
//			dao.getRevueDAO().delete(revue);
//		} catch(Exception sqle) {
//			System.out.println(sqle.getMessage());
//		}
//	}
	
	
}
