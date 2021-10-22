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
	public Revue getById(int id) throws Exception{
		Revue revue = null;
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select * from Revue where id_revue = (?)");
			req.setInt(1, id);
			ResultSet res = req.executeQuery();
			if(res.next()) {
				revue = new Revue(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5), MySQLPeriodiciteDAO.getInstance().getById(res.getInt(6)));
			}
		
		return revue;
	}
	
	@Override
	public boolean create(Revue objet) throws Exception{
		int nbLignes = 0;
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("insert into Revue (titre, description, tarif_numero, visuel, id_periodicite) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			req.setString(1,objet.getTitre());
			req.setString(2, objet.getDescription());
			req.setFloat(3, objet.getTarifnumero());
			req.setString(4, objet.getVisuel());
			req.setInt(5, objet.getPeriodicite().getIdperiodicite());
			nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
				objet.setIdrevue(cle);
			}
		
		return nbLignes==1;
	}
	
	@Override
	public boolean update(Revue objet) throws Exception{
		int nbLignes = 0;
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("update Revue set titre = ?, description = ?, tarif_numero = ?, visuel = ? where id_revue = ? ");
			req.setString(1,objet.getTitre());	
			req.setString(2,objet.getDescription());
			req.setFloat(3, objet.getTarifnumero()); ;
			req.setString(4, objet.getVisuel());
			nbLignes = req.executeUpdate();
		
		return nbLignes==1;
	}
	
	@Override
	public boolean delete(Revue objet) throws Exception{
		int nbLignes = 0;
		
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Revue where id_revue=?");
			req.setInt(1, objet.getIdrevue());
			nbLignes = req.executeUpdate();

		return nbLignes==1;
	}
	
	@Override
	public ArrayList<Revue> findAll() throws Exception{
		ArrayList<Revue> liste = new ArrayList<Revue>();
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select * from Revue");
			ResultSet res = req.executeQuery();
			while (res.next()){
				liste.add(new Revue(res.getInt("id_revue"), res.getString("titre"), res.getString("description"), res.getInt("tarif_numero"), res.getString("visuel"), MySQLPeriodiciteDAO.getInstance().getById(res.getInt(6))));
			}
		}catch (SQLException sqle) {
			System.out.println("Pb dans select" + sqle.getMessage());
		}
		
		return liste;
	}
	
	@Override
	public List<Revue> getByPeriodicite() throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
