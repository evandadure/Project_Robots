package robots;

import java.util.ArrayList;

public class Flotte implements MoveListener {
	private ArrayList<Robot> robotsList = new ArrayList<Robot>();
	private int nbCol;
	private int nbLig;
	private Integer[][] field;	
	
	public Flotte(int nbCol, int nbLig) {
		super();
		this.nbCol = nbCol;
		this.nbLig = nbLig;
		this.field = new Integer[nbCol][nbLig];
	}

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
		Robot r = e.getRobot();
		int coefVitesse = r.getCoefVitesse();
		if(e.getDirection() == "droite")
			r.getCoefVitesse;
		if(e.getDirection() == "gauche")
			r.goLeft();
		if(e.getDirection() == "haut")
			r.goUp();
		if(e.getDirection() == "bas")
			r.goDown();
			
	}
}
