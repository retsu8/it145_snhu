/***************************
*  @Author William Paddock
*  @Version; .01
*  IT 145
*  6.6 Parsing strings (Java)
****************************/

import java.util.*;

public class ParseStrings {
   public static void main(String[] args) {
      // Setup variables
      Scanner scnr = new Scanner(System.in);
      String input = "";

      // Run while loop to get strings, q on exit
      while (!input.equalsIgnoreCase("q")) {
         // Get the user string
         System.out.println("Enter input string: ");
         input = scnr.nextLine();
         // Check if we need to exit or invalid content
         if (input.equalsIgnoreCase("q")){
            continue;
         }
         else if (!input.contains(",")){
            System.out.println("Error: No comma in string");
            continue;
         }

         // Build a list of strings from string spliting at known comma
         List<String> nameList = Arrays.asList(input.split(","));

         // Print the first word
         input = nameList.get(0).trim();
         System.out.println("First word: " + input);

         // Print the second word
         input = nameList.get(1).trim();
         System.out.println("Second word: " + input);

         // Make some space here to look cleaner
         System.out.println("\n");
      }

      return;
   }
}