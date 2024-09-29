/***************************
*  William Paddock
*  IT 145
*  5.12 Online shopping cart (Java)
****************************/

public class ItemToPurchase {
   /* Setup the variables for use */
   private String itemName = "";
   private int itemPrice = 0;
   private int itemQuantity = 0;
   

   public void setName(String name){
      /* Set the item name */
      this.itemName = name;
   }


   public String getName(){
      /* Return the item name */
      return this.itemName;
   }

  public void setPrice(int price){
      /* Set the item price */
      this.itemPrice = price;
   }

   public int getPrice(){
      /* Return the item price */
      return this.itemPrice;
   }

   public void setQuantity(int stock){
      /* Set the item quantity */
      this.itemQuantity = stock;
   }
   public int getQuantity(){
      /* Get the item quantity */
      return this.itemQuantity;
   }

   public int getTotal(){
      /* Build the total for the cart */
      return this.itemPrice * this.itemQuantity;
   }
   
   public void ItemToPurchase(String itemName, int itemPrice, int itemQuantity){
      /* Setup the item defaults for purchase */
      this.itemName = itemName;
      this.itemPrice = itemPrice;
      this.itemQuantity = itemQuantity;
   }

   public void printItemPurchase() {
      /* Print the items to purchase */
      System.out.println(itemName + " " + itemQuantity + " @" + " $" + itemPrice +  
                         " = $" + (itemPrice * itemQuantity));
   }
}
