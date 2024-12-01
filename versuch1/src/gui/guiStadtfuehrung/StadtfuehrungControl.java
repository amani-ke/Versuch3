package gui.guiStadtfuehrung;

import java.io.IOException;
import business.Stadtfuehrung;
import business.StadtfuehrungModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StadtfuehrungControl  implements Observer{
	
	private StadtfuehrungModel stadtfuehrungModel;
	private StadtfuehrungView stadtfuehrungView;
	
	

	public StadtfuehrungControl(Stage primStage) {
		super();
		this.stadtfuehrungModel=  stadtfuehrungModel.getInstanz();
		this.stadtfuehrungView =  new StadtfuehrungView (this,stadtfuehrungModel,primStage);
		stadtfuehrungModel.addObserver(this);
	}
	 

	public void nehmeStadtAuf(){
    	try{
    		this.stadtfuehrungModel.setStadt(new Stadtfuehrung (
    			this.stadtfuehrungView.getTxtTitel().getText(), 
   	            this.stadtfuehrungView.getTxtIdentnummer().getText(),
   	            this.stadtfuehrungView.getTxtKurzbeschreibung().getText(),
    		    this.stadtfuehrungView.getTxtStartuhrzeit().getText(),
    		    this.stadtfuehrungView.getTxtDatum().getText().split(";")));
    		 stadtfuehrungView.zeigeInformationsfensterAn("Das Stadt wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		stadtfuehrungView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
	
	public void leseAusDatei(String typ){
    	try {
      		this.stadtfuehrungModel.leseAusDatei(typ);
      		       	
		}
		catch(IOException exc){
			stadtfuehrungView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		}
		catch(Exception exc){
			stadtfuehrungView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}
		
	public void schreibeBuergeraemterInCsvDatei() {
		try {
			this.stadtfuehrungModel.schreibeBuergeraemterInCsvDatei();
			stadtfuehrungView.zeigeInformationsfensterAn(
	   			"Der Stadt wurden gespeichert!");
		}	
		catch(IOException exc){
			stadtfuehrungView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			stadtfuehrungView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		stadtfuehrungView.zeigeStadtAn();

		
	}
	
	

}
