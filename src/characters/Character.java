package characters;

public class Character {
	
	protected String name = new String();
	
	protected int life;
	protected int maxLife;
	protected int stamina;
	protected int maxStamina;
	
	public Character (String name) {
		this();
		this.name = name;
		
	}
	
	public Character () {

		
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
		
	public String toString() {
		if (this.IsAlive() == true) {
		return "[ " + this.getClass().getSimpleName() + " ]" + "\t" + this.name + "\tLIFE:" + this.life + "\tSTAMINA:" + this.stamina + "\t(ALIVE)";
		}
		return "[ " + this.getClass().getSimpleName() + " ]" + "\t" + this.name + "\tLIFE:" + this.life + "\tSTAMINA:" + this.stamina + "\t(DEAD)";
	}
		
	public Boolean IsAlive() {
		return this.getCurrentLife() > 0;
	}
		
}
