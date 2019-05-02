package robots;

import java.util.ArrayList;

public class ControleRobots {
	private ArrayList<MoveListener> myMoveListeners = new ArrayList<MoveListener>();
	
	
	public void addMoveListener(MoveListener eListener) {
		this.myMoveListeners.add(eListener);
	}
	
	public void removeMoveListener(MoveListener eListener) {
		this.myMoveListeners.remove(eListener);
	}
	
	public void generateMoveEvent(String direction) {
		MoveEvent e = new MoveEvent(this, direction);
		for(MoveListener eListener:myMoveListeners) {
			eListener.onMoveEvent(e);
		}
	}
}
