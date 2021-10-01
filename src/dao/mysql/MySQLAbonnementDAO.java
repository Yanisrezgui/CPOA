package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AbonnementDAO;
import modele.Abonnement;
import td1.Connexion;

public class MySQLAbonnementDAO implements AbonnementDAO {
	private static MySQLAbonnementDAO instance;
	
	public static AbonnementDAO getInstance() {
		
		if (instance == null) {
			instance = new MySQLAbonnementDAO();
		}
		
		return instance;
	}
	
	
	@Override
	public Abonnement getById(int id) {
		//coucou c'est moi
		//TODO Voir si c'est pas mieux de passer en param l'objet abonnement  : getById(Abonnement objet)
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select from Abonnement where id_abonnement = ?");
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
	public boolean create(Abonnement objet) {
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Abonnement (date_debut, date_fin) values(?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setDate(1, java.sql.Date.valueOf(objet.getDatedeb()));	
			req.setDate(2, java.sql.Date.valueOf(objet.getDatefin()));
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
	public boolean update(Abonnement objet) {
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set  date_debut = ? and date_fin = ?)");
			req.setDate(1, java.sql.Date.valueOf(objet.getDatedeb()));	
			req.setDate(2, java.sql.Date.valueOf(objet.getDatefin()));
			int nbLignes = req.executeUpdate();
			//Fermeture
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return true;
	}
	
	@Override
	public boolean delete(Abonnement objet) {
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Abonnement where id_abonnement = ?");
			req.setInt(1, objet.getIdabonnement());
			int nbLignes = req.executeUpdate();
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		
		return true;
	}
	
	@Override
	public ArrayList<Abonnement> findAll() {
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select (*) from Abonnement");
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			// TODO : faire un message de d'exception
		}
		//TODO Voir pour le return en SQL
		return null;
	}
	
	@Override
	public List<Abonnement> getByDateDeb() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
