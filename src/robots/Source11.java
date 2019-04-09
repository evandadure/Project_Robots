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
	
	public void addEvent1Listener(MoveListener eListener) {
		this.mesListeners.add(eListener);
	}
	
	public void removeEvent1Listener(MoveListener eListener) {
		this.mesListeners.remove(eListener);
	}
	
	public void generateEvent1(String direction) {
		MoveEvent e = new MoveEvent(direction);
		for(MoveListener eListener:mesListeners) {
			eListener.onMoveEvent(e);
		}
	}
}
