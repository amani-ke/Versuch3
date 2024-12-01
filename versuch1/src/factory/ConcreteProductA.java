package factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {
	
	private BufferedReader br;
	
	
	

	public ConcreteProductA() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		br= new BufferedReader(new FileReader("StadtAusgabe.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		String [] ergebnisZeile= new String[1];
		String zeile= br.readLine();
		int i=0;
		while(i<ergebnisZeile.length) {
			ergebnisZeile[0]=zeile;
			zeile=br.readLine();
			i++;
		}
		String [] array= ergebnisZeile[0].split(";");
		return ergebnisZeile[0].split(";");
	}

	@Override
	public void schlisseDatei() throws IOException {
		// TODO Auto-generated method stub
		br.close();
	}

}
