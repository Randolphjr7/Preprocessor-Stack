
package com.mycompany.preprocessingstack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author rando
 */
public class Delimeters {

        private Stack<Object> stk;
	private String expression;
	private int length;
		    
	public Delimeters(String expression)
	{
		stk = new Stack<Object>();
		this.expression = expression;
		this.length = expression.length();
	}

	boolean isBalance() // Determine if parentheses are balanced
	{
		int index = 0;
		boolean fail = false;
		
		try
		{
			while (index < length && !fail)
			{
				char ch = expression.charAt(index);
				
				if (ch ==  Constants.LEFT_NORMAL)
						stk.push(ch);
				else if (ch ==  Constants.RIGHT_NORMAL)	
						stk.pop();
				index++;
			}//end of while
		}//end of try 
		catch (EmptyStackException e) 
		{
			System.out.println(e.toString()); 
			fail = true;
		}
		return (stk.empty() && !fail);
	}    
}
