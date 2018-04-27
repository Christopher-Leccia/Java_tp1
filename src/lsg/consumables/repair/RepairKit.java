package lsg.consumables.repair;

import lsg.consumables.Consumable;
import lsg.weapons.Weapon;

public class RepairKit extends Consumable {

	public RepairKit() {
		super("Repair Kit", 10, Weapon.DURABILITY_STAT_STRING);
		
	}
	
	public int use() {
		int capacity = this.getCapacity();
		this.setCapacity(capacity - 1);
		return 1;
	}

}
