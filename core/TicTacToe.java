package com.jda.core;
import com.jda.utility.FunctionalUtility;
import java.util.Random;
public class TicTacToe
{
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
	public static boolean checkOccupied(int[][] arr,int row,int column)
	{
		if(arr[row][column]==-1)
			return false;
		return true;
	}
    public static boolean checkRow(int[][] arr)
    {
    	for(int i=0;i<3;i++)
    	{
    		if(arr[i][0]==1 && arr[i][1]==1 && arr[i][2]==1)
    			return true;
    		else if(arr[i][0]==0 && arr[i][1]==0 && arr[i][2]==0)
    			return true;
    	}
    	return false;

    }
    public static boolean checkColumn(int[][] arr)
    {
    	for(int i=0;i<3;i++)
    	{
    		if(arr[0][i]==1 && arr[1][i]==1 && arr[2][i]==1)
    			return true;
    		else if(arr[0][i]==0 && arr[1][i]==0 && arr[2][i]==0)
    			return true;
    	}
    	return false;

    }
    public static boolean checkDiagonal(int[][] arr)
    {
    	
    	if((arr[0][0]==1 && arr[1][1]==1 && arr[2][2]==1)||(arr[0][2]==1 && arr[1][1]==1 && arr[2][0]==1))
    		return true;
    	else if((arr[0][0]==0 && arr[1][1]==0 && arr[2][2]==0)||(arr[0][2]==0 && arr[1][1]==0 && arr[2][0]==0))
    		return true;
    	else
    		return false;
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
				System.out.println("its computer's turn:");
				if(!checkRow(arr) && !checkColumn(arr)&& !checkDiagonal(arr)
						&& checkEmptyCell(arr))
				{
					   while(true)
					   {
						   int randRow=rand.nextInt(3);
						   int randCol=rand.nextInt(3);
						   System.out.println("compCell:"+randRow+" "+randCol);
						   if(!checkOccupied(arr,randRow,randCol))
						   {
							   arr[randRow][randCol]=0;
							   break;
						   }
					   }
					  
				}
				else
				{
					System.out.println("Game ended!!");
					break;
				}
				 comp_turn=0;
			}
			else
			{
				
				if(!checkRow(arr)&& !checkColumn(arr)&& !checkDiagonal(arr) && checkEmptyCell(arr))
				{
					System.out.println("Hey User,its your turn:");
					int row=Utility.getInt();
					int col=Utility.getInt();
					if(checkOccupied(arr,row,col)==false)
					{
						arr[row][col]=1;
					}
				}
				else
				{
					System.out.println("Game ended!!");
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
