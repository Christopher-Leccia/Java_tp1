package lsg.armor;

import lsg.bags.Collectible;

public class DragonSlayerLeggings extends ArmorItem implements Collectible {

	/**
	 * Constructeur
	 */
	public DragonSlayerLeggings() {
		super();
		this.name = "Dragon Slayer Leggings";
		this.armorValue = 10.2f;
		this.weight = 3;
	}

	/**
	 * Renvoie le poid de DragonSlayerLeggings
	 */
	@Override
	public int getWeight() {

		return this.weight;
	}

}
