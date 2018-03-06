package characters;

public class Monster {
	//Variables
		private String name = new String();
		private static int INSTANCES_COUNT = 1;
			
		private int life;
		private int maxLife;
		private int stamina;
		private int maxStamina;
		
		//Constructors
		public Monster (String name) {
			this();
			this.name = name;
			
		}
		
		public Monster () {
			name = "YMonster_" + INSTANCES_COUNT++;
			life = 10;
			maxLife = 10;
			stamina = 10;
			maxStamina = 10;
	
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
			if (this.IsAlive() == true) {
			return "[ Monster ]\t" + this.name + "\tLIFE:" + this.life + "\tSTAMINA:" + this.stamina + "\t(ALIVE)";
			}
			return "[ Monster ]\t" + this.name + "\tLIFE:" + this.life + "\tSTAMINA:" + this.stamina + "\t(DEAD)";
		}
			
		public Boolean IsAlive() {
			return this.getCurrentLife() > 0;
		}
	
		
}
