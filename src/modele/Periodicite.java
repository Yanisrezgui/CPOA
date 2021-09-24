package modele;

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
		this.libelle = libelle;
	}

	
	@Override
	public String toString() {
		return "Periodicite [idperiodicite=" + idperiodicite + ", libelle=" + libelle + "]";
	}
	
	
}
