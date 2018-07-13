package com.jda.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.jda.utility.AlgorithmUtility;
import com.jda.Utility.CustomLinkedList;

public class LinkedList {

	public static void main(String[] args) throws Exception {
		CustomLinkedList list = new CustomLinkedList();
		String fileName = AlgorithmUtility.getString();
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		String[] tmpstr;
		while ((st = br.readLine()) != null) {
			tmpstr = st.split(",");
			for (int i = 0; i < tmpstr.length; i++) {
				list.add(tmpstr[i]);
			}
		}
		System.out.println("Enter the string to search in the file content");
		String key=AlgorithmUtility.getString();
		int idx = list.search(key);
		if (idx == -1)
		{
			
			list.add(key);
		}
		else
		{
			list.pop(idx);
		}
	
	list.writeToFile(fileName);
	}

}
