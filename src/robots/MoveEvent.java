package robots;

public class MoveEvent {
	private String direction;
	private Robot robot;
	
	public String getDirection() {
		return direction;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public MoveEvent(Robot robot,String direction) {
		super();
		this.direction = direction;
		this.robot = robot;
	}
	

}
