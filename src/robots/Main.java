package robots;

public class Main {

	public static void main(String[] args) {
		Flotte myFlotte = new Flotte();
		Robot robot1 = new Robot(1,1);
		Robot robot2 = new Robot(4,1);
		myFlotte.addRobot(robot1);
		myFlotte.addRobot(robot2);
		
		Source11 source = new Source11();
		source.addEvent1Listener(new FlotteListener());
		source.addEvent1Listener(new FlotteListener());
		source.addEvent1Listener(new FlotteListener());
		source.generateEvent1("droite");
	}

}
