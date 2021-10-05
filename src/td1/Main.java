package td1;

import dao.mysql.MySQLRevueDAO;

public class Main {

	public static void main(String[] args) {
		
		Connexion laConnexion = new Connexion();
		
		
		MySQLRevueDAO dao = new MySQLRevueDAO();
		dao.findAll();
		dao.getById(2);
	}

}
