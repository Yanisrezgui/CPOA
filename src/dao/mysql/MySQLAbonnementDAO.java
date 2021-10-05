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
		Abonnement Abo=null;
	
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select from Abonnement where id_abonnement = ?");
			req.setInt(1, id);
			ResultSet res = req.executeQuery();
			if(res.next()) {
				Abo = new Abonnement(res.getInt(1), res.getDate(2).toLocalDate(), res.getDate(3).toLocalDate(), MySQLClientDAO.getInstance().getById(res.getInt(4)), MySQLRevueDAO.getInstance().getById(res.getInt(5)));
			}
			
		}catch (SQLException sqle) {
			System.out.println("Pb dans select" + sqle.getMessage());
		}
		
		return Abo;
	}
	
	@Override
	public boolean create(Abonnement objet) {
		int nbLignes = 0;
		
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Abonnement (date_debut, date_fin) values(?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setDate(1, java.sql.Date.valueOf(objet.getDatedeb()));	
			req.setDate(2, java.sql.Date.valueOf(objet.getDatefin()));
			nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
				objet.setIdabonnement(cle);
			}		
		}catch (SQLException sqle) {
			System.out.println("Pb dans insert " + sqle.getMessage());
		}
		
		return nbLignes==1;
	}
	
	@Override
	public boolean update(Abonnement objet) {
		int nbLignes=0;
		
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set  date_debut = ?, date_fin = ?)");
			req.setDate(1, java.sql.Date.valueOf(objet.getDatedeb()));	
			req.setDate(2, java.sql.Date.valueOf(objet.getDatefin()));
			nbLignes = req.executeUpdate();
		}catch (SQLException sqle) {
			System.out.println("Pb dans update " + sqle.getMessage());
		}
		
		return nbLignes==1;
	}
	
	@Override
	public boolean delete(Abonnement objet) {
		int nbLignes=0;
		
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Abonnement where id_abonnement = ?");
			req.setInt(1, objet.getIdabonnement());
			nbLignes = req.executeUpdate();
		}catch (SQLException sqle) {
			System.out.println("Pb dans dele " + sqle.getMessage());
		}
		
		return nbLignes==1;
	}
	
	@Override
	public ArrayList<Abonnement> findAll() {
		ArrayList<Abonnement> liste = new ArrayList<Abonnement>();
		
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select * from Abonnement");
			ResultSet res = req.executeQuery();
			while (res.next()){
				liste.add(new Abonnement(res.getInt("idabonnement"), res.getDate("date_debut").toLocalDate(), res.getDate("date_fin").toLocalDate(), MySQLClientDAO.getInstance().getById(res.getInt(4)), MySQLRevueDAO.getInstance().getById(res.getInt(5))));
			}
		}catch (SQLException sqle) {
			System.out.println("Pb dans le select " + sqle.getMessage());
		}
		
		return liste;
	}
	
	@Override
	public List<Abonnement> getByDateDeb() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
