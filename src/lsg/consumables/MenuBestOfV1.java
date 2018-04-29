package lsg.consumables;

import lsg.consumables.food.*;
import lsg.consumables.drinks.*;

public class MenuBestOfV1 {

	private Consumable[] menu;

	/**
	 * Contructeur
	 */
	public MenuBestOfV1() {
		this.menu = new Consumable[5];

		this.menu[0] = new Hamburger();
		this.menu[1] = new Wine();
		this.menu[2] = new Americain();
		this.menu[3] = new Coffee();
		this.menu[4] = new Whisky();
	}

	/**
	 * Surcharge de la méthode toString() Permet d'afficher le contenu du tableau
	 * (menu)
	 */
	@Override
	public String toString() {

		String display = "";
		int index = 1;

		for (Consumable consumable : menu) {
			display += index + ": " + consumable.toString() + "\n";
			index++;
		}

		return display;
	}

	/**
	 * Main pour test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new MenuBestOfV1().toString());
	}

}
