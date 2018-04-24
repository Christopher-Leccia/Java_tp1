package lsg.characters;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;
import lsg.buffs.rings.Ring;

public class Hero extends Character{
	
	private ArmorItem[] armor;
	private Ring[] ring;
	
	private final int MAX_ARMOR_PIECE = 3;
	private final int MAX_RING_PIECE = 2;
	
	public static void main (String[] args) {
		Hero javaIllusionist = new Hero("JavaIllusionist", 100, 100);
		ArmorItem equip1 = new DragonSlayerLeggings();
		
		javaIllusionist.setArmorItem(equip1, 1);
		
		System.out.println(javaIllusionist.armorToString());
	}
	
	//Constructors
	public Hero (String name, int maxLife, int maxStamina) {
		super(name);
		this.maxLife = maxLife;
		this.life = maxLife;
		this.maxStamina = maxStamina;
		this.stamina = maxStamina;
		this.armor = new ArmorItem[this.MAX_ARMOR_PIECE];
		this.ring = new Ring[this.MAX_RING_PIECE];
		
		for (int i = 0; i < armor.length; i++) {
			this.armor[i] = new ArmorItem();
		}
	}
	
	public Hero () {
		super();
		name = "Ynovator";
		life = 100;
		maxLife = 100;
		stamina = 50;
		maxStamina = 50;
		armor = new ArmorItem[this.MAX_ARMOR_PIECE];
		ring = new Ring[this.MAX_RING_PIECE];
		
		for (int i = 0; i < armor.length; i++) {
			this.armor[i] = new ArmorItem();
		}
	}

	public float setArmorItem(ArmorItem armorPiece, int slot) {
		if (slot < 0 || slot > this.MAX_ARMOR_PIECE) {
			return 0;
		}
		
		this.armor[slot - 1] = armorPiece;
		return armor[slot - 1].getArmorValue();
		
	}
	
	public float getTotalArmor() {
		return this.armor[0].getArmorValue() + this.armor[1].getArmorValue() + this.armor[2].getArmorValue();
	}
	
	public String armorToString() {
		String slot1;
		String slot2;
		String slot3;
		
		slot1 = this.armor[0].getArmorValue() != 0 ? this.armor[0].toString() : "empty";
		slot2 = this.armor[1].getArmorValue() != 0 ? this.armor[1].toString() : "empty";
		slot3 = this.armor[2].getArmorValue() != 0 ? this.armor[2].toString() : "empty";
		
		return String.format("%-30s", "ARMOR  1: " + slot1) + String.format("%-30s", " 2: " + slot2) + String.format("%-30s", " 3: " + slot3) + String.format("%-30s", " TOTAL : " + this.getTotalArmor());
	}
	
	public ArmorItem[] getArmorItem() {
		ArmorItem[] heroArmor = new ArmorItem[0];
		
		for (int i = 0; i < armor.length; i++) {
			if (armor[i].getArmorValue() != 0) {
				heroArmor[i] = armor[i];
			}
		}
		
		return heroArmor;
	}


	public float computeProtection() {
		
		return this.getTotalArmor();
	}

	public void setRing(Ring r, int i) {
		
		this.ring[i] = r;
		
	}
	
	
}
