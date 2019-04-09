package robots;

import java.util.ArrayList;

public class Flotte implements MoveListener {
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
	public void onMoveEvent(MoveEvent e) {
		Robot r = (Robot)e.getSource();
		if(e.getDirection() == "droite")
			r.goRight();
		if(e.getDirection() == "gauche")
			r.goLeft();
		if(e.getDirection() == "haut")
			r.goUp();
		if(e.getDirection() == "bas")
			r.goDown();
			
	}
}
