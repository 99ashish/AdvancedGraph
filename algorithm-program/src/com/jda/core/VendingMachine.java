package com.jda.core;
import com.jda.utility.AlgorithmUtility;
/**
 * There is 1, 2, 5, 10, 50, 100, 500 and 1000 Rs Notes which can be
 *returned by Vending Machine.
 * @author bridgelabz
 *
 */
public class VendingMachine 
{
	static int[] notes={1,2,5,10,50,100,500,1000};
	static int[] totalNotes=new int[8];
	static int noteArraySize=7;
	static int totalNotes(int amnt)
	{
		if(noteArraySize<0)
			return 0;
		if((amnt/notes[noteArraySize])>0)
			totalNotes[noteArraySize]=(amnt/notes[noteArraySize]);
		return (amnt/notes[noteArraySize])+totalNotes((amnt%notes[noteArraySize--]));
	}
	public static void main(String[] args) 
	{
		System.out.println("Enter the amount you want dispence");
		int amnt=AlgorithmUtility.getInteger();
		System.out.println("Minimum notes requried :" +totalNotes(amnt));
		for(int i=0;i<8;i++)
		{
			if(totalNotes[i]>0)
			{
				System.out.println("Notes of " + notes[i]+ " requried: " + totalNotes[i]);
			}
		}
		// TODO Auto-generated method stub

	}

}
