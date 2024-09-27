/***************************
*  @Author William Paddock
* @Version; .01
*  IT 145
*  4_3 Project One
****************************/

import java.util.Scanner;

class Pet {

   /**
    * @Comment; Implmentation of the pet class and required attributes.
    * **/
   
   private String petName;
   private String petType;
   private int petAge;
   private int dogSpaces;
   private int catSpaces;
   private int daysStay;
   private double amountDue;
   public void Pet(){
      this.petName = "";
      this.petType = null;
      this.petAge = -1;
      this.dogSpaces = 30;
      this.catSpaces = 20;
      this.daysStay = 0;
      this.amountDue = 0.0;
   }

   public String getPetType(){
      // Return the type of pet
      return this.petType;
   }
   public void setPetType(String petType){
      // Set the pet type
      if (petType == "dog" || petType == "cat"){
         this.petType = petType;
      } else {
         this.petType = null;
      }
   }
   public String getPetName(){
      // Get the pet name
      return this.petName;
   }
   public void setPetName(String petName){
      // Set the pet name and make sure its a name, atleast 3 chars for name like tom
      if (petName.length() > 3){
         this.petName = petName;
      } else {
         // Else set the name to empty
         // TODO, reject name if to short
         this.petName = "";
      }
   }
   public int getPetAge(){
      // Get the pet age
      return this.petAge;
   }
   public void setPetAge(int petAge){
      // Set the pet age; make sure its 0 or more, cant be negitive age.
      if (petAge > 0){
         this.petAge = petAge;
      } else {
         this.petAge = 0;
      }
   }
   public int getDogSpaces(){
      // get the dog spaces total available
      return this.dogSpaces;
   }
   public void setDogSpaces(int dogSpaces){
      // set the total available dog spaces; must be more than 0; cant have -1 aviable.
      if (dogSpaces > 0){
         this.dogSpaces = dogSpaces;
      } else {
         this.dogSpaces = 0;
      }
   }
   public int getCatSpaces(){
      // return the total aviable cat spaces
      return this.catSpaces;
   }
   public void setCatSpaces(int catSpaces){
      // set the total available cat spaces; must be more than 0; cant have -1 aviable.
      if (catSpaces > 0){
         this.catSpaces = catSpaces;
      } else {
         this.catSpaces = 0;
      }
   }
   public int getDaysStay(){
      // Get the days of the stay
      return this.daysStay;
   }
   public void setDaysStay(int daysStay){
      // Set the number of days in a stay; cant stay 0 days, needs atleast 1
      if (daysStay > 0){
         this.daysStay = daysStay;
      } else {
         this.daysStay = 1;
      }
   }
   public double getAmountDue(){
      // Get the amount due
      return this.amountDue;
   }
   public void setAmountDue(double amount){
      // Set the amount due; can only charge 0 or more
      if (amountDue > 0){
         this.amountDue = amount;
      } else {
         this.amountDue = 0;
      }
   }
   public static void main(String[] args) {
      
   }
}