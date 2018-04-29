package lsg.consumables.food;

import lsg.consumables.Consumable;
import lsg.characters.Character;

public class Food extends Consumable {

	/**
	 * Contructeur
	 * 
	 * @param name
	 * @param capacity
	 */
	public Food(String name, int capacity) {
		super(name, capacity, Character.LIFE_STAT_STRING);

	}

}
