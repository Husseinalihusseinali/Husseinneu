package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fabrik.ConcreteCafeCSVCreator;
import fabrik.ConcreteCafeTXTCreator;
import fabrik.Creator;
import fabrik.Product;

public class CafeModel {
	
	private Cafe cafe; 
	
	public Cafe getCafe() {
		return cafe;
	}


	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}


	public void leseAusDatei(String typ) throws Exception{
    	
  		
		 Creator creator=null;
		 
		 if(typ.equals("csv")){
			 creator= new ConcreteCafeCSVCreator();
		 }
		 else {
			 creator= new ConcreteCafeTXTCreator();
		 }
		  
		 Product reader= creator.factoryMethod();
		 
	      			String[] zeile = reader.leseAusDatei();
	      			this.cafe = new Cafe (zeile[0], zeile[1], 
	      				(zeile[2]), 
	      				(zeile[3]), 
	      				zeile[4].split("_"));
	      			reader.schliessedatei();  	  
		}
	

	public void schreibeSportvereineInCsvDatei() throws IOException{
		BufferedWriter aus = new BufferedWriter(new FileWriter("SportvereineAusgabe.csv", true));
			aus.write(cafe.gibCafeZurueck(';'));
			aus.close();
			
   	
		
			
	}
	 
}
