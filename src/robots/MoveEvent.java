package robots;

public class MoveEvent {
	private String direction;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public MoveEvent(String direction) {
		super();
		this.direction = direction;
	}
	

}
