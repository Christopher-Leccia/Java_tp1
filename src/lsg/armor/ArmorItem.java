package lsg.armor;

public class ArmorItem {
	
	protected String name;
	protected float armorValue = 0;
	
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
	
	
}
