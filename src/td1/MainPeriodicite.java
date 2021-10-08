package td1;

import dao.mysql.MySQLPeriodiciteDAO;
import modele.Periodicite;

public class MainPeriodicite {

	public static void main(String[] args) {
		
		MySQLPeriodiciteDAO msqlperi=new MySQLPeriodiciteDAO();
		
		Periodicite p1=new Periodicite(1, "test");
		Periodicite p2=new Periodicite(2, "test2");
		
		msqlperi.create(p1);
		msqlperi.create(p2);
		msqlperi.findAll();
		msqlperi.getById(1);
		msqlperi.delete(p2);
		msqlperi.delete(p1);
	}

}
