package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced> elencoParole;
	
	public AlienDictionary() {
		this.elencoParole = new ArrayList<>();
	}
	
	public boolean addWord(String alienWord, String translation) {
		
		WordEnhanced parola = new WordEnhanced (alienWord, translation);
		
		for ( WordEnhanced w : this.elencoParole) {
					
			if (w.getAlienWord().equals(alienWord)) {
				
				// otteniamo true se la traduzione manca, false se esiste già
				
				return w.setTranslation(translation);
				
				//IMPORTANTE IL BREAK-RETURN PERCHE CAMBIAMO STRUTTURA ALLA LISTA DEL CICLO
			}
		}
		
//		if (this.dictionary.contains(parola)) {
//			this.dictionary.get(this.dictionary.indexOf(parola)).setTranslation(translation);
//			return;
//		}
			
		this.elencoParole.add(parola);
		return true;
		
	}
	
	public String translateWord(String alienWord) {
		
		for ( WordEnhanced w : this.elencoParole) {
			
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();
			
		}
		
		return null;
	}

	public void clear() {
		this.elencoParole.clear();
		
	}
}
