package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import dao.AbonnementDAO;
import modele.Abonnement;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {
	private static ListeMemoireAbonnementDAO instance;
	private List<Abonnement> donnees;
	
	/**
	 * 
	 * @return
	 */
	public static ListeMemoireAbonnementDAO getInstance() {
		
		 if (instance == null) {
			instance = new ListeMemoireAbonnementDAO();
		}
		
		return instance;
	}
	
	/**
	 * 
	 */
	private ListeMemoireAbonnementDAO() {
		this.donnees = new ArrayList<Abonnement>();

		//TODO voir le jeu de donnees 
		this.donnees.add(new Abonnement(1, null,null,null,null));
		this.donnees.add(new Abonnement(2, null,null,null,null)); 
	}
	
	@Override
	public Abonnement getById(int id) {
		
		int idx = this.donnees.indexOf(new Abonnement(id, null ,null,null,null));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}
	
	@Override
	public boolean create(Abonnement objet) {
		objet.setIdabonnement(3);
		
		while (this.donnees.contains(objet)) {

			objet.setIdabonnement(objet.getIdabonnement() + 1);
		}
		boolean ok = this.donnees.add(objet);
	
		return ok;
	}
	
	@Override
	public boolean update(Abonnement objet) {
		
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
	public boolean delete(Abonnement objet) {
		Abonnement supprime;
		
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
	public ArrayList<Abonnement> findAll() {
		
		return (ArrayList<Abonnement>) this.donnees;
	}
	
	@Override
	public List<Abonnement> getByDateDeb() {
		// TODO Auto-generated method stub
		return null;
	}


}
