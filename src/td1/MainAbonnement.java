package td1;

import java.time.LocalDate;

import dao.DAOFactory;
import dao.Persistance;
import modele.Abonnement;
import modele.Client;
import modele.Periodicite;
import modele.Revue;

public class MainAbonnement {

	public static void main(String[] args) {
		
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		
		Client c1 = new Client(1, "Manuel", "Croix", 4, "rue des frites", "36252","Paris","France");
		Periodicite p1=new Periodicite(1, "test");
		Revue r1=new Revue(4, "peaky blinders", "serie", 15,"oui", p1);
		
		LocalDate d1 = LocalDate.of(2021, 2, 25);
		LocalDate d2 = LocalDate.of(2021,7,22);
		
		Abonnement a1=new Abonnement(1, d1, d2, c1, r1);
		Abonnement a2=new Abonnement(2, d1, d2, c1, r1);
		 
		try {
			dao.getAbonnementDAO().create(a1);
			dao.getAbonnementDAO().create(a2);
			dao.getAbonnementDAO().findAll();
			dao.getAbonnementDAO().getById(2);
		}catch(Exception sqle){
			System.out.println(sqle.getMessage());
		}

	}

}
