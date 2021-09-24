package requetes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import td1.Connexion;

public class RequetesRevue {
	
	
	/**
	 * 
	 * @param titre
	 * @param description
	 * @param tarifnumero
	 * @param visuel
	 */
	public void ajouterRevue(String titre, String description, Integer tarifnumero, String visuel) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Revue (titre, description, tarif_numero, visuel) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,titre);
			req.setString(2, description);
			req.setInt(3, tarifnumero);
			req.setString(4, visuel);
			int nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
			}
			//Fermeture
			Connexion.fermeture(laConnexion, req, res);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
	}
	
	/**
	 * 
	 * @param idrevue
	 */
	public void supprimerRevue(int idrevue) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Revue where id_revue=?");
			req.setInt(1, idrevue);
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
	}
	
	/**
	 * 
	 * @param titre
	 * @param description
	 * @param tarifnumero
	 * @param visuel
	 */
	public void modifierClient(String titre, String description, Integer tarifnumero, String visuel) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("update Revue set (titre, description, tarif_numero, visuel) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,titre);	
			req.setString(2,description);
			req.setInt(3, tarifnumero); ;
			req.setString(4, visuel);
			int nbLignes = req.executeUpdate();
			//Fermeture
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
	}
	
}
