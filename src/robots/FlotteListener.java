package robots;

public class FlotteListener implements MoveListener{
	public void onMoveEvent(MoveEvent e) {
		System.out.println("je vais à "+e.getDirection());
	}
	
}
