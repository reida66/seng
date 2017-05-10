package hello.game;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import hello.game.*;
import hello.Player;
import hello.Pets.Pet;

public class gameGUI {
	static int numberOfPlayers = 1;
	static int numberOfDays = 1;
	static int numberOfPets;
	static int numofDone = 0;
	static String playerName;
	static String petName;
	static Scanner read = new Scanner(System.in);
	static Random randomGenerator = new Random();   //For use with random events
	static ArrayList<Player> players = new ArrayList<Player>();
	static ArrayList<Pet> pets = new ArrayList<Pet>();
	static boolean next = false; 
	static int petchoice;
	
	static private void get_info(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					open_screen window = new open_screen();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	static public void set_up_players(){
		System.out.println("yay");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					set_upplayers window = new set_upplayers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
				
			}
		
			
public static void addPlayer(){
	System.out.println(playerName);
	Player player = new Player(playerName);
	players.add(player);
	
}
public static void setPlayer(){
	Player player = new Player(playerName);
	players.add(player);
	}
	
	public static void setPlayerName(String name){
		playerName = name;
		System.out.println(playerName);
	}
	
	public static void setPetName(String name){
		petName = name;
	}
	
	public static void setNext(){
		next = true;
	}
	
	public static void setNumOfPlayers(Object object){
		
		numberOfPlayers = (int) object;
		//System.out.println(numberOfPlayers);
	}
	
	public static void setNumOfDays(Object object){
		numberOfDays = (int) object;
		//System.out.println(numberOfDays);
	}
	
	public static void current_values(){
		String text;
		text = "there are " + numberOfPlayers + " number of players\n" + "there are "+ numberOfDays +" number of days";
		System.out.println(text);
	}
	public static void setnumofdone(){
		 numofDone += 1;
	}
	public static void setPetChoice(int choice){
		petchoice = choice;
	}
	
	public static void main(String [] args) {

		get_info();
		
	    }
	public static void setNumberofPets(Object object){
		players.get(0).setNumberOfPets((int) object);
	}

}
