package org.eclipse.DAO;

import java.util.List;
import java.util.Map;

import org.eclipse.beans.Chambre;

public interface ChambreDao {
	void save(Chambre chambre);
	boolean remove( int chambreId);
	void update(Chambre chambre);
	Chambre findById(int chambreId);
	List<Map<String, Object>> getAll();
}
