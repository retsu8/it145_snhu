/***************************
*  William Paddock
*  IT 145
*  2-3 Assignment: Write a Class
****************************/

import java.util.Scanner;

class Pet {
   private String petName;
   private String petType;
   private int petAge;
   private int dogSpaces;
   private int catSpaces;
   private int daysStay;
   private double amountDue;
   public static void main(String[] args){

   }
   public String getPetType(){
      return this.petType;
   }
   public void getPetType(String petType){
      this.petType = petType;
   }
   public String getPetName(){
      return this.petName;
   }
   public void setPetName(String petName){
      this.petName = petName;
   }
   public int getPetAge(){
      return this.petAge;
   }
   public void setPetAge(int petAge){
      this.petAge = petAge;
   }
   public int getDogSpaces(){
      return this.dogSpaces;
   }
   public void setDogSpaces(int dogSpaces){
      this.dogSpaces = dogSpaces;
   }
   public int getCatSpaces(){
      return this.catSpaces;
   }
   public void setCatSpaces(int catSpaces){
      this.catSpaces = catSpaces;
   }
   public int getDaysStay(){
      return this.daysStay;
   }
   public void setDaysStay(int daysStay){
      this.daysStay = daysStay;
   }
   public double getAmountDue(){
         return this.amountDue;
   }
   public void setAmountDue(double amount){
      this.amountDue = amount;
   }
}


class Cat extends Pet {
   private int catSpaceNumber;
   public void setCatSpaceNumber(int catSpaces) {
      this.catSpaceNumber = catSpaces;
   }
   public int getCatSpaceNumber(){
      return this.catSpaceNumber;
   }
   class Dog extends Pet {

   }
}