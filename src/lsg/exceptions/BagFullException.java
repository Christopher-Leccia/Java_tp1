package lsg.exceptions;

import lsg.bags.Bag;

public class BagFullException extends Exception {

	private Bag bagFull;

	/**
	 * Constructeur
	 * 
	 * @param bag
	 */
	public BagFullException(Bag bag) {
		super(bag.getClass().getSimpleName() + "is full !");
		this.bagFull = bag;
	}

	/**
	 * Retourne une execption si le bag est plain (full)
	 * 
	 * @return
	 */
	public Bag getBagFull() {
		return this.bagFull;
	}
}
