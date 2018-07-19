package com.jda.core;
import com.jda.Utility.Stack;
import com.jda.utility.AlgorithmUtility;
/**
 * Read in Arithmetic Expression such as (5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)
 * Read the expression push open parenthesis and pop closed
 *parenthesis . At the End of the Expression if the Stack is Empty then the
 *Arithmetic Expression is Balanced. Stack Class Methods are Stack(), push(),
 *pop(), peak(), isEmpty(), size().
 * @author bridgelabz
 *
 */
public class ParentesisBalance
{
	public static void main(String[] args) 
	{
		Stack stk=new Stack();
		System.out.println("Enter the equation");
		String str= AlgorithmUtility.getString();
		int len=str.length();
		for (int i=0;i<len;i++)
		{
			if(str.charAt(i)=='(' )
				stk.push("(");
			else if(str.charAt(i)=='{' )
				stk.push("{");
			else if((str.charAt(i)==')' && stk.isEmpty()) || str.charAt(i)=='}' && stk.isEmpty())
			{
				System.out.println("Equation is not balance");
				return;
			}
			else if((str.charAt(i)==')' && !stk.peek().equals("(")) || (str.charAt(i)=='}' && !stk.peek().equals("{")))
			{
				System.out.println("Equation is not balance");
				return;
			}
			else
				stk.pop();
		}
if(stk.isEmpty())
	System.out.println("Equation is balance");
else 
	System.out.println("Equation is not balance");
	}

}
