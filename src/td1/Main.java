package td1;

import modele.Abonnement;
import modele.Client;
import modele.Periodicite;
import modele.Revue;
import dao.mysql.MySQLRevueDAO;
import dao.mysql.MySQLAbonnementDAO;
import dao.mysql.MySQLClientDAO;
import dao.mysql.MySQLDAOFactory;
import dao.mysql.MySQLPeriodiciteDAO;

public class Main {

	public static void main(String[] args) {
		
		Connexion laConnexion = new Connexion();
		
		Client c1=new Client(0, null, null, 0, null, null, null, null);
		Abonnement a1=new Abonnement(0, null, null, c1, null);
		Revue r1=new Revue(0, null, null, 0, null, null);
		Periodicite p1=new Periodicite(0, null);
		
	
		
		
		
		
		
	}

}
