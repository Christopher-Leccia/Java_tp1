package lsg.exceptions;

import lsg.consumables.Consumable;

public abstract class ConsumeException extends Exception {

	private Consumable consumable;

	/**
	 * Constructeur
	 * 
	 * @param message
	 * @param consumable
	 */
	public ConsumeException(String message, Consumable consumable) {
		this.consumable = consumable;

	}

	/**
	 * Retourn le consomable
	 * 
	 * @return
	 */
	public Consumable getConsumable() {
		return this.consumable;
	}

}
