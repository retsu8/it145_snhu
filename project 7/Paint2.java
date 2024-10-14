/******************************************************************
** 
** 7-3 Assignment: Using Java API Documentation
** Paint2.java
** 
** @Author William Paddock
** Southern New Hampshire University
** IT-145-11107-M01 Found in App Development 2024 C-5 (Sept - Oct)
** Dr. Vivian Lyon
** Sept 2, 2024
**
******************************************************************/

import java.util.Scanner;
import java.lang.Math;

public class Paint2 {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;
        double cansNeeded;

        final double squareFeetPerGallons = 350.0;
        final double gallonsPerCan = 1.0;

        // Prompt user to input wall's height
        System.out.println("Enter wall height (feet): ");
        wallHeight = scnr.nextDouble();


        // Prompt user to input wall's width
        System.out.println("Enter wall width (feet): ");
        wallWidth = scnr.nextDouble();

        // Calculate and output wall area
        wallArea = wallHeight * wallWidth;

        // Calculate and output the amount of paint in gallons needed to paint the wall
        gallonsPaintNeeded = wallArea / squareFeetPerGallons;
        System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");

        // Calculate the gallon cans of paint needed
        cansNeeded = Math.ceil(gallonsPaintNeeded / gallonsPerCan);
        if (cansNeeded > 1 ){
            System.out.println("Cans needed: " + cansNeeded + " cans");
        } else {
            System.out.println("Cans needed: " + cansNeeded + " can");
        }
    }
}
