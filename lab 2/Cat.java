/***************************
*  William Paddock
*  IT 145
*  2-3 Assignment: Write a Class
****************************/

import java.util.Scanner;

public class Pet {
   private String petName;
   private String petType;
   private int petAge;
   private int dogSpaces;
   private int catSpaces;
   private int daysStay;
   private double amountDue;
   public static void main(String[] args){

   }
   public static String getPetType(){
      return this.getPetType
   }
   public static void getPetType(String petType){
      this.getPetType = petType;
   }
   public static String getPetName(){
      return this.getPetName;
   }
   public static void setPetName(String petName){
      this.petName = petName;
   }
   public static int getPetAge(){
      return this.petAge;
   }
   public static void setPetAge(int petAge){
      this.petAge = petAge;
   }
   public static int getDogSpaces(){
      return this.dogSpaces;
   }
   public static void setDogSpaces(int dogSpaces){
      this.dogSpaces = dogSpaces;
   }
   public static int getCatSpaces(){
      return this.catSpaces;
   }
   public static void setCatSpaces(int catSpaces){
      this.setCatSpaces = catSpaces;
   }
   public static int getDaysStay(){
      return this.daysStay;
   }
   public static void setDaysStay(int daysStay){
      this.daysStay = daysStay;
   }
   public static double getAmountDue(){
         return this.amountDue;
   }
   public static void setAmountDue(double amount){
      this.amountDue = amount;
   }
}

public class Cat extends Pet {

   public static void main(String[] args) {

   }
}