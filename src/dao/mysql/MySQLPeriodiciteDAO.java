package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PeriodiciteDAO;
import modele.Periodicite;
import td1.Connexion;

public class MySQLPeriodiciteDAO implements PeriodiciteDAO{
	
	
	//TODO getInstance
	
	
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
	public Periodicite getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Periodicite> getByLibelle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
