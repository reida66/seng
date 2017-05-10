package hello.Pets;

public class Cat extends Pet {


	//this is a comment
	public Cat(String name, String gender) {

		super(name, gender);

		SLEEP_LOSS = 50;
		SLEEP_GAIN = 80;
		HUNGER_LOSS = 30;
		ROUGHNESS = 3;
		FAV_FOOD = "Tuna";
		FAV_TOY = "Ball of wool";

		weight = 5;


	}
	
}
