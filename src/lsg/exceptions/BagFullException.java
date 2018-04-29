package lsg.exceptions;

import lsg.bags.Bag;

public class BagFullException extends Exception {
	
	private Bag bagFull;

	public BagFullException(Bag bag) {
		super(bag.getClass().getSimpleName() + "is full !");
		this.bagFull = bag;
	}
	
	public Bag getBagFull() {
		return this.bagFull;
	}
}
