package modele;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private int novoie;	
	private String voie;
	private String codepostal;
	private String ville;
	private String pays;
	
	
	//Constructeur
	public Client(int idClient, String nom, String prenom, int novoie, String voie, String codepostal, String ville,
			String pays) {
		super();
		this.setIdclient(idClient);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setNovoie(novoie);
		this.setVoie(voie);
		this.setCodepostal(codepostal);
		this.setVille(ville);
		this.setPays(pays);
	}
	
	//constructeur sans id
	public Client( String nom, String prenom, int novoie, String voie, String codepostal, String ville,String pays) {
		
		this(-1,nom,prenom,novoie,voie,codepostal,ville,pays);
		
	}

	//Getters & Setters
	public int getIdclient() {
		return idClient;
	}
	
	
	public void setIdclient(int idClient) {
		
		if(idClient<-1)
			throw new IllegalArgumentException("l'identifiant doit etre positif");
		this.idClient = idClient;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	
	
	public void setNom(String nom) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
		Matcher matcherNom = pattern.matcher(nom);
		
		if(nom==null) {
			throw new IllegalArgumentException("Nom ne peut etre null");
		}
		else if("".equals(nom)) {
			throw new IllegalArgumentException("Nom non valide");
		}
		else if(!matcherNom.find()) {
			throw new IllegalArgumentException("Nom non valide");
		}
		else {			
			this.nom = nom;
		}
		
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
		Matcher matcherPrenom = pattern.matcher(prenom);
		
		if(prenom==null) {
			throw new IllegalArgumentException("Prenom ne peut etre null");
		}
		else if("".equals(prenom)) {
			throw new IllegalArgumentException("Prenom non valide");
		}
		else if(!matcherPrenom.find()) {
			throw new IllegalArgumentException("Prenom non valide");
		}
		else {
			this.prenom = prenom;
		}
	}
	public int getNovoie() {
		return novoie;
	}
	public void setNovoie(int novoie) {
		
		if(novoie<1)
			throw new IllegalArgumentException("le numero de voie ne peut pas etre negatif");
		this.novoie = novoie;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		
			if(voie==null) {
				throw new IllegalArgumentException("Voie ne peut etre null");
			}
			else if("".equals(voie)) {
				throw new IllegalArgumentException("Voie non valide");
			}
			else {
				this.voie = voie;
			}
	}
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcherCodePostal = pattern.matcher(codepostal);
		
		if(codepostal==null) {
			throw new IllegalArgumentException("Le code postal ne peut etre null");
		}
		else if("".equals(codepostal)) {
			throw new IllegalArgumentException("Code postal non valide");
		}
		else if(!matcherCodePostal.find()) {
			throw new IllegalArgumentException("Code postal non valide");
		}
		else {
			this.codepostal = codepostal;
		}
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
		Matcher matcherVille = pattern.matcher(ville);
		
		if(ville==null) {
			throw new IllegalArgumentException("Ville ne peut etre null");
		}
		else if("".equals(ville)) {
			throw new IllegalArgumentException("Ville non valide");
		}
		else if(!matcherVille.find()) {
			throw new IllegalArgumentException("Ville non valide");
		}
		else {
			this.ville = ville;
		}
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		Pattern pattern = Pattern.compile("^[A-Za-z-]+$");
		Matcher matcherPays = pattern.matcher(pays);
		
		if(pays==null) {
			throw new IllegalArgumentException("Pays ne peut etre null");
		}
		else if("".equals(pays)) {
			throw new IllegalArgumentException("Pays non valide");
		}
		else if(!matcherPays.find()) {
			throw new IllegalArgumentException("Pays non valide");
		}
		else {
			this.pays = pays;
		}
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return idClient == other.idClient;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", novoie=" + novoie + ", voie="
				+ voie + ", codepostal=" + codepostal + ", ville=" + ville + ", pays=" + pays + "]";
	}
	
}
