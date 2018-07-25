package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;
import javafx.scene.control.TextArea;

public class Model {
	
	private String ParolaInput;
	private Dizionario dizionario;
	private List<Anagramma> anagrammiCorretti = new ArrayList<>();
	private List<Anagramma> anagrammiErrati = new ArrayList<>();
	DizionarioDAO ddao = new DizionarioDAO();
	
	// getter e setter
	public String getParolaInput() {
		return ParolaInput;
	}
	public void setParolaInput(String parolaInput) {
		ParolaInput = parolaInput;
	}
	public Dizionario getDizionario() {
		return dizionario;
	}
	public void setDizionario(Dizionario dizionario) {
		this.dizionario = dizionario;
	}
	public List<Anagramma> getAnagrammiCorretti() {
		return anagrammiCorretti;
	}
	public void setAnagrammiCorretti(List<Anagramma> anagrammiCorretti) {
		this.anagrammiCorretti = anagrammiCorretti;
	}
	public List<Anagramma> getAnagrammiErrati() {
		return anagrammiErrati;
	}
	public void setAnagrammiErrati(List<Anagramma> anagrammiErrati) {
		this.anagrammiErrati = anagrammiErrati;
	}
	
	// metodo 
	public void generaAnagrammi(String parola) {
		
		int lunghezzaParola = parola.length();
		List<Character> parziale = new ArrayList<>();
		char lettere[] = parola.toCharArray();
		List<Character>listaLettere = toList(lettere);
		recursive(0, parziale, listaLettere, lunghezzaParola);
		
	}
	
	// trasforma un array di char in una lista di Character
	public List<Character> toList(char arrayChar[]) {
		List<Character> ris = new ArrayList<>();
		for(int i=0; i<arrayChar.length; i++) {
			ris.add(arrayChar[i]);
		}
		return ris;
	}
	
	// trasforma una lista di Character in una stringa
	public String stampaLista(List<Character> listaCaratteri) {
		String ris="";
		for(Character c: listaCaratteri) {		
			ris+=c;
		}
		
		return ris;
	}
	
	// NB riscorsione sempre private, poi un metodo public la chiama
	private void recursive (int level , List<Character> parziale,  List<Character>lettereDaAggiungere, int numeroCaratteriInseriti) {
		
		Anagramma anagramma = new Anagramma();
		
		if(level >= numeroCaratteriInseriti) { //condizione di uscita 
			anagramma.setParola(this.stampaLista(parziale));
			anagramma.setParziale(parziale);
			if(ddao.isCorrect(anagramma.getParola())) {
				this.anagrammiCorretti.add(anagramma);
			}
			else { 
				this.anagrammiErrati.add(anagramma);
			}
			return;
		}
			
			// ricorsione!!
			List<Character>lettereParola = new ArrayList<>(lettereDaAggiungere);
			
			for(Character c: lettereParola) {
				parziale.add(c);
				lettereDaAggiungere.remove(c);
				
				recursive(level+1, parziale, lettereDaAggiungere,  numeroCaratteriInseriti);
				
				parziale.remove(c);
				lettereDaAggiungere.add(c);
			}
			
			
			

	}

	




	
}
