package robots.Events;

import java.util.EventObject;

public class AttackEvent extends EventObject{
	private int damage;
	
	public int getDamage() {
		return damage;
	}

	public AttackEvent(Object o, int damage) {
		super(o);
		this.damage = damage;
	}
}
