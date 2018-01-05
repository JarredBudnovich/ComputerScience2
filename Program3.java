// Jarred Budnovich
// N00876503
// 9/25/16      COP3503  Assignment 3

import java.util.Scanner;

public class n00876503  {
   public static void main(String[] args) {
   
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter 18 numbers to create two 3x3 arrays and compare them:");     //Scans the input data and forms 3x3 arrays
      int [][] list1 = new int[3][3];
         for (int i = 0; i < list1.length; i++){
            for(int j = 0; j < list1[i].length; j++){
               list1[i][j] = input.nextInt();      
            }
         }
         System.out.println("\nArray 1:");   
         for (int row = 0; row < list1.length; row++){                                       //Makes First 3x3 Array
            for(int col = 0; col < list1[row].length; col++) { 
               System.out.print(list1[row][col] + " ");
            }
            System.out.println();
         }
         
      int [][] list2 = new int[3][3];
         for (int i = 0; i < list2.length; i++){
            for(int j = 0; j < list2[i].length; j++){
               list2[i][j] = input.nextInt();      
            }
         }
         System.out.println("\nArray 2:");                                                   //Makes Second 3x3 Array
         for (int row = 0; row < list2.length; row++){
            for(int col = 0; col < list2[row].length; col++) { 
               System.out.print(list2[row][col] + " ");
            }
            System.out.println();
         }
      boolean a = Strict.equals(list1, list2);                                              //Calls to Methods from Strict Class And Outputs Data
      int b = Strict.how_many(list1, list2);
            System.out.println("\nNumber of identical cells: " + b);
      int c = Strict.diagonal(list1, list2);
            System.out.println("\nNumber of identical cells diagonally: " + c);
      double d = Strict.average(list1, list2);
            System.out.printf("\nThe average of all numbers is: %.2f\n", d);
      Strict.display(list1, list2);
      boolean f = Strict.silly(list1, list2);   
         
         
         
   }         
}         
         
         
class Strict {

   public static boolean equals(int[][] m1, int[][] m2) {                                 //Equates the two Arrays to check it they are identical
      for(int i = 0; i < m1.length; i++){
         for(int j = 0; j < m1.length; j++) {
            int z1 = m1[i][j];
            int z2 = m2[i][j];
            if (z1 != z2){
               System.out.println("\nThe two arrays are not strictly identical");
               return false;
            }
         }
      }
      System.out.println("\nThe two arrays are strictly identical");
      return true;
      
   }
         
   public static int how_many(int[][] m1, int[][] m2) {                                   //Counts how many cells  of the same spots from both arrays are identical
         int count = 0;
         for (int i = 0; i < m1.length; i++){
            for(int j = 0; j < m1[i].length; j++){
               int x = m1[i][j];
               int y = m2[i][j];
                  if (x == y)
                     count++;
            }
         } 
   return count;
   } 
   
   public static int diagonal(int[][] m1, int[][] m2) {                                   //Counts how many diagonal cells are identical between both arrays
         int count = 0;
         int i = 0;
         int j = 0;                        
               int x = m1[i][j];
               int y = m2[i][j];
                    if (m1[i][j] == m2[i][j]) {    
                        count += 1;
                    }
                    if (m1[i + 1][j + 1] == m2[i + 1][j+ 1]) {
                        count += 1;
                    }    
                    if (m1[i + 2][j + 2] == m2[i + 2][j +2]) {
                        count += 1;
                    }    
   return count;      
   }

  public static double average(int[][] m1, int [][] m2) {                                 //Calculates the Average of the total of both arrays
  int sum_m1 = 0;
  int sum_m2 = 0;
  for (int row = 0; row < m1.length; row++) {
    for (int col = 0; col < m1[row].length; col++) {
     sum_m1 += m1[row][col];
    }
  }
  
  for (int row = 0; row < m2.length; row++) {
    for (int col = 0; col < m2[row].length; col++) {
      sum_m2 += m2[row][col];
    }
  }
    
   double average = (double)(sum_m1 + sum_m2) / 18;
  
   return average; 
  }

   public static void display(int[][] m1, int[][] m2){                                    //Displays only the odd values in the array cells
      System.out.println("\nOdd values in Array 1: ");
      for (int row = 0; row < m1.length; row++) {
         for (int col = 0; col < m1[row].length; col++) {
           if(m1[row][col]%2 == 0){
           System.out.print("  ");
           }
           else {
           System.out.print(m1[row][col] + " ");
           }
         }
         System.out.println();
      }
      System.out.println("\nOdd values in Array 2: ");
      for (int row = 0; row < m2.length; row++) {
         for (int col = 0; col < m2[row].length; col++) {
           if(m2[row][col]%2 == 0){
           System.out.print("  ");
           }
           else {
           System.out.print(m2[row][col] + " ");
           }
         }
         System.out.println();
      }
   } 
 
   public static boolean silly(int[][] m1, int[][] m2) {                                  //Check if all numbers in arrays satisfy 1 < number <= 10
       int count = 0;
       for (int row = 0; row < m1.length; row++) {
         for (int col = 0; col < m1[row].length; col++) {
           if(1 < m1[row][col] && m1[row][col] <= 10) {
               count += 1;
           }
           else
               count = count;
         }
       }
       for (int row = 0; row < m2.length; row++) {
         for (int col = 0; col < m2[row].length; col++) {
           if(1 < m2[row][col] && m2[row][col] <= 10) {
               count += 1;
           }
           else
               count = count;
         }
       }

      if (count == 18) {
         System.out.println("\nAll values satisfied greater than 1 and less than or equal to 10!");
         return true;
      }   
      else {
         System.out.println("\nNot all values satisfied greater than 1 and less than or equal to 10!");
         return false;              
      }
   }
   
    
}
      