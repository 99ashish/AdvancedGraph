package com.jda.advanced_utility;
import java.io.File;
import com.jda.advanced_utility.Property;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import com.jda.advanced_utility.Commodity;
public class Inventory {
private static String path="/home/bridgelabz/Desktop/JavaCode/"; 
private static Input get =Input.getInputInstance();
private static List<Commodity> commodityList =new ArrayList<>();
File fileName;
public void addInventory()
{
	fileName=openFile();
	readfromFile(fileName);
	Commodity grain= new Commodity();
	System.out.println("Enter Commodity Name");
	grain.setCommodityName(get.sc.nextLine());
	Property pr=new Property();
	System.out.println("Enter Brand Name");
	pr.setBrandName(get.sc.nextLine());
	System.out.println("Enter the Weight");
	pr.setWeight(get.sc.nextFloat());
	System.out.println("Price Per kg");
	pr.setPricePerKg(get.sc.nextFloat());
	grain.setProperty(pr);
	commodityList.add(grain);
	writeTofile(fileName);
}
public void readfromFile(File fileName)
{
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
	 String filename = path + get.sc.nextLine() + ".json";
	 File fileName= new File(filename);
	 return fileName;
}
public void calculateValueOfInventory()
{
    fileName=openFile();
    readfromFile(fileName);
	for(Commodity cmd:commodityList)
	{
		System.out.println(cmd.getCommodityName());
		System.out.println("\t\t"+cmd.property.getBrandName()+":"
		+cmd.property.getWeight()*cmd.property.getPricePerKg());
	}
}
}
