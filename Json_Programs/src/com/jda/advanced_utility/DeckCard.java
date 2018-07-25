package com.jda.advanced_utility;

import java.util.Random;

public class DeckCard
{
  String[] cardValue={"2 hrt","3 hrt","4 hrt","5 hrt","6 hrt","7 hrt",
          "8 hrt","9 hrt","10 hrt","J hrt","K hrt","Q hrt","A hrt",
          "2 clb","3 clb","4 clb","5 clb","6 clb","7 clb",
          "8 clb","9 clb","10 clb","J clb","K clb","Q clb","A clb",
          "2 dmd","3 dmd","4 dmd","5 dmd","6 dmd","7 dmd",
          "8 dmd","9 dmd","10 dmd","J dmd","K dmd","Q dmd","A dmd",
          "2 spd","3 spd","4 spd","5 spd","6 spd","7 spd",
          "8 spd","9 spd","10 spd","J spd","K spd","Q spd","A spd"};
  public  void distributeCard()
  {
  	shuffle();
  	String[][] playerCard =new String[4][13];
  	for(int i=0;i<13;i++)
  	{
  		for(int j=0;j<4;j++)
  		{
  		    playerCard[j][i]=cardValue[i*4+j];
  		}
  	}
  	for(int i=0;i<4;i++)
  	playerGetCard(playerCard[i],i);
  }
  private void playerGetCard(String[] deckCard,int player)
  {
	  System.out.println("Player "+ (player+1)+" get card");
	  for(int i=0;i<13;i++)
		  System.out.println("\t\t\t"+deckCard[i]);
  }
private void swap(int idx1,int idx2)
{
	String tmpCard=cardValue[idx1];
	       cardValue[idx1]=cardValue[idx2];
	       cardValue[idx2]=tmpCard;
}
private void shuffle()
{
	Random r=  new Random();
	for(int i=0;i<52;i++)
	{
		int idx1=(r.nextInt()%52+52)%52;
		int idx2=(r.nextInt()%52+52)%52;
		swap(idx1,idx2);
	}
}
}
