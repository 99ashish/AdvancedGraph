package com.jda.advanced_utility;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.jda.advanced_utility.Commodity;
public class Inventory {
private static String path="/home/bridgelabz/Desktop/JavaCode/"; 
private static Input get =Input.getInputInstance();
List<Commodity> commodityList =new ArrayList<>();
File fileName;
public void addInventory()
{
	fileName=openFile();
	Commodity grain= new Commodity();
	System.out.println("Commodity Name");
	grain.setCommodityName(get.sc.nextLine());
	System.out.println("Weight");
	grain.setWeight(get.sc.nextFloat());
	System.out.println("Price Per kg");
	grain.setPricePerKg(get.sc.nextFloat());
	commodityList.add(grain);
	writeTofile(fileName);
}
public void readfromFile(File fileName)
{
	showTotalJsonFile();
	try {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(fileName);
        for(JsonNode obj:node)
        {
        	Commodity pr=mapper.treeToValue(obj,Commodity.class);
        	commodityList.add(pr);
        }
      }
	catch(Exception e)
	{
		System.out.println("Unable to read file");
	}
}
private void showTotalJsonFile() {
	File file = new File(path);
	File[] files = file.listFiles();
	for (File f : files) {
		if (f.getName().contains(".json")) {
			System.out.print(f.getName() + " ");
		}
	}
	System.out.println();
}
public void writeTofile(File fileName)
{
	try{
	ObjectMapper mapper = new ObjectMapper();
	ObjectWriter writer = mapper.writer();
		writer.writeValue(fileName,
				commodityList);
}
	catch(Exception e)
	{
		System.out.println("Unable to write file");
	}
}
private File openFile()
{ 
	showTotalJsonFile();
	 System.out.println("Enter the name of the Inventory File");
	 String filename = "/home/bridgelabz/Desktop/JavaCode/" + get.sc.nextLine() + ".json";
	 File fileName= new File(filename);
	 return fileName;
}
public float[] calculateValueOfInventory()
{
	float []price= new float[3];
    fileName=openFile();
	readfromFile(fileName);
	for(Commodity cmd:commodityList)
	{
		if(cmd.getCommodityName().equalsIgnoreCase("rice"))
		{
			price[0]+=(cmd.getWeight()*cmd.getPricePerKg());
		}
		else if(cmd.getCommodityName().equalsIgnoreCase("pulses"))
		{
			price[1]+=(cmd.getWeight()*cmd.getPricePerKg());
		}
		else if(cmd.getCommodityName().equalsIgnoreCase("wheats"))
		{
			price[2]+=(cmd.getWeight()*cmd.getPricePerKg());
		}
	}
	return price;
}
}
