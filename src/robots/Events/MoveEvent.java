package robots.Events;

import java.util.EventObject;

import robots.Structure.Field;

public class MoveEvent extends EventObject{
	// Un moveEvent a comme donn�es une direction et le field dans lequel sont contenus les robots (contenant lui-m�me les positions de tous les autres robots)
	private String direction;
	private Field field;
	
	public String getDirection() {
		return direction;
	}
	
	public Field getField() {
		return field;
	}

	public MoveEvent(Object o, String direction, Field field) {
		super(o);
		this.direction = direction;
		this.field = field;
	}
}
