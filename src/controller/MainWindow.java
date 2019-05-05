package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainWindow {
	@FXML
	private Button btn_up;
	
	@FXML
	private Button left;
	
	@FXML
	private Button right;
	
	@FXML
	private Button down;
	
	
	public void handleBtnUpClick() {
		System.out.println("Wallah");
	}
	
	public String getUp() {
		return btn_up.getText();
	}
	
}
