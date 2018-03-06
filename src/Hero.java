
public class Hero {
	
	//Variables
	private String name = new String();
		
	
	private int life;
	private int maxLife;
	private int stamina;
	private int maxStamina;
	
	//Constructors
	public Hero (String name) {
		this.name = name;
		life = 100;
		maxLife = 100;
		stamina = 50;
		maxStamina = 50;
	}
	
	public Hero () {
		name = "Ynovator";
		life = 100;
		maxLife = 100;
		stamina = 50;
		maxStamina = 50;
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
	
	//Methods
		public void PrintStats() {
			System.out.println(this.toString());
		}
		
		public String toString() {
			return "[ Hero ]\t" + this.name + "\tLIFE:" + this.life + "\tSTAMINA:" + this.stamina;
		}
	
	
}
