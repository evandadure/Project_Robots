package robots;

public abstract class Robot implements MoveListener {
	private int idRobot;
	private Flotte flotte;
	private int coefVitesse;
	private int posX;
	private int posY;

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

	public Robot(int idRobot, int coefVitesse) {
		this.idRobot = idRobot;
		this.coefVitesse = coefVitesse;
	}

	public void move(int newPosX, int newPosY) {
		// checks if the new position is empty (or if there is anything on the way to this position)
		if(flotte.isInField(newPosX, newPosY)){
			if(flotte.isPositionFree(newPosX,newPosY)){
				// flotte.setPosition(this, posX, posY, newPosX, newPosY);
				posX = newPosX;
				posY = newPosY;
			}
		}
	}
	
	public void onMoveEvent(MoveEvent e) {
		// bouge dans une direction un nombre de fois égal à la vitesse (vitesse de 5 = 5 mouvements)
		for (int i = 0; i < coefVitesse; i++) {
			if(e.getDirection() == "droite")
				this.move(posX+1, posY);
			if(e.getDirection() == "gauche")
				this.move(posX-1, posY);
			if(e.getDirection() == "haut")
				this.move(posX, posY+1);
			if(e.getDirection() == "bas")
				this.move(posX, posY-1);
		}
	}
	
}
