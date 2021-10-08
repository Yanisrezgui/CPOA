package td1;

import dao.mysql.MySQLRevueDAO;
import modele.Periodicite;
import modele.Revue;

public class MainRevue {

	public static void main(String[] args) {
		
		MySQLRevueDAO msqlrev=new MySQLRevueDAO();

		Periodicite p1=new Periodicite(1, "test");
		Periodicite p2=new Periodicite(2, "test2");
		
		Revue r1=new Revue(4, "peaky blinders", "serie", 15,"oui", p1);
		Revue r2=new Revue(2, "vikings", "serie", 20, "oui", p2);
		
		msqlrev.create(r1);
		msqlrev.create(r2);
		msqlrev.findAll();
		msqlrev.getById(2);
	}

}
