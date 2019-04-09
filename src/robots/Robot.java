package robots;

public class Robot {
	private int idRobot;
	private int posX;
	private int posY;
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}

	public int getIdRobot() {
		return idRobot;
	}
	
	public void goRight() {
		this.posX+=1;
	}
	
	public void goLeft() {
		this.posX-=1;
	}
	
	public void goUp() {
		this.posY+=1;
	}
	
	public void goDown() {
		this.posY-=1;
	}
	

	public Robot(int X, int Y, int idRobot) {
		this.idRobot = idRobot;
		this.posX = X;
		this.posY = Y;
	}
	
}
