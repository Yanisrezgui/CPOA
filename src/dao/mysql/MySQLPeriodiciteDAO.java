package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PeriodiciteDAO;
import dao.RevueDAO;
import modele.Periodicite;
import td1.Connexion;

public class MySQLPeriodiciteDAO implements PeriodiciteDAO{
	private static MySQLPeriodiciteDAO instance;
	
	/**
	 * 
	 * @return
	 */
	public static PeriodiciteDAO getInstance() {
		
		if (instance == null) {
			instance = new MySQLPeriodiciteDAO();
		}
		
		return instance;
	}
	
	@Override
	public Periodicite getById(int id) {
		
		//TODO Voir si c'est pas mieux de passer en param l'objet abonnement  : getById(Abonnement objet)
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select from Periodicite where id_periodicite = ?");
			req.setInt(1, id);
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return null;
	}
	
	public boolean create(Periodicite objet) {
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,objet.getLibelle());
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
		
		return true;
	}
	
	public boolean update(Periodicite objet) {
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle = ?");
			req.setString(1, objet.getLibelle());
			int nbLignes = req.executeUpdate();
			//Fermeture
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return true;
	}
	
	public boolean delete(Periodicite objet) {
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");
			req.setInt(1, objet.getIdperiodicite());
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return true;
	}
	
	@Override
	public ArrayList<Periodicite> findAll() {

		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select (*) from Periodicite");
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return null;
	}
	
	@Override
	public List<Periodicite> getByLibelle() {
		// TODO Auto-generated method stub
		return null;
	}

}
