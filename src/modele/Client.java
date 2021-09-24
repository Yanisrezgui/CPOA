package modele;

public class Client {
	private int idclient;
	private String nom;
	private String prenom;
	private int novoie;
	private String voie;
	private String codepostal;
	private String ville;
	private String pays;
	
	
	//Constructeur
	public Client(int idclient, String nom, String prenom, int novoie, String voie, String codepostal, String ville,
			String pays) {
		super();
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.novoie = novoie;
		this.voie = voie;
		this.codepostal = codepostal;
		this.ville = ville;
		this.pays = pays;
	}

	//Getters & Setters
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNovoie() {
		return novoie;
	}
	public void setNovoie(int novoie) {
		this.novoie = novoie;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	
	
	@Override
	public String toString() {
		return "Client [idclient=" + idclient + ", nom=" + nom + ", prenom=" + prenom + ", novoie=" + novoie + ", voie="
				+ voie + ", codepostal=" + codepostal + ", ville=" + ville + ", pays=" + pays + "]";
	}
	
}
