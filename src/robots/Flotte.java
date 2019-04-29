package robots;

import java.util.ArrayList;

public class Flotte implements MoveListener {
	private ArrayList<Robot> robotsList = new ArrayList<Robot>();
	private int nbCol;
	private int nbLig;
	private Robot[][] field;	
	
	public Flotte(int nbCol, int nbLig) {
		super();
		this.nbCol = nbCol;
		this.nbLig = nbLig;
		this.field = new Robot[nbCol][nbLig];
	}

	public ArrayList<Robot> getRobotsList() {
		return robotsList;
	}

	public void setRobotsList(ArrayList<Robot> robotsList) {
		this.robotsList = robotsList;
	}

	public void addRobot(Robot r,int posX, int posY) {
		r.setPosX(posX);
		r.setPosY(posY);
		this.robotsList.add(r);
		this.field[posX][posY] = r;
	}
	
	private boolean isPositionFree(int posX,int posY) {
		return this.field[posX][posY] == null;
	}
	
	private boolean isInField(int posX,int posY) {
		return posX>=0 && posX<this.nbCol && posY>=0 && posY<nbLig;
	}
	
	private void moveRobot(Robot r, int newPosX, int newPosY) {
		// checks if the new position is empty (or if there is anything on the way to this position)
		if(isInField(newPosX, newPosY)){
			if(isPositionFree(newPosX,newPosY)){
				this.field[newPosX][newPosY] = r;
				this.field[r.getPosX()][r.getPosY()] = null;
				r.setPosX(newPosX);
				r.setPosY(newPosY);
			}
		}
	}
	
	public void onMoveEvent(MoveEvent e) {
		Robot r = e.getRobot();
		int coefVitesse = r.getCoefVitesse();
		// bouge dans une direction un nombre de fois égal à la vitesse (vitesse de 5 = 5 mouvements)
		for (int i = 0; i < coefVitesse; i++) {
			int posX = r.getPosX();
			int posY = r.getPosY();
			if(e.getDirection() == "droite")
				this.moveRobot(r, posX+1, posY);
			if(e.getDirection() == "gauche")
				this.moveRobot(r, posX-1, posY);
			if(e.getDirection() == "haut")
				this.moveRobot(r, posX, posY+1);
			if(e.getDirection() == "bas")
				this.moveRobot(r, posX, posY-1);
		}
	}
}
