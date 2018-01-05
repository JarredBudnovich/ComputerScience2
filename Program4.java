// Jarred Budnovich
// N00876503
// 10/20/16      COP3503  Assignment 4

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class n00876503  {
   public static void main(String[] args) throws FileNotFoundException {
   
   Scanner x = new Scanner(new File(args[0]));                             //Created a scanner for a file opened from the args0 command line slot
      String Line = new String();


   ArrayList<vehicle> vehicleList = new ArrayList<vehicle>();        //Created an ArrayList to store the records
   
   
      boolean convertible;
      boolean detroit;
      boolean union;   
      
   while(x.hasNextLine()) {                        //while loop with nested for loops to scan each record based on the type of vehicle scanned
      String kind = x.nextLine();

      if ("vehicle".equals(kind)) {                //vehicle record type scanned
         String type = "vehicle";
         String name = x.nextLine();
         String address = x.nextLine();
         String phone = x.nextLine();
         String email = x.nextLine();
         
         vehicleList.add(new vehicle(type, name, address, phone, email));        //added to ArrayList named vehicleList
      }
      
      else if ("car".equals(kind)) {               //car record type scanned
         String type = "car";
         String name = x.nextLine();
         String address = x.nextLine();
         String phone = x.nextLine();
         String email = x.nextLine();
         String bool = x.nextLine();
         
         if (bool.equals("true"))
            convertible = true;
         else
            convertible = false;
         String color = x.nextLine();
         
         vehicleList.add(new car(type, name, address, phone, email, convertible, color));       //added to ArrayList named vehicleList
      }
      
      else if ("american car".equals(kind)) {      //american car record type scanned
         String type = "american car";
         String name = x.nextLine();
         String address = x.nextLine();
         String phone = x.nextLine();
         String email = x.nextLine();
         String bool = x.nextLine();
         
         if (bool.equals("true"))
            convertible = true;
         else
            convertible = false;
         String color = x.nextLine();
         if (bool.equals("true"))
            detroit = true;
         else
            detroit = false;
         if (bool.equals("true"))
            union = true;
         else
            union = false;

         vehicleList.add(new american_car(type, name, address, phone, email, convertible, color, detroit, union));         //added to ArrayList named vehicleList
      }
      
      else if ("foreign car".equals(kind)) {       //foreign car record type scanned
         String type = "foreign car";
         String name = x.nextLine();
         String address = x.nextLine();
         String phone = x.nextLine();
         String email = x.nextLine();
         String bool = x.nextLine();
         
         if (bool.equals("true"))
            convertible = true;
         else
            convertible = false;
         String color = x.nextLine();
         String country = x.nextLine();
         float import_duty = Float.parseFloat(x.nextLine());
         
         vehicleList.add(new foreign_car(type, name, address, phone, email, convertible, color, country, import_duty));       //added to ArrayList named vehicleList
      }

      if ("bicycle".equals(kind)) {                //bicycle record type scanned
         String type = "bicycle";
         String name = x.nextLine();
         String address = x.nextLine();
         String phone = x.nextLine();
         String email = x.nextLine();
         int speeds = Integer.parseInt(x.nextLine());
         
         vehicleList.add(new bicycle(type, name, address, phone, email, speeds));               //added to ArrayList named vehicleList
      }

      if ("truck".equals(kind)) {                     //truck record type scanned
         String type = "truck";
         String name = x.nextLine();
         String address = x.nextLine();
         String phone = x.nextLine();
         String email = x.nextLine();
         float tons = Float.parseFloat(x.nextLine());
         float cost = Float.parseFloat(x.nextLine());
         String date = x.nextLine();
         
         vehicleList.add(new truck(type, name, address, phone, email, tons, cost, date));       //added to ArrayList named vehicleList
      }

      //else System.out.print("");
      
   }
   
   x.close();                    //closed the file for good programming practice
   
  // System.out.println(vehicleList);           //Used for debugging and printing excess vehicleList 
   printAll(vehicleList);                       //method in main to print every record from vehicleList
   sortEmail(vehicleList);                      //method in main to sort the records by email alphabetically
   recordCount(vehicleList);                    //method in main to count how many records are scanned
   printBikeTruck(vehicleList);                 //method in main to print only bikes and trucks from records scanned
   areaCode(vehicleList);                       //method in main to print only records from area code (987)
   }
   
   public static void printAll(ArrayList<vehicle> vehicleList) {        //Finds size of arraylist (vehicleList) and prints a new line for each classifier of that group
       System.out.println("\nAll records\n");
      for(int i = 0; i < vehicleList.size(); i++)
         System.out.println("\n" + vehicleList.get(i));
      
   }
   
   public static void sortEmail(ArrayList<vehicle> vehicleList) {                                                    //method sorts alphabetically by email
      System.out.println("\n////////////////////////////////////////////////////////////////////////////////\n");

      System.out.println("\nThe records sorted by email:\n");
      boolean resume = true;
      int a = 0;
      vehicle temp;
      //System.out.println(vehicleList.get(2).getEmail());     //used as a debugging print statement to check if it scanned a printed an email
      do {
         resume = false;
         a++;
      
         for(int i = 0; i < vehicleList.size() - a; i++) {
            String email1 = vehicleList.get(i).getEmail();
            String email2 = vehicleList.get(i + 1).getEmail();
            
            if((email1.compareTo(email2)) > 0) {
               temp = vehicleList.get(i);
               vehicleList.set(i,vehicleList.get(i + 1));
               vehicleList.set((i + 1), temp);
               resume = true;
            }
         }
      }while(resume);
            
      for(int i = 0; i < vehicleList.size(); i++) {
         System.out.println("\n" + vehicleList.get(i));      
      }
   }
   
   public static void recordCount(ArrayList<vehicle> vehicleList) {                                                        //method counts how many records and prints number
              System.out.println("\n////////////////////////////////////////////////////////////////////////////////\n");

      System.out.println("\nThe number of records is:\n");   
      System.out.println(vehicleList.size() + "\n"); 
   }
   
      public static void printBikeTruck(ArrayList<vehicle> vehicleList) {                                                  //method prints only bikes and trucks from file scanned
              System.out.println("\n////////////////////////////////////////////////////////////////////////////////\n");

      System.out.println("\nBike and Truck Records:\n");
      
      for(int i = 0; i < vehicleList.size(); i++) {
         if(vehicleList.get(i) instanceof bicycle || vehicleList.get(i) instanceof truck)
            System.out.println("\n" + vehicleList.get(i));
      }
   }
   
      public static void areaCode(ArrayList<vehicle> vehicleList) {                                                        //method prints only area code 987 records
      System.out.println("\n////////////////////////////////////////////////////////////////////////////////\n");

      System.out.println("\nThe records of area code (987):\n");
         for(int i = 0; i < vehicleList.size(); i++) {
            String areacode = vehicleList.get(i).getPhone();
            areacode = areacode.substring(0, 5);
               if (areacode.equals("(987)"))
                  System.out.println("\n" + vehicleList.get(i));
         }         
   }   
}

