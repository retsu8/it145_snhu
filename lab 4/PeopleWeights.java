/***************************
*  @Author William Paddock
* @Version; .01
*  IT 145
*  4.5 People's weights (Java)
****************************/

import java.util.Scanner;

public class PeopleWeights {
   public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		// Setup a double array to hold weights
		double weights[] = new double[5];

		// Get all the requested weights
		System.out.println("Enter weight 1: ");
		weights[0] = scnr.nextDouble();
		System.out.println("Enter weight 2: ");
		weights[1] = scnr.nextDouble();
		System.out.println("Enter weight 3: ");
		weights[2] = scnr.nextDouble();
		System.out.println("Enter weight 4: ");
		weights[3] = scnr.nextDouble();
		System.out.println("Enter weight 5: ");
		weights[4] = scnr.nextDouble();
		System.out.println("");

		// Print out the weights nicely
		System.out.print("You entered: ");
		for(int i = 0; i < weights.length; i++){
			System.out.print(weights[i] + " ");
		}
		// Adding for persnicity compile test
		System.out.println("");

		// Find the sum of all the weights
		double sum = 0.0;
		for(int i = 0; i < weights.length; i++){
			sum += weights[i];
		}
		System.out.println("Total weight: " + sum);

		// Print the average of the weights
		double avg = sum / weights.length;
		System.out.println("Average weight: " + avg);

		// Print the max weight
		double max = -1;
		for(int i = 0; i < weights.length; i++){
			if(max < weights[i]){
				max = weights[i];
			}
		}
		System.out.println("Max weight: " + max);
   }
}