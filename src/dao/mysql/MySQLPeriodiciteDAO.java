package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PeriodiciteDAO;
import modele.Periodicite;

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
	public Periodicite getById(int id) throws Exception{
		Periodicite perio = null;
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select * from Periodicite where id_periodicite = ?");
			req.setInt(1, id);
			ResultSet res = req.executeQuery();
			if(res.next()) {
				perio = new Periodicite(res.getInt(1),res.getString(2));
			}
		
		return perio;
	}
	
	public boolean create(Periodicite objet) throws Exception{
		int nbLignes = 0;
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,objet.getLibelle());
			nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
				objet.setIdperiodicite(cle);
			}
		
		return nbLignes==1;
	}
	
	public boolean update(Periodicite objet) throws Exception{
		int nbLignes = 0;
		
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement req = laConnexion.prepareStatement("update Periodicite set libelle = ? where id_periodicite = ?");
			req.setString(1, objet.getLibelle());
			nbLignes = req.executeUpdate();
		
		return nbLignes==1;
	}
	
	public boolean delete(Periodicite objet) throws Exception{
		int nbLignes = 0;
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");
			req.setInt(1, objet.getIdperiodicite());
			nbLignes = req.executeUpdate();
		
		return nbLignes==1;
	}
	
	@Override
	public ArrayList<Periodicite> findAll() throws Exception{
		ArrayList<Periodicite> liste = new ArrayList<Periodicite>();
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select * from Periodicite");
			ResultSet res = req.executeQuery();
			while (res.next()){
				liste.add(new Periodicite(res.getInt("id_periodicite"),res.getString("libelle")));
			}
		
		return liste;
	}
	
	@Override
	public List<Periodicite> getByLibelle() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
