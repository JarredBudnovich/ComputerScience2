// Jarred Budnovich
// N00876503
// 11/15/16      COP3503  Assignment 6

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;


public class n00876503 extends Application {
      @Override
      public void start(Stage primaryStage){
         HBox hbox = new HBox(15);
    
    
                                                                           //Create a Digital Clock & Analog Clock with Random Time  
          ClockPane clock = new ClockPane();
          Random rand = new Random();
          int hour = rand.nextInt(24) + 1;
          int minute = rand.nextInt(60) + 1;
          int second = rand.nextInt(60) + 1;
          
          clock.setHour(hour);
          clock.setMinute(minute);
          clock.setSecond(second);
          
          String timeString = hour + ":" + minute + ":" + second;
          Label labelForCurrentTime = new Label(timeString);
          Text myName = new Text(150, 150, "Jarred Budnovich");
      
          BorderPane clockpane = new BorderPane();
          clockpane.setCenter(clock);
          clockpane.setBottom(labelForCurrentTime);
          BorderPane.setAlignment(labelForCurrentTime, Pos.CENTER);
          
          hbox.getChildren().add(clockpane);
                                                                           //Ends the Creation of the Clock
    
                                                                           //Start of the Hangman Drawing
          Pane hangmanpane = new Pane();
          
          Arc arc = new Arc(50, 300, 80, 80, 60, 60);
          arc.setFill(Color.TRANSPARENT);
          arc.setType(ArcType.OPEN);
          arc.setStroke(Color.BLACK);
          hangmanpane.getChildren().add(arc); 
          
          Line line1 = new Line(50, 220, 50, 25);
          line1.setStrokeWidth(1);
          line1.setStroke(Color.BLACK);
          hangmanpane.getChildren().add(line1);
          
          Line line2 = new Line(50, 25, 150, 25);
          line2.setStrokeWidth(1);
          line2.setStroke(Color.BLACK);
          hangmanpane.getChildren().add(line2);
          
          Line line3 = new Line(150, 25, 150, 160);
          line3.setStrokeWidth(1);
          line3.setStroke(Color.BLACK);
          hangmanpane.getChildren().add(line3);
          
          Line line4 = new Line(150, 160, 120, 210);
          line4.setStrokeWidth(1);
          line4.setStroke(Color.BLACK);
          hangmanpane.getChildren().add(line4);
          
          Line line5 = new Line(150, 160, 180, 210);
          line5.setStrokeWidth(1);
          line5.setStroke(Color.BLACK);
          hangmanpane.getChildren().add(line5);
          
          Line line6 = new Line(150, 80, 180, 120);
          line6.setStrokeWidth(1);
          line6.setStroke(Color.BLACK);
          hangmanpane.getChildren().add(line6);
          
          Line line7 = new Line(150, 80, 120, 120);
          line7.setStrokeWidth(1);
          line7.setStroke(Color.BLACK);
          hangmanpane.getChildren().add(line7);
          
          Circle head = new Circle();
          head.setRadius(20);
          head.setCenterX(150);
          head.setCenterY(60);
          head.setFill(Color.LIGHTGREY);
          head.setStroke(Color.BLACK);
          hangmanpane.getChildren().add(head);
          
          hbox.getChildren().add(hangmanpane);
                                                                              //Ends the Hangman Drawing
    
                                                                              //Begins the Fan Drawings
          Pane stackpane1 = new StackPane();
          Pane stackpane2 = new StackPane();
          Pane stackpane3 = new StackPane();
          Pane stackpane4 = new StackPane();
          
          GridPane gridpane = new GridPane();
          gridpane.setAlignment(Pos.CENTER);
          gridpane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
          gridpane.setHgap(7);
          gridpane.setVgap(7);
          
                                                                              //Begins Fan #1     
          Pane fan1 = new Pane();
          
          Circle circle1 = new Circle();
          circle1.setRadius(60);
          circle1.setCenterX(150);
          circle1.setCenterY(250);
          circle1.setFill(Color.WHITE);
          circle1.setStroke(Color.BLACK);
          stackpane1.getChildren().add(circle1);
          
          Arc arc1 = new Arc(60, 60, 55, 55, 30, 35); 
          arc1.setFill(Color.BLACK); 
          arc1.setType(ArcType.ROUND); 
          fan1.getChildren().add(arc1); 
             
          
          Arc arc2 = new Arc(60, 60, 55, 55, 30 + 90, 35);
          arc2.setFill(Color.BLACK);
          arc2.setType(ArcType.ROUND);
          fan1.getChildren().add(arc2);
      
      
          Arc arc3 = new Arc(60, 60, 55, 55, 30 + 180, 35);
      
          arc3.setFill(Color.BLACK);
          arc3.setType(ArcType.ROUND);
          fan1.getChildren().add(arc3);
      
          
          Arc arc4 = new Arc(60, 60, 55, 55, 30 + 270, 35);
      
          arc4.setFill(Color.BLACK);
          arc4.setType(ArcType.ROUND);
          fan1.getChildren().add(arc4); 
                                                                                 //Ends Fan #1
          
                                                                                 //Begins Fan #2
          Pane fan2 = new Pane();
      
          
          Circle circle2 = new Circle();
          circle2.setRadius(60);
          circle2.setCenterX(150);
          circle2.setCenterY(250);
          circle2.setFill(Color.WHITE);
          circle2.setStroke(Color.BLACK);
          stackpane2.getChildren().add(circle2);
          
          Arc arc5 = new Arc(60, 60, 55, 55, 30, 35); 
          arc5.setFill(Color.BLACK); 
          arc5.setType(ArcType.ROUND); 
          fan2.getChildren().add(arc5); 
             
          
          Arc arc6 = new Arc(60, 60, 55, 55, 30 + 90, 35);
          arc6.setFill(Color.BLACK);
          arc6.setType(ArcType.ROUND);
          fan2.getChildren().add(arc6);
      
      
          Arc arc7 = new Arc(60, 60, 55, 55, 30 + 180, 35);
          arc7.setFill(Color.BLACK);
          arc7.setType(ArcType.ROUND);
          fan2.getChildren().add(arc7);
      
          
          Arc arc8 = new Arc(60, 60, 55, 55, 30 + 270, 35);
          arc8.setFill(Color.BLACK);
          arc8.setType(ArcType.ROUND);
          fan2.getChildren().add(arc8); 
                                                                                    //Ends Fan #2
             
                                                                                    //Begins Fan #3
          Pane fan3 = new Pane();
          
          Circle circle3 = new Circle();
          circle3.setRadius(60);
          circle3.setCenterX(150);
          circle3.setCenterY(250);
          circle3.setFill(Color.WHITE);
          circle3.setStroke(Color.BLACK);
          stackpane3.getChildren().add(circle3);
          
          Arc arc9 = new Arc(60, 60, 55, 55, 30, 35); 
          arc9.setFill(Color.BLACK); 
          arc9.setType(ArcType.ROUND); 
          fan3.getChildren().add(arc9); 
             
          
          Arc arc10 = new Arc(60, 60, 55, 55, 30 + 90, 35);
          arc10.setFill(Color.BLACK);
          arc10.setType(ArcType.ROUND);
          fan3.getChildren().add(arc10);
      
      
          Arc arc11 = new Arc(60, 60, 55, 55, 30 + 180, 35);
          arc11.setFill(Color.BLACK);
          arc11.setType(ArcType.ROUND);
          fan3.getChildren().add(arc11);
      
          
          Arc arc12 = new Arc(60, 60, 55, 55, 30 + 270, 35);
          arc12.setFill(Color.BLACK);
          arc12.setType(ArcType.ROUND);
          fan3.getChildren().add(arc12); 
                                                                                       //Ends Fan #2
          
          
                                                                                       //Begins Fan #4
          Pane fan4 = new Pane();
              
          Circle circle4 = new Circle();
          circle4.setRadius(60); 
          circle4.setCenterX(150);
          circle4.setCenterY(250);
          circle4.setStroke(Color.BLACK);
          circle4.setFill(Color.WHITE);
          stackpane4.getChildren().add(circle4);
          
          Arc arc13 = new Arc(60, 60, 55, 55, 30, 35); 
          arc13.setFill(Color.BLACK); 
          arc13.setType(ArcType.ROUND); 
          fan4.getChildren().add(arc13); 
             
          
          Arc arc14 = new Arc(60, 60, 55, 55, 30 + 90, 35);
          arc14.setFill(Color.BLACK);
          arc14.setType(ArcType.ROUND);
          fan4.getChildren().add(arc14);
      
      
          Arc arc15 = new Arc(60, 60, 55, 55, 30 + 180, 35);
          arc15.setFill(Color.BLACK);
          arc15.setType(ArcType.ROUND);
          fan4.getChildren().add(arc15);
      
          
          Arc arc16 = new Arc(60, 60, 55, 55, 30 + 270, 35);
          arc16.setFill(Color.BLACK);
          arc16.setType(ArcType.ROUND);
          fan4.getChildren().add(arc16);
          
          stackpane1.getChildren().add(fan1);
          stackpane2.getChildren().add(fan2);
          stackpane3.getChildren().add(fan3);
          stackpane4.getChildren().add(fan4);
          
          gridpane.add(stackpane1, 0, 0);                                                 //Gridpane to Organize the Fans
          gridpane.add(stackpane2, 0, 1);
          gridpane.add(stackpane3, 1, 0);
          gridpane.add(stackpane4, 1, 1);  
          
          hbox.getChildren().add(gridpane);
                                                                                          //Ends Fan #4         
          
          Scene scene = new Scene(hbox);                                                  //Creates the Scene and Stage for Javafx Program
          primaryStage.setTitle("Assignment Number 6 - Jarred Budnovich");                //Sets Title of Window for Program
          primaryStage.setScene(scene);                                                   //Creates Scene
          primaryStage.show();                                                            //Shows the Scene and Stage
      }
      
