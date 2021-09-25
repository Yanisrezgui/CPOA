package dao;

import java.util.ArrayList;

public interface DAO<T> {
	
	public abstract T getById(int id); 
	public abstract boolean create(T objet); 
	public abstract boolean update(T objet); 
	public abstract boolean delete(T objet);
	public abstract ArrayList findAll(); 
	
}
