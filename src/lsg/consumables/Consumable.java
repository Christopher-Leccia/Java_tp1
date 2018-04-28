package lsg.consumables;

import lsg.bags.Collectible;

public class Consumable implements Collectible{
	
	private String name;
	private int capacity;
	private String stat;
	
	protected int weight = 1;
	
	public Consumable (String name, int capacity, String stat) {
		this.name = name;
		this.capacity = capacity;
		this.stat = stat;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getStat() {
		return stat;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}
	
	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}	
	
	@Override
	public String toString() {
		return this.name + " [" + this.capacity + " " + this.stat + " point(s) ]";
	}
	
	public int use() {
		int currentCapacity = this.getCapacity();
		this.setCapacity(0);
		return currentCapacity;
	}

	@Override
	public int getWeight() {
		
		return this.weight;
	}



}
