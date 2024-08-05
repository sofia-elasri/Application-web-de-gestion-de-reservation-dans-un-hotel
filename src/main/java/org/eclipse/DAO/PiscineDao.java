package org.eclipse.DAO;

import java.util.List;
import java.util.Map;

import org.eclipse.beans.Piscine;

public interface PiscineDao {
	void save(Piscine piscine);
	boolean remove( int piscineId);
	void update(Piscine piscine);
	Piscine findById(int piscineId);
	List<Map<String, Object>> getAll();
}
