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
	 * Surcharge de la méthode Méthode permttant l'utilisation d'un kit de
	 * réparation
	 */
	@Override
	public int use() {
		int capacity = this.getCapacity();
		this.setCapacity(capacity - 1);
		return 1;
	}

}
