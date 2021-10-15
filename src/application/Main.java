package application;

import java.lang.Exception;
import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage primaryStage) {
	try {
	URL fxmlURL=getClass().getResource("/fenetre.fxml");
	FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
	Node root = fxmlLoader.load();
	Scene scene = new Scene((VBox) root, 600, 400);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.setTitle("Ma premi�re fen�tre JavaFX");
	primaryStage.show();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}

}
