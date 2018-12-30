package com.java.core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThreadJoinImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*bankingSystem acnt = new bankingSystem();
		acnt.setAccountBalance(10000);
		acnt.setAccountHolderName("Pandu");
		acnt.setAccountNumber("28782391233");
		Thread t1 = new Thread(acnt);
		Thread t2 = new Thread(acnt);
		Thread t3 = new Thread(acnt);
		t1.setName("Ashish");
		t2.setName("Ankur");
		t3.setName("Amit");
		t1.start();
		t2.start();
		t3.start();
		try{
			Thread.currentThread().sleep(210);
		}
		catch(InterruptedException e){
			System.out.println("Exception:" +e);
		}*/
      System.out.println("main thread finish");
      try{
    	  Connection con=null;
    	  String url = "jdbc:sqlserver://localhost;databaseName=javadb";
    	  String dbname ="sa";
    	  String pass ="RedPrairie1";
    			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    			 con=DriverManager.getConnection(  
    					 url,dbname,pass);  
    			 System.out.println(con);
    			 PreparedStatement pst = con.prepareStatement("select * from dbo.userdb");
    			 ResultSet rs = pst.executeQuery();
    			 while(rs.next())
    			 {
    				 String id = rs.getString("pass");
    				 System.out.println(id);
    			 }
      }
      catch(Exception e)
      {
    	  System.out.println("hi");
    	  System.out.println(e);
	
	}
}
}


