package hello.Pets;

import hello.Foods.Food;
import hello.Toys.Toy;

import java.lang.Math;

public class Pet {
	
	String petName;
	String petGender;
	String petType = this.getClass().getSimpleName();

	/**
	 * Stats for pets, these start at 80 so that in the first turn
	 * actions will affect these statuses
	 * These each have a maximum value of 100
	 */
	int hunger = 80;
	int energy = 80;
	int happiness = 80;
	int toiletNeed = 80;

	boolean hasDied = false;
	boolean isdead = false;
	boolean isSick = false;
	boolean isMisbehaving = false;
	int turns = 2;

	//getters and setters yay
	int SLEEP_LOSS;    //These will be assigned by the subclass when instantiated
	int SLEEP_GAIN;
	int HUNGER_LOSS;
	int ROUGHNESS;
	String FAV_FOOD;
	String FAV_TOY;
	int weight;
	
	
	public Pet(String PetName, String genderChoice) {
		petName = PetName;
		petGender = genderChoice;
	}

	public String getName() {
		return petName;
	}

	public String getGender() {
		return petGender;
	}

	public String getType() {
		return petType;
	}

	public int getHunger() {
		return hunger;
	}

	public int getEnergy() {
		return energy;
	}

	public int getHappiness() {
		return happiness;
	}

	public int getToiletNeed() {
		return toiletNeed;
	}

	public int getTurns() {
		return turns;
	}

	public boolean getHasDied() {
		return hasDied;
	}

	public boolean getIsMisbehaving() {
		return isMisbehaving;
	}

	public int getSLEEP_LOSS() {
		return SLEEP_LOSS;
	}

	public int getSLEEP_GAIN() {
		return SLEEP_GAIN;
	}

	public int getHUNGER_LOSS() {
		return HUNGER_LOSS;
	}

	public int getROUGHNESS() {
		return ROUGHNESS;
	}

	public int getWeight() {
		return weight;
	}

	public void sleep(){

		energy = Math.min(energy + SLEEP_GAIN, 100);
		turns --;
	}

	/**
	 * Feeds selected food to current pet <p>
	 * Hunger stats increase, and happiness increases if the food is the pet
	 * types favourite food
	 *
	 * @param Food The type of food to be fed to the pet
	 */
	public void feed(Food Food) {

		if (Food.foodName == FAV_FOOD) {
			happiness = Math.min(happiness + 10, 100);
		}
		//Do pets get happiness from food that isn't their favourite?
		hunger = Math.min(hunger + Food.FEED_VALUE, 100);
		turns --;
	}

	/**
	 * javadoccccc
	 */
	public void useToilet() {

		toiletNeed = 100;
		turns --;
	}

	public void play(Toy toy) {

		if (toy.getToyName() == FAV_TOY) {
			happiness += 20;
		} else {
			happiness += 10;
		}
		turns --;
	}
		
	public void misbehave() {
		isMisbehaving = true;
	}

	public void discipline() {

		isMisbehaving = false;
		//Should happiness go down if they are already unhappy?
		happiness = Math.min(happiness, 45);
	}

	public void getSick() {
		isSick = true;
	}

	public void giveMedicine() {
		isSick = false;
	}

	public void die() {
		hasDied = true;
		//turns --;
	}

	public void revive() {
		turns --;
	}

	public void resetTurn() {
		turns = 2;
	}

	/**
	 * Prints info about the pet in the following format:
	 * <p>
	 * Pet name (pet type) <p>
	 * Gender: pet gender<p>
	 * Hunger: hunger level
	 */
	public String toString() {
		
		String returnString = "";
		returnString += petName + " (" + petType + ")" +"\n Gender: " + petGender
				+ "\n Hunger: " + hunger + "\n Energy: " + energy + "\n Toilet need: " + toiletNeed
				+ "\n Happiness: " + happiness + "\n Turns: " + turns;

		return returnString;
	}
	
}
