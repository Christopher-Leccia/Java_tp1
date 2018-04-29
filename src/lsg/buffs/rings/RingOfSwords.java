package lsg.buffs.rings;

import lsg.characters.Hero;
import lsg.weapons.Sword;

public class RingOfSwords extends Ring {

	public RingOfSwords() {
		super("Ring of Swords", 10);
	}

	/**
	 * Surcharge la méthode Si le héro possède une épée il possède alors le pouvoir
	 * de cet anneau
	 */
	@Override
	public float computeBuffValue() {
		if (hero != null && (hero.getWeapon() instanceof Sword))
			return power;
		else
			return 0f;

	}

	/**
	 * Un test...
	 * 
	 * @param args
	 *            non utilisé
	 */
	public static void main(String[] args) {
		Hero hero = new Hero();
		RingOfSwords r = new RingOfSwords();
		hero.setRing(r, 1);
		hero.setWeapon(new Sword());
		System.out.println(r);
	}
}
