package td1;

import dao.mysql.MySQLAbonnementDAO;
import dao.mysql.MySQLClientDAO;
import dao.mysql.MySQLPeriodiciteDAO;
import dao.mysql.MySQLRevueDAO;
import modele.Abonnement;
import modele.Client;
import modele.Periodicite;
import modele.Revue;

public class Main {

	public static void main(String[] args) {
		Connexion connexion = new Connexion();
		
		MySQLClientDAO msqlcl = new MySQLClientDAO();
		MySQLAbonnementDAO msqlabo= new MySQLAbonnementDAO();
		MySQLRevueDAO msqlrev=new MySQLRevueDAO();
		MySQLPeriodiciteDAO msqlperi=new MySQLPeriodiciteDAO();
		
		
		Client c1 = new Client(1, "Manuel", "Croix", 4, "rue des frites", "36252","Paris","France");
		Client c2 = new Client(2, "Picon", "Biere", 6, "rue des bourres", "75578","Metz","France");
		
		msqlcl.create(c1);
		msqlcl.create(c2);
		msqlcl.delete(c2);
		msqlcl.findAll();
		msqlcl.getById(1);
		
		
		Abonnement a1=new Abonnement(1, null, null, c1, null);
		Abonnement a2=new Abonnement(2, null, null, c1, null);
		 
		msqlabo.create(a1);
		msqlabo.create(a2);
		msqlabo.findAll();
		msqlabo.getById(2);
		 
		
		Periodicite p1=new Periodicite(1, "test");
		Periodicite p2=new Periodicite(2, "test2");
		
		msqlperi.create(p1);
		msqlperi.create(p2);
		msqlperi.findAll();
		msqlperi.getById(1);
		
		Revue r1=new Revue(1, "peaky blinders", "serie", 15,"oui", p1);
		Revue r2=new Revue(2, "vikings", "serie", 20, "oui", p2);
		
		msqlrev.create(r1);
		msqlrev.create(r2);
		msqlrev.findAll();
		msqlrev.getById(2);
		
		
	}

}
