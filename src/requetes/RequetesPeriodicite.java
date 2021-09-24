package requetes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import td1.Connexion;

public class RequetesPeriodicite {
	
	/**
	 * 
	 * @param libellePeriodicite
	 */
	public void ajouterPeriodicite(String libellePeriodicite) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,libellePeriodicite);
			int nbLignes = req.executeUpdate();
			// Incrémentation id
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
			}
			//Fermeture 
			Connexion.fermeture(laConnexion, req, res);
		}catch (SQLException sqle) {
			System.out.println("Pb dans insert " + sqle.getMessage());
		}
	}
	
	/**
	 * 
	 * @param libellePeriodicite
	 */
	public void supprimerPeriodicite(int id) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");
			req.setInt(1, id);
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
	}
	
	/**
	 * 
	 * @param id 
	 * @param libellePeriodicite
	 */
	public void modifierPeriodicite(String libellePeriodicite) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle = ?");
			req.setString(1, libellePeriodicite);
			int nbLignes = req.executeUpdate();
			//Fermeture
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
	}
}
