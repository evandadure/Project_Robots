package robots.Structure;

import java.util.ArrayList;
import java.lang.Math.*;

public class Field {
	private Flotte flotteA;
	private Flotte flotteB;
	private ArrayList<Robot> robotsList = new ArrayList<Robot>();
	private int nbCol;
	private int nbLig;
	
	public Field(int nbCol, int nbLig) {
		// initialise le terrain : place les diff�rents robots � leur position de d�part et les assigne dans une flotte (A ou B)
		super();
		this.nbCol = nbCol;
		this.nbLig = nbLig;
		this.flotteA = new Flotte("A");
		this.flotteB = new Flotte("B");
		// Les constructeurs des robots sont compos�s d'un id, d'un posX et d'un posY
		this.addRobot(flotteA,new RobotLent(1,6,9));
		this.addRobot(flotteA,new RobotRapide(2,2,9));
		this.addRobot(flotteA,new RobotHealer(3,4,9));
		this.addRobot(flotteB,new RobotLent(4,3,0));
		this.addRobot(flotteB,new RobotRapide(5,7,0));
		this.addRobot(flotteB,new RobotHealer(6,5,0));
		
		// ==========CARACTERISTIQUES DES ROBOTS==========
		//Robot Rapide : Vie 4, Port�e 1, D�gats 2, Mouvements 3, Port�e 1
		//Robot Lent : Vie 7, Port�e 3, D�gats 4, Mouvements 1, Port�e 3
		//Robot Healer : Vie 5, Port�e 2, Heal 3, Mouvements 2, Port�e 2
		
		
		// ==========COMPOSITION DU TERRAIN AU DEBUT==========
		//Le terrain fait 10x10 et les 0 sont en bas � gauche (cases num�rot�es de 0 � 9)
		//Flotte A : Rapide id2 (2,9) / Lent id1 (6,9) / Healer id3 (4,9)
		//Flotte B : Rapide id5 (7,0) / Lent id4 (3,0) / Healer id6 (5,0)
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
		// r�cup�re un robot � partir de son ID
		for(Robot r:this.robotsList) {
			if(r.getIdRobot() == id)
				return r;
		}
		return null;
	}
	
	public Robot getRobotByPos(int posX, int posY) {
		// r�cup�re un robot � partir de ses positions en X et Y (un seul robot peut �tre pr�sent � une position donn�e)
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
		// checks if a given position belongs to the field
		return posX>=0 && posX<this.nbCol && posY>=0 && posY<nbLig;
	}
	
	public ArrayList<Robot>getCloseRobots(Robot currentRobot) {
		// Retourne tous les robots dans la port�e du robot en param�tre
		ArrayList<Robot> listCloseRobots = new ArrayList<Robot>();
		for(Robot r:this.robotsList) {
			// check if each robot is close enough to the currentRobot
			if(currentRobot != r && (Math.abs(r.getPosX()-currentRobot.getPosX())+Math.abs(r.getPosY()-currentRobot.getPosY())<=currentRobot.getPortee())) 
				listCloseRobots.add(r);
		}
		return listCloseRobots;
	}
	

}
