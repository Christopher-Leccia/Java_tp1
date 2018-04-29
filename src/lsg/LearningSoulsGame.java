package lsg;

import java.util.Scanner;

import lsg.characters.*;
import lsg.consumables.Consumable;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.food.Hamburger;
import lsg.helpers.*;
import lsg.weapons.*;
import lsg.armor.*;
import lsg.buffs.rings.*;


public class LearningSoulsGame {
	
	public static final String BULLET_POINT = "\u2219";
	
	Hero hero = new Hero ("Gurey", 100, 50);
	Monster monster = new Monster ("Mongrel", 100, 50);
	Hero victim = new Hero("Victim", 100 , 100);

	
	ArmorItem equip1 = new DragonSlayerLeggings();
	ArmorItem equip2 = new RingedKnightArmor();

	
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dice diceRoll = new Dice(50);
		
		LearningSoulsGame lsg = new LearningSoulsGame();
		lsg.title();
		lsg.play_v3();;
		
		
	}
	
	public void refresh() {
		
		this.hero.PrintStats();
		System.out.println(this.BULLET_POINT + this.hero.getWeapon().toString());
		System.out.println(this.BULLET_POINT + this.hero.getConsumable().toString());
		this.monster.PrintStats();

	}
	
	public int fight1v1() {
		while (this.hero.IsAlive() && this.monster.IsAlive()) {
			
			boolean input = true;
			
		refresh();
		System.out.println("\nHero's action for next move : (1) Attack | (2) Consume > ");
		int action = scan.nextInt();
		
		while (input) {
			switch (action) {
			case 1:
				this.hero.currentBattle(this.monster);
				input = false;
				break;
			
			case 2:
				this.hero.consume();
				input = false;
				break;
		
			default :
				System.out.println("\nHero's action for next move : (1) Attack | (2) Consume > ");
				action = scan.nextInt();
				break;
			}
		}
		
		if (!this.monster.IsAlive()) {
			System.out.println(this.hero.getName() + " won the battle !");
			return 0;
		}
		
		refresh();
		this.monster.currentBattle(this.hero);
		
		
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
		
		this.hero.setConsumable(new Hamburger());
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
		monster = new Lycanthrope();
		hero.setRing(new DragonSlayerRing(), 1);
		hero.setRing(new RingOfDeath(), 2);
		fight1v1();
	}
	
	public void createExhaustedHero() {
		this.victim.getHitWith(99);
		this.victim.setWeapon(new Weapon("BONER-KUN", 0, 0, 1000, 100));
		this.victim.attack();
		this.victim.PrintStats();
	}
	
	public void aTable() {
		MenuBestOfV4 consumingObject = new MenuBestOfV4();
		for (Consumable consumable : consumingObject.getMenu()) {
			this.victim.use(consumable);
			this.victim.PrintStats();
			System.out.println("After use : " + consumable.toString());
		}
		victim.getWeapon().printStatWeapon();
	}
	
	public void title() {
		System.out.println("###########################");
		System.out.println("# THE LEARNING SOULS GAME #");
		System.out.println("###########################");
		
	}

}
