package org.eclipse.DAO;

import java.util.List;
import java.util.Map;

import org.eclipse.beans.Reservation;

public interface ReservationDao {
	void save(Reservation res);
	boolean remove( int id);
	void update(Reservation res);
	Reservation findById(int id);
	List<Map<String,Object>> getAll();
}
