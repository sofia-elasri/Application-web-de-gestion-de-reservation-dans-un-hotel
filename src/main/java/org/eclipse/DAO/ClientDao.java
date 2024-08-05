package org.eclipse.DAO;

import java.util.List;

import org.eclipse.beans.Client;

public interface ClientDao {
	void save(Client client);
	boolean remove( int id);
	void update(Client client);
	Client findById(int id);
	List<Client> getAll();
}
