package hello.Pets;

import hello.Pets.Pet;

public class Pig extends Pet {
	
	public Pig(String name, String gender) {

		//this is a comment
		super(name, gender);

		SLEEP_LOSS = 40;
		SLEEP_GAIN = 60;
		HUNGER_LOSS = 50;
		ROUGHNESS = 5;
		FAV_FOOD = "Cotton candy";
		FAV_TOY = "Slide";

		weight = 5;
	}
	
}
