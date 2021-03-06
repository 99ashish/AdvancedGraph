package com.jda.core;
import com.jda.Utility.Queue;
import com.jda.utility.AlgorithmUtility;
/**
 * Assumption is that all the visitors have existing account number in the bank.
 * It's working on the basis of queue, when new customer will come, it will be added
 * to the queue, and when one customer done their job pop out from the queue.
 *
 */
public class QueueImplementation
{
	public static <T> void main(String[] args) 
	{
		Queue que= new Queue();
		while(true)
		{
			System.out.println("1.Enque");
			System.out.println("2.Deque");
			int opt=AlgorithmUtility.getInteger();
			AlgorithmUtility.getString();
			if(opt==1)
			{
				System.out.println("Account holder name");
				que.push(AlgorithmUtility.getString());
			}
			else if(opt==2)
			{
				if(que.isEmpty())
				{
					System.out.println("Queue is empty");
					continue;
				}
				System.out.println("Select your task");
				System.out.println("1.Withdraw");
				System.out.println("2.Deposite");
				System.out.println("3.Balance Enquiry");
				int option=AlgorithmUtility.getInteger();
				if(option==1)
				{
					 System.out.println("Enter the amount");
					 int amnt=AlgorithmUtility.getInteger();
					 if(amnt<=0)
					 {
						 System.out.println("Invalid amount: "+ amnt);
						 continue;
					 }
					 que.withDraw(amnt);
				}
				else if(option==2)
				{
					 System.out.println("Enter the amount");
					 int amnt=AlgorithmUtility.getInteger();
					 if(amnt<=0)
					 {
						 System.out.println("Invalid amount: "+ amnt);
						 continue;
					 }
					 que.deposite(amnt);
				}
					int amnt=que.getBal();
					System.out.println("Current account balance is : "+ amnt);
				    T name=(T) que.deque();
				    
				    System.out.println(name + ", Done his/her job!");
			}
			else
				System.out.println("invalid Entry!");
		}
		

	}

}
