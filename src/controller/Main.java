package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import robots.ControleRobots;
import robots.Structure.Field;
import robots.Structure.Robot;
import robots.Structure.RobotHealer;

public class Main extends Application  {
	private Model frame;

	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		try {

			// ==========CREATION DE LA SOURCE (Controller), DU TERRAIN ET DES ROBOTS==========
			ControleRobots source = new ControleRobots(new Field(10,10));
			Field mainField = source.getCurrentField();


			loader.setLocation(getClass().getResource("../view/PersonOverview2.fxml"));

			AnchorPane root = (AnchorPane) loader.load();
			primaryStage.setTitle("Login");
			primaryStage.setScene(new Scene(root));
			this.frame = loader.getController();
			Scene scene = primaryStage.getScene();
			SplitPane sp = (SplitPane)scene.lookup("sp");                        

			displayNewRobot("heal","A",5,0);
			mainField.getRobotsList();
			frame.addRobotsToLV(mainField.getRobotsList());



			primaryStage.show();

		} catch (Exception e) {
			System.out.println("ATTENTION DERRIERE TOI C EST AFFREUX " + e);
			// TODO: handle exception
		}
	}

	public void displayNewRobot(String typeRobot, String nomFlotte, int posX, int posY) throws FileNotFoundException {
		String color;
		if(nomFlotte=="A")
			color = "blue";
		else
			color = "red";
		String filePath = "src/view/pictures/"+typeRobot+"_"+color+".png";
		GridPane grid = frame.getGridField();
		FileInputStream imageStream = new FileInputStream(filePath);
		ImageView image = new ImageView(new Image(imageStream));
		image.setFitWidth(62);
		image.setFitHeight(58);
		grid.add(image, posX, posY);
	}


	public void deleteRobot(int posX, int posY) throws FileNotFoundException{
		String filePath = "src/view/pictures/empty.png";
		GridPane grid = frame.getGridField();
		FileInputStream imageStream = new FileInputStream(filePath);
		ImageView image = new ImageView(new Image(imageStream));
		image.setFitWidth(62);
		image.setFitHeight(58);
		grid.add(image, posX, posY);
	}

	public static void main(String[] args) {
		launch(args);
	}
}