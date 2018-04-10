package lsg.weapons;

public class Weapon {
	
	protected String name = new String();
	
	protected int minDamage;
	protected int maxDamage;
	protected int stamCost;
	protected int durability;
	
	public Weapon (String name, int minDamage, int maxDamage, int stamCost, int durability) {
		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.stamCost = stamCost;
		this.durability = durability;

	}
	
	public Weapon () {
		
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMaxDamage() {
		return maxDamage;
	}
	
	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}
	
	public int getMinDamage() {
		return minDamage;
	}
	
	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}
	
	public int getStamCost() {
		return stamCost;
	}
	
	public void setStamCost(int stamCost) {
		this.stamCost = stamCost;
	}
	
	public int getDurability() {
		return durability;
	}
	
	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	public void use() {
		this.durability--;
	}
	
	public Boolean isBroken() {
		if (this.durability == 0) {
			return true;
		}
		else
			return false;
	}
	
	public void printStatWeapon() {
		System.out.println(this.toString());
		
	}
	
	public String toString() {
		return this.name + " (min:" + this.minDamage + " max:" + this.maxDamage + " stam:" + this.stamCost + " dur:" + this.durability + ")";
	}
	
	

}
