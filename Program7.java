// Jarred Budnovich
// N00876503
// 11/29/16      COP3503  Assignment 7


import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;




class ButtonDemo extends Application {
  protected Text text = new Text(150, 80, "Jarred Budnovich");
  
  GridPane grid = new GridPane();
 
  protected BorderPane getPane() {
    HBox paneForButtons = new HBox(20);
    Button btUp = new Button("UP");
    Button btDown = new Button("DOWN");   
    paneForButtons.getChildren().addAll(btUp, btDown);
    paneForButtons.setAlignment(Pos.CENTER);
    paneForButtons.setStyle("-fx-border-color: blue");

    BorderPane pane = new BorderPane();
    pane.setBottom(paneForButtons);
    
    Pane paneForText = new Pane();
    paneForText.getChildren().add(text);
    grid.add(paneForText, 0, 0);
    
    grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    grid.setHgap(5.5);
    grid.setVgap(5.5);
    
    pane.setCenter(grid);
    
    btUp.setOnAction(e -> text.setY(text.getY() - 10));
    btDown.setOnAction(e -> text.setY(text.getY() + 10));
    
    return pane;
  }
  
   @Override                                                         // Override the start method in the Application class
  public void start(Stage primaryStage) {
    Scene scene = new Scene(getPane(), 1000, 600);                   // Create a scene and place it in the stage
    primaryStage.setTitle("COP3503 Assignment 7");                   // Sets the stage window title
    primaryStage.setScene(scene);                                    // Places the scene in the stage
    primaryStage.show();                                             // Displays the stage window
  }
  
  
  }
  
class CheckBoxDemo extends ButtonDemo {
  @Override 
    protected BorderPane getPane() {
    BorderPane pane = super.getPane();

    Font fontBoldItalic = Font.font("Calibri", 
      FontWeight.BOLD, FontPosture.ITALIC, 12);
    Font fontBold = Font.font("Calibri", 
      FontWeight.BOLD, FontPosture.REGULAR, 12);
    Font fontItalic = Font.font("Calibri", 
      FontWeight.NORMAL, FontPosture.ITALIC, 12);
    Font fontNormal = Font.font("Calibri", 
      FontWeight.NORMAL, FontPosture.REGULAR, 12);
    text.setFont(fontNormal);
    
    VBox paneForCheckBoxes = new VBox(20);
    paneForCheckBoxes.setPadding(new Insets(7, 7, 7, 7)); 
    paneForCheckBoxes.setStyle("-fx-border-width: 1px; -fx-border-color: darkred");
    CheckBox chkBold = new CheckBox("Bold");
    CheckBox chkItalic = new CheckBox("Italic");
    paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
    pane.setLeft(paneForCheckBoxes);

          EventHandler<ActionEvent> handler = e -> { 
            if (chkBold.isSelected() && chkItalic.isSelected()) {
              text.setFont(fontBoldItalic);                                                     // Both check boxes checked
            }
            else if (chkBold.isSelected()) {
              text.setFont(fontBold);                                                           // The Bold check box checked
            }
            else if (chkItalic.isSelected()) {
              text.setFont(fontItalic);                                                         // The Italic check box checked
            }      
            else {
              text.setFont(fontNormal);                                                         // Both check boxes unchecked
            }
          };   
          chkBold.setOnAction(handler);
          chkItalic.setOnAction(handler);
          return pane; 
          }
}
  
