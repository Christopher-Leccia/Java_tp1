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

	/**
	 * Constructeur
	 * 
	 * @param capacity
	 */
	public Bag(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Getters
	 * 
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	public int getWeight() {
		return weight;
	}

	/**
	 * M�thode r�cup�rant les objets du sac
	 * 
	 * @return
	 */
	public Collectible[] getItems() {

		Collectible[] bagContent = new Collectible[this.capacity];
		int i = 0;

		for (Collectible collectible : this.items) {
			bagContent[i] = collectible;
			i++;
		}
		return bagContent;
	}

	/**
	 * M�thode permettant d'ajouter un objet dans le sac
	 * 
	 * @param item
	 * @throws BagFullException
	 */
	public void push(Collectible item) throws BagFullException {
		if (item.getWeight() <= this.getCapacity() - this.getWeight()) {
			this.items.add(item);
			this.weight += item.getWeight();
		} else {
			System.out.println("Trop lourd !!");
		}

	}

	/**
	 * M�thode permettant d'enlever un item du sac
	 * 
	 * @param item
	 * @return
	 */
	public Collectible pop(Collectible item) {
		if (contains(item)) {
			this.items.remove(item);
			this.weight -= item.getWeight();
			return item;
		} else {
			return null;
		}
	}

	/**
	 * Methode pour savoir si une item est bien contenue dans le sac
	 * 
	 * @param item
	 * @return
	 */
	public boolean contains(Collectible item) {
		if (this.items.contains(item)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Surcharge de toString pour afficher le contenu du sac
	 */
	@Override
	public String toString() {

		int count = 0;
		String bodyContent = "";

		Collectible[] content = this.getItems();

		for (int j = 0; j < content.length; j++) {
			if (content[count] != null) {
				bodyContent += content[count].toString() + " [ " + content[count].getWeight() + " kg ]\n";
				count++;
			}
		}

		if (count == 0) {
			return this.getClass().getSimpleName() + " [ empty | " + this.getWeight() + "/" + this.getCapacity()
					+ " kg ]";
		} else {
			String headTitle = this.getClass().getSimpleName() + " [ " + count + " items | " + this.getWeight() + "/"
					+ this.getCapacity() + " kg ]\n";
			return headTitle += bodyContent;
		}
	}

	/**
	 * M�thode permettant le trasnfert du sac 'from' vers le sac 'into'
	 * 
	 * @param from
	 * @param into
	 * @throws BagFullException
	 */
	public static void transfert(Bag from, Bag into) throws BagFullException {
		Collectible[] contentFrom = from.getItems();

		if (from == null || into == null) {
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
	 * 
	 * @param args
	 *            no use
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

		// Bag.transfert(biggerBag, bag);

		// System.out.println(biggerBag.toString());
		// System.out.println(bag.toString());

	}

}
