package com.jda.core;
import com.jda.utility.FunctionalUtility;
import java.util.Random;
/**
 * In Tic Tac Toe game there will be two player, one is computer itself and other one is user.
 * The logic behind the game is that if either user or computer able to insert the same decided value 
 * (0 for computer and 1 for user) in any row or any column or any diagonal,  then according to game 
 *  rule either computer or user win the game.
 * @author bridgelabz
 *
 */
public class TicTacToe
{
	// Check that a particular (row,col) in the range or not 
	public static boolean rangeCheck(int row ,int col)
	{
		if((row>=0 && row<3) && (col>=0 &&col<3))
			return true;
		return false;
	}
	// Checking for empty cell
	public static boolean checkEmptyCell(int[][] arr)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(arr[i][j]==-1)
					return true;
			}
		}
		return false;
	}
	// Check that particular cell is available or not
	public static boolean checkOccupied(int[][] arr,int row,int column)
	{
		if(arr[row][column]==-1)
			return false;
		return true;
	}
	// Row check if any row have same value (0 or 1) then either computer or user win the game
    public static int checkRow(int[][] arr)
    {
    	for(int i=0;i<3;i++)
    	{
    		if(arr[i][0]==1 && arr[i][1]==1 && arr[i][2]==1)
    			return 1;
    		else if(arr[i][0]==0 && arr[i][1]==0 && arr[i][2]==0)
    			return 0;
    	}
    	return -1;

    }
 // Column check if any column have same value (0 or 1) then either computer or user win the game
    public static int checkColumn(int[][] arr)
    {
    	for(int i=0;i<3;i++)
    	{
    		if(arr[0][i]==1 && arr[1][i]==1 && arr[2][i]==1)
    			return 1;
    		else if(arr[0][i]==0 && arr[1][i]==0 && arr[2][i]==0)
    			return 0;
    	}
    	return -1;

    }
    // Diagonal check if any one diagonal have same value (0 or 1) then either computer or user win the game
    public static int checkDiagonal(int[][] arr)
    {
    	
    	if((arr[0][0]==1 && arr[1][1]==1 && arr[2][2]==1)||(arr[0][2]==1 && arr[1][1]==1 && arr[2][0]==1))
    		return 1;
    	else if((arr[0][0]==0 && arr[1][1]==0 && arr[2][2]==0)||(arr[0][2]==0 && arr[1][1]==0 && arr[2][0]==0))
    		return 0;
    	else
    		return -1;
    }
	public static void main(String[] args) {
		//int size=Utility.getInt();
		int[][] arr=new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				arr[i][j]=-1;
			}
		}
		Random rand=new Random();
		int comp_turn=1;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		while(true)
		{
			if(comp_turn==1) 
			{
				// Looking for a available cell
				if(checkRow(arr) == -1 &&  checkColumn(arr) == -1&& checkDiagonal(arr) == -1
						&& checkEmptyCell(arr))
				{
					   while(true)
					   {
						   int randRow=rand.nextInt(3);
						   int randCol=rand.nextInt(3);
						   System.out.println("compCell:"+randRow+" "+randCol);
						   if(rangeCheck(randRow,randCol) && !checkOccupied(arr,randRow,randCol))
						   {
							   arr[randRow][randCol]=0;
							   // After computer's move check that may be computer win
							   if(checkRow(arr) == 0 ||  checkColumn(arr) == 0 || checkDiagonal(arr) == 0 )
							   {
								   System.out.println("Computer win the game!!");
								   return;
							   }
							   break;
						   }
					   }	  
				}
				// If all the position of row or column or diagonal occupied with 0  
				else
				{ 
					System.out.println("Computer win the game!!");
					break;
				}
				 comp_turn=0;
			}
			else
			{
				
				if(checkRow(arr) == -1 &&  checkColumn(arr) == -1&& checkDiagonal(arr) == -1 && checkEmptyCell(arr))
				{
					System.out.println("Give your move");
					while(true)
					{
					  int row=FunctionalUtility.getInteger();
					  int col=FunctionalUtility.getInteger();
					  if( rangeCheck(row,col) && checkOccupied(arr,row,col)==false)
					  {
						arr[row][col]=1;
						 if(checkRow(arr) == 1 ||  checkColumn(arr) == 1 || checkDiagonal(arr) == 1)
						   {
							   System.out.println("You win the game!!");
							   return;
						   }
						break;
					  }
					  System.out.println("Invalid move");
					}
				}
				else
				{
					System.out.println("You win the game!!");
					break;
				}
				comp_turn=1;
			}
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}