class RadioButtonDemo extends CheckBoxDemo {
 @Override 
    protected BorderPane getPane() {
    BorderPane pane = super.getPane();
    
    VBox paneForRadioButtons = new VBox(20);
    paneForRadioButtons.setPadding(new Insets(7, 7, 7, 7)); 
    paneForRadioButtons.setStyle("-fx-border-color: darkblue");
    paneForRadioButtons.setStyle("-fx-border-width: 1px; -fx-border-color: darkblue");
    RadioButton rbPlum = new RadioButton("Plum");
    RadioButton rbChocolate = new RadioButton("Chocolate");
    RadioButton rbOlive = new RadioButton("Olive");
    paneForRadioButtons.getChildren().addAll(rbPlum, rbChocolate, rbOlive);
    pane.setRight(paneForRadioButtons);

    ToggleGroup group = new ToggleGroup();
    rbPlum.setToggleGroup(group);
    rbChocolate.setToggleGroup(group);
    rbOlive.setToggleGroup(group);
    
          rbPlum.setOnAction(e -> {
            if (rbPlum.isSelected()) {
              text.setFill(Color.PLUM);
            }
          });
          
          rbChocolate.setOnAction(e -> {
            if (rbChocolate.isSelected()) {
              text.setFill(Color.CHOCOLATE);
            }
          });
      
          rbOlive.setOnAction(e -> {
            if (rbOlive.isSelected()) {
              text.setFill(Color.OLIVE);
            }
          });
          
    return pane;
   }
  
}
  
 
class BounceBoxSlider extends RadioButtonDemo {
  
  private Timeline animation;
  private int dx = 1;
  private int dy = -1;
  private int x = 750;
  private int y = 10;
  
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();
    BorderPane paneForSlider = new BorderPane();
    
    int speed = 1;
    
    Slider slHorizontal = new Slider();
    slHorizontal.setMax(20);
    slHorizontal.setMin(1);
    slHorizontal.setShowTickMarks(true);
    paneForSlider.setBottom(slHorizontal);
    
    Pane paneForBox = new Pane();
    paneForBox.setPrefSize(1000, 100);
    Rectangle box = new Rectangle(0, 0);
    box.setWidth(100);
    box.setHeight(30);
    box.setX(300);
    box.setY(30);
    box.setFill(Color.DARKRED);
    
    animation = new Timeline(new KeyFrame(Duration.millis(50), e-> moveRectangle(box, speed, slHorizontal)));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play();
    
    paneForBox.getChildren().add(box);
    paneForSlider.setCenter(paneForBox);
    
    pane.setTop(paneForSlider);
    
    return pane;
    
    }
    
  void moveRectangle(Rectangle r, int speed, Slider s) {
    speed = ((int) s.getValue());
    
    if(r.getX() > 960 || r.getX() < 0) {
      dx *= -1;
    }
    
    if(r.getY() < 5 || r.getY() > 80) {
      dy *= -1;
    }
    
    x += dx * speed;
    y += dy * speed;
    
    r.setX(x);
    r.setY(y);
    }    
      
  }

  
public class n00876503 extends BounceBoxSlider {               //Had issues getting the .mp4 file to reszie to fit the screen. The unfortunately messes up the rest of the stage. If it wasnt for the 
  private static final String MEDIA_URL =                      // video size, the rest of the program runs as it should. Usually before the video loads from the server, you can see everything working.
    "http://www.unf.edu/~n00876503/test2.mp4";

  @Override 
    protected BorderPane getPane() {
    BorderPane pane = super.getPane();
    
    Media media = new Media(MEDIA_URL);
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    MediaView mediaView = new MediaView(mediaPlayer);

    Button playButton = new Button("-->");
    playButton.setOnAction(e -> {
      if (playButton.getText().equals("-->")) {
        mediaPlayer.play();
        playButton.setText("||");
      } else {
        mediaPlayer.pause();
        playButton.setText("-->");
      }
    });

    Button rewindButton = new Button("<<--");
    rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));
    
    Slider slVolume = new Slider();
    slVolume.setPrefWidth(150);
    slVolume.setMaxWidth(Region.USE_PREF_SIZE);
    slVolume.setMinWidth(30);
    slVolume.setValue(50);
    mediaPlayer.volumeProperty().bind(
      slVolume.valueProperty().divide(100));

    HBox hBox = new HBox(10);
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(playButton, rewindButton,
      new Label("Volume"), slVolume);

    BorderPane pane2 = new BorderPane();
    pane2.setCenter(mediaView);
    pane2.setBottom(hBox);

    grid.add(pane2, 1, 0);
    grid.setHalignment(pane2, HPos.RIGHT);
    pane.setCenter(grid);
    
   
    return pane;
    }
  



   public static void main(String[] args) {
    launch(args);
  }
}

   


  
    

