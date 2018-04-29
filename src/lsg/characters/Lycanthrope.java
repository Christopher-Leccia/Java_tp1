package lsg.characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster {

	/**
	 * Constructeur vide
	 */
	public Lycanthrope() {
		super("Lycanthrope", 250, 300);
		this.setSkinThickness(30);
		this.setWeapon(new Claw("Bloody Claw", 25, 30, 10, 100));
	}

}
