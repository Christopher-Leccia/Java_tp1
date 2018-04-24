package lsg.characters;

import lsg.buffs.talismans.Talisman;

public class Monster extends Character{
	//Variables
		private static int INSTANCES_COUNT = 1;
		private float skinThickness = 20;
		private Talisman talisman;
			
		
		//Constructors
		public Monster (String name, int maxLife, int maxStamina) {
			super(name);
			this.maxLife = maxLife;
			this.life = maxLife;
			this.maxStamina = maxStamina;
			this.stamina = maxStamina;
			
		}
		
		public Monster () {
			super();
			name = "YMonster_" + INSTANCES_COUNT++;
			life = 10;
			maxLife = 10;
			stamina = 10;
			maxStamina = 10;
	
		}

		protected float getSkinThickness() {
			return skinThickness;
		}

		protected void setSkinThickness(float skinThickness) {
			this.skinThickness = skinThickness;
		}
		
		protected void setTalisman(Talisman talisman) {
			this.talisman = talisman;
		}


		public float computeProtection() {
			
			return skinThickness;
		}
		
		
}
