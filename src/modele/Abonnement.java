package modele;

import java.time.LocalDate;

public class Abonnement {
	private int idAbonnement;
	private LocalDate datedeb;
	private LocalDate datefin;
	private Client client;
	private Revue revue;
	
	
	//Contructeur
	public Abonnement(int idAbonnement, LocalDate datedeb, LocalDate datefin, Client client, Revue revue) {
		super();
		this.idAbonnement = idAbonnement;
		this.datedeb = datedeb;
		this.datefin = datefin;
		this.client = client;
		this.revue = revue;
	}

	//Getters & Setters
	public int getIdabonnement() {
		return idAbonnement;
	}
	public void setIdabonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}
	public LocalDate getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(LocalDate datedeb) {
		
		if(this.datedeb.isAfter(this.datefin)) {
			throw new IllegalArgumentException("Date de debut non valide");
		}
		else {
			this.datedeb = datedeb;
		}
	}
	public LocalDate getDatefin() {
			return datefin;
	}
	public void setDatefin(LocalDate datefin) {
		
		if(this.datefin.isBefore(this.datedeb)) {
			throw new IllegalArgumentException("Date de fin non valide");
		}
		else {
			this.datefin = datefin;
		}
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		
		if(this.getClient()==null) {
			throw new IllegalArgumentException("Client ne peut etre null");
		}
		else {
			this.client = client;
		}
	}
	public Revue getRevue() {
		return revue;
	}
	public void setRevue(Revue revue) {
		
		if(this.getRevue()==null) {
			throw new IllegalArgumentException("Revue ne peut etre null");
		}
		else {
			this.revue = revue;
		}
	}

	
	
	@Override
	public String toString() {
		return "Abonnement [idAbonnement=" + idAbonnement + ", datedeb=" + datedeb + ", datefin=" + datefin
				+ ", client=" + client + ", revue=" + revue + "]";
	}
	
	
}
