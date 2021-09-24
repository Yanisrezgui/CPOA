package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import dao.RevueDAO;
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
		
		this.donnees.add(new Revue(1, "Batman","Aventure",32,"beau", null));
		this.donnees.add(new Revue(2, "Stark","Tony",42,"rue des avengers",null)); 
	}
	
	@Override
	public Revue getById(int id) {

		int idx = this.donnees.indexOf(new Revue(id, "test","test",1,"test",null));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}
	
	@Override
	public boolean create(Revue objet) {
		objet.setIdrevue(3);
		
		while (this.donnees.contains(objet)) {

			objet.setIdrevue(objet.getIdrevue() + 1);
		}
		boolean ok = this.donnees.add(objet);
	
		return ok;
	}
	
	@Override
	public boolean update(Revue objet) {
		
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
