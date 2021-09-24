package requetes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import td1.Connexion;

public class RequeteTest {
	
	/**
	 * test d'une requete 
	 */
	public static void uneRequete() {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			Statement requete = laConnexion.createStatement(); 
			ResultSet res = requete.executeQuery("select nom, prenom, id_client from Client");
			//Resultat
			while (res.next()) {
				int no = res.getInt(1);
				   String nom = res.getString("nom");
				   System.out.println(nom);
			}
			//Fermeture
			if (res != null)
				res.close();
			if (requete != null) 
				requete.close();
			if (laConnexion != null) 
				laConnexion.close();
		
		} catch (SQLException sqle) {
		System.out.println("Pb select" + sqle.getMessage());
		}
	}
	
	/**
	 * test d'un requete avec parametre 
	 */
	public void requeteNomClient(String nom) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			Statement requete = laConnexion.createStatement(); 
			ResultSet res = requete.executeQuery("select nom from Client where nom= '" + nom + "'");
			//Resultat
			while (res.next()) {
				int no = res.getInt(1);
				   String nom1 = res.getString("nom");
				   System.out.println(nom1);
			}
			//Fermeture
			if (res != null)
				res.close();
			if (requete != null) 
				requete.close();
			if (laConnexion != null) 
				laConnexion.close();
		} catch (SQLException sqle) {
		System.out.println("Pb select" + sqle.getMessage());
		}
	}
}
