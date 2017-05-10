/**
 * @author Alanna Reid
 * @author Elizabeth Wilson
 */

package hello;

import hello.Foods.Food;
import hello.Foods.*;
import hello.Pets.*;
import hello.Toys.*;
import hello.Toys.Toy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

//this is a comment
public class gameEnvironment {
 
	//test comment please ignore
	static int numberOfPlayers;
	static int numberOfDays;
	static int numberOfPets;
	static String playerName;
	static String petName;
	static Scanner read = new Scanner(System.in);
	static Random randomGenerator = new Random();   //For use with random events
	static ArrayList<Player> players = new ArrayList<Player>();
	static ArrayList<Pet> pets = new ArrayList<Pet>();
	
	/**
	 * Gets initial information from user
	 * (Asks for number of players and number of days)
	 */
	private static void get_info(){
		//Perhaps could separate this our into separate methods?
		
		System.out.println("Wellllcome to the game");
		numberOfPlayers = getIntInput("How many Players? ", Integer.MAX_VALUE);
		//MAX_VALUE as we do not want this to throw a too large exception, this is instead handled below
		//(as this needs to be handled differently than others}
		//Possibly a cleaner way to do this?
		
		while(numberOfPlayers > 3 || numberOfPlayers <= 0){

			if(numberOfPlayers > 3){
			System.out.println("You can have a maximum of 3 players!");}
			
			else if (numberOfPlayers <= 0){
				System.out.println("There must be at least one player");
			}

			numberOfPlayers = getIntInput("How many Players? ", Integer.MAX_VALUE);
			}

		numberOfDays = getIntInput("How many days? ", Integer.MAX_VALUE);

		while(numberOfDays <= 0 || numberOfDays > 30){

			if (numberOfDays <= 0){
				System.out.println("There must be at least one day");

			numberOfDays = getIntInput("How many Days? ", Integer.MAX_VALUE);

		}else{
			System.out.println("You can have a maximum of 30 days!");

				numberOfDays = getIntInput("How many Days? ", Integer.MAX_VALUE);
			}
		}
	}
	
