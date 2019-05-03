package robots;

import robots.Structure.Field;
import robots.Structure.Robot;

public class Main {

	public static void main(String[] args) {
		Field field = new Field(10,10);
		ControleRobots source = new ControleRobots(field);
		
		// ==========CARACTERISTIQUES DES ROBOTS==========
		//Robot Rapide : Vie 4, Portée 1, Dégats 2, Mouvements 3
		//Robot Lent : Vie 7, Portée 3, Dégats 4, Mouvements 1
		//Robot Healer : Vie 5, Portée 2, Heal 3, Mouvements 2
		
		
		// ==========COMPOSITION DU TERRAIN AU DEBUT==========
		//Le terrain fait 10x10 et les 0 sont en bas à gauche (cases numérotées de 0 à 9)
		//Flotte A : Rapide id2 (2,9) / Lent id1 (6,9) / Healer id3 (4,9)
		//Flotte B : Rapide id5 (7,0) / Lent id4 (3,0) / Healer id6 (5,0)
		
		for (Robot r : field.getRobotsList()) {
			System.out.println("- id : "+r.getIdRobot()+", posX : " +r.getPosX() +", posY : " + r.getPosY()+ ", vie : "+r.getLifePoints());
		}
		
		System.out.println("----------------------------");
		source.addMoveListener(field.getRobotById(5)); // seul le robot 5 (un robot rapide) se déplace (au début en 7,0)
		source.generateMoveEvents("haut");//7,3
		source.generateMoveEvents("haut");//7,6
		source.generateMoveEvents("haut");//7,9 (touche le robot 1 : lui enlève 2 PV)
		source.generateMoveEvents("gauche");//7,9 encore (touche le robot 1 : lui enlève 2 PV)
		source.generateMoveEvents("bas");//7,6
		source.generateMoveEvents("gauche");//4,6
		source.generateMoveEvents("haut");//4,8 (touche le robot 3 : lui enlève 2 PV)
		source.removeMoveListener(field.getRobotById(5));// le robot 5 n'est plus MoveListener
		source.addMoveListener(field.getRobotById(3));//le robot 3 (soigneur) devient MoveListener
		source.generateMoveEvents("droite");//5,9 : se colle au robot 1 et le soigne de 3 PV
		source.generateMoveEvents("haut");//5,9 encore : soigne le robot 1 de 3 PV
		

		
		for (Robot r : field.getRobotsList()) {
			System.out.println("- id : "+r.getIdRobot()+", posX : " +r.getPosX() +", posY : " + r.getPosY()+ ", vie : "+r.getLifePoints());
		}
	}

}
