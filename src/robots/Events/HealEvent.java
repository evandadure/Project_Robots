package robots.Events;

import java.util.EventObject;

public class HealEvent extends EventObject{
	// Un healEvent a comme donn�e une puissance de soin (nombre de points de vie � restaurer)
	private int heal;
	
	public int getHeal() {
		return heal;
	}

	public HealEvent(Object o, int heal) {
		super(o);
		this.heal = heal;
	}
}
