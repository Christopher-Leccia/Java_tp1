package characters;

public class Hero extends Character{
	
	//Constructors
	public Hero (String name, int maxLife, int maxStamina) {
		super(name);
		this.maxLife = maxLife;
		this.life = maxLife;
		this.maxStamina = maxStamina;
		this.stamina = maxStamina;

	}
	
	public Hero () {
		super();
		name = "Ynovator";
		life = 100;
		maxLife = 100;
		stamina = 50;
		maxStamina = 50;
	}
	
}
