package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.ClientDAO;
import modele.Client;
import td1.Connexion;

public class MySQLClientDAO implements ClientDAO {
	private static MySQLClientDAO instance;
	
	
	/**
	 * 
	 * @return
	 */
	public static ClientDAO getInstance() {
		
		if (instance == null) {
			instance = new MySQLClientDAO();
		}
		
		return instance;
	}

	@Override
	public Client getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Client objet) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement(
					"insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getNom());
			req.setString(2, objet.getPrenom());
			req.setInt(3, objet.getNovoie());
			req.setString(4, objet.getVoie());
			req.setString(5, objet.getCodepostal());
			req.setString(6, objet.getVille());
			req.setString(7, objet.getPays());
			int nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
			}
			// Fermeture
			Connexion.fermeture(laConnexion, req, res);
		} catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		return true;
	}

	@Override
	public boolean update(Client objet) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement(
					"update Client set (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getNom());
			req.setString(2, objet.getPrenom());
			req.setInt(3, objet.getNovoie());
			req.setString(4, objet.getVoie());
			req.setString(5, objet.getCodepostal());
			req.setString(6, objet.getVille());
			req.setString(7, objet.getPays());
			int nbLignes = req.executeUpdate();
			// Fermeture
			Connexion.fermeture(laConnexion, req);
		} catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		return true;
	}

	@Override
	public boolean delete(Client objet) {
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_client=?");
			req.setInt(1, objet.getIdclient());
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		return true;
	}

	@Override
	public List<Client> getByVille() {
		// TODO Auto-generated method stub
		return null;
	}

}
