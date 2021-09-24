package dao;

import java.util.List;

import modele.Abonnement;

public interface AbonnementDAO extends DAO<Abonnement>{
	
	public  List<Abonnement> getByDateDeb();
}
