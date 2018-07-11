package com.jda.core;
import com.jda.utility.FunctionalUtility;
/**
 * In this game gambler have inital amount and he wish to achive a certain goal 
 * by using this amount.
 * Gambler initially make a bet for $1 and flip a coin if it is head then he win the bet ang get
 * $2 and tail he get $0
 * and conitinue in the same until achive the goal or rest amount will be zero.
 */
import java.util.Random;

public class Gambler 
{
	//Total tries taken by gambler to win or loss the game
	static int totalTries(int amnt, int score ) {
		int tries = 0;
		Random r = new Random();
		while (amnt > 0 && amnt < score) 
		{
			float RandomNumber = r.nextFloat();
			if (RandomNumber < 0.5) 
			{
				amnt--;
			} 
			else 
			{
				amnt++;
			}
			tries++;
		}
		if (amnt == score)
			return tries;
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("Enter the inital amount of gambler:");
		int stake = FunctionalUtility.getInteger();
		System.out.println("Enter the goal amount of gambler:");
		int goal = FunctionalUtility.getInteger();
		System.out.println("Enter the total number of try:");
		int tolTries = FunctionalUtility.getInteger();
		int win = 0;
		for (int i = 1; i <= tolTries; i++) 
		{
			int ans = totalTries(stake, goal);
			if (ans > 0) 
			{
				win++;
			}
				System.out.println("Try " + i + " takes " + ans + "  times ");
		}
		System.out.println("Gambler win " + win + " times");
		System.out.println("Gambler lose  " + (tolTries - win) + " times");
	}
}
