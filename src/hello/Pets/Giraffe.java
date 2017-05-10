package hello.Pets;

import hello.Pets.Pet;

public class Giraffe extends Pet {

	//this is a comment
	public Giraffe(String name, String gender) {

		super(name, gender);

		SLEEP_LOSS = 30;
		SLEEP_GAIN = 50;
		HUNGER_LOSS = 20;
		ROUGHNESS = 7;
		FAV_FOOD = "Leaves";
		FAV_TOY = "Puzzle";

		weight = 20;
	}
	
}
