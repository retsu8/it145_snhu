/***************************
*  William Paddock
*  IT 145
*  2.17 LAB: Driving cost - methods
****************************/

import java.util.Scanner;

public class LabProgram {
   
   public static double drivingCost(double milesPerGallon, double dollarsPerGallon, double milesDriven){     
      // Calculate the total driving cost of the trip.
      return ( dollarsPerGallon / milesPerGallon ) *  milesDriven ;
   }
   
   public static void main(String[] args) {
      // Scan in new input for milesperGallon and dollarsPerGallon
      Scanner scnr = new Scanner(System.in);

      // Add in the input to the new double for milesperGallon and dollarsPerGallon
      double milesPerGallon = Double.parseDouble(scnr.next());
      double dollarsPerGallon = Double.parseDouble(scnr.next());
      // Calculate 10 miles
      double ten_miles = drivingCost(milesPerGallon, dollarsPerGallon, 10);
      // Calculate 50 miles
      double fifty_miles = drivingCost(milesPerGallon, dollarsPerGallon, 50);
      // Calculate 400miles
      double four_hundred_miles = drivingCost(milesPerGallon, dollarsPerGallon, 400);
      // Print driving cost for 10
       System.out.printf("%.2f ", ten_miles);
      // Print driving cost for 50
       System.out.printf("%.2f ", fifty_miles);
      // Print driving cost for 400
       System.out.printf("%.2f", four_hundred_miles);
       // Add in a new line here.
       System.out.println("");
   }
}