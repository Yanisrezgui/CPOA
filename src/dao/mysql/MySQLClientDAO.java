package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		Client client=null;
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select from Client where id_client = ?");
			req.setInt(1, id);
			ResultSet res = req.executeQuery();
			if(res.next()) {
				client = new Client(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8));
			}
		}catch (SQLException sqle) {
			System.out.println("Pb dans select" + sqle.getMessage());
		}
		
		return client;
	}

	@Override
	public boolean create(Client objet) {
		int nbLignes = 0;
		
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
			nbLignes = req.executeUpdate();
			ResultSet res = req.getGeneratedKeys();
			if (res.next()) {
				int cle = res.getInt(1);
				objet.setIdclient(cle);
			}		
		} catch (SQLException sqle) {
			System.out.println("Pb dans insert " + sqle.getMessage());
		}
		return nbLignes==1;
	}

	@Override
	public boolean update(Client objet) {
		int nbLignes = 0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion();
			//TODO changer la requetes update correctement
			PreparedStatement req = laConnexion.prepareStatement(
					"update Client set nom=?, prenom=?, no_rue=?, voie=?, code_postal=?, ville=?, pays=?)",
					Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getNom());
			req.setString(2, objet.getPrenom());
			req.setInt(3, objet.getNovoie());
			req.setString(4, objet.getVoie());
			req.setString(5, objet.getCodepostal());
			req.setString(6, objet.getVille());
			req.setString(7, objet.getPays());
			nbLignes = req.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Pb dans update " + sqle.getMessage());
		}
		return nbLignes==1;
	}

	@Override
	public boolean delete(Client objet) {
		int nbLignes = 0;
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("delete from Client where id_client=?");
			req.setInt(1, objet.getIdclient());
			nbLignes = req.executeUpdate();
		}catch (SQLException sqle) {
			System.out.println("Pb dans dele " + sqle.getMessage());
		}
		return nbLignes==1;
	}


	@Override
	public ArrayList<Client> findAll() {
		ArrayList<Client> liste = new ArrayList<Client>();
		
		
		
		try {
			Connection laConnexion = Connexion.creeConnexion(); 
			PreparedStatement req = laConnexion.prepareStatement("select (*) from Client");
			ResultSet res = req.executeQuery();
			while (res.next()){
				liste.add(new Client(res.getInt("idclient"),res.getString("nom"),res.getString("prenom"),res.getInt("novoie"),res.getString("voie"),res.getString("codepostale"),res.getString("ville"),res.getString("pays")));
			}
		}catch (SQLException sqle) {
			System.out.println("Pb dans select" + sqle.getMessage());		}
		
		return liste ;
	}

	@Override
	public List<Client> getByVille() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
