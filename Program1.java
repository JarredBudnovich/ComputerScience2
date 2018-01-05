// Jarred Budnovich
// N00876503
// 9/4/16      COP3503  Assignment 1

import java.util.Scanner;

public class n00876503 {
   public static void main(String[] args) {
                                                   //Create Scanner
      Scanner input = new Scanner(System.in);
      
                                                  //Read Inputs
      System.out.print("Enter how far you want to drive: ");
      double Distance = input.nextDouble();
      
      System.out.print("Enter how many miles per gallon your car gets: ");
      double MPG = input.nextDouble();
      
      System.out.print("Enter the current price per gallon: $");
      double PricePerGallon = input.nextDouble();
      
                                                  //Calculate Cost
      double TotalCost = (((Distance) / (MPG)) * PricePerGallon);
      
      
      System.out.println("The total cost of driving is: $" + (int)(TotalCost * 100) / 100.0);
   }
}      
                                                                                                    