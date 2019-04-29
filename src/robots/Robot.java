package robots;

public abstract class Robot {
	private int idRobot;
	private int coefVitesse;

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
