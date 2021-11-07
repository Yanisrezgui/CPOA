package controleur;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DAOFactory;
import dao.Persistance;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Periodicite;

public class ControleurPeriodicite {
	@FXML
	private TextField txtLibelle;
	private Label lblAffichage;
	private Stage vue;
	
	public void ajouterPeriodicite() {
		String libelle = this.txtLibelle.getText();
		
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
		Matcher matcherLibelle = pattern.matcher(libelle);
		
		try {
			if(libelle == null || "".equals(libelle)) {
				throw new IllegalArgumentException("Saisir un libelle");
			}
			else if(!matcherLibelle.find()) {
				throw new IllegalArgumentException("Saisir un libelle valide");
			}
			else {
				Periodicite periodicite = new Periodicite(libelle);
				dao.getPeriodiciteDAO().create(periodicite);
				this.lblAffichage.setText(periodicite.toString());
			}
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	
	public Stage getVue() {
		return vue;
	}
	public void setVue(Stage vue) {
		this.vue = vue;
	}
	
}
