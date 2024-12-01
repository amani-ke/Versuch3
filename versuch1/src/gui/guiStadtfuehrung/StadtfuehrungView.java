package gui.guiStadtfuehrung;


import business.StadtfuehrungModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class StadtfuehrungView {

	
	
	 //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblTitel 					= new Label("Titel:");
    private Label lblIdentnummer   	     	= new Label("Identnummer");
    private Label lblKurzbeschreibung  	 	= new Label("Kurzbeschreibung:");
    private Label lblStartUhrzeit   		= new Label("Startuhrzeit:");
    private Label lblDatum  		        = new Label("Datum:");
    private TextField txtTitel 	 			= new TextField();
    private TextField txtIdentnummer		= new TextField();
    private TextField txtKurzbeschreibung		= new TextField();
    private TextField txtStartuhrzeit			= new TextField();
    private TextField txtDatum	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Buergeramt
    private StadtfuehrungModel stadtfuehrungModel;
	private StadtfuehrungControl stadtfuehrungControl;
    
    public StadtfuehrungView(StadtfuehrungControl stadtfuehrungControl,StadtfuehrungModel stadtfuehrungModel, Stage primaryStage){
    	this.stadtfuehrungModel=stadtfuehrungModel;
    	this.stadtfuehrungControl=stadtfuehrungControl;
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Stadt");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblTitel.setLayoutX(20);
    	lblTitel.setLayoutY(90);
    	lblIdentnummer.setLayoutX(20);
    	lblIdentnummer.setLayoutY(130);
    	lblKurzbeschreibung.setLayoutX(20);
    	lblKurzbeschreibung.setLayoutY(170);
    	lblStartUhrzeit.setLayoutX(20);
    	lblStartUhrzeit.setLayoutY(210);
    	lblDatum.setLayoutX(20);
    	lblDatum.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblTitel, lblIdentnummer, lblKurzbeschreibung,
       		lblStartUhrzeit, lblDatum);
    
    	// Textfelder
     	txtTitel.setLayoutX(170);
    	txtTitel.setLayoutY(90);
    	txtTitel.setPrefWidth(200);
    	txtIdentnummer.setLayoutX(170);
    	txtIdentnummer.setLayoutY(130);
    	txtIdentnummer.setPrefWidth(200);
    	txtKurzbeschreibung.setLayoutX(170);
    	txtKurzbeschreibung.setLayoutY(170);
    	txtKurzbeschreibung.setPrefWidth(200);
      	txtStartuhrzeit.setLayoutX(170);
    	txtStartuhrzeit.setLayoutY(210);
    	txtStartuhrzeit.setPrefWidth(200);
    	txtDatum.setLayoutX(170);
    	txtDatum.setLayoutY(250);
    	txtDatum.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtTitel, txtIdentnummer, txtKurzbeschreibung,
     		txtStartuhrzeit, txtDatum);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    stadtfuehrungControl.nehmeStadtAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeStadtAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	    		stadtfuehrungControl.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		    	stadtfuehrungControl.leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stadtfuehrungControl.schreibeBuergeraemterInCsvDatei();
			}	
	    });
    }
   
   
   

   public void zeigeStadtAn(){
   	if(this.stadtfuehrungModel.getStadt() != null){
   		txtAnzeige.setText(
   			this.stadtfuehrungModel.getStadt().gibStadtZurueck(' '));
   	}
   	else{
   	    zeigeInformationsfensterAn("Bisher wurde kein Stadt aufgenommen!");
   	}
   }
   
   
   public void zeigeInformationsfensterAn(String meldung){
   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
   		"Information", meldung).zeigeMeldungsfensterAn();
   }	
   
  public void zeigeFehlermeldungsfensterAn(String meldung){
      	new MeldungsfensterAnzeiger(AlertType.ERROR,
       	"Fehler", meldung).zeigeMeldungsfensterAn();
   }
  

public TextField getTxtTitel() {
	return txtTitel;
}

public void setTxtTitel(TextField txtTitel) {
	this.txtTitel = txtTitel;
}

public TextField getTxtIdentnummer() {
	return txtIdentnummer;
}

public void setTxtIdentnummer(TextField txtIdentnummer) {
	this.txtIdentnummer = txtIdentnummer;
}

public TextField getTxtKurzbeschreibung() {
	return txtKurzbeschreibung;
}

public void setTxtKurzbeschreibung(TextField txtKurzbeschreibung) {
	this.txtKurzbeschreibung = txtKurzbeschreibung;
}

public TextField getTxtStartuhrzeit() {
	return txtStartuhrzeit;
}

public void setTxtStartuhrzeit(TextField txtStartuhrzeit) {
	this.txtStartuhrzeit = txtStartuhrzeit;
}

public TextField getTxtDatum() {
	return txtDatum;
}

public void setTxtDatum(TextField txtDatum) {
	this.txtDatum = txtDatum;
}
   
   

   
   
   
   
	
	
}
