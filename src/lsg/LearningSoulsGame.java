package lsg;

import java.util.Scanner;

import lsg.characters.*;
import lsg.helpers.*;
import lsg.weapons.*;
import lsg.armor.*;
import lsg.buffs.*;


public class LearningSoulsGame {
	
	Hero hero = new Hero ("Gurey", 100, 50);
	Monster monster = new Monster ("Mongrel", 100, 50);

	
	ArmorItem equip1 = new DragonSlayerLeggings();
	ArmorItem equip2 = new RingedKnightArmor();

	
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dice diceRoll = new Dice(50);
		
		new LearningSoulsGame().play_v3();
		
		
	}
	
	public void refresh() {
		
		this.hero.PrintStats();
		this.monster.PrintStats();

	}
	
	public int fight1v1() {
		while (this.hero.IsAlive() && this.monster.IsAlive()) {
			
		refresh();
		this.hero.currentBattle(this.monster);
		String str = scan.nextLine();
		
		if (!this.monster.IsAlive()) {
			System.out.println(this.hero.getName() + " won the battle !");
			return 0;
		}
		
		refresh();
		this.monster.currentBattle(this.hero);
		str = scan.nextLine();
		
		if (!this.hero.IsAlive()) {
			System.out.println(this.monster.getName() + " won the battle !");
			return 0;
		}
		
		}
		return 0;
		
	}
	
	public void init() {
		this.hero.setWeapon(new Sword ("Buritzu Blade", 20, 50, 5, 100));
		this.monster.setWeapon(new Claw("Rusty Claw", 15, 45, 5, 100));
	}
	
	public void play_v1() {
		init();
		fight1v1();
	}
	
	public void play_v2() {
		init();
		this.hero.setArmorItem(equip1, 1);
		this.hero.setArmorItem(equip2, 2);
		fight1v1();
	}
	
	public void play_v3() {
		init();
		this.hero.setArmorItem(equip1, 1);
		this.hero.setArmorItem(equip2, 2);
		this.monster = new Lycanthrope();
		fight1v1();
	}

}