      public static void main(String[] args) {                                            //Main method to run within JGrasp IDE
         Application.launch(args);
      }
}

class ClockPane extends Pane {
        private int hour;
        private int minute;
        private int second;
      
                                                                                          //Clock pane's width and height
        private double w = 250, h = 250;
        
                                                                                          //Construct a default clock with the current time
        public ClockPane() {
          setCurrentTime();
        }
      
                                                                                          //Construct a clock with specified hour, minute, and second
        public ClockPane(int hour, int minute, int second) {
          this.hour = hour;
          this.minute = minute;
          this.second = second;
          paintClock();
        }
      
                                                                                          //Return hour
        public int getHour() {
          return hour;
        }
      
                                                                                          //Set a new hour
        public void setHour(int hour) {
          this.hour = hour;
          paintClock();
        }
      
                                                                                          //Return minute
        public int getMinute() {
          return minute;
        }
      
                                                                                          //Set a new minute
        public void setMinute(int minute) {
          this.minute = minute;
          paintClock();
        }
      
                                                                                          //Return second
        public int getSecond() {
          return second;
        }
      
                                                                                          //Set a new second
        public void setSecond(int second) {
          this.second = second;
          paintClock();
        }
      
                                                                                          // Return clock pane's width 
        public double getW() {
          return w;
        }
        
