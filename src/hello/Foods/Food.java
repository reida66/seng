package hello.Foods;

import hello.Player;

public class Food implements hello.purchasable{

	public static String foodName;
	public static int FOOD_COST;
	public static int FEED_VALUE;
	public Food(){

	}

	public boolean purchase(Player player) {
	    boolean enoughFunds = player.setMoneyBalance(FOOD_COST);

	    if (enoughFunds) {
            player.addToFoodInventory(this);
            return true;
        }
        return false;
	}

	public String toString() {
		String returnString = "";
	
		returnString += "Food name: " + foodName + "\n";
		returnString += "Food cost: " + FOOD_COST;
		
		return returnString;

}

}
