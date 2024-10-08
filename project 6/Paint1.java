/***************************
*  @Author William Paddock
*  @Version; .01
*  IT 145
*  6-3 Assignment: Validating User Input and Debugging
****************************/

import java.util.*;

public class Paint1 {

    public static double checkUserInput(Scanner scnr){
        // Hold the value of the length here.
        Double length = 0.0;
        do {
            try{
                // Check to make sure the value is a double
                length = scnr.nextDouble();
                if (length <= 0.0){
                    System.out.println("Input needs to be greater than zero to pain a wall.");
                }
            } catch (InputMismatchException e){
                // Try it again if it isnt.
                System.out.println("Input is not a double, kindly re-enter input.");
                // Clean up the invalid input.
                scnr.nextLine();
            }
        // Check to make sure the input makes sense.
        // Cant have an area with no size.  
        } while (length <= 0.0);
        return length;
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;
        
        final double squareFeetPerGallons = 350.0;
        
        // Implement a do-while loop to ensure input is valid
        // Prompt user to input wall's height
        System.out.println("Enter wall height (feet): ");
        wallHeight = checkUserInput(scnr);

        // Implement a do-while loop to ensure input is valid
        // Prompt user to input wall's width
        System.out.println("Enter wall width (feet): ");
        wallWidth  = checkUserInput(scnr);

        // Calculate and output wall area
        wallArea = wallHeight * wallWidth;
        System.out.println("Wall area: " + wallArea + " square feet");

        // Calculate and output the amount of paint (in gallons) needed to paint the wall
        gallonsPaintNeeded = wallArea/squareFeetPerGallons;
        System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");

    }
}
