package lsg.consumables;

import lsg.bags.Collectible;
import lsg.exceptions.ConsumeEmptyException;

public class Consumable implements Collectible {

	private String name;
	private int capacity;
	private String stat;

	protected int weight = 1;

	/**
	 * Constructeur
	 * 
	 * @param name
	 * @param capacity
	 * @param stat
	 */
	public Consumable(String name, int capacity, String stat) {
		this.name = name;
		this.capacity = capacity;
		this.stat = stat;
	}

	/**
	 * Getters
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getStat() {
		return stat;
	}

	/**
	 * Setters
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Srucharge de la méthode toString() Permet l'affichage d'un consumable
	 */
	@Override
	public String toString() {
		return this.name + " [" + this.capacity + " " + this.stat + " point(s) ]";
	}

	/**
	 * Méthode permettant l'utilisation d'un consumable
	 * 
	 * @return
	 * @throws ConsumeEmptyException
	 */
	public int use() throws ConsumeEmptyException {
		if (this.getCapacity() == 0) {
			throw new ConsumeEmptyException(this);
		} else {
			int currentCapacity = this.getCapacity();
			this.setCapacity(0);
			return currentCapacity;
		}
	}

	/**
	 * Surcharge de la méthode retourne le poid d'un consumable
	 */
	@Override
	public int getWeight() {

		return this.weight;
	}

}
