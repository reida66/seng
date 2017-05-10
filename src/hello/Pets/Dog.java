package hello.Pets;

import hello.Pets.Pet;

public class Dog extends Pet {

	//this is a comment
	public Dog(String name, String gender) {

		super(name, gender);

		SLEEP_LOSS = 30;
		SLEEP_GAIN = 50;
		HUNGER_LOSS = 40;
		ROUGHNESS = 5;
		FAV_FOOD = "Steak";
		FAV_TOY = "Chew toy";

		weight = 7;
	}
	
}
