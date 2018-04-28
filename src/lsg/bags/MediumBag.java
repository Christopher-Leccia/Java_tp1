package lsg.bags;

import lsg.armor.DragonSlayerLeggings;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.food.Hamburger;

public class MediumBag extends Bag{

	public MediumBag() {
		super(40);
		
	}
	
	public static void main(String[] args) {
		MediumBag bager = new MediumBag();
		DragonSlayerLeggings dsl = new DragonSlayerLeggings();
		
		bager.push(dsl);
		bager.push(new Whisky());
		bager.push(new Hamburger());
		
		System.out.println(bager.toString());
		
		bager.pop(dsl);
		System.out.println("POP on DragonSlayer Leggings\n");
		
		System.out.println(bager.toString());
	}


}
