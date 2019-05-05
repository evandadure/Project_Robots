package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(getClass().getResource("../view/PersonOverview2.fxml"));
			
			AnchorPane root = (AnchorPane) loader.load();
			primaryStage.setTitle("Login");
			primaryStage.setScene(new Scene(root));
			MainWindow frame = loader.getController();
			Scene scene = primaryStage.getScene();
			SplitPane sp = (SplitPane)scene.lookup("sp");			
			primaryStage.show();
		
			
			
		} catch (Exception e) {
			System.out.println("ATTENTION DERRIERE TOI C EST AFFREUX " + e);
		}
			// TODO: handle exception
		}
		
		

	public static void main(String[] args) {
		launch(args);
	}
}