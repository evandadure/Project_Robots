package robots;

public class Main {

	public static void main(String[] args) {
		Flotte myFlotte = new Flotte(6,6);
		Robot robot1 = new RobotLent(1);
		Robot robot2 = new RobotRapide(2);
		myFlotte.addRobot(robot1, 0,1);
		myFlotte.addRobot(robot2, 3,1);
		
		for (Robot r : myFlotte.getRobotsList()) {
			System.out.println(r.getIdRobot() +" " +r.getPosX() + " " + r.getPosY());
		}
		
		ControleFlotte source = new ControleFlotte();
		source.addMoveListener(myFlotte);

		source.generateMoveEvent(robot2, "gauche");
		source.generateMoveEvent(robot1, "haut");
		
		System.out.println("robot 2"+robot2.getIdRobot() +" " +robot2.getPosX() + " " + robot2.getPosY());
		
		
		source.generateMoveEvent(robot2, "gauche");
		source.generateMoveEvent(robot2, "gauche");
		source.generateMoveEvent(robot1, "haut");
		source.generateMoveEvent(robot1, "haut");
		source.generateMoveEvent(robot1, "haut");
		source.generateMoveEvent(robot1, "haut");
		source.generateMoveEvent(robot1, "haut");
		source.generateMoveEvent(robot1, "haut");
		source.generateMoveEvent(robot2, "droite");
		source.generateMoveEvent(robot2, "haut");
		
		for (Robot r : myFlotte.getRobotsList()) {
			System.out.println(r.getIdRobot() +" " +r.getPosX() + " " + r.getPosY());
		}
	}

}
