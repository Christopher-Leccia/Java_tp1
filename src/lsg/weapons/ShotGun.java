package lsg.weapons;

public class ShotGun extends Weapon {

	/**
	 * Constructeur
	 * 
	 * @param name
	 * @param minDamage
	 * @param maxDamage
	 * @param stamCost
	 * @param durability
	 */
	public ShotGun(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		super(name, minDamage, maxDamage, stamCost, durability);

	}

	/**
	 * Constructeur vide
	 */
	public ShotGun() {
		super();
		this.name = "Basic ShotGun";
		this.minDamage = 6;
		this.maxDamage = 20;
		this.stamCost = 5;
		this.durability = 100;

	}

}
