package lsg.bags;

import lsg.armor.DragonSlayerLeggings;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.food.Hamburger;
import lsg.exceptions.BagFullException;

public class SmallBag extends Bag {

	public SmallBag() {
		super(10);

	}

	/**
	 * main permettant de tester le sac
	 * 
	 * @param args
	 * @throws BagFullException
	 */
	public static void main(String[] args) throws BagFullException {
		SmallBag baggy = new SmallBag();
		DragonSlayerLeggings dsl = new DragonSlayerLeggings();

		baggy.push(dsl);
		baggy.push(new Whisky());
		baggy.push(new Hamburger());

		System.out.println(baggy.toString());

		baggy.pop(dsl);
		System.out.println("POP on DragonSlayer Leggings\n");

		System.out.println(baggy.toString());
	}

}
