package lsg.consumables;

import lsg.consumables.food.*;
import lsg.consumables.drinks.*;
import java.util.LinkedHashSet;

public class MenuBestOfV2 {

	private LinkedHashSet<Consumable> menu = new LinkedHashSet<Consumable>();

	/**
	 * Constructeur
	 */
	public MenuBestOfV2() {

		this.menu.add(new Hamburger());
		this.menu.add(new Wine());
		this.menu.add(new Americain());
		this.menu.add(new Coffee());
		this.menu.add(new Whisky());

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
	 * Retroune le contenu du menu
	 * 
	 * @return
	 */
	public LinkedHashSet<Consumable> getMenu() {
		return this.menu;
	}

	/**
	 * Main pour test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new MenuBestOfV2().toString());
	}

}
