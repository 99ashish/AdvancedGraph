package com.jda.core;
import com.jda.utility.*;
import java.util.Random;
public class FlipCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int heads=0, tails=0;
		FunctionalUtility intUtility = new FunctionalUtility();
		System.out.println("Enter the number of fliping the coin");
		int flip = intUtility.getInteger();
		Random r=  new Random();		
		for (int i = 0 ; i < flip ; i++ )
		{
			float RandomNumber= r.nextFloat();
			if(RandomNumber <  0.5)
			{
				tails++;
			}
			else
			{
				heads++;
			}
				
		}
		float headPercentage= (heads*100)/flip;
		float tailPercentage= (tails*100)/flip;
    System.out.println("Percentage of heads :"  +  headPercentage);
    System.out.println("Percentage of heads :"  +  tailPercentage);
	}

}
