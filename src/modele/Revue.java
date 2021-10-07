package modele;

public class Revue {
	private int idrevue;
	private String titre;
	private String description;
	private float tarifnumero;
	private String visuel;
	private Periodicite periodicite;
	
	
	//Constructeur avec
	public Revue(int idrevue, String titre, String description, float tarifnumero, String visuel,
			Periodicite periodicite) {
		super();
		this.idrevue = idrevue;
		this.titre = titre;
		this.description = description;
		this.tarifnumero = tarifnumero;
		this.visuel = visuel;
		this.periodicite = periodicite;
	}
	
	//Getters & Setters 
	public int getIdrevue() {
		return idrevue;
	}
	public void setIdrevue(int idrevue) {
		this.idrevue = idrevue;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getTarifnumero() {
		return tarifnumero;
	}
	public void setTarifnumero(float tarifnumero) {
		this.tarifnumero = tarifnumero;
	}
	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	public Periodicite getPeriodicite() {
		return periodicite;
	}
	public void setPeriodicite(Periodicite periodicite) {
		this.periodicite = periodicite;
	}

	
	
	@Override
	public String toString() {
		return "Revue [idrevue=" + idrevue + ", titre=" + titre + ", description=" + description + ", tarifnumero="
				+ tarifnumero + ", visuel=" + visuel + ", periodicite=" + periodicite + "]";
	}
	
}
