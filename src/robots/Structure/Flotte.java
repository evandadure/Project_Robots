package robots.Structure;

import java.util.ArrayList;

public class Flotte {
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
		// adds a robot to the current fleet's list of robots
		this.robotsList.add(r);
	}
	
	

}
