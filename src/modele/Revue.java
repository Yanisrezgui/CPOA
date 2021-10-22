package modele;

import java.util.Objects;

public class Revue {
	private int idRevue;
	private String titre;
	private String description;
	private float tarifnumero;
	private String visuel;
	private Periodicite periodicite;
	
	
	//Constructeur 
	public Revue(int idrevue, String titre, String description, float tarifnumero, String visuel,
			Periodicite periodicite) {
		super();
		this.setIdrevue(idrevue);
		this.setTitre(titre);
		this.setDescription(description);
		this.setTarifnumero(tarifnumero);
		this.setVisuel(visuel);
		this.setPeriodicite(periodicite);
	}
	
	public Revue( String titre, String description, float tarifnumero, String visuel,Periodicite periodicite) {
		
		this(-1,titre,description,tarifnumero,visuel,periodicite);
		
	}
	
	//Getters & Setters 
	public int getIdrevue() {
		return idRevue;
	}
	public void setIdrevue(int idrevue) {
		
		if(idrevue<-1)
			throw new IllegalArgumentException("l'id doit etre positif");
		this.idRevue = idrevue;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		
		if(this.getTitre()==null) {
			throw new IllegalArgumentException("Titre ne peut etre null");
		}
		else if("".equals(this.getTitre())) {
			throw new IllegalArgumentException("Titre non valide");
		}
		else {
			this.titre = titre;
		}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		
		if(this.getDescription()==null) {
			throw new IllegalArgumentException("Description ne peut etre null");
		}
		else if("".equals(this.getDescription())) {
			throw new IllegalArgumentException("Description non valide");
		}
		else {
			this.description = description;
		}
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revue other = (Revue) obj;
		return idRevue == other.idRevue;
	}

	public void setVisuel(String visuel) {
		
		if(this.getVisuel()==null) {
			throw new IllegalArgumentException("Visuel ne peut etre null");
		}
		else if("".equals(this.getVisuel())) {
			throw new IllegalArgumentException("Visuel non valide");
		}
		else {
			this.visuel = visuel;
		}
	}
	public Periodicite getPeriodicite() {
		return periodicite;
	}
	public void setPeriodicite(Periodicite periodicite) {
		
		if(this.getPeriodicite()==null) {
			throw new IllegalArgumentException("Periodicite ne peut etre null");
		}
		else {
			this.periodicite = periodicite;
		}
	}

	
	
	@Override
	public String toString() {
		return "Revue [idrevue=" + idRevue + ", titre=" + titre + ", description=" + description + ", tarifnumero="
				+ tarifnumero + ", visuel=" + visuel + ", periodicite=" + periodicite + "]";
	}
	
}
