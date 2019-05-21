package robots.Structure;

import java.util.ArrayList;

public class Flotte {
	// Cette classe est utile car elle permet de séparer les robots en deux groupes (flotte A, flotte B -> voir la classe Field)
	private ArrayList<Robot> robotsList = new ArrayList<Robot>();
	private String name;
	
	public Flotte(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public ArrayList<Robot> getRobotsList() {
		return robotsList;
	}

	public void addRobot(Robot r) {
		this.robotsList.add(r);
	}
	
	

}
