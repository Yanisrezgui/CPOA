package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import dao.PeriodiciteDAO;
import modele.Periodicite;

public class ListeMemoirePeriodiciteDAO implements PeriodiciteDAO {
	private static ListeMemoirePeriodiciteDAO instance;
	private List<Periodicite> donnees;

	/**
	 * 
	 * @return
	 */
	public static ListeMemoirePeriodiciteDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoirePeriodiciteDAO();
		}

		return instance;
	}

	/**
	 * 
	 */
	private ListeMemoirePeriodiciteDAO() {

		this.donnees = new ArrayList<Periodicite>();

		this.donnees.add(new Periodicite(1, "Mensuel"));
		this.donnees.add(new Periodicite(2, "Quotidien"));
	}


	@Override
	public boolean create(Periodicite objet) {
		objet.setIdperiodicite(3);

		while (this.donnees.contains(objet)) {
			objet.setIdperiodicite(objet.getIdperiodicite() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Periodicite objet) {
		
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean delete(Periodicite objet) {
		Periodicite supprime;
		
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	@Override
	public Periodicite getById(int id) {
		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(new Periodicite(id, "test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}
	
	//TODO demander au prof
	/*
	@Override
	public ArrayList<Periodicite> findAll() {
		return (ArrayList<Periodicite>) this.donnees;
	}
	*/

	@Override
	public List<Periodicite> getByLibelle() {
		// TODO Auto-generated method stub
		return null;
	}
}
