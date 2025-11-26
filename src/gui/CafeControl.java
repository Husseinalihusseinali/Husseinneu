package gui;


import java.io.IOException;
import business.Cafe;
import business.CafeModel;
import javafx.stage.Stage;

public class CafeControl {
	private CafeModel cafeModel;
	private CafeView cafeView;
	
	public CafeControl(Stage primaryStage) {
		super();
		this.cafeModel = new CafeModel();
		this.cafeView = new CafeView(this, cafeModel,primaryStage );
	}
	 public void leseAusDatei(String typ){
	    	try {
	      		this.cafeModel.leseAusDatei(typ);
	      		cafeView.zeigeCafeAn();
	      		cafeView.zeigeInformationsfensterAn("Datei erfolgreich eingelesen!");
	      		
			}
			catch(IOException exc){
				cafeView.zeigeFehlermeldungsfensterAn( "IOException beim Lesen!");
			}
			catch(Exception exc){
				cafeView.zeigeFehlermeldungsfensterAn( "Unbekannter Fehler beim Lesen!");
			}
		}
	 
	 
	 public void schreibeCafesInCsvDatei() {
			try {
				this.cafeModel.schreibeSportvereineInCsvDatei();
				cafeView.zeigeFehlermeldungsfensterAn("Datei erfolgreich gespeichert!");
			}	
			catch(IOException exc){
				cafeView.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				cafeView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}
	 public void nehmeCafeAuf(){
	    	try{ 
	    		this.cafeModel.setCafe( new Cafe(
	    			cafeView.getTxtAnzeige().getText(), 
	    			cafeView.getTxtOrt().getText(),
	    			cafeView.getTxtBeschreibung().getText(),
	    			cafeView.getTxtMitBaeckerei().getText(),
	    			cafeView.getTxtKaffeeprodukte().getText().split(";")));
	    		cafeView.zeigeInformationsfensterAn("Das Cafe wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		cafeView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
}
