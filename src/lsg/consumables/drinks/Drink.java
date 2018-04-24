package lsg.consumables.drinks;

import lsg.consumables.Consumable;
import lsg.characters.*;
import lsg.characters.Character;


public class Drink extends Consumable{
	
	public int stat = Character.getCurrentStamina();
	
	public Drink(String name, int capacity, String stat) {
		super(name, capacity, stat);
		
	}

}
