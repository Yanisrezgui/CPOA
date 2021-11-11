package controleur;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import dao.DAOFactory;
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
	private Button btnSupprimer;
	@FXML
	private TableView<Revue> tblRevue;
	@FXML
	private TableColumn<Revue, String> titre;
	@FXML 
	private TableColumn<Revue, String> description;
	@FXML 
	private TableColumn<Revue, Integer> tarif;
	@FXML 
	private TableColumn<Revue, Periodicite> periodicite;
	private static ControleurMenu controleurMenu;
	
	
	
	public void ajouterRevue() {
		String titre = this.txtTitre.getText();
		String description = this.txtDescription.getText();
		String tarif = this.txtTarif.getText();
		String visuel = "test";
		Periodicite periodicite = this.cboxPeriodicite.getSelectionModel().getSelectedItem();
		
		DAOFactory dao = controleurMenu.choixPersistance();
		
		
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
				throw new IllegalArgumentException("Veuillez donner un visuel");
			}
			else if(periodicite == null ) {
				throw new IllegalArgumentException("Veuillez selectionner une périodicité");
			}
			else {
				try {
					Revue revue = new Revue(titre, description, Integer.parseInt(tarif), null, periodicite);
					dao.getRevueDAO().create(revue);
					this.tblRevue.getItems().add(revue);
				}catch(Exception sqle) {
					System.out.println(sqle.getMessage());
				}
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
	
	 
	public void supprimerRevue() {
		DAOFactory dao = controleurMenu.choixPersistance();
		
		try {
			dao.getRevueDAO().delete(this.tblRevue.getSelectionModel().getSelectedItem());
			this.tblRevue.getItems().remove(this.tblRevue.getSelectionModel().getSelectedItem());
		} catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	
	
	public void voirRevue() {
		DAOFactory dao = controleurMenu.choixPersistance();
		
		try {
			titre.setCellValueFactory(new PropertyValueFactory<Revue, String>("titre"));
			description.setCellValueFactory(new PropertyValueFactory<Revue, String>("description"));
			tarif.setCellValueFactory(new PropertyValueFactory<Revue, Integer>("tarif"));
			periodicite.setCellValueFactory(new PropertyValueFactory<Revue, Periodicite>("periodicite"));
			
			this.tblRevue.getColumns().setAll(titre, description, tarif, periodicite);
			this.tblRevue.getItems().addAll(dao.getRevueDAO().findAll());
			this.tblRevue.getSelectionModel().selectedItemProperty().addListener(this);
			
		}catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	
	
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		this.voirRevue();
		
        DAOFactory dao = controleurMenu.choixPersistance();
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
