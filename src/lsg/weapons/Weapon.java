package lsg.weapons;

import lsg.bags.Collectible;
import lsg.consumables.repair.RepairKit;
import lsg.exceptions.ConsumeNullException;

public class Weapon implements Collectible {

	protected String name = new String();

	protected int minDamage;
	protected int maxDamage;
	protected int stamCost;
	protected int durability;

	public static final String DURABILITY_STAT_STRING = "DURABILITY";

	protected int weight = 2;

	/**
	 * Constructeur
	 * 
	 * @param name
	 * @param minDamage
	 * @param maxDamage
	 * @param stamCost
	 * @param durability
	 */
	public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.stamCost = stamCost;
		this.durability = durability;

	}

	/**
	 * Constructeur vide
	 */
	public Weapon() {

	}

	/**
	 * Getters / Setters
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getStamCost() {
		return stamCost;
	}

	public void setStamCost(int stamCost) {
		this.stamCost = stamCost;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public void use() {
		this.durability--;
	}

	/**
	 * Méthode retournant si l'arme est cassé ou non
	 * 
	 * @return
	 */
	public Boolean isBroken() {
		if (this.durability == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Méthode affichant les caractéristiques d'un arme
	 */
	public void printStatWeapon() {
		System.out.println(this.toString());

	}

	
	/**
	 * Surcharge de la méthode toString() Permttant l'affichage des caractéristiques
	 * d'une arme
	 */
	@Override
	public String toString() {
		return this.getName() + " (min:" + this.minDamage + " max:" + this.maxDamage + " stam:" + this.stamCost
				+ this.DURABILITY_STAT_STRING + " : " + this.durability + ")";
	}

	public void repairWith(RepairKit kit) throws ConsumeNullException {
		if (kit == null) {
			throw new ConsumeNullException(kit);
		} else {
			kit.use();
		}
	}

	
	/**
	 * Surcharge de la méthode pour renvoyer le poid d'une arme
	 */
	@Override
	public int getWeight() {

		return this.weight;
	}

}
