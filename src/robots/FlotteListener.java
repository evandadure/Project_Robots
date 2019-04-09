package robots;

public class FlotteListener implements MoveListener{
	
	public void onMoveEvent(MoveEvent e) {
		if(e.getDirection() == "droite")
			e.getRobot().goRight();
		if(e.getDirection() == "gauche")
			e.getRobot().goLeft();
		if(e.getDirection() == "haut")
			e.getRobot().goUp();
		if(e.getDirection() == "bas")
			e.getRobot().goDown();
			
	}
	
}
