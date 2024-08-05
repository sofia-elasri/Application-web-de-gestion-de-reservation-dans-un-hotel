package org.eclipse.DAO;

import org.eclipse.beans.Facture;

public interface FactureDao {
	void save(Facture facture);
	boolean remove( int factureId);
	void update(Facture facture);
	Facture findById(int factureId);
}
