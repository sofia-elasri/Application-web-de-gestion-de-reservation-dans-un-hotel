package org.eclipse.DAO;

import java.util.List;

import org.eclipse.beans.Tarif;

public interface TarifDao {
	void update(Tarif tarif);

	Tarif findById(int tarifId);

	List<Tarif> getAll();
}
