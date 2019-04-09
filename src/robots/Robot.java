package robots;

public class Robot {
	private int posX;
	private int posY;
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
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
	
	public Robot(int X, int Y) {
		this.posX = X;
		this.posY = Y;
	}
	
}
