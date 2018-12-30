package com.java.core;
import java.util.ArrayList;
import java.util.List;
import com.java.GenericUtility.GenericSorting;
import com.java.GenericUtility.GenericSorting;;
class Ashish1{
	private void fun()
	{
		System.out.println("function of class A");
	}
	static void name()
	{
		System.out.println("Class name A");
	}
}

class Pandey1 extends Ashish1{
	void fun()
	{
		System.out.println("function of class A");	
	}
}
public class classAccessifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Pandey<Integer> obj = new Pandey<Integer>(23);
      System.out.println(obj.getObj());
      String str = "Ashish";
      str.concat(" pandey");
      System.out.println(str);
      List<String> dataList = new ArrayList<>();
      dataList.add("SAJ");
      dataList.add("ADS");
      dataList.add("SSF");
      dataList.add("DFB");
      List<Integer> dataList1 = new ArrayList<>();
      dataList1.add(1);
      dataList1.add(4);
      dataList1.add(-1);
      dataList1.add(8);
      dataList1.add(-21);
      GenericSorting list = new GenericSorting();
      try {
		list.heapSort(dataList1, dataList1.size());
		System.out.println(dataList1);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}

}
