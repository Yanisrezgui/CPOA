package dao.mysql;

import java.sql.*;

public class Connexion {
	
	private static Connexion instance;

	public static Connexion getInstance() { if (instance == null) {
		instance = new Connexion(); }
		return instance; }
	
	/** 
	 * Creer la connexion à la BDD
	 * @return une connexion
	 */
	public static Connection creeConnexion() {
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/levrel1u_CPOABDD";
		url += "?serverTimezone=Europe/Paris";		//pour le decallage horraire 
		String login = "levrel1u_appli";
		String pwd = "31906194";
		Connection maConnexion = null;
		
		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage()); 
		}
		return maConnexion; 
	}
	
	/**
	 * 
	 * @param laConnexion
	 * @param req
	 * @param res
	 * @throws SQLException
	 */
	//Surcharge de fermeture pour pouvoir fermet soit les requetes + les resultat soit que la requete
	public static void fermeture(Connection laConnexion, PreparedStatement req) throws SQLException {
		fermeture(laConnexion,req,null);
	}
	public static void fermeture(Connection laConnexion, PreparedStatement req, ResultSet res) throws SQLException {
		
		if (res != null)
		       res.close();
		if (req != null) 
				req.close();
		if (laConnexion != null) 
				laConnexion.close();
		
	}
	
}
