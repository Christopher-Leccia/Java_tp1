package lsg.exceptions;

import lsg.weapons.Weapon;

public class WeaponBrokenException extends Exception {

	private Weapon weaponBroke;

	/**
	 * Constructeur
	 * 
	 * @param weapon
	 */
	public WeaponBrokenException(Weapon weapon) {
		super(weapon.getName() + "is broken !");
		this.weaponBroke = weapon;

	}

	/**
	 * Retorunune exception si l'amrme est cassée
	 * 
	 * @return
	 */
	public Weapon getWeaponBroke() {
		return this.weaponBroke;
	}

}
