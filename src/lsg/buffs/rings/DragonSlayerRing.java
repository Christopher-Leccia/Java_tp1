package lsg.buffs.rings;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;

public class DragonSlayerRing extends Ring {

	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14);
	}

	
	/**
	 * Surcharge de la méthode pour l'objet actuel
	 */
	@Override
	public float computeBuffValue() {
		if (hero != null && hasDragonsSlayerItem()) {
			return power;
		} else
			return 0;
	}

	/**
	 * Méthode vérifiant si le héros possède un armoItem de type
	 * DragonSlayerLeggings
	 * 
	 * @return
	 */
	private boolean hasDragonsSlayerItem() {
		ArmorItem[] items = hero.getArmorItem();
		for (ArmorItem item : items) {
			if (item instanceof DragonSlayerLeggings)
				return true;
		}
		return false;
	}

}
