package lsg.consumables.repair;

import lsg.consumables.Consumable;
import lsg.weapons.Weapon;

public class RepairKit extends Consumable {

	/**
	 * Constructeur
	 */
	public RepairKit() {
		super("Repair Kit", 10, Weapon.DURABILITY_STAT_STRING);

	}

	/**
	 * Surcharge de la m�thode M�thode permttant l'utilisation d'un kit de
	 * r�paration
	 */
	@Override
	public int use() {
		int capacity = this.getCapacity();
		this.setCapacity(capacity - 1);
		return 1;
	}

}
