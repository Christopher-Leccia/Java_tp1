package lsg.exceptions;

import lsg.weapons.Weapon;

public class WeaponBrokenException extends Exception{
	
	private Weapon weaponBroke;
	
	public WeaponBrokenException(Weapon weapon) {
		super(weapon.getName() + "is broken !");
		this.weaponBroke = weapon;
		
	}

	public Weapon getWeaponBroke() {
		return this.weaponBroke;
	}
	
	

}
