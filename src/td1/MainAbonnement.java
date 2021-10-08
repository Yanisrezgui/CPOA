package td1;

import dao.mysql.MySQLAbonnementDAO;
import modele.Abonnement;
import modele.Client;
import modele.Periodicite;
import modele.Revue;

public class MainAbonnement {

	public static void main(String[] args) {
		
		MySQLAbonnementDAO msqlabo= new MySQLAbonnementDAO();
		
		Client c1 = new Client(1, "Manuel", "Croix", 4, "rue des frites", "36252","Paris","France");
		Periodicite p1=new Periodicite(1, "test");
		Revue r1=new Revue(4, "peaky blinders", "serie", 15,"oui", p1);
		
		Abonnement a1=new Abonnement(1, null, null, c1, r1);
		Abonnement a2=new Abonnement(2, null, null, c1, r1);
		 
		msqlabo.create(a1);
		msqlabo.create(a2);
		msqlabo.findAll();
		msqlabo.getById(2);

	}

}
