package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible{
	
	protected String name;
	protected float armorValue = 0;
	protected int weight = 4;
	
	//Constructor
	
	public ArmorItem(String name, float armorValue) {
		this();
		this.name = name;
		this.armorValue = armorValue;	

	}
	
	public ArmorItem() {
		this.armorValue = 0;
		this.name = "empty";
	}
	
	//Getters
	public String getName() {
		return name;
	}

	public float getArmorValue() {
		return armorValue;
	}


	public String toString() {
		return this.name + "(" + this.armorValue + ")";
	}

	@Override
	public int getWeight() {
		
		return this.weight;
	}
	
	
}