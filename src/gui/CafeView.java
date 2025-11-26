package gui;

import business.CafeModel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

import javafx.event.*;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;

public class CafeView {
	private CafeModel cafeModel; 
	private CafeControl cafeControl;
	
	public CafeView(CafeControl cafeControl, CafeModel cafeModel, Stage primaryStage ) {
		this.cafeModel = cafeModel;
		this.cafeControl = cafeControl;
		
		Scene scene = new Scene (this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung eines Moebelstuecks");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
	} 
	 private Pane pane     					= new  Pane();
	    private Label lblEingabe    	 		= new Label("Eingabe");
	    private Label lblAnzeige   	 	    	= new Label("Anzeige");
	    private Label lblName 					= new Label("Name:");
	    private Label lblOrt   		 			= new Label("Ort:");
	    private Label lblBeschreibung  	 	 	= new Label("Beschreibung:");
	    private Label lblMitBaeckerei   		= new Label("Mit Baeckerei:");
	    private Label lblKaffeeprodukte  		= new Label("Kaffeeprodukte:");
	    private TextField txtName 	 			= new TextField();
	    private TextField txtOrt				= new TextField();
	    private TextField txtBeschreibung		= new TextField();
	    private TextField txtMitBaeckerei		= new TextField();
	    private TextField txtKaffeeprodukte	 	= new TextField();
	    private TextArea txtAnzeige  			= new TextArea();
	    private Button btnEingabe 		 		= new Button("Eingabe");
	    private Button btnAnzeige 		 		= new Button("Anzeige");
	    private MenuBar mnbrMenuLeiste  		= new MenuBar();
	    private Menu mnDatei             		= new Menu("Datei");
	    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
	    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
	    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
	    //-------Ende Attribute der grafischen Oberflaeche-------
	    public void initKomponenten(){
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
	       	lblName.setLayoutX(20);
	    	lblName.setLayoutY(90);
	    	lblOrt.setLayoutX(20);
	    	lblOrt.setLayoutY(130);
	    	lblBeschreibung.setLayoutX(20);
	    	lblBeschreibung.setLayoutY(170);
	    	lblMitBaeckerei.setLayoutX(20);
	    	lblMitBaeckerei.setLayoutY(210);
	    	lblKaffeeprodukte.setLayoutX(20);
	    	lblKaffeeprodukte.setLayoutY(250);    	
	       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
	       		lblName, lblOrt, lblBeschreibung,
	       		lblMitBaeckerei, lblKaffeeprodukte);
	    
	    	// Textfelder
	     	txtName.setLayoutX(170);
	    	txtName.setLayoutY(90);
	    	txtName.setPrefWidth(200);
	    	txtOrt.setLayoutX(170);
	    	txtOrt.setLayoutY(130);
	    	txtOrt.setPrefWidth(200);
	    	txtBeschreibung.setLayoutX(170);
	    	txtBeschreibung.setLayoutY(170);
	    	txtBeschreibung.setPrefWidth(200);
	      	txtMitBaeckerei.setLayoutX(170);
	    	txtMitBaeckerei.setLayoutY(210);
	    	txtMitBaeckerei.setPrefWidth(200);
	    	txtKaffeeprodukte.setLayoutX(170);
	    	txtKaffeeprodukte.setLayoutY(250);
	    	txtKaffeeprodukte.setPrefWidth(200);
	      	pane.getChildren().addAll( 
	     		txtName, txtOrt, txtBeschreibung,
	     		txtMitBaeckerei, txtKaffeeprodukte);
	     	
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
	    public void initListener() {
		    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	        	    cafeControl.nehmeCafeAuf();
	            }
		    });
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		            zeigeCafeAn();
		        } 
	   	    });
		    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		    		cafeControl.leseAusDatei("csv");
		    	}
		    });
		    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent e) {
			    	cafeControl.leseAusDatei("txt");
			    }
	    	});
		    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					cafeControl.schreibeCafesInCsvDatei();
				}	
		    });
	    }
	    
	    public void zeigeCafeAn(){
	    	if(this.cafeModel.getCafe() != null){
	    		txtAnzeige.setText(
	    			this.cafeModel.getCafe().gibCafeZurueck(' '));
	    	}
	    	else{
	    		zeigeInformationsfensterAn("Bisher wurde keine Cafe aufgenommen!");
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
	    
	    
		public TextField getTxtName() {
			return txtName;
		}
		public void setTxtName(TextField txtName) {
			this.txtName = txtName;
		}
		public TextField getTxtOrt() {
			return txtOrt;
		}
		public void setTxtOrt(TextField txtOrt) {
			this.txtOrt = txtOrt;
		}
		public TextField getTxtBeschreibung() {
			return txtBeschreibung;
		}
		public void setTxtBeschreibung(TextField txtBeschreibung) {
			this.txtBeschreibung = txtBeschreibung;
		}
		public TextField getTxtMitBaeckerei() {
			return txtMitBaeckerei;
		}
		public void setTxtMitBaeckerei(TextField txtMitBaeckerei) {
			this.txtMitBaeckerei = txtMitBaeckerei;
		}
		public TextField getTxtKaffeeprodukte() {
			return txtKaffeeprodukte;
		}
		public void setTxtKaffeeprodukte(TextField txtKaffeeprodukte) {
			this.txtKaffeeprodukte = txtKaffeeprodukte;
		}
		public TextArea getTxtAnzeige() {
			return txtAnzeige;
		}
		public void setTxtAnzeige(TextArea txtAnzeige) {
			this.txtAnzeige = txtAnzeige;
		}
	    
	    
}
