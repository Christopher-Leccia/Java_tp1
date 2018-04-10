package lsg;

import java.util.Scanner;

import characters.Hero;
import characters.Monster;
import lsg.helpers.*;
import lsg.weapons.*;

public class LearningSoulsGame {
	
	Hero hero = new Hero ("Gurey");
	Monster monster = new Monster ("Ezechiel");
	
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dice diceRoll = new Dice(50);
		
		Hero hero1 = new Hero();
		Monster monster1 = new Monster();
		
		Sword weapon1 = new Sword("Buritzu blade", 7, 25, 20, 100);
		Sword weaponSword = new Sword();
		
		Sword monstweapon = new Sword("Stickity Stick", 5, 10, 25, 100);
		
		hero1.SetWeapon(new ShotGun());
		monster1.SetWeapon(new Sword("Stickity Stick", 5, 10, 25, 100));
		
		
		while (hero1.getCurrentStamina() > 0 && monster1.IsAlive() == true) {
			hero1.currentBattle(monster1);
		}
		
	}
	
	public void refresh() {
		
		this.hero.PrintStats();
		this.monster.PrintStats();
	}
	
	public String fight1v1() {
		while (this.hero.IsAlive() && this.monster.IsAlive()) {
			
		refresh();
		this.hero.currentBattle(this.monster);
		String str = scan.nextLine();
		
		refresh();
		this.monster.currentBattle(this.hero);
		str = scan.nextLine();
		
		}
		if (this.hero.IsAlive()) {
			return (this.hero.getName() + " won the battle !");
		}
		if (this.monster.IsAlive()) {
			return (this.monster.getName() + " won the battle !");
		}
	}
	
	public void init() {
		
	}

}
