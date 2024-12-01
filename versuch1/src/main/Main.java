package main;



import gui.guiStadt.StadtControl;
import gui.guiStadtfuehrung.StadtfuehrungControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		new StadtfuehrungControl(primaryStage);
		Stage stadtFenster= new Stage();
			new StadtControl(stadtFenster);
			
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
