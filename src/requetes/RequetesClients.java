package requetes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import td1.Connexion;

public class RequetesClients {
	
	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param norue
	 * @param voie
	 * @param codepostal
	 * @param ville
	 * @param pays
	 */
	public void ajouterClient(String nom, String prenom, Integer norue, String voie, Integer codepostal, String ville, String pays) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,nom);	
			req.setString(2,prenom);
			req.setInt(3, norue); ;
			req.setString(4, voie);
			req.setInt(5, codepostal);
			req.setString(6, ville);
			req.setString(7, pays);
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
	 * @param idclient
	 */
	public void supprimerClient(int idclient) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_client=?");
			req.setInt(1, idclient);
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
	}
	
	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param norue
	 * @param voie
	 * @param codepostal
	 * @param ville
	 * @param pays
	 */
	public void modifierClient(String nom, String prenom, Integer norue, String voie, Integer codepostal, String ville, String pays) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("update Client set (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,nom);	
			req.setString(2,prenom);
			req.setInt(3, norue); ;
			req.setString(4, voie);
			req.setInt(5, codepostal);
			req.setString(6, ville);
			req.setString(7, pays);
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
	}
	
}
