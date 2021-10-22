package td1;

import dao.DAOFactory;
import dao.Persistance;
import modele.Periodicite;

public class MainPeriodicite {

	public static void main(String[] args) {
		
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		Periodicite p1=new Periodicite(1, "test");
		Periodicite p2=new Periodicite(2, "test2");
		
		try {
			dao.getPeriodiciteDAO().create(p1);
			dao.getPeriodiciteDAO().create(p2);
			dao.getPeriodiciteDAO().findAll();
			dao.getPeriodiciteDAO().getById(1);
			dao.getPeriodiciteDAO().delete(p2);
			dao.getPeriodiciteDAO().delete(p1);
		} catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}

}
