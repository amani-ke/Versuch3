package business;

public class Stadtfuehrung {
	private String titel;
	private String identnummer;
	private String kurzbeschreibung;
	private String startzeit;
    private String [] datum;
    
    
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getIdentnummer() {
		return identnummer;
	}
	public void setIdentnummer(String identnummer) {
		this.identnummer = identnummer;
	}
	public String getKurzbeschreibung() {
		return kurzbeschreibung;
	}
	public void setKurzbeschreibung(String kurzbeschreibung) {
		this.kurzbeschreibung = kurzbeschreibung;
	}
	public String getStartzeit() {
		return startzeit;
	}
	public void setStartzeit(String startzeit) {
		this.startzeit = startzeit;
	}
	public String[] getDatum() {
		return datum;
	}
	public void setDatum(String[] datum) {
		this.datum = datum;
	}
	public Stadtfuehrung(String titel, String identnummer, String kurzbeschreibung, String startzeit, String[] datum) {
		super();
		this.titel = titel;
		this.identnummer = identnummer;
		this.kurzbeschreibung = kurzbeschreibung;
		this.startzeit = startzeit;
		this.datum = datum;
	}
    
	
	public String getDatumAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getDatum().length - 1; i++) {
			ergebnis = ergebnis + this.getDatum()[i] + trenner; 
		}
		return ergebnis	+ this.getDatum()[i];
	}
	
	public String gibStadtZurueck(char trenner){
  		return this.getTitel() + trenner 
  			+ this.getIdentnummer() + trenner
  		    + this.getKurzbeschreibung() + trenner
  		    + this.getStartzeit() + trenner 
  		    + this.getDatumAlsString(trenner) + "\n";
  	}
}
