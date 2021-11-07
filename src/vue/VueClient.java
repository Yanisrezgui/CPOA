package vue;

import java.net.URL;

import controleur.ControleurClient;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VueClient extends Stage{
	private ControleurClient controleur;
	private Object vue;
	
	public VueClient() { 
		try {
			this.initModality(Modality.APPLICATION_MODAL);
			final URL fxmlURL= getClass().getResource("/vue/CreerClient.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL); 
			final VBox node = (VBox)fxmlLoader.load();
			Scene scene = new Scene(node);
			controleur = fxmlLoader.getController();
			setScene(scene);
			setTitle("Gestion Client");
			controleur.setVue(this);
			this.show();
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}

	public ControleurClient getControleur() {
		return this.controleur;
	}

	public void setControleur(ControleurClient controleur) {
		this.controleur = controleur;
	}

	public Object getVue() {
		return this.vue;
	}

	public void setVue(Object vue) {
		this.vue = vue;
	}
	
	
}
