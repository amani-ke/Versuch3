package gui.guiStadt;


import business.Stadtfuehrung;
import business.StadtfuehrungModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class StadtView {

	
		private Pane pane     					= new  Pane();
	    private TextArea txtAnzeige  			= new TextArea();
    	private Label lblAnzeigeVolkshochschulekurs = new Label("Anzeige Stadt");;
	    private Button btnAnzeige 		 		= new Button("Anzeige");


   
	    //-------Ende Attribute der grafischen Oberflaeche-------
	    
	    // speichert temporaer ein Objekt vom Typ Buergeramt
	    private Stadtfuehrung Stadt;
	    
	    private StadtControl stadtControl;
	    private StadtfuehrungModel stadtfuehrungModel;
	    
	    public StadtView(StadtControl stadtControl, Stage primaryStage, StadtfuehrungModel stadtfuehrungModel) {
	        super();
	        this.stadtControl = stadtControl;
	        this.stadtfuehrungModel = stadtfuehrungModel.getInstanz();

	        // Ensure volkshochschulekursModel is not null when passed
	        Scene scene = new Scene(this.pane, 560, 340);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Anzeige von Stadt");
	        primaryStage.show();
	        this.initKomponenten();
	        this.initListener();
	    }

	    
	    


	    
	    private void initKomponenten(){
	       	// Labels

	    	Font font = new Font("Arial", 24); 
	

    		lblAnzeigeVolkshochschulekurs.setLayoutX(310);
    		lblAnzeigeVolkshochschulekurs.setLayoutY(40);
    		lblAnzeigeVolkshochschulekurs.setFont(font);
    		lblAnzeigeVolkshochschulekurs.setStyle("-fx-font-weight: bold;"); 
    		pane.getChildren().add(lblAnzeigeVolkshochschulekurs);
	     	
	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(310);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(220);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons

	        btnAnzeige.setLayoutX(310);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll( btnAnzeige); 
	        
	   }
	    


		public void initListener() {
			btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {

		    	@Override
		        public void handle(ActionEvent e) {
		            zeigeStadtAn();
		        } 
	   	    });
	
		
	    }
	    
	    public void zeigeStadtAn(){
	       	if(this.stadtfuehrungModel.getStadt() != null){
	       		txtAnzeige.setText(
	       			this.stadtfuehrungModel.getStadt().gibStadtZurueck(' '));
	       	}
	       	else{
	       		zeigeInformationsfensterAn("Bisher wurde keine Stadt aufgenommen!");
	       	}
	       }
	    
	    public void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
	    }	
	    





	    
}

