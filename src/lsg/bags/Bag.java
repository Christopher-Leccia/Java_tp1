package lsg.bags;

import java.util.HashSet;

import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Hamburger;
import lsg.exceptions.BagFullException;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

public class Bag {
	
	private int capacity;
	private int weight;
	
	private HashSet<Collectible> items = new HashSet<Collectible>();
	
	//Constructor
	public Bag(int capacity) {
		this.capacity = capacity;
	}
	
	//Getters
	public int getCapacity() {
		return capacity;
	}

	public int getWeight() {
		return weight;
	}
	
	
	public void push(Collectible item) throws BagFullException {
		if (item.getWeight() <= this.getCapacity() - this.getWeight()) {
			this.items.add(item);
			this.weight += item.getWeight();
		} 
		else {
			System.out.println("Trop lourd !!");
		}
		
	}
	
	public Collectible pop(Collectible item) {
		if (contains(item)) {
			this.items.remove(item);
			this.weight -= item.getWeight();
			return item;
		} 
		else {
			return null;
		}
	}
	
	public boolean contains(Collectible item) {
		if (this.items.contains(item)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Collectible[] getItems() {
		
		Collectible[] bagContent = new Collectible[this.capacity];
		int i = 0;
		
		for (Collectible collectible : this.items) {
			bagContent[i] = collectible;
			i++;
		}
		return bagContent;
	}
	
	@Override
	public String toString() {

        int count = 0;
        String bodyContent = "";
        
        Collectible[] content = this.getItems();
        
        for (int j = 0; j < content.length; j++) {
           if (content[count] != null) {
        	   bodyContent += content[count].toString() + " [ " + content[count].getWeight() + " kg ]\n";
               count ++;
           }
        }

        if (count == 0) {
            return this.getClass().getSimpleName() + " [ empty | " + this.getWeight() + "/" + this.getCapacity() + " kg ]";
        } 
        else {
            String headTitle = this.getClass().getSimpleName() + " [ "+ count +" items | " + this.getWeight() + "/" + this.getCapacity() + " kg ]\n";
            return headTitle += bodyContent;
        }
    }
	
	public static void transfert(Bag from, Bag into) throws BagFullException {
		Collectible[] contentFrom = from.getItems();
		
		if (from == null || into ==null) {
			return;
		}
		
		for (int i = 0; i < contentFrom.length; i++) {
			if (contentFrom[i] != null) {
				if (contentFrom[i].getWeight() <= into.getCapacity() - into.getWeight()) {
					try {
						into.push(contentFrom[i]);
					} catch (BagFullException e) {
						
						e.printStackTrace();
					}
					from.pop(contentFrom[i]);
				}
			}
		}
	}

	/**
	 * Main permettant les tests sur Bag
	 * @param args no use
	 * @throws BagFullException 
	 */
	
	public static void main(String[] args) throws BagFullException {
		Bag bag = new Bag(10);
		Bag biggerBag = new MediumBag();
		
		DragonSlayerLeggings dsl = new DragonSlayerLeggings();
		ArmorItem bwv = new BlackWitchVeil();
		Hamburger hbg = new Hamburger();
		Wine win = new Wine();
		
		Weapon sword = new Sword();
		
		biggerBag.push(dsl);
		biggerBag.push(hbg);
		biggerBag.push(sword);
		biggerBag.push(bwv);
		biggerBag.push(win);

		System.out.println(biggerBag.pop(hbg));
		System.out.println(biggerBag.toString());
		
		//Bag.transfert(biggerBag, bag);
		
		//System.out.println(biggerBag.toString());
		//System.out.println(bag.toString());
		
		
	}



}
