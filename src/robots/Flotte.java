package robots;

import java.util.ArrayList;

public class Flotte {
	private ArrayList<Robot> robotsList = new ArrayList<Robot>();
	private int nbCol;
	private int nbLig;
	
	public Flotte(int nbCol, int nbLig) {
		super();
		this.nbCol = nbCol;
		this.nbLig = nbLig;
	}

	public ArrayList<Robot> getRobotsList() {
		return robotsList;
	}

	public void addRobot(Robot r,int posX, int posY) {
		r.setPosX(posX);
		r.setPosY(posY);
		r.setFlotte(this);
		this.robotsList.add(r);
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
	

}
