package robots;

import java.util.ArrayList;

public class Source11 {
	private ArrayList<MoveListener> mesListeners = new ArrayList<MoveListener>();

	public ArrayList<MoveListener> getMesListeners() {
		return mesListeners;
	}

	public void setMesListeners(ArrayList<MoveListener> mesListeners) {
		this.mesListeners = mesListeners;
	}
	
	public void addMoveListener(MoveListener eListener) {
		this.mesListeners.add(eListener);
	}
	
	public void removeMoveListener(MoveListener eListener) {
		this.mesListeners.remove(eListener);
	}
	
	public void generateMoveEvent(Robot robot, String direction) {
		MoveEvent e = new MoveEvent(this, robot, direction);
		for(MoveListener eListener:mesListeners) {
			eListener.onMoveEvent(e);
		}
	}
}
