package vue;

import java.net.URL;

import controleur.ControleurRevue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VueRevue extends Stage{
	private ControleurRevue controleur;

	
	public VueRevue() { 
		try {
			this.initModality(Modality.APPLICATION_MODAL);
			final URL fxmlURL= getClass().getResource("/vue/CreerRevue.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL); 
			final VBox node = (VBox)fxmlLoader.load();
			Scene scene = new Scene(node);
			controleur = fxmlLoader.getController();
			setScene(scene);
			setTitle("Gestion Revue");
			controleur.setVue(this);
			this.show();
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}

	
	public ControleurRevue getControleur() {
		return this.controleur;
	}
	public void setControleur(ControleurRevue controleur) {
		this.controleur = controleur;
	}
}
