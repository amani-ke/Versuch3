package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import factory.ConcreteCreatorAB;
import factory.Creator;
import factory.Product;
import ownUtil.Observable;
import ownUtil.Observer;

//import gui.Stadt;

public class StadtfuehrungModel implements Observable{
	

	LinkedList<Observer> liste = new LinkedList<Observer>();
	
	private static StadtfuehrungModel instanz=null;
	
	public static StadtfuehrungModel getInstanz() {
		if(instanz == null) {
			instanz = new StadtfuehrungModel();
		}
		return instanz;
	}
	
	
	
   private 	Stadtfuehrung stadt;
   
  private StadtfuehrungModel() {
	   
   }
	
   


	public Stadtfuehrung getStadt() {
	return stadt;
}

public void setStadt(Stadtfuehrung stadt) {
	this.stadt = stadt;
	notifyObservers();
}

	public void leseAusDatei(String typ) throws IOException{
		
		Creator creator= new ConcreteCreatorAB();
		Product reader= creator.factoryMethode(typ);
		
		String [] zeile= reader.leseAusDatei();
		this.stadt = new Stadtfuehrung(zeile[0], zeile[1], 
      			zeile[2], zeile[3], zeile[4].split("_"));
		reader.schlisseDatei();
		
		
      		/*if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("StadtAusgabe.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.stadt = new Stadtfuehrung(zeile[0], zeile[1], 
      			zeile[2], zeile[3], zeile[4].split("_"));
      				ein.close();
      	  
      		}*/
	}
		
	public void schreibeBuergeraemterInCsvDatei() throws IOException {
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("StadtAusgabe.csv"));
			aus.write(stadt.gibStadtZurueck(';'));
			aus.close();

	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		liste.add(obs);
		
	}


	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		liste.remove(obs);
		
	}


	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer o : liste) {
			o.update();
		}
		

	}

}
