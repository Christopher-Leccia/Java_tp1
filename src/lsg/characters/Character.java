package lsg.characters;

import lsg.weapons.Weapon;
import lsg.bags.Bag;
import lsg.bags.Collectible;
import lsg.bags.SmallBag;
import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
import lsg.exceptions.BagFullException;
import lsg.exceptions.ConsumeEmptyException;
import lsg.exceptions.ConsumeNullException;
import lsg.exceptions.ConsumeRepairNullWeaponException;
import lsg.exceptions.NoBagException;
import lsg.exceptions.StaminaEmptyException;
import lsg.exceptions.WeaponBrokenException;
import lsg.exceptions.WeaponNullException;
import lsg.helpers.Dice;

public abstract class Character {
	
	protected String name = new String();
	
	protected int life;
	protected int maxLife;
	protected int stamina;
	protected int maxStamina;
	
	protected Dice dice;
	protected Weapon weapon;
	
	public static final String LIFE_STAT_STRING = "LIFE ";
	public static final String STAM_STAT_STRING = "STAMINA ";
	public static final String PROTECTION_STAT_STRING = "PROTECTION ";
	public static final String BUFF_STAT_STRING = "BUFF ";
	
	private Consumable consumable;
	
	private Bag bag;

	public Character (String name) {
		this();
		this.name = name;

	}
	
	public Character () {
		dice = new Dice(101);
		this.bag = new SmallBag();
	}
	
	//Getters
	public String getName() {
		return name;
	}
			
	public int getCurrentLife() {
		return life;
	}
			
	public int getMaxLife() {
		return maxLife;
	}
			
	public int getCurrentStamina() {
		return stamina;
	}
			
	public int getMaxStamina() {
		return maxStamina;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public Consumable getConsumable() {
		return consumable;
	}
			
	//Setters
	public void setName(String name) {
		this.name = name;
	}
			
	public void setLife(int life) {
		this.life = life;
	}
			
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
			
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
			
	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}
	
	public void PrintStats() {
		System.out.println(this.toString());
	}
		
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void setConsumable(Consumable consumable) {
		this.consumable = consumable;
	}
	
	@Override	
	public String toString() {
		if (this.IsAlive() == true) {
		return String.format("%-20s", "[" + this.getClass().getSimpleName() + "]") + String.format("%-20s", this.name) + this.LIFE_STAT_STRING + String.format("%-20s", this.life) + this.STAM_STAT_STRING + String.format("%-20s", this.stamina) + this.PROTECTION_STAT_STRING + String.format("%-20s", this.computeProtection()) + this.BUFF_STAT_STRING + String.format("%-20s", this.computeBuff()) + "(ALIVE)";
		}
		return String.format("%-20s", "[" + this.getClass().getSimpleName() + "]") + String.format("%-20s", this.name) + this.LIFE_STAT_STRING + String.format("%-20s", this.life) + this.STAM_STAT_STRING + String.format("%-20s", this.stamina) + this.PROTECTION_STAT_STRING + String.format("%-20s", this.computeProtection()) + this.BUFF_STAT_STRING + String.format("%-20s", this.computeBuff()) + "(DEAD)";
	}
		
	public Boolean IsAlive() {
		if (this.getCurrentLife() > 0) {
			return true;
		}
		else {
			return false;
		}

	}
	
	private int attackWith(Weapon weapon) throws WeaponNullException, WeaponBrokenException, StaminaEmptyException {
		
		if (this.getWeapon() == null) {
			throw new WeaponNullException();
		}
		
		double damageOutPut = 0;
		
		if (weapon.isBroken()) {
			throw new WeaponBrokenException(weapon);
		}
		
		if (this.getCurrentStamina() <= 0) {
			throw new StaminaEmptyException();
		}
	
		int diceDamage = (this.dice.roll() * (weapon.getMaxDamage() - weapon.getMinDamage()) / 100);
		int damage = (weapon.getMinDamage() + Math.round(diceDamage));
		
		if (this.stamina < weapon.getStamCost()) {
			damageOutPut = damage *((double)this.stamina / (double)weapon.getStamCost());
			damage = (int)damageOutPut;	
		}
		
		float buffedDamage = (float) ((this.computeBuff() / 100) * damage);
		damage += (int) buffedDamage;
		
		weapon.setDurability(weapon.getDurability() - 1);
		this.stamina -= weapon.getStamCost();
		
		if (this.stamina < 0) {
			this.stamina = 0;
		}
		
		return damage;
	}
	
	public int attack() throws WeaponNullException, WeaponBrokenException, StaminaEmptyException {
		int characterAttack;
		
		characterAttack = attackWith(this.getWeapon());
		
		return characterAttack;
	}
	
	public int getHitWith (int damage) {
		int lifeRemaining;
		
		int sauce = damage * Math.round(this.computeProtection()) / 100;
		int damageReduced = damage - sauce;
		
		lifeRemaining = this.getCurrentLife() - damageReduced;
		
		lifeRemaining = lifeRemaining < 0 ? 0 : lifeRemaining;
		this.setLife(lifeRemaining);
		
		return damageReduced;
	}
	
	public void currentBattle (Character monster) throws WeaponNullException, WeaponBrokenException, StaminaEmptyException {
		int damage = this.attack();
		int damageReduced = monster.getHitWith(damage);
	
		
		System.out.println("\n!!! " + this.name + " attack " + monster.name + " with " + this.getWeapon() + " !!! ->" + " ATTACK : " + damage + " | " + "DAMAGES : "  + damageReduced);
		System.out.println(monster.name + " remaining life : " + monster.getCurrentLife());
	}
	
