package robots;

import java.util.ArrayList;

public class Flotte {
	private ArrayList<Robot> robotsList = new ArrayList<Robot>();

	public ArrayList<Robot> getRobotsList() {
		return robotsList;
	}

	public void setRobotsList(ArrayList<Robot> robotsList) {
		this.robotsList = robotsList;
	}
	
	public void addRobot(Robot r) {
		this.robotsList.add(r);
	}
}
