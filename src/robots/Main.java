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
		
		ControleRobots source = new ControleRobots();
		
		source.addMoveListener(robot1);
		source.generateMoveEvent("gauche");
		
		source.removeMoveListener(robot1);
		source.addMoveListener(robot2);
		source.generateMoveEvent("haut");
		
		source.addMoveListener(robot1);
		source.generateMoveEvent("gauche");
		source.generateMoveEvent("droite");
		
		for (Robot r : myFlotte.getRobotsList()) {
			System.out.println(r.getIdRobot() +" " +r.getPosX() + " " + r.getPosY());
		}
	}

}
