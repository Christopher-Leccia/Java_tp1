package lsg.weapons;

public class ShotGun extends Weapon {
		
	public ShotGun(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		super(name, minDamage, maxDamage, stamCost, durability);
		

	}
	
	public ShotGun() {
		super();
		this.name = "Basic ShotGun";
		this.minDamage = 6;
		this.maxDamage = 20;
		this.stamCost = 5;
		this.durability = 100;

	}

}
