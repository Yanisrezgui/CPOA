package modele;

import java.util.Date;

public class Abonnement {
	private int idabonnement;
	private Date datedeb;
	private Date datefin;
	private Client client;
	private Revue revue;
	
	
	//Contructeur
	public Abonnement(int idabonnement, Date datedeb, Date datefin, Client client, Revue revue) {
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
	public Date getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
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
