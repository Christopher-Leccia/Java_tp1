package lsg.consumables;

import lsg.consumables.food.*;
import lsg.consumables.drinks.*;
import java.util.LinkedHashSet;

public class MenuBestOfV2 {
	
	
	private LinkedHashSet<Consumable> menu = new LinkedHashSet<Consumable>();
	
	public MenuBestOfV2() {
		
		this.menu.add(new Hamburger());
		this.menu.add(new Wine());
		this.menu.add(new Americain());
		this.menu.add(new Coffee());
		this.menu.add(new Whisky());	
		
	}
	
	public String toString() {
		
		String display = "";
		int index = 1;
		
		for (Consumable consumable : menu) {
			display += index + ": " + consumable.toString() + "\n";
			index++;
		}
		
		return display;
	}
	
	public LinkedHashSet<Consumable> getMenu() {
		return this.menu;
	}
	
	public static void main(String[] args) {
		System.out.println(new MenuBestOfV2().toString());
	}
	

}
