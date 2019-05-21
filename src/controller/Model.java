package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import robots.ControleRobots;
import robots.Structure.Field;
import robots.Structure.Robot;

public class Model {
	@FXML
	private Button btn_up;
	
	@FXML
	private Button btn_left;
	
	@FXML
	private Button btn_right;
	
	@FXML
	private Button btn_down;
	
	@FXML
	private GridPane gridField;
	
	@FXML
	private ListView<String> lv_robots;
	
	@FXML
	private SplitPane sp;
	
	private Field field;
	
	private ControleRobots ctrlRobots;
	
	public Model(){
		ctrlRobots = new ControleRobots(new Field(10,10));
		field = ctrlRobots.getCurrentField();
	}
	
	public GridPane getGridField() {
		return gridField;
	}
	
	public ListView getListView() {
		return lv_robots;
	}


	public void setField(Field field) {
		this.field = field;
	}
	
	public Field getField() {
		return this.field;
	}


	public void setCtrlRobots(ControleRobots ctrlRobots) {
		this.ctrlRobots = ctrlRobots;
	}

	public String getSelectedRobot() {
		// Permet de retourner l'id du robot sélectionné dans la listView
		return lv_robots.getSelectionModel().getSelectedItem().split(" ")[0];
	}
	
	public void addRobotsToLV(ArrayList<Robot> robots) {
		// Ajoute des robots dans la listView de l'applciation
		ArrayList<String> robsString = new ArrayList<String>();
		for (Robot robot : robots) {
			String classe = robot.getClass().toString().substring(28);
			robsString.add(robot.getIdRobot() + " " + classe + " " + robot.getLifePoints());
		}
		ObservableList<String> items =FXCollections.observableArrayList(robsString);
		lv_robots.setItems(items);
	}
	

	public void deleteRobot(int posX, int posY) throws FileNotFoundException{
		// Cette méthode permet de "supprimer" un robot de l'écran en recouvrant sa case par une image grise.
		String filePath = "src/view/pictures/empty.png";
		FileInputStream imageStream = new FileInputStream(filePath);
		ImageView image = new ImageView(new Image(imageStream));
		image.setFitWidth(62);
		image.setFitHeight(58);
		gridField.add(image, posX, posY);
	}
	
	public void moveRobot(String direction) {
		// On récupère le robot actuellement sélectionné
		Robot rob = field.getRobotById(Integer.parseInt(getSelectedRobot()));
		// On supprime le "robot" (uniquement sa présence à l'écran)
		try {
			deleteRobot(rob.getPosX(), rob.getPosY());			
		} catch (Exception e) {
			System.out.println(e);
		}
		// Changement de la position du robot en fonction de la direction
		ctrlRobots.addMoveListener(rob);
		ctrlRobots.generateMoveEvents(direction);
		ctrlRobots.removeMoveListener(rob);
		// Réaffichage de tous les robots (et donc de la nouvelle position du robot)
		displayAllRobots(field.getRobotsList());
		// Refresh de la listView
		addRobotsToLV(field.getRobotsList());

	}
// ACTION DES BOUTONS DE DEPLACEMENT
	public void onClickBtnUp() {
		moveRobot("haut");
	}
	
	public void onClickBtnRight() {
		moveRobot("droite");
	}
	
	public void onClickBtnDown() {
		moveRobot("bas");
	}
	
	public void onClickBtnLeft() {
		moveRobot("gauche");
	}
	
	public Button getUp() {
		return btn_up;
	}
	
	public SplitPane getSp() {
		return sp;
	}
	
	public void displayAllRobots(ArrayList<Robot> Robots) {
		//Affiche tous les robots d'une liste de Robots
		for (Robot robot : Robots) {
			try {
				displayNewRobot(robot.getClass().toString().substring(28).toLowerCase(),
						robot.getFlotte().getName(), 
						robot.getPosX(), 
						robot.getPosY());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void displayNewRobot(String typeRobot, String nomFlotte, int posX, int posY) throws FileNotFoundException {
		// ajoute graphiquement un robot en fonction de sa flotte (A = bleu, B = rouge) et de son type
		// (chaque type de robot à sa propre illustration)
		String color;
		if(nomFlotte=="A")
			color = "blue";
		else
			color = "red";
		String filePath = "src/view/pictures/"+typeRobot+"_"+color+".png";
		FileInputStream imageStream = new FileInputStream(filePath);
		ImageView image = new ImageView(new Image(imageStream));
		image.setFitWidth(62);
		image.setFitHeight(58);
		gridField.add(image, posX, posY);
	}
	
	
	
}
