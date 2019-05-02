package robots;

import java.util.ArrayList;
import java.lang.Math.*;

public class Field {
	private Flotte flotteA;
	private Flotte flotteB;
	private ArrayList<Robot> robotsList = new ArrayList<Robot>();
	private int nbCol;
	private int nbLig;
	
	public Field(int nbCol, int nbLig) {
		// initialise le terrain : place les différents robots à leur position de départ et les assigne dans une flotte (A ou B)
		super();
		this.nbCol = nbCol;
		this.nbLig = nbLig;
		this.flotteA = new Flotte("A");
		this.flotteB = new Flotte("B");
		this.addRobot(flotteA,new RobotLent(1,6,9));
		this.addRobot(flotteA,new RobotRapide(2,2,9));
		this.addRobot(flotteA,new RobotHealer(3,4,9));
		this.addRobot(flotteB,new RobotLent(4,3,0));
		this.addRobot(flotteB,new RobotRapide(5,7,0));
		this.addRobot(flotteB,new RobotHealer(6,5,0));
	}

	public ArrayList<Robot> getRobotsList() {
		return robotsList;
	}

	public void addRobot(Flotte f, Robot r) {
		// adds the robot in the list of all robots on the field
		this.robotsList.add(r);
		// adds the robot in his fleet's list of robots
		r.setFlotte(f);
		f.addRobot(r);
	}
	
	public Robot getRobotById(int id) {
		for(Robot r:this.robotsList) {
			if(r.getIdRobot() == id)
				return r;
		}
		return null;
	}
	
	public Robot getRobotByPos(int posX, int posY) {
		for(Robot r:this.robotsList) {
			if(r.getPosX() == posY && r.getPosY() == posY)
				return r;
		}
		return null;
	}
	
	public boolean isPositionFree(int posX,int posY) {
		// checks for each robot if it's on the wanted position. Returns false if the position is occupied, or true if not.
		for(Robot r:robotsList) {
			if(r.getPosX()==posX && r.getPosY()==posY)
				return false;
		}
		return true;
	}
	
	public boolean isInField(int posX,int posY) {
		return posX>=0 && posX<this.nbCol && posY>=0 && posY<nbLig;
	}
	
	public ArrayList<Robot>getCloseRobots(Robot currentRobot) {
		ArrayList<Robot> listCloseRobots = new ArrayList<Robot>();
		for(Robot r:this.robotsList) {
			// check if each robot is close enough to the currentRobot
			if(currentRobot != r && (Math.abs(r.getPosX()-currentRobot.getPosX())+Math.abs(r.getPosY()-currentRobot.getPosY())<=currentRobot.getPortee())) 
				listCloseRobots.add(r);
		}
		return listCloseRobots;
	}
	

}
