package lsg.weapons;

public class Claw extends Weapon {

	/**
	 * Constructeur
	 * 
	 * @param name
	 * @param minDamage
	 * @param maxDamage
	 * @param stamCost
	 * @param durability
	 */
	public Claw(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		super(name, minDamage, maxDamage, stamCost, durability);

	}

	/**
	 * Constructeur vide
	 */
	public Claw() {
		super();
		this.name = "Bloddy Claw";
		this.minDamage = 50;
		this.maxDamage = 150;
		this.stamCost = 5;
		this.durability = 100;

	}

}
