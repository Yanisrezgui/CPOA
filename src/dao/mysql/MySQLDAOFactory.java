package dao.mysql;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.DAOFactory;
import dao.RevueDAO;

public class MySQLDAOFactory extends DAOFactory {
	
	@Override
	public ClientDAO getClientDAO() {
		return MySQLClientDAO.getInstance();
	}
	@Override
	public RevueDAO getRevueDAO() {
		return MySQLRevueDAO.getInstance();
	}
	@Override
	public AbonnementDAO getAbonnementDAO() {
		return MySQLAbonnementDAO.getInstance();
	}
	
}
