package hello.Pets;

import hello.Pets.Pet;

public class Fish extends Pet {

	//this is a comment
	public Fish(String name, String gender) {

		super(name, gender);

		SLEEP_LOSS = 50;
		SLEEP_GAIN = 100;
		HUNGER_LOSS = 20;
		ROUGHNESS = 2;
		FAV_FOOD = "Seaweed";
		FAV_TOY = "Lego";

		weight = 5;
	}
	
}
