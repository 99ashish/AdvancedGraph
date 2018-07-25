package com.jda.advanced_core;

import com.jda.advanced_utility.Input;
import com.jda.advanced_utility.Inventory;
public class InventoryManagement 
{
	private static Input get =Input.getInputInstance();
	public static void main(String[] args) 
	{
      while(true)
      {
    	  System.out.println("1.Add inventory" + "\n" +"2.Get Value" +"\n" +"3.Exit");
    	  int opt=get.sc.nextInt();
    	  get.sc.nextLine();
    	  Inventory inventory=new Inventory();
    	  switch(opt)
    	  {
    	  case 1:
    		  inventory.addInventory();
    		  break;
    	  case 2:
    		      float []price=inventory.calculateValueOfInventory();
    		      System.out.println("Rice value :" + price[0]+"\n" + "Pulses value:" + price[1] +"\n" +"Wheat value" + price[2]);
    	  }
      }
	}

}
