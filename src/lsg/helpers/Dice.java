package lsg.helpers;

import java.util.*;

public class Dice {
	
	protected int faces;
	protected Random random = new Random();
	
	//Getters
	public int getFaces() {
		return faces;
	}
	
	//Setters
	public void setFaces(int faces) {
		this.faces = faces;
	}
	
	
	//Methods
	public Dice (int nbFaces) {
		this.faces = nbFaces;
		
	}
	
	public int roll() {
		return random.nextInt(faces);
	}
	
	public void roll500() {
		int i;
		int min = 0;
		int max = 0;
		for (i = 1; i < 501; i++) {
			int var = random.nextInt(this.faces);
			if (var == 0) {
				min = var;
			}
			if (var == this.faces - 1) {
				max = var;
			}
			
		}
		
		System.out.println("Min : " + min);
		System.out.println("Max : " + max);
	}

}
