package modele;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Periodicite {
	private int idperiodicite;
	private String libelle;
	
	
	//Contructeur
	public Periodicite(int idperiodicite, String libelle) {
		super();
		this.idperiodicite = idperiodicite;
		this.libelle = libelle;
	}

	//Getters& Setters
	public int getIdperiodicite() {
		return idperiodicite;
	}
	public void setIdperiodicite(int idperiodicite) {
		this.idperiodicite = idperiodicite;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
		Matcher matcherLibelle = pattern.matcher(this.getLibelle());
		
		if(this.getLibelle()==null) {
			throw new IllegalArgumentException("Libelle ne peut etre null");
		}
		else if("".equals(this.getLibelle())) {
			throw new IllegalArgumentException("Libelle non valide");
		}
		else if(!matcherLibelle.find()) {
			throw new IllegalArgumentException("Libelle non valide");
		}
		else {	
			this.libelle = libelle;
		}
	}

	
	@Override
	public String toString() {
		return "Periodicite [idperiodicite=" + idperiodicite + ", libelle=" + libelle + "]";
	}
	
	
}
