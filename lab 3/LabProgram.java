/***************************
*  @Author William Paddock
* @Version; .01
*  IT 145
*  3-3.36 LAB: Count input length without spaces, periods, exclamation points, or commas
****************************/
import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String userText;
      String dirtyString;
   
      // Gets entire line, including spaces. 
      dirtyString = scnr.nextLine();  

      // Clean the user input;
      userText = dirtyString.replaceAll("[ .!,]","");

      // Print the length of the excepted string of chars
      System.out.println(userText.length());
   }
}

