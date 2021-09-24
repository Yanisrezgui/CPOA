package requetes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import td1.Connexion;

public class RequetesAbonnement {

	/**
	 * 
	 * @param datedeb
	 * @param datefin
	 */
	public void ajouterAbonnement(Date datedeb, Date datefin) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Abonnement (date_debut, date_fin) values(?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setDate(1, datedeb);	
			req.setDate(2, datefin);
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
	 * @param id
	 */
	public void supprimerAbonnement(int id) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Abonnement where id_abonnement = ?");
			req.setInt(1, id);
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
	}
	
	public void modifierAbonnement(Date datedeb, Date datefin) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set  date_debut = ? and date_fin = ?)");
			req.setDate(1, datedeb);	
			req.setDate(2, datefin);
			int nbLignes = req.executeUpdate();
			//Fermeture
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
	}
	
}
