package com.java.core;
class bankingSystem implements Runnable{
	String accountNumber;
	String accountHolderName;
	float accountBalance;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
    synchronized public void withDraw(float amount) throws InterruptedException
	{
		if(accountBalance-amount >= 0)
		{	
			accountBalance -= amount;
			Thread.currentThread().sleep(200);
			for(int i=0;i<3;i++)
				System.out.println("Hello" + "Child Thread" + Thread.currentThread());
		}
		else
		{
			System.out.println("insufficient balance");
		}
		System.out.println(Thread.currentThread());
	}
	@Override
	public void run() {
		try {
			withDraw(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

public class Threadimpl
{
	public static void main(String[] args) throws InterruptedException 
	{
		bankingSystem acnt= new bankingSystem();
		acnt.setAccountNumber("74582838354");
		acnt.setAccountHolderName("ashish pandey");
		acnt.setAccountBalance(6000);
		Thread t1 = new Thread(acnt);
		Thread t2 = new Thread(acnt);
		t1.setName("Ashish");
		t2.setName("Ankur");
		t1.setPriority(1);
		t2.setPriority(5);
		t1.start();
		t2.start();
	}
}
