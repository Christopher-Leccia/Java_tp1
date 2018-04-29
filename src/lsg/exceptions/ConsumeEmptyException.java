package lsg.exceptions;

import lsg.consumables.Consumable;

public class ConsumeEmptyException extends ConsumeException {

	/**
	 * Constructeur
	 * 
	 * @param consumable
	 */
	public ConsumeEmptyException(Consumable consumable) {
		super("Consumable is empty !", consumable);
	}

}
