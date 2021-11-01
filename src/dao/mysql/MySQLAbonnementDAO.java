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

public class MySQLAbonnementDAO implements AbonnementDAO {
	private static MySQLAbonnementDAO instance;
	
	public static AbonnementDAO getInstance() {
		
		if (instance == null) {
			instance = new MySQLAbonnementDAO();
		}
		
		return instance;
	}
	
	
	@Override
	public Abonnement getById(int id) throws Exception{
		Abonnement Abo=null;
	
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select * from Abonnement where id_abonnement = ?");
			req.setInt(1, id);
			ResultSet res = req.executeQuery();
			if(res.next()) {
				Abo = new Abonnement(res.getInt(1), res.getDate(2).toLocalDate(), res.getDate(3).toLocalDate(), MySQLClientDAO.getInstance().getById(res.getInt(4)), MySQLRevueDAO.getInstance().getById(res.getInt(5)));
			}
		
		return Abo;
	}
	
	@Override
	public boolean create(Abonnement objet) throws Exception{
		int nbLignes = 0;
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Abonnement (date_debut, date_fin, id_client, id_revue) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setDate(1, java.sql.Date.valueOf(objet.getDatedeb()));	
			req.setDate(2, java.sql.Date.valueOf(objet.getDatefin()));
			req.setInt(3, objet.getClient().getIdclient());
			req.setInt(4, objet.getRevue().getIdrevue());
			nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
				objet.setIdabonnement(cle);
			}		
		
		return nbLignes==1;
	}
	
	@Override
	public boolean update(Abonnement objet) throws Exception{
		int nbLignes=0;
		
		
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement("update Abonnement set  date_debut = ?, date_fin = ? where id_abonnement = ?");
			req.setDate(1, java.sql.Date.valueOf(objet.getDatedeb()));
			req.setDate(2, java.sql.Date.valueOf(objet.getDatefin()));
			nbLignes = req.executeUpdate();
		
		return nbLignes==1;
	}
	
	@Override
	public boolean delete(Abonnement objet) throws Exception{
		int nbLignes=0;
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Abonnement where id_abonnement = ?");
			req.setInt(1, objet.getIdabonnement());
			nbLignes = req.executeUpdate();
		
		return nbLignes==1;
	}
	
	@Override
	public ArrayList<Abonnement> findAll() throws Exception{
		ArrayList<Abonnement> liste = new ArrayList<Abonnement>();
		
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select * from Abonnement");
			ResultSet res = req.executeQuery();
			while (res.next()){
				liste.add(new Abonnement(res.getInt("id_abonnement"), res.getDate("date_debut").toLocalDate(), res.getDate("date_fin").toLocalDate(), MySQLClientDAO.getInstance().getById(res.getInt(4)), MySQLRevueDAO.getInstance().getById(res.getInt(5))));
			}
		}catch (SQLException sqle) {
			System.out.println("Pb dans le select " + sqle.getMessage());
		}
		
		return liste;
	}
	
	@Override
	public List<Abonnement> getByDateDeb() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
}
