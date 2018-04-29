package lsg.weapons;

public class Sword extends Weapon {

	/**
	 * Constructeur
	 * 
	 * @param name
	 * @param minDamage
	 * @param maxDamage
	 * @param stamCost
	 * @param durability
	 */
	public Sword(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		super(name, minDamage, maxDamage, stamCost, durability);

	}

	/**
	 * Constructeur vide
	 */
	public Sword() {
		super();
		this.name = "Basic Sword";
		this.minDamage = 5;
		this.maxDamage = 10;
		this.stamCost = 20;
		this.durability = 100;

	}

}
