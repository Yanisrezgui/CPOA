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
		this.setIdabonnement(idAbonnement);
		this.setDatedeb(datedeb);
		this.setDatefin(datefin);
		this.setClient(client);
		this.setRevue(revue);
	}
	
	//constructeur sans id
	public Abonnement( LocalDate datedeb, LocalDate datefin, Client client, Revue revue) {
		
		this(-1,datedeb,datefin,client,revue);
	}

	//Getters & Setters
	public int getIdabonnement() {
		return idAbonnement;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonnement other = (Abonnement) obj;
		return idAbonnement == other.idAbonnement;
				
	}

	public void setIdabonnement(int idAbonnement) {
		
		if(idAbonnement<-1)
			throw new IllegalArgumentException("l'identifiant doit etre positif");
		else
		this.idAbonnement = idAbonnement;
	}
	
	public LocalDate getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(LocalDate datedeb) {
		
		
		if(this.datedeb.isAfter(this.datefin) && this.datefin!=null) {
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
		
		if(this.datefin.isBefore(this.datedeb) && this.datedeb!=null) {
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
		
		if(client==null) {
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
		
		if(revue==null) {
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
