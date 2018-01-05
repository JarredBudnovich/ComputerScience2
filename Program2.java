// Jarred Budnovich
// N00876503
// 9/11/16      COP3503  Assignment 2

import java.util.Scanner;

public class n00876503 {
   public static void main(String[] args) {
   
      Scanner input = new Scanner(System.in);

      System.out.println("Please input a single odd positive integer that you would like to be the last denominator of the sum of a series.");
      double Denominator = input.nextInt();
      
      double Numerator = Denominator - 2;          //Finds the final numerator
      double Fraction = Numerator / Denominator;   //Finds the final fraction value to end the upcoming While loop
      double x = 1;                                //First numerator value
      double y = 3;                                //First denominator value
      double z = x / y;                            //Initial fraction of the series
      double w = 0;                                //For the While loop
      double Sum = 0;                              //Initial Sum of Series
      
      Sum = Sum + z;
      
      while (w < Fraction)  {             //Creates a sum of fractions
         x = x + 2;
         y = y + 2;
         z = x / y;
         Sum = Sum + z;
         w = z;
         
      }

      System.out.printf("The sum of the series with your value as the last denominator is :  %6.12f\n", Sum);   


       double SecondDenominator = Denominator / 2 + 1;            //Reverse computation to figure out the last denominator value for the Pi formula
       double i = 1;                                              //Starts at 1 so the loop doesn't add an extra value of 1 to the PieSum (Figured out while Debugging)
       double PieSum = 0;                                         //Initial Sum
       double Pie = 0;                                            //Initial Value
       
       while( i < SecondDenominator) {                            //While loop to collect a sum for partial Pi calculation
  
         Pie = (Math.pow(-1, i + 1)) / (2 * i - 1);
         PieSum = PieSum + Pie;
         i++;

       } 
       
       double RealPie = 4 * PieSum;                               //Finishes the computation for Pi
       
       System.out.printf("The Approximate Value of Pi with your given input is :              %6.12f\n", RealPie);
}
}