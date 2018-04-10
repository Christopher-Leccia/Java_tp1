package lsg;

import characters.Hero;
import characters.Monster;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public class LearningSoulsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		Hero hero1 = new Hero("Gurey");
		Hero hero2 = new Hero();
		
		Monster monster1 = new Monster("Etudiator");
		Monster monster2 = new Monster();
		Monster monster3 = new Monster();
		
		Dice diceRoll = new Dice(50);
		
		Weapon weapon1 = new Weapon("Buritzu Sword", 7, 25, 20, 100);
		Weapon weaponSword = new Weapon();
		
		Weapon monstweapon = new Weapon("Stickity Stick", 5, 10, 25, 100);
		
		/*hero1.PrintStats();
		hero2.PrintStats();
		
		monster1.PrintStats();
		monster2.PrintStats();
		monster3.PrintStats();
		
		diceRoll.roll500();
		
		weapon1.printStatWeapon();
		weaponSword.printStatWeapon();*/
		
		for (i = 0; i < 10; i++) {
			hero1.PrintStats();
			hero1.attackWith(weapon1);
			monster1.PrintStats();
			monster1.attackWith(weapon1);
		}
		
		//hero1.attackWith(weaponSword);
		
	}

}
