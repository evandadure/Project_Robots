package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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
	
	public Model(){
		System.out.println("debut window");

//		this.gridField.add(image, 1, 0);
//		this.gridField.add(image, 2, 0);
//		this.gridField.add(image, 3, 0);
	}
	

	
	public GridPane getGridField() {
		return gridField;
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
