package application;

import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.*;
import javafx.stage.Stage;


public class rps extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	public void start(Stage primaryStage) throws FileNotFoundException {
		
		GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        Label label = new Label("STONE-PAPER-SCISSOR");
        label.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, 30));
        label.setAlignment(Pos.CENTER);
        
      
        Label name1= new Label("Player 1 Name :");
        name1.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC,  20));
        Label name2= new Label("Player 2 Name :");
        name2.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC, 20));
        
        //Text field to get the names of players
        TextField txt1=new TextField();
        txt1.setMaxWidth(250);
        TextField txt2=new TextField();
        txt2.setMaxWidth(250);
        
        //Label represents player 1
	    Label l1= new Label("Player 1");
	    l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22));
	
	
	//Radio button for stone
	RadioButton b1=new RadioButton();
	Image image1 = new Image(new FileInputStream("C:\\Users\\ASHIKA\\Pictures\\game\\rock.png"));  
    ImageView imageView1 = new ImageView(image1); 
    imageView1.setFitHeight(120); 
    imageView1.setFitWidth(120);   
    imageView1.setPreserveRatio(true);
    b1.setGraphic(imageView1);
    
    //Radio button for paper
    RadioButton b2=new RadioButton();
	Image image2 = new Image(new FileInputStream("C:\\Users\\ASHIKA\\Pictures\\game\\paper.png"));  
    ImageView imageView2 = new ImageView(image2); 
    imageView2.setFitHeight(120); 
    imageView2.setFitWidth(120);   
    imageView2.setPreserveRatio(true);
    b2.setGraphic(imageView2);
    
    //Radio button for scissor
    RadioButton b3=new RadioButton();
	Image image3 = new Image(new FileInputStream("C:\\Users\\ASHIKA\\Pictures\\game\\scissor.png"));  
    ImageView imageView3 = new ImageView(image3); 
    imageView3.setFitHeight(120); 
    imageView3.setFitWidth(120);   
    imageView3.setPreserveRatio(true);
    b3.setGraphic(imageView3);
	
    //Label represents player 2
	Label l2= new Label("Player 2");
	l2.setFont(Font.font("Times New Roman", FontWeight.BOLD ,FontPosture.ITALIC,  22));
	
	//Radio button for stone
	RadioButton b4=new RadioButton();  
    ImageView imageView4 = new ImageView(image1); 
    imageView4.setFitHeight(120); 
    imageView4.setFitWidth(120);   
    imageView4.setPreserveRatio(true);
    b4.setGraphic(imageView4);
    
    //Radio button for paper
    RadioButton b5=new RadioButton();  
    ImageView imageView5 = new ImageView(image2); 
    imageView5.setFitHeight(120); 
    imageView5.setFitWidth(120);   
    imageView5.setPreserveRatio(true);
    b5.setGraphic(imageView5);
    
    //Radio button for scissor
    RadioButton b6=new RadioButton(); 
    ImageView imageView6 = new ImageView(image3); 
    //imageView6.setX(50); 
    // imageView6.setY(25);
    imageView6.setFitHeight(120); 
    imageView6.setFitWidth(120);   
    imageView6.setPreserveRatio(true);
    b6.setGraphic(imageView6);
	
    //Toggle group for radio buttons
    ToggleGroup grp1 = new ToggleGroup();
	ToggleGroup grp2 = new ToggleGroup();
	
	b1.setToggleGroup(grp1);
	b2.setToggleGroup(grp1);
	b3.setToggleGroup(grp1);
	
	b4.setToggleGroup(grp2);
	b5.setToggleGroup(grp2);
	b6.setToggleGroup(grp2);
    
    //Play button
    Button play=new Button();
    Image img1 = new Image(new FileInputStream("C:\\Users\\ASHIKA\\Pictures\\game\\playButton.png")); 
	ImageView view1 = new ImageView(img1); 
	view1.setFitHeight(30); 
    view1.setFitWidth(75);
    play.setGraphic(view1);
    play.setAlignment(Pos.CENTER);
    
    //Event handler for play button
    EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e)
		{
			l1.setText("Player 1 "+txt1.getText());
			l2.setText("Player 2 "+txt2.getText());
		}
	};
    
    play.setOnAction(event1);
    
    //Label to show the result
    Label lb=new Label();
	lb.setFont(Font.font("Times New Roman", FontWeight.BOLD ,  25));
	
	//Submit button
		Button but=new Button();
		Image img = new Image(new FileInputStream("C:\\Users\\ASHIKA\\Pictures\\game\\submit.png")); 
		ImageView view = new ImageView(img); 
		view.setFitHeight(30); 
	    view.setFitWidth(75);
	    but.setGraphic(view);
	    but.setAlignment(Pos.CENTER);
    
	//Event handler for submit button
	EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e)
		{
			if((b1.isSelected() && b4.isSelected()) || (b2.isSelected() && b5.isSelected()) || (b3.isSelected() && b6.isSelected()))
			{
				//lb.setText("!!Tie!!");
				File audiofile=new File("C:\\Users\\ASHIKA\\Pictures\\game\\tie.wav");
				Media audio=new Media(audiofile.toURI().toString());
				MediaPlayer audioplayer=new MediaPlayer(audio);
				audioplayer.setAutoPlay(true);
				
				Alert a = new Alert(AlertType.NONE,"!! Tie !!\nPress OK to continue the game.",ButtonType.OK);
				a.setTitle("Result");
				
				DialogPane dgpane=a.getDialogPane();
				dgpane.setStyle("-fx-background-color:coral;");
				a.show();
				
				/*pane.setStyle("-fx-background-color:RED;");
				
				Optional<ButtonType> result = a.showAndWait();
				ButtonType button=result.orElse(ButtonType.CANCEL);
				if(button==ButtonType.OK) {
					pane.setStyle("-fx-background-color:LIGHTGREEN;");
				}*/
			}
			else if(b1.isSelected() && b5.isSelected()) {
				lb.setText("Congratulation "+ txt2.getText()+"  !!You Won!!");
				File audiofile=new File("C:\\Users\\ASHIKA\\Pictures\\game\\cong.mp3");
				Media audio=new Media(audiofile.toURI().toString());
				MediaPlayer audioplayer=new MediaPlayer(audio);
				audioplayer.setAutoPlay(true);
				
				/*Alert a1 = new Alert(AlertType.NONE,"Congradulation "+ txt2.getText()+"!!You Won!!",ButtonType.OK);
				a1.setTitle("Result");
				DialogPane dgpane=a1.getDialogPane();
				dgpane.setStyle("-fx-background-color:greenyellow;");
				a1.show();*/
			
			}
			else if(b1.isSelected() && b6.isSelected())
			{
				lb.setText("Congratulation "+ txt1.getText()+"  !!You Won!!");
				File audiofile=new File("C:\\Users\\ASHIKA\\Pictures\\game\\cong.mp3");
				Media audio=new Media(audiofile.toURI().toString());
				MediaPlayer audioplayer=new MediaPlayer(audio);
				audioplayer.setAutoPlay(true);
				
				/*Alert a2 = new Alert(AlertType.NONE,"Congradulation "+ txt1.getText()+"!!You Won!!",ButtonType.OK);
				a2.setTitle("Result");
				DialogPane dgpane=a2.getDialogPane();
				dgpane.setStyle("-fx-background-color:greenyellow;");
				a2.show(); */
				
			}
			else if(b2.isSelected() && b4.isSelected())
			{
				lb.setText("Congratulation "+ txt1.getText()+"  !!You Won!!");
				File audiofile=new File("C:\\Users\\ASHIKA\\Pictures\\game\\cong.mp3");
				Media audio=new Media(audiofile.toURI().toString());
				MediaPlayer audioplayer=new MediaPlayer(audio);
				audioplayer.setAutoPlay(true);
				
				/*Alert a3 = new Alert(AlertType.NONE,"Congradulation "+ txt1.getText()+"!!You Won!!",ButtonType.OK);
				a3.setTitle("Result");
				DialogPane dgpane=a3.getDialogPane();
				dgpane.setStyle("-fx-background-color:greenyellow;");
				a3.show(); */
				
			}
			
			else if(b2.isSelected() && b6.isSelected())
			{
				lb.setText("Congratulation "+ txt2.getText()+"  !!You Won!!");
				File audiofile=new File("C:\\Users\\ASHIKA\\Pictures\\game\\cong.mp3");
				Media audio=new Media(audiofile.toURI().toString());
				MediaPlayer audioplayer=new MediaPlayer(audio);
				audioplayer.setAutoPlay(true);
				
				/*Alert a4 = new Alert(AlertType.NONE,"Congradulation "+ txt2.getText()+"!!You Won!!",ButtonType.OK);
				a4.setTitle("Result");
				DialogPane dgpane=a4.getDialogPane();
				dgpane.setStyle("-fx-background-color:greenyellow;");
				a4.show(); */
				
			}
			else if(b3.isSelected() && b4.isSelected())
			{
				lb.setText("Congratulation "+ txt2.getText()+"  !!You Won!!");
				File audiofile=new File("C:\\Users\\ASHIKA\\Pictures\\game\\cong.mp3");
				Media audio=new Media(audiofile.toURI().toString());
				MediaPlayer audioplayer=new MediaPlayer(audio);
				audioplayer.setAutoPlay(true);
				
				/*Alert a5 = new Alert(AlertType.NONE,"Congradulation "+ txt2.getText()+"!!You Won!!",ButtonType.OK);
				a5.setTitle("Result");
				DialogPane dgpane=a5.getDialogPane();
				dgpane.setStyle("-fx-background-color:greenyellow;");
				a5.show();*/
				
			}
			else if(b3.isSelected() && b5.isSelected())
			{
				lb.setText("Congratulation "+txt1.getText()+"  !!You Won!!");
				File audiofile=new File("C:\\Users\\ASHIKA\\Pictures\\game\\cong.mp3");
				Media audio=new Media(audiofile.toURI().toString());
				MediaPlayer audioplayer=new MediaPlayer(audio);
				audioplayer.setAutoPlay(true);
				
				/*Alert a6 = new Alert(AlertType.NONE,"Congradulation "+ txt1.getText()+"!!You Won!!",ButtonType.OK);
				a6.setTitle("Result");
				DialogPane dgpane=a6.getDialogPane();
				dgpane.setStyle("-fx-background-color:greenyellow;");
				a6.show(); */
			}
			
		}
	};
	
	but.setOnAction(event);
	
	pane.setStyle("-fx-background-color:lightgreen;");
	
	Label naming1=new Label("  		Stone           		Paper             	         Scissor");
	naming1.setFont(Font.font("Times New Roman", FontWeight.BOLD ,  16));
	Label naming2=new Label("  	     Stone            	       Paper            		 Scissor");
	naming2.setFont(Font.font("Times New Roman", FontWeight.BOLD ,  16));
	
	pane.add(label, 1, 0);
	pane.add(name1, 0, 1);
    pane.add(txt1, 1, 1);
    pane.add(name2, 0, 2);
    pane.add(txt2, 1, 2);
    pane.add(play, 1, 3);
    pane.add(l1, 0, 4);
	
    HBox hbox=new HBox();
    hbox.getChildren().addAll(b1,b2,b3);
    hbox.setSpacing(15);
    //hbox.setAlignment(Pos.CENTER);
    pane.add(hbox, 1, 5);
	
    pane.add(naming1, 1, 6);
    pane.add(l2, 0, 7);
    
    HBox hbox1=new HBox();
	hbox1.getChildren().addAll(b4,b5,b6);
	hbox1.setSpacing(15);
	//hbox1.setAlignment(Pos.CENTER);
	pane.add(hbox1, 1, 8);
	pane.add(naming2, 1, 9);
	
	pane.add(but, 1, 10);
	pane.add(lb, 1, 11);
	
	
	
	Scene scene = new Scene(pane,800,645);
	primaryStage.setTitle("Stone-Paper-Scissor");
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	
}
