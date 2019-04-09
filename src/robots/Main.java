package robots;

public class Main {

	public static void main(String[] args) {
		Flotte myFlotte = new Flotte();
		Robot robot1 = new Robot(1,1,1);
		Robot robot2 = new Robot(4,1,2);
		myFlotte.addRobot(robot1);
		myFlotte.addRobot(robot2);
		
		for (Robot r : myFlotte.getRobotsList()) {
			System.out.println(r.getIdRobot() +" " +r.getPosX() + " " + r.getPosY());
		}
		
		Source11 source = new Source11();
		source.addEvent1Listener(new FlotteListener());

		source.generateEvent1(robot1, "droite");
		source.generateEvent1(robot1, "droite");
		source.generateEvent1(robot2, "bas");
		source.generateEvent1(robot2, "gauche");
		
		for (Robot r : myFlotte.getRobotsList()) {
			System.out.println(r.getIdRobot() +" " +r.getPosX() + " " + r.getPosY());
		}
	}

}
