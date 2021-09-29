package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.RevueDAO;
import modele.Revue;
import td1.Connexion;

public class MySQLRevueDAO implements RevueDAO{
	private static MySQLRevueDAO instance;
	
	/**
	 * 
	 * @return
	 */
	public static RevueDAO getInstance() {
		
		if (instance == null) {
			instance = new MySQLRevueDAO();
		}
		
		return instance;
	}
	
	@Override
	public Revue getById(int id) {
		
		//TODO Voir si c'est pas mieux de passer en param l'objet abonnement  : getById(Abonnement objet)
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select from Revue where id_revue = ?");
			req.setInt(1, id);
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return null;
	}
	
	@Override
	public boolean create(Revue objet) {
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Revue (titre, description, tarif_numero, visuel) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,objet.getTitre());
			req.setString(2, objet.getDescription());
			req.setFloat(3, objet.getTarifnumero());
			req.setString(4, objet.getVisuel());
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
		
		return true;
	}
	@Override
	public boolean update(Revue objet) {
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("update Revue set (titre, description, tarif_numero, visuel) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,objet.getTitre());	
			req.setString(2,objet.getDescription());
			req.setFloat(3, objet.getTarifnumero()); ;
			req.setString(4, objet.getVisuel());
			int nbLignes = req.executeUpdate();
			//Fermeture
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return true;
	}
	
	@Override
	public boolean delete(Revue objet) {
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Revue where id_revue=?");
			req.setInt(1, objet.getIdrevue());
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return true;
	}
	
	@Override
	public ArrayList<Revue> findAll() {
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select (*) from Revue");
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return null;
	}
	
	@Override
	public List<Revue> getByPeriodicite() {
		// TODO Auto-generated method stub
		return null;
	}

}
