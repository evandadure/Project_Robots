package robots.Events;

import java.util.EventObject;

public class HealEvent extends EventObject{
	private int heal;
	
	public int getHeal() {
		return heal;
	}

	public HealEvent(Object o, int heal) {
		super(o);
		this.heal = heal;
	}
}
