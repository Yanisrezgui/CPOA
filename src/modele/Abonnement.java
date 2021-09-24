package modele;

import java.time.LocalDate;
import java.util.Date;

public class Abonnement {
	private int idabonnement;
	private LocalDate datedeb;
	private LocalDate datefin;
	private Client client;
	private Revue revue;
	
	
	//Contructeur
	public Abonnement(int idabonnement, LocalDate datedeb, LocalDate datefin, Client client, Revue revue) {
		super();
		this.idabonnement = idabonnement;
		this.datedeb = datedeb;
		this.datefin = datefin;
		this.client = client;
		this.revue = revue;
	}

	//Getters & Setters
	public int getIdabonnement() {
		return idabonnement;
	}
	public void setIdabonnement(int idabonnement) {
		this.idabonnement = idabonnement;
	}
	public LocalDate getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(LocalDate datedeb) {
		this.datedeb = datedeb;
	}
	public LocalDate getDatefin() {
		return datefin;
	}
	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Revue getRevue() {
		return revue;
	}
	public void setRevue(Revue revue) {
		this.revue = revue;
	}

	
	
	@Override
	public String toString() {
		return "Abonnement [idabonnement=" + idabonnement + ", datedeb=" + datedeb + ", datefin=" + datefin
				+ ", client=" + client + ", revue=" + revue + "]";
	}
	
	
}
