package org.eclipse.DAO;

import java.util.List;
import java.util.Map;

import org.eclipse.beans.Club;

public interface ClubDao {
	void save(Club club);
	boolean remove( int clubId);
	void update(Club club);
	Club findById(int clubId);
	List<Map<String, Object>> getAll();
}
