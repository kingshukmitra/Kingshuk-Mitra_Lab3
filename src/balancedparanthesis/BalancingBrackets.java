package balancedparanthesis;

import java.util.Stack;

public class BalancingBrackets {

	/*
	 * Method to check if given expression has balanced paranthesis
	 * 
	 * 1) Declare a character stack s 
	 * 2) Traverse the string expression
	 *  a) If the current character is a starting bracket, push it to stack 
	 *  b) If the current character is a closing bracket, pop it from stack 
	 *  i) If the popped character is a closing pair of the starting bracket, then move on, else the brackets
	 * are not balanced 
	 * 3) After complete traversal, if any bracket is left in the stack, then it is not balanced
	 */
	boolean checkBalancedBrackets(String s) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
				continue;
			}

			if (stack.isEmpty())
				return false;

			char popped;

			switch (c) {

			case '}':
				popped = stack.pop();
				if (popped == '(' || popped == '[')
					return false;
				break;

			case ')':
				popped = stack.pop();
				if (popped == '{' || popped == '[')
					return false;
				break;

			case ']':
				popped = stack.pop();
				if (popped == '{' || popped == '(')
					return false;
				break;

			}
		}

		return stack.isEmpty();
	}
}
