package balancedparanthesis;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// input
		String inputExpression = "( [ [ { } ] ] )";
		
		Boolean isBalanced = false;
		
		//Object of the class that contains method to check if brackets are balanced
		BalancingBrackets bb = new BalancingBrackets();
		
		isBalanced = bb.checkBalancedBrackets(inputExpression);
		
		if(isBalanced)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");

	}

}
