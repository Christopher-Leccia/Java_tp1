package characters;

import lsg.weapons.Weapon;
import lsg.helpers.Dice;

public abstract class Character {
	
	protected String name = new String();
	
	protected int life;
	protected int maxLife;
	protected int stamina;
	protected int maxStamina;
	
	protected Dice dice;
	protected Weapon weapon;
	
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
		
	public void SetWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
		
	public String toString() {
		if (this.IsAlive() == true) {
		return String.format("%-20s", "[" + this.getClass().getSimpleName() + "]") + String.format("%-20s", this.name) + "LIFE:" + String.format("%-20s", this.life) + "STAMINA:" + String.format("%-20s", this.stamina) + "(ALIVE)";
		}
		return String.format("%-20s", "[" + this.getClass().getSimpleName() + "]") + String.format("%-20s", this.name) + "LIFE:" + String.format("%-20s", this.life) + "STAMINA:" + String.format("%-20s", this.stamina) + "(DEAD)";
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
		
		lifeRemaining = getCurrentLife() - damage;
		
		lifeRemaining = lifeRemaining < 0 ? 0 : lifeRemaining;
		this.setLife(lifeRemaining);
		
		return lifeRemaining;
	}
	
	public void currentBattle (Character monster) {
		int damage = this.attack();
		monster.getHitWith(damage);
		
		System.out.println("!!! " + this.name + " attack " + monster.name + " with " + this.getWeapon() + " !!! ->" + " DAMAGES : " + damage);
		System.out.println(monster.name + " remaining life : " + monster.getCurrentLife());
	}
	
	public abstract float computeProtection();
	
		
}
