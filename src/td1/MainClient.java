package td1;

import dao.DAOFactory;
import dao.Persistance;
import modele.Client;

public class MainClient {

	public static void main(String[] args) {
		
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		Client c1 = new Client(1, "Manuel", "Croix", 4, "rue des frites", "36252","Paris","France");
		Client c2 = new Client(2, "Picon", "Biere", 6, "rue des bourres", "75578","Metz","France");
		
		try {
			dao.getClientDAO().create(c1);
			dao.getClientDAO().create(c2);
			dao.getClientDAO().delete(c1);
			dao.getClientDAO().findAll();
			dao.getClientDAO().getById(1);
		} catch(Exception sqle) {
			System.out.println(sqle.getMessage());
		}
	}

}
