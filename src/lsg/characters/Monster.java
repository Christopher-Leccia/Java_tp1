package lsg.characters;

import lsg.buffs.talismans.Talisman;

public class Monster extends Character {

	private static int INSTANCES_COUNT = 1;
	private float skinThickness = 20;
	private Talisman talisman;

	/**
	 * Constructeurs
	 */
	public Monster(String name, int maxLife, int maxStamina) {
		super(name);
		this.maxLife = maxLife;
		this.life = maxLife;
		this.maxStamina = maxStamina;
		this.stamina = maxStamina;

	}

	/**
	 * Constructeur vide
	 */
	public Monster() {
		super();
		name = "YMonster_" + INSTANCES_COUNT++;
		life = 10;
		maxLife = 10;
		stamina = 10;
		maxStamina = 10;

	}

	/**
	 * Getters
	 */
	protected float getSkinThickness() {
		return skinThickness;
	}

	public Talisman getTalisman() {
		return this.talisman;
	}

	/**
	 * Setters
	 */
	protected void setSkinThickness(float skinThickness) {
		this.skinThickness = skinThickness;
	}

	public void setTalisman(Talisman talisman) {
		this.talisman = talisman;
	}

	/**
	 * Surcharge de la méthode On renvoie l'armure totale pour la gestion de
	 * reduction de dégâts
	 */
	@Override
	public float computeProtection() {

		return this.getSkinThickness();
	}

	/**
	 * Surcharge de la méthode On renvoie la valeur des buffs pour l'augmentation
	 * des dégâts
	 */
	@Override
	public float computeBuff() {
		if (talisman != null) {
			return this.talisman.computeBuffValue();
		} else {
			return 0;
		}
	}

}
