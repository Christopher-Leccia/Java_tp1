package lsg.consumables;

import lsg.consumables.repair.RepairKit;

public class MenuBestOfV4 extends MenuBestOfV2{
	
	public MenuBestOfV4() {
		super();
		
		this.getMenu().add(new RepairKit());

	}
	
	public String toString() {
		
		String display = "";
		int index = 1;
		
		for (Consumable consumable : getMenu()) {
			display += index + ": " + consumable.toString() + "\n";
			index++;
		}
		
		return display;
	}
	
	public static void main(String[] args) {
		System.out.println(new MenuBestOfV4().toString());
	}
	

}
