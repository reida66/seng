package hello.Toys;

import hello.Pets.Pet;
import hello.Player;

public class Toy implements hello.purchasable{

	String toyName;
	int TOY_PRICE;
	int toyDurability;


	public Toy() {

	}

	//this is a comment
	public Toy(int toyNumber) {

		switch (toyNumber) {

			case 1:
				toyName = "Ball of wool";
				TOY_PRICE = 10;
				toyDurability = 10;
				break;
			case 2:
				toyName = "Chew toy";
				TOY_PRICE = 12;
				toyDurability = 13;
				break;
			case 3:
				toyName = "Ball";
				TOY_PRICE = 12;
				toyDurability = 20;
				break;
			case 4:
				toyName = "Puzzle";
				TOY_PRICE = 15;
				toyDurability = 15;
				break;
			case 5:
				toyName = "Lego";
				TOY_PRICE = 20;
				toyDurability = 17;
				break;
			case 6:
				toyName = "Slide";
				TOY_PRICE = 30;
				toyDurability = 20;
				break;
		}
	}

	public String getToyName() {
		return toyName;
	}


	//Just playing around
	//Subtracts pet roughness from toy durability
	//Returns bool based on whether toy breaks (true if toy breaks)
	public boolean playWithToy(Pet pet) { //Should roughness be in caps for constant???

		boolean toyBroken = false;
		toyDurability = Math.max(toyDurability - pet.getROUGHNESS(), 0);

		if (toyDurability == 0) {
			toyBroken = true;
			//need to remove from inventory
		}
		return toyBroken;
	}

	public boolean purchase(Player player) {

		if (player.getMoneyBalance() < this.TOY_PRICE) {
			return false;
		}

		player.setMoneyBalance(TOY_PRICE);
		player.addToToyInventory(this);
		return true;
	}

	public String toString() {

		String returnString = "";

		returnString += "Toy name: " + toyName + "\n";
		returnString += "Toy cost: " + TOY_PRICE + "\n";
		returnString += "Durability: " + toyDurability + "\n";

		return returnString;

	}
}