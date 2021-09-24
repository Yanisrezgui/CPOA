package dao.listememoire;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.DAOFactory;
import dao.RevueDAO;

public class ListeMemoireDAOFactory extends DAOFactory {
	
	@Override
	public ClientDAO getClientDAO() {
		return ListeMemoireClientDAO.getInstance();
	}
	@Override
	public RevueDAO getRevueDAO() {
		return ListeMemoireRevueDAO.getInstance();
	}
	@Override
	public AbonnementDAO getAbonnementDAO() {
		return ListeMemoireAbonnementDAO.getInstance();
	}
}
