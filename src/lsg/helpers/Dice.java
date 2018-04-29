package lsg.helpers;

import java.util.*;

public class Dice {

	protected int faces;
	protected Random random = new Random();

	/**
	 * Constructeur
	 * 
	 * @param nbFaces
	 */
	public Dice(int nbFaces) {
		this.faces = nbFaces;

	}

	/**
	 * Getters
	 */
	public int getFaces() {
		return faces;
	}

	/**
	 * Setters
	 */
	public void setFaces(int faces) {
		this.faces = faces;
	}

	/**
	 * Méthode retournant le nombre que le dé à donné
	 * 
	 * @return
	 */
	public int roll() {
		return random.nextInt(faces);
	}

	/**
	 * Méthode lançant un dé a 500 face
	 */
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
