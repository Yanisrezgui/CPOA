package dao;

import dao.listememoire.ListeMemoireDAOFactory;
import dao.mysql.MySQLDAOFactory;

public abstract class DAOFactory {
	
	/**
	 * 
	 * @param cible
	 * @return
	 */
	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactory daoF = null;
		
		switch (cible) {
		case MYSQL:
			daoF = new MySQLDAOFactory();
			break;
		case LISTE_MEMOIRE:
			daoF = new ListeMemoireDAOFactory();
			break;
		}
		return daoF;
	}

	public abstract ClientDAO getClientDAO();
	public abstract RevueDAO getRevueDAO();
	public abstract AbonnementDAO getAbonnementDAO();
}
