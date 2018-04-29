package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible {

	protected String name;
	protected float armorValue = 0;
	protected int weight = 4;

	/**
	 * Constructeur
	 * 
	 * @param name
	 * @param armorValue
	 */

	public ArmorItem(String name, float armorValue) {
		this();
		this.name = name;
		this.armorValue = armorValue;

	}

	/**
	 * Constructeur vide
	 */
	public ArmorItem() {
		this.armorValue = 0;
		this.name = "empty";
	}

	/**
	 * Getters
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public float getArmorValue() {
		return armorValue;
	}

	@Override
	public int getWeight() {

		return this.weight;
	}

	/**
	 * Surcharge de la méthode toString() pour afficher les caractéristique d'une
	 * armure
	 */
	@Override
	public String toString() {
		return this.name + "(" + this.armorValue + ")";
	}

}
