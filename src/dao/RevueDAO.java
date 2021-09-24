package dao;

import java.util.List;

import modele.Revue;

public interface RevueDAO extends DAO<Revue>{
	
	public List<Revue> getByPeriodicite();
	
}
