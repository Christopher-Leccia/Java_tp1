package lsg.buffs.rings;

import lsg.buffs.BuffItem;
import lsg.characters.Hero;

public abstract class Ring extends BuffItem {

	protected int power;
	protected Hero hero;

	/**
	 * Constructeur de Ring
	 * 
	 * @param name
	 * @param power
	 */
	public Ring(String name, int power) {
		super(name);
		this.power = power;
	}

	/**
	 * Equipe ring sur le héro
	 * 
	 * @param hero
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * Récupère le héro
	 * 
	 * @return
	 */
	public Hero getHero() {
		return hero;
	}

}
