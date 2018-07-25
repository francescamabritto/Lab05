package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Anagramma {
	
	private String parola;
	private List<Character> parziale = new ArrayList<>();
	
	public Anagramma() {
		
	}
	
	public Anagramma(String parola) {
		this.parola=parola;
	}
	
	
	
	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public List<Character> getParziale() {
		return parziale;
	}

	public void setParziale(List<Character> parziale) {
		this.parziale = new ArrayList<>(parziale);
	}

	public String toString() {
		return parola;
	}
	
}
