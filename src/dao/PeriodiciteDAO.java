package dao;

import java.util.List;

import modele.Periodicite;

public interface PeriodiciteDAO extends DAO<Periodicite> {
	
	public List<Periodicite> getByLibelle() throws Exception;

}
