package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import dao.ClientDAO;
import modele.Client;
import modele.Periodicite;

public class ListeMemoireClientDAO implements ClientDAO {
	private static ListeMemoireClientDAO instance;
	private List<Client> donnees;
	
	/**
	 * 
	 * @return
	 */
	public static ListeMemoireClientDAO getInstance() {
		
		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}
		
		return instance;
	}
	
	/**
	 * 
	 */
	private ListeMemoireClientDAO() {
		this.donnees = new ArrayList<Client>();

		this.donnees.add(new Client(1, "Dupont","Zoubir",32,"rue du trou","66699","Marange","Tchetchenie"));
		this.donnees.add(new Client(2, "Stark","Tony",42,"rue des avengers","52901","Maliby","USA")); 
	}
	
	
	@Override
	public Client getById(int id) {
		
		int idx = this.donnees.indexOf(new Client(id, "test","test",1,"test","test","test","test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} 
		else {
			return this.donnees.get(idx);
		}
	}
	
	@Override
	public boolean create(Client objet) {
		objet.setIdclient(3);
		
		while (this.donnees.contains(objet)) {

			objet.setIdclient(objet.getIdclient() + 1);
		}
		boolean ok = this.donnees.add(objet);
	
		return ok;
	}
	
	@Override
	public boolean update(Client objet) {
		
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} 
		else {
			this.donnees.set(idx, objet);
		}
				
		return true;
	}
	
	@Override
	public boolean delete(Client objet) {
		Client supprime;
		
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} 
		else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}
	
	@Override
	public List<Client> getByVille() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> findAll() {
		return (ArrayList<Client>) this.donnees;
	}

}
