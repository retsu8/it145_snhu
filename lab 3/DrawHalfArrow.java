/***************************
*  @Author William Paddock
* @Version; .01
*  IT 145
*  3-3 LAB*: Program: Drawing a half arrow
****************************/

import java.util.Scanner; 

public class DrawHalfArrow {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      /* collect the information for the arrow */
      int arrowBaseHeight;
      int arrowBaseWidth = 0;
      int arrowHeadWidth = 0;
      
      System.out.println("Enter arrow base height:");
      arrowBaseHeight = scnr.nextInt();
      
      System.out.println("Enter arrow base width:");
      arrowBaseWidth = scnr.nextInt();
      
      while (arrowHeadWidth <= arrowBaseWidth){
            System.out.println("Enter arrow head width:");
            arrowHeadWidth = scnr.nextInt();
      }
      System.out.println("");

      // Draw arrow base (height = arrowBaseHeight, width = arrowBaseWidth)
      for (int i = 0; i < arrowBaseHeight; i++){
         for(int j = 0; j < arrowBaseWidth; j++){
            System.out.print("*");
         }
         System.out.println("");
      }
      
      // Draw arrow head (width = arrowHeadWidth)
      for (int i = arrowHeadWidth; i > 0; i--){
         for(int j = 0; j < i; j++){
            System.out.print("*");
         }
         System.out.println("");
      }
   }
}