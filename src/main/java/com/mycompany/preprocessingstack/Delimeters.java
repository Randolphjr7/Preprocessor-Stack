
package com.mycompany.preprocessingstack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author rando
 */
public class Delimeters {

        private Stack<Object> stkParenthesis, stkCurlyBraces, stkSquareBrackets;
	private String expression;
	private int length;
		    
	public Delimeters(String expression)
	{
            stkParenthesis    = new Stack<Object>();
            stkCurlyBraces    = new Stack<Object>();
            stkSquareBrackets = new Stack<Object>();            
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
				
                            // Put on corresponding Stacks if delimeter found
                            if (ch == Constants.LEFT_PAREN)
				stkParenthesis.push(ch);
                                        
                            else if (ch == Constants.RIGHT_PAREN)	
                                stkParenthesis.pop();
                            else if (ch == Constants.LEFT_CURLY)
                                stkCurlyBraces.push(ch);
                            else if (ch == Constants.RIGHT_CURLY)
                                stkCurlyBraces.pop();
                            else if (ch == Constants.LEFT_BRACKET)
                                stkSquareBrackets.push(ch);
                            else if (ch == Constants.RIGHT_BRACKET)
                                stkSquareBrackets.pop();
				index++;
			}//end of while
		}//end of try 
		catch (EmptyStackException e) 
		{
			System.out.println(e.toString()); 
			fail = true;
		}
		return (!fail && 
                        stkParenthesis.empty() && 
                        stkCurlyBraces.empty() && 
                        stkSquareBrackets.empty());
	}    
}
