package gui.guiStadt;



import business.StadtfuehrungModel;
import javafx.stage.Stage;
import ownUtil.Observer;



public class StadtControl implements Observer {
	

	private StadtfuehrungModel stadtfuehrungModel;
	private StadtView  stadtView;
	
	
	public StadtControl(Stage primaryStage) {
		super();
		this.stadtfuehrungModel = stadtfuehrungModel.getInstanz();
		this.stadtView = new StadtView(this, primaryStage, stadtfuehrungModel);
		stadtfuehrungModel.addObserver(this);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		stadtView.zeigeStadtAn();
		
	}







	

		
		

}