class vehicle   {             //initializes a vehicle class
   private String type;
   private String name;
   private String address;
   private String phone;
   private String email;
   
   vehicle() {}               //vehicle constructor
   
   public vehicle(String type, String name, String address, String phone, String email){     //vehicle object
      this.type = type;
      this.name = name;
      this.address = address;
      this.phone = phone;
      this.email = email;
   }
   
   public String getType() {           //getters and setters for vehicle class objects and parameters
      return type;
   }
   
   public void setType(String type) {
      this.type = type;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String getAddress() {
      return address;
   }
   
   public void setAddress(String Address) {
      this.address = address;
   }
   
   public String getPhone() {
      return phone;
   }
   
   public void setPhone(String phone) {
      this.phone = phone;
   }
   
   public String getEmail() {
      return email;
   }
   
   public void setEmail(String email) {
      this.email = email;
   }
   
   public String toString() {             //toString print statement that is called
     return "Type: " + type + "\n" + "name: " + name + "\naddress: " + address + "\nphone: " + phone + "\nemail: " + email;
   }
   
}
           
class car extends vehicle   {             //car class extending vehicle class
   //private String type;
   //private String name;
   //private String address;
   //private String phone;
   //private String email;
   private boolean convertible;
   private String color;
   
   car() {}       //car constructor
   
   public boolean getConvertible() {         //getters and setters of car class objects and parameters
      return convertible;
   }
   
   public void setConvertible(boolean convertible) {
      this.convertible = convertible;
   }
   
   public String getColor() {
      return color;
   }
   
