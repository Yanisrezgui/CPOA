package controleur;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import dao.DAOFactory;
import dao.Persistance;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.Periodicite;
import modele.Revue;

public class ControleurRevue implements Initializable, ChangeListener<Revue> {
	@FXML
	private TextField txtTitre;
	@FXML
	private TextArea txtDescription;
	@FXML
	private TextField txtTarif;
	@FXML
	private ComboBox<Periodicite> cboxPeriodicite;
	@FXML
	private Stage vue;
	@FXML
	private String nomfichier="";
	@FXML
	private TableView<Revue> tblRevue;
	@FXML
	private Button btnSupprimer;
	
	
	
	public void ajouterRevue() {
		String titre = this.txtTitre.getText();
		String description = this.txtDescription.getText();
		String tarif = this.txtTarif.getText();
		String visuel = "test";
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
	
	
	public void ajouterVisuel() {
		FileChooser fileChooser=new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter(".jpg","JPG"),
				new FileChooser.ExtensionFilter(".png", "PNG"));
		fileChooser.setTitle("open Resource File");
		File f=fileChooser.showOpenDialog(this.vue);
		if(f!=null)
		{
			nomfichier=f.getAbsolutePath();
		}
				
				
	}
	
	 
	public void supprimerRevue(Revue revue) {
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		try {
			dao.getRevueDAO().delete(revue);
		} catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	
	
	public void voirRevue() {
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		try {
			TableColumn<Revue, String> titre = new TableColumn<>("titre");
			TableColumn<Revue, String> description = new TableColumn<>("description");
			TableColumn<Revue, Integer> tarif = new TableColumn<>("tarif");
			TableColumn<Periodicite, String> periodicite = new TableColumn<>("periodicite");
			
			titre.setCellValueFactory(new PropertyValueFactory<Revue, String>("titre"));
			description.setCellValueFactory(new PropertyValueFactory<Revue, String>("description"));
			tarif.setCellValueFactory(new PropertyValueFactory<Revue, Integer>("tarif"));
			periodicite.setCellValueFactory(new PropertyValueFactory<Periodicite, String>("periodicite"));
			
			this.tblRevue.getColumns().setAll(titre, description, tarif, periodicite);
			this.tblRevue.getItems().addAll(dao.getPeriodiciteDAO().findAll());
			this.tblRevue.getSelectionModel().selectedItemProperty().addListener(this);
			
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	
	
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {

        DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
        try {
			this.cboxPeriodicite.setItems(FXCollections.observableArrayList(dao.getPeriodiciteDAO().findAll()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	public void setVue(Stage vue) {
		this.vue=vue;
	}
	public Stage getVue() {
		return vue;
	}


	@Override
	public void changed(ObservableValue<? extends Revue> observable, Revue oldValue, Revue newValue) {
		this.btnSupprimer.setDisable(newValue == null);	
		
	}
	
}
