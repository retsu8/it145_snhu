/***************************
*  William Paddock
*  IT 145
*  1.37 Basic output with variables 
****************************/

import java.util.Scanner; 

public class OutputWithVars {
   public static void main(String[] args) {
   	// Build the scanner
	Scanner scnr = new Scanner(System.in);

	// Setup the variables for basic use
	int userNum = 0;
	int userNum2 = 0;

	// Get the first integer
	System.out.println("Enter integer: ");
	userNum = scnr.nextInt();

	// Print first inteteger information
	System.out.println("You entered: " + userNum);
	System.out.println(userNum + " squared is " + (int)Math.pow(userNum, 2));
	System.out.println("And " + userNum + " cubed is " + (int)Math.pow(userNum, 3) + "!!");

	// Get second Integer
	System.out.println("Enter another integer: ");
	userNum2 = scnr.nextInt();

	// Do stuff with first and second integer
	int userAdd = userNum + userNum2;
	System.out.println(userNum + " + " + userNum2 + " is " + userAdd);
	System.out.println(userNum + " * " + userNum2 + " is " + userNum * userNum2);

	return;
   }
}