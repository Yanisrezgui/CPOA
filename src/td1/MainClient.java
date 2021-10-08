package td1;

import dao.mysql.MySQLClientDAO;
import modele.Client;

public class MainClient {

	public static void main(String[] args) {
		
		MySQLClientDAO msqlcl = new MySQLClientDAO();
		
		Client c1 = new Client(1, "Manuel", "Croix", 4, "rue des frites", "36252","Paris","France");
		Client c2 = new Client(2, "Picon", "Biere", 6, "rue des bourres", "75578","Metz","France");
		
		msqlcl.create(c1);
		msqlcl.create(c2);
		msqlcl.delete(c1);
		msqlcl.findAll();
		msqlcl.getById(1);

	}

}
