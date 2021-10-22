package td1;

import dao.DAOFactory;
import dao.Persistance;
import modele.Periodicite;
import modele.Revue;

public class MainRevue {

	public static void main(String[] args) {
		
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);

		Periodicite p1=new Periodicite(1, "test");
		Periodicite p2=new Periodicite(2, "test2");
		
		Revue r1=new Revue(1, "peaky blinders", "serie", 15,"oui", p1);
		Revue r2=new Revue(2, "vikings", "serie", 20, "oui", p2);
		
		try {
			dao.getRevueDAO().create(r1);
			dao.getRevueDAO().create(r2);
			dao.getRevueDAO().findAll();
			dao.getRevueDAO().getById(2);
		} catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}

}
