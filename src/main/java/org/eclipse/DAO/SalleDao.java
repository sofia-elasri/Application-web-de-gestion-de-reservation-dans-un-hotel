package org.eclipse.DAO;

import java.util.List;
import java.util.Map;

import org.eclipse.beans.Salle;

public interface SalleDao {
	void save(Salle salle);
	boolean remove( int salleId);
	void update(Salle salle);
	Salle findById(int salleId);
	List<Map<String, Object>> getAll();
}
