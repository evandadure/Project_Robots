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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
	
	private String idRobot;
	
	public void addRobotsToLV(ArrayList<Robot> robots) {
		ArrayList<String> robsString = new ArrayList<String>();
		for (Robot robot : robots) {
			String classe = robot.getClass().toString().substring(28);
			robsString.add(robot.getIdRobot() + " " + classe + " " + robot.getLifePoints());
		}
		ObservableList<String> items =FXCollections.observableArrayList(robsString);
		lv_robots.setItems(items);
	}
	
	public Model(){
		System.out.println("debut window");

//		this.gridField.add(image, 1, 0);
//		this.gridField.add(image, 2, 0);
//		this.gridField.add(image, 3, 0);
	}
	
	
	public GridPane getGridField() {
		return gridField;
	}

	public ListView getListView() {
		return lv_robots;
	}

	public void onClickBtnUp() {
		System.out.println("up");
	}
	
	public void onClickBtnRight() {
		System.out.println("right");
	}
	
	public void onClickBtnDown() {
		System.out.println("down");
	}
	
	public void onClickBtnLeft() {
		System.out.println("left");
	}
	
	public void onClickBtnAction() {
		System.out.println("heal or attack");
	}
	
	public String getUp() {
		return btn_up.getText();
	}
	
}
