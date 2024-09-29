/***************************
*  William Paddock
*  IT 145
*  5.12 Online shopping cart (Java)
****************************/

import java.util.Scanner;

public class ShoppingCartPrinter {
   public static void main(String[] args) {
      /* Setup the main class for shopping cart */

      // Setup new scanner
      Scanner scnr = new Scanner(System.in);

      // Setup the needed variables
      int i = 0;
      String productName;
      int productPrice = 0;
      int productQuantity = 0;
      int cartTotal = 0;
  
      // Build the first item
      System.out.println("Item 1");
      
      // Build the initial item
      ItemToPurchase item1 = new ItemToPurchase();

      // Get the new item name
      System.out.println("Enter the item name: ");
      productName = scnr.nextLine();
      item1.setName(productName);

      // Get the new item price
      System.out.println("Enter the item price: ");
      productPrice = scnr.nextInt();
      item1.setPrice(productPrice);

      // Get the new item quantity
      System.out.println("Enter the item quantity: ");
      productQuantity = scnr.nextInt();
      item1.setQuantity(productQuantity);

      // Clean the the scanner for new item
      System.out.println();
      scnr.nextLine();

      // Build the second item
      System.out.println("Item 2");
      ItemToPurchase item2 = new ItemToPurchase();

      // Get the new item name
      System.out.println("Enter the item name: ");
      productName = scnr.nextLine();
      item2.setName(productName);

      // Get the new item price
      System.out.println("Enter the item price: ");
      productPrice = scnr.nextInt();
      item2.setPrice(productPrice);

      // Get the new item quantity
      System.out.println("Enter the item quantity: ");
      productQuantity = scnr.nextInt();
      item2.setQuantity(productQuantity);
      
      // Seperating out total
      System.out.println();
      
      // Get the total item cost
      System.out.println("TOTAL COST");
      item1.printItemPurchase();
      item2.printItemPurchase();

      // Calculate the cart total
      System.out.println();
      cartTotal = item1.getTotal() + item2.getTotal();
      System.out.println("Total: $" + cartTotal);
      return;
   }
}