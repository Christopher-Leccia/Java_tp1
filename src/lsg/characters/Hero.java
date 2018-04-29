package lsg.characters;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;
import lsg.bags.Collectible;
import lsg.buffs.rings.Ring;
import lsg.exceptions.NoBagException;

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
		ArmorItem[] displayArmor;
		int j = 0;
		
		for (int i = 0; i < MAX_ARMOR_PIECE; i++) {
			if (this.armor[i] != null) {
				j++;
			}
		}
		displayArmor = new ArmorItem[j];
		j = 0;
		
		for (int i = 0; i < MAX_RING_PIECE; i++) {
			if (this.armor[i] != null) {
				displayArmor[j] = this.armor[i];
				j++;
			}
		}
		
		return displayArmor;
	}

	@Override
	public float computeProtection() {
		
		return this.getTotalArmor();
	}

	public float setRing(Ring ringEquiped, int slot) {
		
		if (slot < 0 || slot > this.MAX_RING_PIECE) {
			return 0;
		}
		
		this.ring[slot - 1] = ringEquiped;
		ringEquiped.setHero(this);
		return ring[slot - 1].computeBuffValue();
		
	}
	
	public Ring[] getRings() {
		Ring[] displayRing;
		int j = 0;
		
		for (int i = 0; i < MAX_RING_PIECE; i++) {
			if (this.ring[i] != null) {
				j++;
			}
		}
		displayRing = new Ring[j];
		j = 0;
		
		for (int i = 0; i < MAX_RING_PIECE; i++) {
			if (this.ring[i] != null) {
				displayRing[j] = this.ring[i];
				j++;
			}
		}
		
		return displayRing;
		}
	
	@Override
	public float computeBuff() {
		float totalBuff = 0;
		for (Ring r : this.ring) {
			if (r != null) {
				totalBuff += r.computeBuffValue();
			}
		}
		return totalBuff;
	}	

	
	public void equip(ArmorItem item, int slot) throws NoBagException {
		Collectible[] items = this.getBagItems();
		
		for (int i = 0; i < items.length; i++) {
			if (items[i] == item) {
				if (this.setArmorItem(item, slot) != 0) {
					this.pullOut(items[i]);
					System.out.println(this.getName() + " pulls out " + item.toString() + " and equips it !");
				}	
			}
		}
	}
	
	public void equip(Ring ring, int slot) throws NoBagException {
		Collectible[] items = this.getBagItems();
		
		for (int i = 0; i < items.length; i++) {
			if (items[i] == ring) {
				if (this.setRing(ring, slot) != 0) {
					this.pullOut(items[i]);
					System.out.println(this.getName() + " pulls out " + ring.toString() + " and equips it !");
				}	
			}
		}
	}
	
	public String ringToString() {
		String slot1;
		String slot2;
		
		
		slot1 = this.ring[0] != null ? this.ring[0].toString() : "empty";
		slot2 = this.ring[1] != null ? this.ring[1].toString() : "empty";
		
		return String.format("%-30s", "RINGS  1: " + slot1) + String.format("%-30s", " 2: " + slot2);
	}
	
	public void printRing() {
		System.out.println(this.ringToString());
	}
	
}