	public abstract float computeProtection();
	public abstract float computeBuff();
	
	
	private int drink(Drink drink) throws ConsumeNullException, ConsumeEmptyException {
		
		if (drink == null) {
			throw new ConsumeEmptyException(drink);
		}
		else {
			System.out.println(this.name + " drinks " + drink);
		
			int preRecover = this.getCurrentStamina();
			int recoverPower = drink.use();
			if (preRecover + recoverPower > this.getMaxStamina()) {
				this.setStamina(this.getMaxStamina());
				int temp1 = (preRecover + recoverPower) - this.getMaxStamina();
				return recoverPower - temp1;
			}
		
			this.setStamina(this.getCurrentStamina() + recoverPower);
		
			return recoverPower;
		}
	}
	
	private int eat(Food food) throws ConsumeNullException, ConsumeEmptyException {
		
		if (food == null) {
			throw new ConsumeEmptyException(food);
		}
		else {
			System.out.println(this.name + " eats " + food);
		
			int preHeal = this.getCurrentLife();
			int healPower = food.use();
			if (preHeal + healPower > this.getMaxLife()) {
				this.setLife(this.getMaxLife());
				int temp2 = (preHeal + healPower) - this.getMaxLife();
				return healPower - temp2;
			}
		
			this.setLife(this.getCurrentLife() + healPower);
		
			return healPower;
		}
	}
	
	public void use(Consumable consumable) throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException {
		
		if (consumable == null) {
			throw new ConsumeNullException(consumable);
		}
		else {
		
			if (consumable instanceof Drink) {
				this.drink((Drink) consumable);
			}
			if (consumable instanceof RepairKit) {
				try {
					this.repairWeaponWith((RepairKit) consumable);
				} catch (WeaponNullException e) {
				
					throw new ConsumeRepairNullWeaponException(consumable);
				}
			}
			if (consumable instanceof Food) {
				this.eat((Food) consumable);
			}
		}
	}
	
	private void repairWeaponWith(RepairKit kit) throws WeaponNullException {
		
		if (this.getWeapon() == null) {
			throw new WeaponNullException();
		}
		
		System.out.println(this.name + " rapairs " + this.getWeapon().toString() + " with " + kit.toString());
		this.getWeapon().setDurability(this.getWeapon().getDurability() + kit.use());
		
	}
	
	public void consume() throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException {
		
		this.use(this.getConsumable());
	}
	
	public void pickUp(Collectible item) throws NoBagException, BagFullException {
		if (item.getWeight() <= this.bag.getCapacity() - this.bag.getWeight()) {
			this.bag.push(item);
			System.out.println(this.getName() + " picked up " + item.toString());
		} 

	}
	
	public Collectible pullOut(Collectible item) throws NoBagException {
		Collectible pull = this.bag.pop(item);
		if (pull != null) {
			System.out.println(this.getName() + " pulls out " + item.toString());
			return pull;
		}
		
		return null;
	}
	
	public void printBag() {
		System.out.println(this.bag.toString());
	}
	
	public int getBagCapacity() {
		return this.bag.getCapacity();
	}
	
	public int getBagWeight() throws NoBagException {
		return this.bag.getCapacity() - this.bag.getWeight(); 
	}
	
	public Collectible[] getBagItems() throws NoBagException {
		return this.bag.getItems();
	}
	
	public Bag setBag(Bag bag) throws BagFullException {
		try {
			Bag.transfert(this.bag, bag);
		} catch (BagFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bag previousBag = this.bag;
		this.bag = bag;
		
		System.out.println(this.name + " change " + previousBag.getClass().getSimpleName() + " to " + this.bag);
		return previousBag;
	}
	
	public void equip(Weapon weapon) throws NoBagException {
		if (this.bag.pop(weapon) != null) {
			this.setWeapon(weapon);
			System.out.println(this.getName() + " pulls out " + weapon.toString() + " and equips it !");
		}
		
	}
	
	public void equip(Consumable consumable) throws NoBagException {
		if (this.bag.pop(consumable) != null) {
			this.setConsumable(consumable);
			System.out.println(this.getName() + " pulls out " + consumable.toString() + " and equips it !");
		}
	}
	
	private Consumable fastUseFirst(Class<? extends Consumable> type) throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException, NoBagException {
		Consumable consumed = null;
		String doing = "";
		
		for (Collectible vrac : bag.getItems()) {
						
			if (type.isInstance(vrac)) {
				this.use((Consumable) vrac);
				
				if (vrac instanceof Food) {
					doing = " eats ";
				}
				if (vrac instanceof Drink) {
					doing = " drinks ";
				}
				if (vrac instanceof RepairKit) {
					doing = " repairs ";
				}
				
				System.out.println(this.getName() + doing + vrac.toString());
				
				if (((Consumable) vrac).getCapacity()<=0)
					try {
						this.pullOut(vrac);
					} catch (NoBagException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				consumed = (Consumable) vrac;
			}
		}
		return consumed;
	}
	
	public Drink fastDrink() throws ConsumeNullException, ConsumeEmptyException, NoBagException {
		Drink returnValue = null;
		try {
			return (Drink)this.fastUseFirst(Drink.class);
		} catch (ConsumeRepairNullWeaponException e) {
			
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public Food fastEat() throws ConsumeNullException, ConsumeEmptyException, NoBagException {
		Food returnValue = null;
		try {
			return (Food)this.fastUseFirst(Food.class);
		} catch (ConsumeRepairNullWeaponException e) {
			
			e.printStackTrace();
		}
		
		return returnValue;
	}
	
	public RepairKit fastRepair() throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException, NoBagException {
		
		return (RepairKit)this.fastUseFirst(RepairKit.class);
		
	}
	
	public void printConsumable() {
		System.out.println("CONSUMABLES : " + this.getConsumable());
	}
	
	public void printWeapon() {
		System.out.println("WEAPON : " + this.getWeapon());
	}
}