   public void setColor(String color) {
      this.color = color;
   }
   
   public car(String type, String name, String address, String phone, String email, boolean convertible, String color) {      //car object
      setType(type);
      setName(name);
      setAddress(address);
      setPhone(phone);
      setEmail(email);
      this.convertible = convertible;
      this.color = color;
   }  
   
   public String toString() {    //toString print statement that is called
      return super.toString() + "\nconvertible: " + convertible + "\ncolor: " + color;
         }
      
}
   
   
class american_car extends car  {         //american car class extending car class
   //private String type;
   //private String name;
   //private String address;
   //private String phone;
   //private String email;
   //private boolean convertible;
   //private String color;
   private boolean detroit;
   private boolean union;
   
   public boolean getDetroit() {       //getters and setters for american car class
      return detroit;
   }
   
   public void setDetroit(boolean detroit) {
      this.detroit = detroit;
   }
   
   public boolean getUnionshop() {
      return union;
   }
   
   public void setUnionshop(boolean union) {
      this.union = union;
   }
   
 public american_car(String type, String name, String address, String phone, String email, boolean convertible, String color, boolean detroit, boolean union) {      //american car object
      setType(type);
      setName(name);
      setAddress(address);
      setPhone(phone);
      setEmail(email);
      setConvertible(convertible);
      setColor(color);
      this.detroit = detroit;
      this.union = union;
   }  
   
   public String toString() {    //toString print statement for american car
      return super.toString() + "\ndetroit: " + detroit + "\nunion shop: " + union;
         }
      
}
   
class foreign_car extends car  {    //foreign car class extending car class
   //private String type;
   //private String name;
   //private String address;
   //private String phone;
   //private String email;
   //private String convertible;
   //private String color;
   private String country;
   private float import_duty;
   
   public String getCountry() {        //getters and setters for foreign car
      return country;
   }
   
   public void setCountry(String country) {
      this.country = country;
   }
   
   public float getImportduty() {
      return import_duty;
   }
   
   public void setImportduty(float import_duty) {
      this.import_duty = import_duty;
   }
   
   public foreign_car(String type, String name, String address, String phone, String email, boolean convertible, String color, String country, float import_duty) {     //foreign car object
      setType(type);
      setName(name);
      setAddress(address);
      setPhone(phone);
      setEmail(email);
      setConvertible(convertible);
      setColor(color);
      this.country = country;
      this.import_duty = import_duty;
   }  
   
   public String toString() {       //toString print statement for foreign car
      return super.toString() + "\ncountry: " + country + "\nimport duty: " + import_duty;
         }
      
}
      
class bicycle extends vehicle   {         //bicycle class extending vehicle class
   //private String type;
   //private String name;
   //private String address;
   //private String phone;
   //private String email;
   private int speeds;
   
   public int getSpeeds() {         //getter and setter for bicycle
      return speeds;
   }
   
   public void setSpeeds(int speeds) {
      this.speeds = speeds;
   }
   
   public bicycle(String type, String name, String address, String phone, String email, int speeds) {       //bicycle object
      setType(type);
      setName(name);
      setAddress(address);
      setPhone(phone);
      setEmail(email);
      this.speeds = speeds;
   }  
   
   public String toString() {    //toString print statement for bicycle
      return super.toString() + "\nspeeds: " + speeds;
         }
      
}

class truck extends vehicle  {         //truck class extending vehicle
   //private String type;
   //private String name;
   //private String address;
   //private String phone;
   //private String email;
   private float tons;
   private float cost;
   private String date;
   
   public float getTons() {         //getters and setters for truck
      return tons;
   }
   
   public void setTons(float tons) {
      this.tons = tons;
   }
   
   public float getCost() {
      return cost;
   }
   
   public void setCost(float cost) {
      this.cost = cost;
   }
   
   public String getDate() {
      return date;
   }
   
   public void setDate(String date) {
      this.date = date;
   }
   
   public truck(String type, String name, String address, String phone, String email, float tons, float cost, String date) {     //truck object
      setType(type);
      setName(name);
      setAddress(address);
      setPhone(phone);
      setEmail(email);
      this.tons = tons;
      this.cost = cost;
      this.date = date;
   }  
   
   public String toString() {          //toString print statement for truck
      return super.toString() + "\ntons: " + tons + "\ncost" + cost + "\ndate: " + date;
         }
      
}
