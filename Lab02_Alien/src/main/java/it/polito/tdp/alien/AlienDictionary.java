package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> dictionary;
	
	public AlienDictionary() {
		this.dictionary = new ArrayList<>();
	}
	
	public void addWord(String alienWord, String translation) {
		
		Word parola = new Word (alienWord, translation);
		
		for ( Word w : this.dictionary) {
					
			if (w.getAlienWord().equals(alienWord)) {
				this.dictionary.remove(w);
				//IMPORTANTE IL BREAK PERCHE CAMBIAMO STRUTTURA ALLA LISTA DEL CICLO
				break;
			}
		}
		
//		if (this.dictionary.contains(parola)) {
//			this.dictionary.get(this.dictionary.indexOf(parola)).setTranslation(translation);
//			return;
//		}
			
		this.dictionary.add(parola);
		
	}
	
	public String translateWord(String alienWord) {
		
		for ( Word w : this.dictionary) {
			
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();
			
		}
		
		return null;
	}

	public void clear() {
		this.dictionary.clear();
		
	}
}
