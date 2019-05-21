package controller;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import robots.Structure.Robot;

public class Main extends Application  {
	// Le mod�le est compos� d'un Field (= les donn�es) et des diff�rents �l�ments de notre application
	// (ainsi que les comportements qui leur sont associ�s)
	private Model frame = new Model();

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			// L'interface graphique et les �l�ments qui la composent sont 
			// d�taill�s dans le fichier FXML, g�n�r� � partir de JavaFX SceneBuilder
			loader.setLocation(getClass().getResource("../view/PersonOverview2.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			primaryStage.setTitle("Robots");
			primaryStage.setScene(new Scene(root));
			this.frame = loader.getController();
			// R�cup�re les robots du Field (automatiquement instanci�s � la cr�ationd d'un Field)
			ArrayList<Robot> robots = frame.getField().getRobotsList();
			// Ajoute les robots � la listView de l'application, et �galement graphiquement
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