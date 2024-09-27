/***************************
*  William Paddock
*  IT 145
*  5.12 Online shopping cart (Java)
****************************/

public class ItemToPurchase {
   private String itemName = "";
   private int itemPrice = 0;
   private int itemQuantity = 0;
   
   public void setName(String name){
      this.itemName = name;
   }
   public String getName(){
      return this.itemName;
   }

  public void setPrice(int price){
      this.itemPrice = price;
   }
   public int getPrice(){
      return this.itemPrice;
   }

   public void setQuantity(int stock){
      this.itemQuantity = stock;
   }
   public int getQuantity(){
      return this.itemQuantity;
   }
   
   public void ItemToPurchase(String itemName, int itemPrice, int itemQuantity){
      this.itemName = itemName;
      this.itemPrice = itemPrice;
      this.itemQuantity = itemQuantity;
   }

   //print item to purchase
   public void printItemPurchase() {
      System.out.println(itemQuantity + " " + itemName + " $" + itemPrice +  
                         " = $" + (itemPrice * itemQuantity));
   }
}
