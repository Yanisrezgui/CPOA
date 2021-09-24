package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import dao.RevueDAO;
import modele.Client;
import modele.Revue;

public class ListeMemoireRevueDAO implements RevueDAO {
	private static ListeMemoireRevueDAO instance;
	private List<Revue> donnees;
	
	/**
	 * 
	 * @return
	 */
	public static ListeMemoireRevueDAO getInstance() {
		
		 if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}
		
		return instance;
	}
	
	/**
	 * 
	 */
	private ListeMemoireRevueDAO() {
		this.donnees = new ArrayList<Revue>();

		//TODO voir le jeu de donnees 
		//TODO voir pour mettre une periodicite 
		this.donnees.add(new Revue(1, "Batman","Aventure",32,"beau", mensuel);
		this.donnees.add(new Revue(2, "Stark","Tony",42,"rue des avengers",hebdomadaire)); 
	}
	
	@Override
	public Revue getById(int id) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		//TODO voir pour la periodicite
		int idx = this.donnees.indexOf(new Revue(id, "test","test",1,"test",test));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}
	
	@Override
	public boolean create(Revue objet) {
		objet.setIdrevue(3);
		
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setIdrevue(objet.getIdrevue() + 1);
		}
		boolean ok = this.donnees.add(objet);
	
		return ok;
	}
	
	@Override
	public boolean update(Revue objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
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
	public boolean delete(Revue objet) {
		Revue supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
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
	public List<Revue> getByPeriodicite() {
		// TODO Auto-generated method stub
		return null;
	}

}
