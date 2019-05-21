package robots.Events;

import java.util.EventObject;

public class AttackEvent extends EventObject{
	// Un attackEvent a comme donn�e une puissance d'attaque (nombre de dommages � infliger)
	private int damage;
	
	public int getDamage() {
		return damage;
	}

	public AttackEvent(Object o, int damage) {
		super(o);
		this.damage = damage;
	}
}
