package lsg;

import characters.Hero;
import characters.Monster;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public class LearningSoulsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero hero1 = new Hero("Gurey");
		Hero hero2 = new Hero();
		
		Monster monster1 = new Monster("Etudiator");
		Monster monster2 = new Monster();
		Monster monster3 = new Monster();
		
		Dice diceRoll = new Dice(50);
		
		Weapon weapon1 = new Weapon("Buritzu Sword", 5, 10, 20, 100);
		
		hero1.PrintStats();
		hero2.PrintStats();
		
		monster1.PrintStats();
		monster2.PrintStats();
		monster3.PrintStats();
		
		diceRoll.roll500();
		
		weapon1.printStatWeapon();
		
		
	}

}
