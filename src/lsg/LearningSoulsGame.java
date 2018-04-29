package lsg;

import java.util.Scanner;

import lsg.characters.*;
import lsg.characters.Character;
import lsg.consumables.Consumable;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Hamburger;
import lsg.exceptions.ConsumeEmptyException;
import lsg.exceptions.ConsumeNullException;
import lsg.exceptions.ConsumeRepairNullWeaponException;
import lsg.exceptions.StaminaEmptyException;
import lsg.exceptions.WeaponBrokenException;
import lsg.exceptions.WeaponNullException;
import lsg.helpers.*;
import lsg.weapons.*;
import lsg.armor.*;
import lsg.bags.*;
import lsg.buffs.rings.*;

public class LearningSoulsGame {

	public static final String BULLET_POINT = "\u2022";

	/**
	 * Instance des objets
	 */
	Hero hero = new Hero("Gurey", 100, 50);
	Monster monster = new Monster("Mongrel", 100, 50);
	Hero victim = new Hero("Victim", 100, 100);

	Character test = new Hero();
	Bag superBag = new MediumBag();

	ArmorItem equip1 = new DragonSlayerLeggings();
	ArmorItem equip2 = new RingedKnightArmor();

	Scanner scan = new Scanner(System.in);

	/**
	 * Main Principale permet de lancer le Jeu Learning Souls Game
	 * 
	 * @param args
	 * @throws WeaponNullException
	 * @throws ConsumeNullException
	 * @throws WeaponBrokenException
	 * @throws StaminaEmptyException
	 */
	public static void main(String[] args)
			throws WeaponNullException, ConsumeNullException, WeaponBrokenException, StaminaEmptyException {
		// TODO Auto-generated method stub

		LearningSoulsGame lsg = new LearningSoulsGame();
		lsg.init();
		lsg.testException();
		lsg.refresh();

	}

	/**
	 * Méthode affichant le titre du jeu
	 */
	public void title() {
		System.out.println("###########################");
		System.out.println("# THE LEARNING SOULS GAME #");
		System.out.println("###########################");

	}

	/**
	 * Méthode affichant des informations sur le jeu
	 */
	public void refresh() {

		this.hero.PrintStats();
		System.out.println(this.hero.armorToString());
		this.hero.printRing();
		this.hero.printConsumable();
		this.hero.printWeapon();
		this.hero.printBag();

		System.out.println("\n");
		this.monster.PrintStats();
		this.monster.printWeapon();

	}

	/**
	 * Méthodes permettant le combat contre 1 hero et 1 monstre
	 * 
	 * @return
	 * @throws WeaponNullException
	 * @throws WeaponBrokenException
	 * @throws StaminaEmptyException
	 * @throws ConsumeNullException
	 */
	public int fight1v1()
			throws WeaponNullException, WeaponBrokenException, StaminaEmptyException, ConsumeNullException {

		title();

		while (this.hero.IsAlive() && this.monster.IsAlive()) {

			boolean input = true;

			refresh();
			System.out.println("\nHero's action for next move : (1) Attack | (2) Consume > ");
			int action = scan.nextInt();

			while (input) {
				switch (action) {
				case 1:
					try {
						this.hero.currentBattle(this.monster);
					} catch (WeaponNullException e) {

						e.printStackTrace();
						System.out.println("No Weapon Equiped !!");
					} catch (WeaponBrokenException e) {

						e.printStackTrace();
						System.out.println("Weapon BROKEN !");
					} catch (StaminaEmptyException e) {

						e.printStackTrace();
						System.out.println("No STamina left !");
					}
					input = false;
					break;

				case 2:
					try {
						this.hero.consume();
					} catch (ConsumeNullException e) {

						e.printStackTrace();
						System.out.println("NO CONSUMABLE EQUIPED");
					} catch (ConsumeEmptyException e) {

						e.printStackTrace();
						System.out.println("ACTION HAS NO EFFECT: " + hero.getConsumable() + " is empty ! \n");
					} catch (ConsumeRepairNullWeaponException e) {

						e.printStackTrace();
						System.out.println("ACTION IMPOSSIBLE : no weapon has been equiped !\n");
					}
					input = false;
					break;

				default:
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
			try {
				this.monster.currentBattle(this.hero);
			} catch (WeaponNullException | WeaponBrokenException | StaminaEmptyException e) {

				e.printStackTrace();

			}

			if (!this.hero.IsAlive()) {
				System.out.println(this.monster.getName() + " won the battle !");
				return 0;
			}

		}
		return 0;

	}

	/**
	 * Méthode permttant d'équiper les characters
	 */
	public void init() {
		this.hero.setWeapon(new Sword("Buritzu Blade", 20, 50, 5, 100));
		this.monster.setWeapon(new Claw("Rusty Claw", 15, 45, 5, 100));

		this.hero.setConsumable(new Hamburger());
	}

	/**
	 * Permière méthode de jeu
	 * 
	 * @throws ConsumeNullException
	 * @throws WeaponNullException
	 * @throws WeaponBrokenException
	 * @throws StaminaEmptyException
	 */
	public void play_v1()
			throws ConsumeNullException, WeaponNullException, WeaponBrokenException, StaminaEmptyException {
		init();
		fight1v1();
	}

	/**
	 * Deuxième méthode de jeu
	 * 
	 * @throws ConsumeNullException
	 * @throws WeaponNullException
	 * @throws WeaponBrokenException
	 * @throws StaminaEmptyException
	 */
	public void play_v2()
			throws ConsumeNullException, WeaponNullException, WeaponBrokenException, StaminaEmptyException {
		init();
		this.hero.setArmorItem(equip1, 1);
		this.hero.setArmorItem(equip2, 2);
		fight1v1();
	}

	/**
	 * Troisième méthode jeu
	 * 
	 * @throws ConsumeNullException
	 * @throws WeaponNullException
	 * @throws WeaponBrokenException
	 * @throws StaminaEmptyException
	 */
	public void play_v3()
			throws ConsumeNullException, WeaponNullException, WeaponBrokenException, StaminaEmptyException {
		init();
		this.hero.setArmorItem(equip1, 1);
		monster = new Lycanthrope();
		hero.setRing(new DragonSlayerRing(), 1);
		hero.setRing(new RingOfDeath(), 2);
		fight1v1();
	}

	/**
	 * Création d'un hero epuiser pour le test de consommables
	 */
	public void createExhaustedHero() {
		this.victim.getHitWith(99);
		this.victim.setWeapon(new Weapon("BONER-KUN", 0, 0, 1000, 100));

		try {
			this.victim.attack();
		} catch (WeaponNullException e) {

			e.printStackTrace();
			System.out.println("No weapon equiped");
		} catch (WeaponBrokenException e) {

			e.printStackTrace();
			System.out.println("WEAPON BROKEN");
		} catch (StaminaEmptyException e) {

			e.printStackTrace();
			System.out.println("No Stamina left !");
		}

		this.victim.PrintStats();
	}

	/**
	 * Différent tests pour les exceptions
	 * 
	 * @throws WeaponNullException
	 * @throws ConsumeNullException
	 * @throws WeaponBrokenException
	 * @throws StaminaEmptyException
	 */
	public void testException()
			throws WeaponNullException, ConsumeNullException, WeaponBrokenException, StaminaEmptyException {
		this.hero.setWeapon(null);
		this.fight1v1();
	}

}
