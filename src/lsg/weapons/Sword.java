package lsg.weapons;

public class Sword extends Weapon {
		
	public Sword(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		super(name, minDamage, maxDamage, stamCost, durability);
		

	}
	
	public Sword() {
		super();
		this.name = "Basic Sword";
		this.minDamage = 5;
		this.maxDamage = 10;
		this.stamCost = 20;
		this.durability = 100;

	}

}
