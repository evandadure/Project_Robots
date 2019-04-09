package robots;

public class Listener1 implements Event1Listener{
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void onEventGauche(EventGauche e) {
		System.out.println("je vais à gauche");
	}

	
	public void onEventDroite(EventDroite e) {
		System.out.println("je vais à droite");
	}
}
