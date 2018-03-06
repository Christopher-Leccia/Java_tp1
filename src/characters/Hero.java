package characters;

public class Hero extends Character{
	
	//Variables
	
	//Constructors
	public Hero (String name) {
		this();
		this.name = name;

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
