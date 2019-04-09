package robots;

import java.util.EventObject;

public class MoveEvent extends EventObject{
	private String direction;
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public MoveEvent(Robot robot,String direction) {
		super(robot);
		this.direction = direction;
	}
	

}
