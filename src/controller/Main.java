package controller;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import robots.Structure.Robot;

public class Main extends Application  {
	// Le modèle est composé d'un Field (= les données) et des différents éléments de notre application
	// (ainsi que les comportements qui leur sont associés)
	private Model frame = new Model();

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			// L'interface graphique et les éléments qui la composent sont 
			// détaillés dans le fichier FXML, généré à partir de JavaFX SceneBuilder
			loader.setLocation(getClass().getResource("../view/PersonOverview2.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			primaryStage.setTitle("Robots");
			primaryStage.setScene(new Scene(root));
			this.frame = loader.getController();
			// Récupère les robots du Field (automatiquement instanciés à la créationd d'un Field)
			ArrayList<Robot> robots = frame.getField().getRobotsList();
			// Ajoute les robots à la listView de l'application, et également graphiquement
			frame.addRobotsToLV(robots);
			frame.displayAllRobots(robots);
			primaryStage.show();

		} catch (Exception e) {
			System.out.println("An error was raised, look ! " + e);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}