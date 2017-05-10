package hello;

import hello.Foods.Food;
import hello.Pets.Pet;
import hello.Toys.Toy;

import java.util.ArrayList;

public class Player {

	//this is a comment
	public String PlayerName;
	int MoneyBalance = 100;
	int NumberOfPets;
	ArrayList<Pet> playerPets = new ArrayList<Pet>();
	ArrayList<Food> foodInventory = new ArrayList<Food>();
	ArrayList<Toy> toyInventory = new ArrayList<Toy>();
	int score = 0;
	
	
	/**
	 * Constructs player
	 * Account balance initialized to 100
	 * @param playerName Player name from input
	 */

	public Player(String playerName) {

		PlayerName = playerName;

	}

	public String getPlayerName() {
		return PlayerName;
	}

	public int getMoneyBalance() {
		return MoneyBalance;
	}
	public void setNumberOfPets(int number){
		NumberOfPets = number;
	}
	public boolean setMoneyBalance(int amount) {
		//need to check if there is enough money
		//should maybe be subtract MoneyBalance?
        if (MoneyBalance > amount) {
            MoneyBalance -= amount;
            return true;
        }
		return false;
	}

	public void addToFoodInventory(Food food) {
		foodInventory.add(food);
	}

	public void addToToyInventory(Toy toy) {
		toyInventory.add(toy);
	}

	public void printFood() {

		System.out.println("Food:");
		int counter = 1;
		for (Food food: foodInventory) {
			System.out.println(counter + ". " + food);
			counter ++;
		}
	}

	public void printToys() {

		System.out.println("Toys:");
		int counter = 1;
		for (Toy toy: toyInventory) {
			System.out.println(counter + ". " + toy);
			counter ++;
		}
	}

//	//Do we need the same methods for food and toys???????
//	public boolean purchaseFood() {
//
//	}

	public void printInventory() {
		printFood();
		printToys();
	}

	public void scoreDay() {

		for (Pet pet: playerPets) {
			int dailyScore = pet.getEnergy() + pet.getHappiness() + pet.getHunger() + pet.getToiletNeed();
			score += dailyScore;
		}
	}

	/**
	 * @return	String representation of player
	 * @Override
	 */
	public String toString() {
		String returnString = "";
		
		returnString += "Player name: " + PlayerName + "\n";
		returnString += "Account balance: " + MoneyBalance + "\n";
		returnString += "Your pets are:\n";
		for (Pet i : playerPets) {
			returnString += i + "\n\n";
		}
		
		return returnString;
	}
	
}
