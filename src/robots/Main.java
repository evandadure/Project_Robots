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
		
		ControleFlotte source = new ControleFlotte();
		source.addMoveListener(myFlotte);

		source.generateMoveEvent(robot1, "droite");
		source.generateMoveEvent(robot1, "droite");
		source.generateMoveEvent(robot2, "bas");
		source.generateMoveEvent(robot2, "gauche");
		
		for (Robot r : myFlotte.getRobotsList()) {
			System.out.println(r.getIdRobot() +" " +r.getPosX() + " " + r.getPosY());
		}
	}

}
