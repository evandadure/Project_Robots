package robots;

import java.util.EventObject;

public class MoveEvent extends EventObject{
	private String direction;
	private Robot robot;
	
	public String getDirection() {
		return direction;
	}

	public Robot getRobot() {
		return robot;
	}

	public MoveEvent(Object o, Robot robot, String direction) {
		super(o);
		this.robot = robot;
		this.direction = direction;
	}
	

}
