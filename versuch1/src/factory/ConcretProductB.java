package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcretProductB extends Product {
private BufferedReader br;
	
	
	

	public ConcretProductB() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		br= new BufferedReader(new FileReader("StadtAusgabe.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		String [] ergebnisZeile= new String[5];
		String zeile= br.readLine();
		int i=0;
		while(i<ergebnisZeile.length) {
			ergebnisZeile[i]=zeile;
			zeile=br.readLine();
			i++;
		}
		
		return ergebnisZeile;
	}

	@Override
	public void schlisseDatei() throws IOException {
		// TODO Auto-generated method stub
		br.close();
	}
}
