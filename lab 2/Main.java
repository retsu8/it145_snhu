/***************************
*  @Author William Paddock
* @Version; .01
*  IT 145
*  2-3 Assignment: Write a Class
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
      this.petType = petType;
   }
   public String getPetName(){
      // Get the pet name
      return this.petName;
   }
   public void setPetName(String petName){
      // Set the pet name
      this.petName = petName;
   }
   public int getPetAge(){
      // Get the pet age
      return this.petAge;
   }
   public void setPetAge(int petAge){
      // Set the pet age
      this.petAge = petAge;
   }
   public int getDogSpaces(){
      // get the dog spaces total available
      return this.dogSpaces;
   }
   public void setDogSpaces(int dogSpaces){
      // set the total available dog spaces
      this.dogSpaces = dogSpaces;
   }
   public int getCatSpaces(){
      // return the total aviable cat spaces
      return this.catSpaces;
   }
   public void setCatSpaces(int catSpaces){
      // Set the total aviable cat spaces
      this.catSpaces = catSpaces;
   }
   public int getDaysStay(){
      // Get the days of the stay
      return this.daysStay;
   }
   public void setDaysStay(int daysStay){
      // Set the number of days in a stay
      this.daysStay = daysStay;
   }
   public double getAmountDue(){
      // Get the amount due
      return this.amountDue;
   }
   public void setAmountDue(double amount){
      // Set the amount due
      this.amountDue = amount;
   }
}

class Cat extends Pet {
   /**
    * @Comment; This Class initiates the Cat extension from pet
    * **/
   private int catSpaceNumber;
   public Cat(){
      // Main instatiation function
      this.catSpaceNumber = 0;
      this.setPetType("Cat");
      this.setCatSpaces(30);
   }
   public void setCatSpaceNumber(int catSpaces) {
      // Set the number of spaces for cats
      this.catSpaceNumber = catSpaces;
   }
   public int getCatSpaceNumber(){
      // Return the number of used cat spaces.
      return this.catSpaceNumber;
   }
}

class Dog extends Pet {
   /**
    * @Comment; This Class initiates the Dog extension from pet
    * **/
   private int dogSpaceNumber;
   private double dogWeight;
   private Boolean grooming;
   public Dog(){
      this.dogSpaceNumber = 0;
      this.grooming = false;
      this.dogWeight = -1;
      this.setPetType("Dog");
      this.setDogSpaces(30);
   }
   public int getDogSpaceNumber(){
      // Return the number of used dog spaces.
      return this.dogSpaceNumber;
   }
   public void setDogSpaceNumber(int dogSpaces){
      // Set the number of used spaces
      this.dogSpaceNumber = dogSpaces;
   }
   public void setDogWeight(double weight){
      // Set the weight
      this.dogWeight = weight;
   }
   public double getDogWeight(){
      // Return the weight
      return this.dogWeight;
   }
   public boolean getGrooming(){
      // Is this grooming
      return this.grooming;
   }
   public void setGrooming(boolean groom){
      // Set if grooming needed.
      this.grooming = groom;
   }
   public boolean checkIfGroomAble(){
      // Get the days set in the stay
      int days_stay = this.getDaysStay();

      // Check if long enough to groom
      if(days_stay >= 2) {
         return true;
      } else return false;
   }
}

public class Main{
   public static void main(String[] args){
      // Main java class used to instantiate Pet.
   }
}