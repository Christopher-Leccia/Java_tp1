package lsg.exceptions;

import lsg.consumables.Consumable;

public class ConsumeNullException extends ConsumeException {

	/**
	 * Constructeur
	 * 
	 * @param consumable
	 */
	public ConsumeNullException(Consumable consumable) {
		super("Consumable is null !", consumable);
	}

}