	/**Sets up each player, creates a new player object 
	 * and calls set_up_pets method for each player
	 */
	private static void set_up_player() {
		
		for(int j = 0; j < numberOfPlayers; j++){
			int player_num = j + 1;
			playerName = getStringInput("What is your name player "+ player_num +"? ");

			while (!isUniquePlayerName(playerName)) {
				playerName = getStringInput("That name is already used, please choose another name player " + player_num);
			}

			System.out.println("How many pets do you want " + playerName + "?");
			numberOfPets = read.nextInt();

			while (numberOfPets > 3|| numberOfPets <=0){
				if(numberOfPets > 3){
					System.out.println("you can only have a max of 3 pets " + playerName);
					System.out.println("How many pets do you want? " + playerName);
					numberOfPets = read.nextInt();
				}else{
					System.out.println("you must have at least 1 pet " + playerName);
					System.out.println("How many pets do you want? " + playerName);
					numberOfPets = read.nextInt();
				}
			}
			
			Player player = new Player(playerName);
			players.add(player);

			for (int k = 0; k < numberOfPets; k++){ // Called to set up each pet for the current player
				set_up_pets(player, k);
			}
		}
		}
	private static boolean isUniquePetName(String name) {

		for (Pet pet : pets) {
			if (pet.getName().toLowerCase().equals(name)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isUniquePlayerName(String name) {

		for (Player player: players) {
			if (player.getPlayerName().toLowerCase().equals(name)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Prompts user to name their pet
	 * @param petChoice Type of pet the user has chosen
	 * @return String of the name input by the user
	 */
	private static String getName(String petChoice) {

		petName = getStringInput("What do you want to name your " + petChoice);

		while (!isUniquePetName(petName)) {
		    petName = getStringInput("That name is already used, please choose another name");
        }
		return petName;
	}
	
	private static String getGender(String petChoice){

		int genderChoiceInt;
		String genderChoice;

		String genderPrompt = "Please choose a gender for your " + petChoice +"\n1. Male" +"\n"+ "2. Female" + "\n" + "3. Other";
		genderChoiceInt = getIntInput(genderPrompt, 3);

		switch (genderChoiceInt) {
		case 1:
			genderChoice = "Male";
			break;
		case 2:
			genderChoice = "Female";
			break;
		case 3:
			genderChoice = "Other";
			break;
		default:
			genderChoice = "Female";
		}
		return genderChoice;
	}
	
	/**
	 * Prompts player to choose what kind of pet they want
	 * @param player The player who is currently choosing pets
	 * @param playerNumber To keep track of what player is being set up with pets
	 */
	private static void set_up_pets(Player player, int playerNumber) {

		String petChoice;
		playerNumber ++;

		String petTypePrompt = player.PlayerName + " please choose a type for pet number " + playerNumber + ":"
				+ "\n1. Cat \n2. Dog \n3. Lizard \n4. Giraffe \n5. Fish \n6. Pig";
		int petChoiceInt = getIntInput(petTypePrompt, 6);
		
		switch (petChoiceInt) { 
		case 1: 
			petChoice = "Cat";
			Cat newCat = new Cat(getName(petChoice), getGender(petChoice));
			player.playerPets.add(newCat); //Find some way to use this only once at the bottom
			pets.add(newCat);
			break;
		case 2:
			petChoice = "Dog";
			Dog newDog = new Dog(getName(petChoice), getGender(petChoice));
			player.playerPets.add(newDog);
			pets.add(newDog);
			break;
		case 3:
			petChoice = "Lizard";
			Lizard newLizard = new Lizard(getName(petChoice), getGender(petChoice));
			player.playerPets.add(newLizard);
			pets.add(newLizard);
			break;
		case 4:
			petChoice = "Giraffe";
			Giraffe newGiraffe = new Giraffe(getName(petChoice), getGender(petChoice));
			player.playerPets.add(newGiraffe);
			pets.add(newGiraffe);
			break;
		case 5:
			petChoice = "Fish";
			Fish newFish = new Fish(getName(petChoice), getGender(petChoice));
			player.playerPets.add(newFish);
			pets.add(newFish);
			break;
		case 6:
			petChoice = "Pig";
			Pig newPig = new Pig(getName(petChoice), getGender(petChoice));
			player.playerPets.add(newPig);
			pets.add(newPig);
			break;
		}
	}

	public static void gamePlay() {

		//Need to add automatic going to next day
		while (numberOfDays > 0) {
			System.out.println("DAYS REMAINING = " + numberOfDays);
			for (Player player : players) {
				randomEvent(player);
				System.out.println("CURRENT PLAYER = " + player.PlayerName);
				boolean turnEnded = isTurnsRemaining(player);
				while (turnEnded) { //FIX NAMING IT'S WRONG
					int choiceNumber = displayPlayChoices(player);

					switch (choiceNumber) {
						case 1:
							store(player);
							break;
						case 2:
							Pet pet = choosePet(player);
							petInteraction(player, pet);
							break;
						case 3:
							player.printInventory();
							break;
						case 4:
							displayPets(player);
							break;
						case 5:
							turnEnded = false;
							break;
					}
					if(turnEnded == true) {
						turnEnded = isTurnsRemaining(player);
					}
					System.out.println("===============================================================================");
				}
			}
			Print_player_info();
			numberOfDays --;
			resetDay();
		}
	}

	public static int displayPlayChoices(Player player) {

		String choiceList = "1. Visit Store\n2. Interact with pet\n3. Visit Inventory\n4. View pets\n5. End turn";
		int choiceNumber = getIntInput(choiceList, 5);

		return choiceNumber;
	}


	public static void store(Player player) {

		int typeChoice = getIntInput("1. Food\n2. Toys", 2);

		//some way to combine these? Both loops do the same(ish) thing
		if (typeChoice == 1) { //When player chooses food
			String foodChoices = "Food:\n 1. Tuna ($3)\n 2. Steak ($5)\n 3. Bug ($1)\n 4. Leaves ($1)\n 5. Seaweed ($2)" +
					"\n 6. Cotton Candy ($7)\n";
			int foodChoice = getIntInput(foodChoices, 6);

			ArrayList<Food> foodPurchaseList = new ArrayList<Food>();

			//better way to do this?
			switch (foodChoice) {
                case 1:
                    Tuna newTuna = new Tuna();
                    foodPurchaseList.add(newTuna);
                    break;
                case 2:
                    Steak newSteak = new Steak();
                    foodPurchaseList.add(newSteak);
                    break;
                case 3:
                    Bug newBug = new Bug();
                    foodPurchaseList.add(newBug);
                    break;
                case 4:
                    Leaves newLeaves = new Leaves();
                    foodPurchaseList.add(newLeaves);
                    break;
                case 5:
                    Seaweed newSeaweed = new Seaweed();
                    foodPurchaseList.add(newSeaweed);
                    break;
                case 6:
                    CottonCandy newCottonCandy = new CottonCandy();
                    foodPurchaseList.add(newCottonCandy);
                    break;
            }

            for (Food food: foodPurchaseList) {
			    food.purchase(player);
            }


		}else if (typeChoice == 2) {  //When player chooses toys

			String toyChoices = "Toys:\n 1. Ball of wool ($10)\n 2. Chew toy ($12)\n 3. Ball ($12)\n " +
					"4. Puzzle ($15)\n 5. Lego ($20)\n 6. Slide ($20)";
			int toyChoice = getIntInput(toyChoices, 6);
			ArrayList<Toy> toyPurchaseList = new ArrayList<Toy>();

			switch(toyChoice) {
                case 1:
                    BallOfWool newBallOfWool = new BallOfWool();
                    toyPurchaseList.add(newBallOfWool);
                    break;
                case 2:
                    ChewToy newChewToy = new ChewToy();
                    toyPurchaseList.add(newChewToy);
                    break;
                case 3:
                    Ball newBall = new Ball();
                    toyPurchaseList.add(newBall);
                    break;
                case 4:
                    Puzzle newPuzzle = new Puzzle();
                    toyPurchaseList.add(newPuzzle);
                    break;
                case 5:
                    Lego newLego = new Lego();
                    toyPurchaseList.add(newLego);
                    break;
                case 6:
                    Slide newSlide = new Slide();
                    toyPurchaseList.add(newSlide);
                    break;
            }

            for (Toy toy: toyPurchaseList) {
			    toy.purchase(player);
            }
		}
		player.printInventory();
	}


	public static Pet choosePet(Player player) {

		System.out.println("What pet would you like to interact with?");
		displayPets(player);
		int petChoice = read.nextInt();

		return (player.playerPets.get(petChoice - 1));
	}

	public static void displayPets(Player player) {

		int counter = 1;
		for (Pet pet: player.playerPets) {
			System.out.println(counter + ". " + pet);
			counter++;
		}
	}

	public static void petInteraction(Player player, Pet pet) {

		int choice = petInteractionChoice();

		switch (choice) {
			case 1:
				pet.sleep();
				break;
			case 2:
				pet.useToilet();
				break;
			case 3:
				playWithToy(player, pet);
				break;
			case 4:
				feedPet(player, pet);
		}
	}


	public static void feedPet(Player player, Pet pet) {

		System.out.println("Please choose what to feed your pet");
		player.printFood();
		int choice = read.nextInt();
		Food foodChoice = player.foodInventory.get(choice - 1);
		pet.feed(foodChoice);
	}

	public static void playWithToy(Player player, Pet pet) {

        if (pet.getIsMisbehaving()) {
            System.out.println("Sorry your pet will not play, they are misbehaving");
            //need to offer to discipline

        }else {
            System.out.println("Choose a toy to play with:");
            player.printToys();
            int toyChoiceNumber = read.nextInt();
            Toy toy = player.toyInventory.get(toyChoiceNumber - 1);
            pet.play(toy);

            boolean isBroken = toy.playWithToy(pet);

            if (isBroken) {
                System.out.println(pet.getName() + " has broken" + toy.getToyName() + " :(");
                player.toyInventory.remove(toy);
                player.printToys(); //for testing
            }
        }
	}

	public static int petInteractionChoice() {

		System.out.println("Please choose an action:");
		String interactionChoices = "1. Sleep\n2. Go to the toilet\n3. Play with toy\n4. Feed pet";
		System.out.println(interactionChoices);
		int interactionChoice = read.nextInt();

		return interactionChoice;
	}

	public static void randomEvent(Player player) {

		int randomEventNumber = randomGenerator.nextInt(35);
		int randomPetNumber = randomGenerator.nextInt(player.playerPets.size());
		Pet randomPet = player.playerPets.get(randomPetNumber);


		switch (randomEventNumber) {
			case 1:
				misbehavingPet(player, randomPet); //what if pet is already misbehaving?
				break;
			case 2:
				sickPet(player, randomPet);
				break;
			case 3:
				randomPet.die();
				System.out.println(randomPet.getName() + " has died");
				break;
		}
	}

	public static void misbehavingPet(Player player, Pet pet) {

		pet.misbehave();
		System.out.println(pet.getName() + " is misbehaving");
		System.out.println("Do you want to discipline your pet?");
		System.out.println("1. Yes\n2. No");
		int choice = read.nextInt();

		if (choice == 1) {
			pet.discipline();
		}
	}
    //this is comment
	public static void sickPet(Player player, Pet pet) {

		pet.getSick();
		System.out.println(pet.getName() + " is sick");
		System.out.println("Do you want to buy medicine for " + pet.getName() + "?\n Cost = $25");
		System.out.println("1. Yes\n2. No");
		int choice = read.nextInt();

		if (choice == 1) {
			player.MoneyBalance -= 25;
		}
	}

	private static void resetDay() {

		for (Player player: players) {
		    player.scoreDay();
			for (Pet pet: player.playerPets) {
				pet.resetTurn();
			}
		}
	}

	private static boolean isTurnsRemaining(Player player) {

		for (Pet pet: player.playerPets) {
			if (pet.getTurns() != 0) {
				return true;
			}
		}
		return false;
	}

	private static String getStringInput(String prompt) {
		String input = ""; //is this right?

		try {
			System.out.println(prompt);
			input = read.next();
			if(input.length() > 30) {
				throw new IOException("Sorry that is too long, please choose a new name");
			}

		}catch (IOException e) {
			System.out.println(e);
			input = getStringInput(prompt);
		}
		return input;
	}

	private static int getIntInput(String prompt, int maxInput) {

		int input = 0; //?????

		try {
			System.out.println(prompt);
			input = read.nextInt();

			if (input > maxInput) {
				throw new IOException("That number is not valid");
			}

		}catch (InputMismatchException e) {
			System.out.println("Please input a number");
			input = getIntInput(prompt, maxInput);
		}catch (IOException e) {
			System.out.println(e);
			input = getIntInput(prompt, maxInput);
		}
		return input;
	}

    private static void Print_player_info() {
        for (Player i : players) {
            String playerInfo = i.toString();
            System.out.println(playerInfo);
        }
    }

    public static void endGame() {
	    System.out.println("END OF GAME\nSCORES:");
	    int maxScore = 0;
	    Player winner  = players.get(1);

         for (Player player: players) {
             if (player.score > maxScore) {
                 maxScore = player.score;
                 winner = player;
             }
             System.out.println(player.getPlayerName() + ": " + player.score);
         }
        System.out.println("WINNER: " + winner.getPlayerName());
    }

	public static void main(String [] args) {

		get_info();
		set_up_player();
		gamePlay();
		Print_player_info();
		endGame();
		read.close();
	    }
	}

