package td1;

import dao.mysql.MySQLClientDAO;
import modele.Client;

public class Main {
	
	Connexion connexion = new Connexion();
	
	MySQLClientDAO MC = new MySQLClientDAO();
	
	Client c1 = new Client(1, "Rezgui", "Yanis", 3, "rue du chaudron", "52422", "Paris", "France" );
	Client c2 = new Client(2, "Batman", "Louis", 7, "rue de la loire", "36232", "Metz", "France" );
	
}
