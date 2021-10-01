package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

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
		Periodicite perio = null;
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select * from Periodicite where id_periodicite = ?");
			req.setInt(1, id);
			ResultSet res = req.executeQuery();
			if(res.next()) {
				perio = new Periodicite(res.getInt(1),res.getString(2));
			}
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			System.out.println("Pb dans select" + sqle.getMessage());
		}
		
		return perio;
	}
	
	public boolean create(Periodicite objet) {
		int nbLignes = 0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,objet.getLibelle());
			nbLignes = req.executeUpdate();
			// Incrémentation id
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
				objet.setIdperiodicite(cle);
			}
			//Fermeture 
			Connexion.fermeture(laConnexion, req, res);
		}catch (SQLException sqle) {
			System.out.println("Pb dans insert " + sqle.getMessage());
		}
		
		return nbLignes==1;
	}
	
	public boolean update(Periodicite objet) {
		int nbLignes = 0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle = ?");
			req.setString(1, objet.getLibelle());
			nbLignes = req.executeUpdate();
			//Fermeture
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			System.out.println("Pb dans update " + sqle.getMessage());
		}
		
		return nbLignes==1;
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
		ArrayList<Periodicite> liste = new ArrayList<Periodicite>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select (*) from Periodicite");
			ResultSet res = req.executeQuery();
			while (res.next()){
				liste.add(new Periodicite(res.getInt("id_periodicite"),res.getString("libelle")));
			}
			//Fermeture 
			Connexion.fermeture(laConnexion, req);
		}catch (SQLException sqle) {
			System.out.println("Pb dans select" + sqle.getMessage());
		}
		
		return liste;
	}
	
	@Override
	public List<Periodicite> getByLibelle() {
		// TODO Auto-generated method stub
		return null;
	}

}