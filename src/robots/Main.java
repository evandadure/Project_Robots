package robots;

public class Main {

	public static void main(String[] args) {
		Flotte myFlotte = new Flotte(6,6);
		Robot robot1 = new RobotLent(1);
		Robot robot2 = new RobotRapide(2);
		myFlotte.addRobot(robot1, 1,1);
		myFlotte.addRobot(robot2, 3,1);
		
		for (Robot r : myFlotte.getRobotsList()) {
			System.out.println(r.getIdRobot() +" " +r.getPosX() + " " + r.getPosY());
		}
		
		ControleFlotte source = new ControleFlotte();
		source.addMoveListener(myFlotte);

		source.generateMoveEvent(robot2, "gauche");
		
		for (Robot r : myFlotte.getRobotsList()) {
			System.out.println(r.getIdRobot() +" " +r.getPosX() + " " + r.getPosY());
		}
	}

}
