package controller;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import robots.Structure.Robot;

public class Main extends Application  {
	private Model frame = new Model();

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		try {

			// ==========CREATION DE LA SOURCE (Controller), DU TERRAIN ET DES ROBOTS==========
			loader.setLocation(getClass().getResource("../view/PersonOverview2.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			primaryStage.setTitle("Robots");
			primaryStage.setScene(new Scene(root));
			this.frame = loader.getController();
			ArrayList<Robot> robots = frame.getField().getRobotsList();
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