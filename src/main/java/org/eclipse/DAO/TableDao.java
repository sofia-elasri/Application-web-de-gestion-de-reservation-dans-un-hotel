package org.eclipse.DAO;

import java.util.List;
import java.util.Map;

import org.eclipse.beans.Table;

public interface TableDao {
	void save(Table table);
	boolean remove( int tableId);
	void update(Table table);
	Table findById(int tableId);
	List<Map<String, Object>> getAll();
}
