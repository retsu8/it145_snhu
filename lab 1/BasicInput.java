/***************************
*  William Paddock
*  IT 145
*  1.38 Variables, input, and casting 
****************************/

import java.util.Scanner;

public class BasicInput {
   public static void main(String[] args) {
      // Setup the scanner
      Scanner scnr = new Scanner(System.in);

      // Setup the variables for use
      int userInt = 0;
      double userDouble = 0.0;
      char userChar;
      String userString = "";
      
      // Get an integer
      System.out.println("Enter integer: ");
      userInt = scnr.nextInt();

      // Get a double
      System.out.println("Enter double: ");
      userDouble = scnr.nextDouble();
      
      // Get a char
      System.out.println("Enter character: ");
      userChar = scnr.next().charAt(0);

      // Clean off the rest of the char items to have a clean buffer for string.
      userString = scnr.nextLine();

      // Get a string
      System.out.println("Enter string: ");
      userString = scnr.nextLine();
      
      // Print out string handling
      System.out.println("" + userInt + " " + userDouble + " " + userChar + " " + userString);
      System.out.println("" + userString + " " + userChar + " " + userDouble + " " + userInt);
      System.out.println(userDouble + " cast to an integer is " + (int)userDouble);

      return;
   }
}