package modele;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Periodicite {
	private int idPeriodicite;
	private String libelle;
	
	
	//Contructeur
	public Periodicite(int idPeriodicite, String libelle) {
		super();
		this.setIdperiodicite(idPeriodicite);
		this.setLibelle(libelle);
	}
	
	//constructeur sans id
	public Periodicite( String libelle) {
		
		this(-1,libelle);
	}

	//Getters& Setters
	public int getIdperiodicite() {
		return idPeriodicite;
	}
	public void setIdperiodicite(int idPeriodicite) {
		
		if(idPeriodicite<-1)
			throw new IllegalArgumentException("l'id doit etre positif");
		this.idPeriodicite = idPeriodicite;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodicite other = (Periodicite) obj;
		return idPeriodicite == other.idPeriodicite;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
		Matcher matcherLibelle = pattern.matcher(libelle);
		
		if(libelle==null) {
			throw new IllegalArgumentException("Libelle ne peut etre null");
		}
		else if("".equals(libelle)) {
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
