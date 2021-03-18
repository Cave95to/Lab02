package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnTranslate;
    
    @FXML
    private TextField txtUtente;
    
    @FXML
    private TextArea txtRisposta;

    @FXML
    private Button btnReset;
    
    AlienDictionary dizionario = new AlienDictionary();

    @FXML
    void doReset(ActionEvent event) {
    	this.txtRisposta.clear();
    	this.txtUtente.clear();
    	this.dizionario.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String inserimento = this.txtUtente.getText().toLowerCase();
    	this.txtUtente.clear();
    	
    	//controllo inserimento che non sia vuoto
    	/*
    	if ( inserimento == null || inserimento.length()==0) {
    		this.txtRisposta.setText("ERRORE: inserire 1 o 2 parole");
    		return;
    	} */
    	
    	//LO DIVIDO CON GLI SPAZI
    	
    	StringTokenizer st = new StringTokenizer(inserimento, " ");
    	
    	// Controllo su String Tokenizer che non siano inseriti solo spazi ad esempio o sia vuoto
    	// ovvero che abbia elementi
    	
    	if (!st.hasMoreElements()) {
    		txtRisposta.setText("Inserire una o due parole.");
    		return;
    	}
    	
    	//il primo è la parola aliena
    	
    	String parola = st.nextToken();
    	
    	if (!parola.matches("[a-zA-Z]*")) {
			this.txtRisposta.setText("ERRORE: gli unici caratteri ammessi sono a-z, A-Z");
			return;
		}
    	
    	// se ho 2 parole
    	
    	if (st.hasMoreTokens()) {
    		
    		String traduzione = st.nextToken();
       		
    		if (st.hasMoreTokens()) {
    			this.txtRisposta.setText("Inserire una o due parole.");
    			return;
    		}
    		
    		if (!traduzione.matches("[a-zA-Z]*")) {
    			this.txtRisposta.setText("ERRORE: gli unici caratteri ammessi sono a-z, A-Z");
    			return;
    		}
    		
    		if(!this.dizionario.addWord(parola, traduzione)) {
    			
    			this.txtRisposta.setText("La parola -> "+parola+ ", con traduzione -> "+traduzione+", è già presente nel dizionario");
    			return;
	    	
    		} else {
		    	this.txtRisposta.setText("La parola -> "+parola+ ", con traduzione -> "+traduzione+", è stata correttamente inserita nel dizionario");
		    	return;
    		}
    	}
    	
	    //se utente inserisce 1 sola parola
    	
    	if(this.dizionario.translateWord(parola)==null)
    		this.txtRisposta.setText("La parola cercata -> "+parola+" non esiste ancora nel dizionario");
    
    	else
    		this.txtRisposta.setText(this.dizionario.translateWord(parola));
	    	
    }
//    }

    @FXML
    void initialize() {
    	  assert txtUtente != null : "fx:id=\"txtUtente\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtRisposta != null : "fx:id=\"txtRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}