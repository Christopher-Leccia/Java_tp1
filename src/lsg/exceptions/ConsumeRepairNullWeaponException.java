package lsg.exceptions;

import lsg.consumables.Consumable;

public class ConsumeRepairNullWeaponException extends ConsumeException {

	/**
	 * Constructeur
	 * 
	 * @param consumable
	 */
	public ConsumeRepairNullWeaponException(Consumable consumable) {
		super("Trying to repair null weapon !", consumable);
	}

}