                                                                                          //Set clock pane's width 
        public void setW(double w) {
          this.w = w;
          paintClock();
        }
        
                                                                                          //Return clock pane's height 
        public double getH() {
          return h;
        }
        
                                                                                          //Set clock pane's height
        public void setH(double h) {
          this.h = h;
          paintClock();
        }
        
                                                                                          //Set the current time for the clock
        public void setCurrentTime() {
                                                                                          // Construct a calendar for the current date and time
          Calendar calendar = new GregorianCalendar();
      
                                                                                          // Set current hour, minute and second
          this.hour = calendar.get(Calendar.HOUR_OF_DAY);
          this.minute = calendar.get(Calendar.MINUTE);
          this.second = calendar.get(Calendar.SECOND);
          
          paintClock();                                                                   //Repaint the Clock
        }
        
                                                                                          //Paint the Clock
        private void paintClock() {
                                                                                          //Initialize Clock Parameters
          double clockRadius = Math.min(w, h) * 0.8 * 0.5;
          double centerX = w / 2;
          double centerY = h / 2;
      
                                                                                          //Draws Circle
          Circle circle = new Circle(centerX, centerY, clockRadius);
          circle.setFill(Color.WHITE);
          circle.setStroke(Color.BLACK);
          Text t1 = new Text(centerX - 8, centerY - clockRadius + 12, "12");
          Text t2 = new Text(centerX - clockRadius + 3, centerY + 6, "9");
          Text t3 = new Text(centerX + clockRadius - 10, centerY + 6, "3");
          Text t4 = new Text(centerX - 5, centerY + clockRadius - 3, "6");
          Text name = new Text(centerX - clockRadius + 55, centerY + 5, "Jarred Budnovich");
          name.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.REGULAR, 12));
          
                                                                                          //Draws Second Hand
          double sLength = clockRadius * 0.8;
          double secondX = centerX + sLength * 
            Math.sin(second * (2 * Math.PI / 60));
          double secondY = centerY - sLength * 
            Math.cos(second * (2 * Math.PI / 60));
          Line sLine = new Line(centerX, centerY, secondX, secondY);
          sLine.setStroke(Color.DARKRED);
      
                                                                                          //Draws Minute Hand
          double mLength = clockRadius * 0.65;
          double xMinute = centerX + mLength * 
            Math.sin(minute * (2 * Math.PI / 60));
          double minuteY = centerY - mLength * 
            Math.cos(minute * (2 * Math.PI / 60));
          Line mLine = new Line(centerX, centerY, xMinute, minuteY);
          mLine.setStroke(Color.PURPLE);
          
                                                                                          //Draws Hour Hand
          double hLength = clockRadius * 0.5;
          double hourX = centerX + hLength * 
            Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
          double hourY = centerY - hLength *
            Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
          Line hLine = new Line(centerX, centerY, hourX, hourY);
          hLine.setStroke(Color.DARKORANGE);
          
          getChildren().clear();  
          getChildren().addAll(circle, t1, t2, t3, t4, name, sLine, mLine, hLine);
        }
}