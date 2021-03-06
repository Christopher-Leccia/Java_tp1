package lsg.characters;

import lsg.weapons.Weapon;
import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
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

	public Character (String name) {
		this();
		this.name = name;

	}
	
	public Character () {
		dice = new Dice(101);

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
	
	private int attackWith(Weapon weapon) {
		
		double damageOutPut = 0;
		
		if (weapon.isBroken()) {
			return 0;
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
	
	public int attack() {
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
	
	public void currentBattle (Character monster) {
		int damage = this.attack();
		int damageReduced = monster.getHitWith(damage);
	
		
		System.out.println("\n!!! " + this.name + " attack " + monster.name + " with " + this.getWeapon() + " !!! ->" + " ATTACK : " + damage + " | " + "DAMAGES : "  + damageReduced);
		System.out.println(monster.name + " remaining life : " + monster.getCurrentLife());
	}
	
	public abstract float computeProtection();
	public abstract float computeBuff();
	
	private int drink(Drink drink) {
		
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
	
	private int eat(Food food) {
		
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
	
	public void use(Consumable consumable) {
		
		if (consumable instanceof Drink) {
			this.drink((Drink) consumable);
		}
		if (consumable instanceof RepairKit) {
			this.repairWeaponWith((RepairKit) consumable);
		}
		if (consumable instanceof Food) {
			this.eat((Food) consumable);
		}
	}
	
	private void repairWeaponWith(RepairKit kit) {
		
		System.out.println(this.name + " rapairs " + this.getWeapon().toString() + " with " + kit.toString());
		this.getWeapon().setDurability(this.getWeapon().getDurability() + kit.use());
		
	}
	
	public void consume() {
		
		this.use(this.getConsumable());
	}
	
		
}
