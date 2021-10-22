package modele;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Periodicite {
	private int idPeriodicite;
	private String libelle;
	
	
	//Contructeur
	public Periodicite(int idPeriodicite, String libelle) {
		super();
		this.idPeriodicite = idPeriodicite;
		this.libelle = libelle;
	}

	//Getters& Setters
	public int getIdperiodicite() {
		return idPeriodicite;
	}
	public void setIdperiodicite(int idPeriodicite) {
		this.idPeriodicite = idPeriodicite;
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
		return "Periodicite [idPeriodicite=" + idPeriodicite + ", libelle=" + libelle + "]";
	}
	
	
}
