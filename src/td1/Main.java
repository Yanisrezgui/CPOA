package td1;

<<<<<<< HEAD
import dao.mysql.MySQLRevueDAO;
=======
import modele.Abonnement;
import modele.Client;
import modele.Periodicite;
import modele.Revue;
import dao.mysql.MySQLRevueDAO;
import dao.mysql.MySQLAbonnementDAO;
import dao.mysql.MySQLClientDAO;
import dao.mysql.MySQLDAOFactory;
import dao.mysql.MySQLPeriodiciteDAO;
>>>>>>> branch 'master' of https://github.com/Yanisrezgui/CPOA

public class Main {
	//je test

	public static void main(String[] args) {
		
		Connexion laConnexion = new Connexion();
		
<<<<<<< HEAD
		
		MySQLRevueDAO dao = new MySQLRevueDAO();
		dao.findAll();
		dao.getById(2);
=======
		Client c1=new Client(0, null, null, 0, null, null, null, null);
		Abonnement a1=new Abonnement(0, null, null, c1, null);
		Revue r1=new Revue(0, null, null, 0, null, null);
		Periodicite p1=new Periodicite(0, null);
		
	
		
		
		
		
		
>>>>>>> branch 'master' of https://github.com/Yanisrezgui/CPOA
	}

}
