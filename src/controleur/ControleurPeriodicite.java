package controleur;



import java.util.regex.Matcher;
import java.util.regex.Pattern;



import dao.DAOFactory;
import dao.Persistance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modele.Periodicite;

public class ControleurPeriodicite {
	@FXML
	private TextField txtLibelle;
	@FXML
	private TableView<Periodicite> tblPeriodicite;
	@FXML
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
				
			}
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	
	public void voirPeriodicite() {
		DAOFactory dao=DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		try {
			TableColumn<Periodicite, Integer> idLibelle =new TableColumn<>("id");
			TableColumn<Periodicite, String> Libelle = new TableColumn<>("Libelle");
			
			idLibelle.setCellValueFactory(new PropertyValueFactory<Periodicite, Integer>("id"));
			Libelle.setCellValueFactory(new PropertyValueFactory<Periodicite, String>("Libelle"));
			
			this.tblPeriodicite.getColumns().setAll(idLibelle,Libelle);
			
			this.tblPeriodicite.getItems().addAll(dao.getPeriodiciteDAO().findAll());
					
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
		
		
	}
	
	/*public void supprimerPeriodicite(Periodicite periodicite) {
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
	
		try {
			dao.getPeriodiciteDAO().delete(periodicite);
		} catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}*/
	

	
	public Stage getVue() {
		return vue;
	}
	public void setVue(Stage vue) {
		this.vue = vue;
	}
	
}
