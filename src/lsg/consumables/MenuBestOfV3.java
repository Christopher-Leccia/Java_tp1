package lsg.consumables;

public class MenuBestOfV3 extends MenuBestOfV2 {

	/**
	 * Constructeur
	 */
	public MenuBestOfV3() {
		super();

	}

	/**
	 * Surcharge de la méthode toString() Permet d'afficher le contenu du tableau
	 * (menu)
	 */
	@Override
	public String toString() {

		String display = "";
		int index = 1;

		for (Consumable consumable : getMenu()) {
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
		System.out.println(new MenuBestOfV3().toString());
	}

}
