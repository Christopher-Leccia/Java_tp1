package lsg.consumables;

public class MenuBestOfV3 extends MenuBestOfV2{
	
	public MenuBestOfV3() {
		super();

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
		System.out.println(new MenuBestOfV3().toString());
	}
	

}
