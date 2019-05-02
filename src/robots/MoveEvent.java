package robots;

import java.util.EventObject;

public class MoveEvent extends EventObject{
	private String direction;
	
	public String getDirection() {
		return direction;
	}

	public MoveEvent(Object o, String direction) {
		super(o);
		this.direction = direction;
	}
}
