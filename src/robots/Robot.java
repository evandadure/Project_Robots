package robots;

import java.util.ArrayList;

public abstract class Robot implements MoveListener, AllyListener,EnnemyListener {
	private int idRobot;
	private Flotte flotte;
	private int coefVitesse;
	private int posX;
	private int posY;
	private int portee;
	private int lifePoints;
	private int power;
	private int maxLifePoints;

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getIdRobot() {
		return idRobot;
	}
	
	public int getCoefVitesse() {
		return coefVitesse;
	}

	public Flotte getFlotte() {
		return flotte;
	}

	public void setFlotte(Flotte flotte) {
		this.flotte = flotte;
	}
	
	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public int getPower() {
		return power;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public Robot(int idRobot, int posX, int posY, int coefVitesse, int portee, int lifePoints, int power) {
		this.idRobot = idRobot;
		this.posX = posX;
		this.posY = posY;
		this.coefVitesse = coefVitesse;
		this.portee = portee;
		this.lifePoints = lifePoints;
		this.power = power;
		this.maxLifePoints = lifePoints;
	}

	public void move(Field f,int newPosX, int newPosY) {
		// checks if the new position is empty (or if there is anything on the way to this position)
		if(f.isInField(newPosX, newPosY)){
			if(f.isPositionFree(newPosX,newPosY)){
				posX = newPosX;
				posY = newPosY;
			}
		}
		
	}
	
	public void onMoveEvent(MoveEvent e) {
		// bouge dans une direction un nombre de fois égal à la vitesse (vitesse de 5 = 5 mouvements)
		Field f = e.getField();
		for (int i = 0; i < coefVitesse; i++) {
			if(e.getDirection() == "droite")
				this.move(f,posX+1, posY);
			if(e.getDirection() == "gauche")
				this.move(f,posX-1, posY);
			if(e.getDirection() == "haut")
				this.move(f,posX, posY+1);
			if(e.getDirection() == "bas")
				this.move(f,posX, posY-1);
		}
		// mets à jour la liste des écouteurs alliés et ennemis, à partir de la nouvelle position du robot courant.
		ControleRobots myController = (ControleRobots)e.getSource();
		ArrayList<AllyListener> newAllyList = new ArrayList<AllyListener>();
		ArrayList<EnnemyListener> newEnnemyList = new ArrayList<EnnemyListener>();
		// vérifie pour chaque robot proche s'il est de la meme flotte ou pas
		for(Robot r:f.getCloseRobots(this)) {
			if(r.getFlotte()==this.flotte)
				newAllyList.add(r);
			else
				newEnnemyList.add(r);
		}
		myController.setMyAllyListeners(newAllyList);
		myController.setMyEnnemyListeners(newEnnemyList);
	}
	
	public void onAttackEvent(AttackEvent e) {
		// perds de la vie, dépendant des dégats de l'attaque
		this.lifePoints-=e.getDamage();
		if(this.lifePoints<0)
			this.lifePoints = 0;
	}

	public void onHealEvent(HealEvent e) {
		// reprends de la vie, jusqu'à son nombre max de lifePoints
		this.lifePoints+=e.getHeal();
		if(this.lifePoints>this.maxLifePoints)
			this.lifePoints = this.maxLifePoints;
	}
}
