package robots;

import java.util.ArrayList;

import robots.Events.AttackEvent;
import robots.Events.HealEvent;
import robots.Events.MoveEvent;
import robots.Listeners.AllyListener;
import robots.Listeners.EnnemyListener;
import robots.Listeners.MoveListener;
import robots.Structure.Field;
import robots.Structure.Robot;
import robots.Structure.RobotLent;
import robots.Structure.RobotRapide;

public class ControleRobots {
	// Cette classe est l'unique source des Events de notre application.
	
	private ArrayList<MoveListener> myMoveListeners = new ArrayList<MoveListener>();
	private ArrayList<AllyListener> myAllyListeners = new ArrayList<AllyListener>();
	private ArrayList<EnnemyListener> myEnnemyListeners = new ArrayList<EnnemyListener>();
	private Field currentField;
	
	public Field getCurrentField(){
		return this.currentField;
	}
	
	public void setMyAllyListeners(ArrayList<AllyListener> myAllyListeners) {
		this.myAllyListeners = myAllyListeners;
	}

	public void setMyEnnemyListeners(ArrayList<EnnemyListener> myEnnemyListeners) {
		this.myEnnemyListeners = myEnnemyListeners;
	}

	public ControleRobots(Field field) {
		this.currentField = field;
	}
	
	public void addMoveListener(MoveListener eListener) {
		this.myMoveListeners.add(eListener);
	}
	
	public void removeMoveListener(MoveListener eListener) {
		this.myMoveListeners.remove(eListener);
	}
	
	public void generateMoveEvents(String direction) {
		// Methode pour g�n�rer des moveEvents selon une direction.
		MoveEvent evMove = new MoveEvent(this, direction,currentField);
		for(MoveListener eListener:myMoveListeners) {
			eListener.onMoveEvent(evMove);
			// A la fin d'un mouvement, chaque listener (robot) d�plac� va attaquer ou soigner s'il est � port�e d'autres robots :
			Robot currentMovingRobot = (Robot)eListener;
			if(currentMovingRobot.getClass()==RobotLent.class || currentMovingRobot.getClass()==RobotRapide.class)
				// g�n�re un AttackEvent si le robot est un robot lent ou rapide (robots offensifs)
				generateAttackEvents(currentMovingRobot.getPower());
			else
				// g�n�re un HealEvent si le robot est un robot soigneur
				generateHealEvents(currentMovingRobot.getPower());
		}
	}
	
	public void generateAttackEvents(int damage) {
		// Methode pour g�n�rer des attackEvents selon un nombre de dommages
		for(EnnemyListener eListener:myEnnemyListeners) {
			AttackEvent evAttack = new AttackEvent(this, damage);
			eListener.onAttackEvent(evAttack);
		}
	}
	
	public void generateHealEvents(int heal) {
		// Methode pour g�n�rer des healEvents selon une puissance de soin
		for(AllyListener eListener:myAllyListeners) {
			HealEvent evHeal = new HealEvent(this, heal);
			eListener.onHealEvent(evHeal);
		}
	}
}
