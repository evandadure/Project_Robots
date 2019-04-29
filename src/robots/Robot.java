package robots;

public abstract class Robot {
	private int idRobot;
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

	public Robot(int idRobot, int coefVitesse) {
		this.idRobot = idRobot;
		this.coefVitesse = coefVitesse;
	}
	
}
