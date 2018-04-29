package lsg.buffs;

import java.util.Locale;

import lsg.bags.Collectible;

public abstract class BuffItem implements Collectible {

	private String name;

	protected int weight = 1;

	/**
	 * Constructeur
	 * 
	 * @param name
	 */
	public BuffItem(String name) {
		this.name = name;
	}

	public abstract float computeBuffValue();

	// Getter
	public String getName() {
		return name;
	}

	/**
	 * Surcharge de toString() pour afficher l'objet [ ring ou talisman ]
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "[%s, %.2f]", getName(), computeBuffValue());
	}

	/**
	 * Surcharge de getWeight()
	 */
	@Override
	public int getWeight() {

		return this.weight;
	}

}
