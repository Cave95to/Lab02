package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translations;
	
	public WordEnhanced(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translations = new ArrayList<>();
		this.translations.add(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		String s = "";
		for ( String st : this.translations) {
			s = s + st + "\n";
		}
		return s;
	}

	public boolean setTranslation(String translation) {
		
		if (!this.translations.contains(translation)) {
			this.translations.add(translation);
			return true;
		}
		
		return false;
	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
	 * return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Word other = (Word) obj; if (alienWord == null) { if (other.alienWord
	 * != null) return false; } else if (!alienWord.equals(other.alienWord)) return
	 * false; return true; }
	 * 
	 * 
	 */
}
