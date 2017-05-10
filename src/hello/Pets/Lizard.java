package hello.Pets;

import hello.Pets.Pet;

public class Lizard extends Pet {

	//this is a comment
	public Lizard(String name, String gender) {

		super(name, gender);

		SLEEP_LOSS = 40;
		SLEEP_GAIN = 60;
		HUNGER_LOSS = 10;
		ROUGHNESS = 2;
		FAV_FOOD = "Bug";
		FAV_TOY = "Ball";

		weight = 1;
	}
	
}
