package org.eclipse.DAO;

import java.util.List;
import java.util.Map;

import org.eclipse.beans.Terasse;

public interface TerasseDao {
	void save(Terasse terasse);
	boolean remove( int terasseId);
	void update(Terasse terasse);
	Terasse findById(int terasseId);
	List<Map<String, Object>> getAll();
}
