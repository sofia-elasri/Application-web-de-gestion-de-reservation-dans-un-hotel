package org.eclipse.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.beans.Client;

public class ClientDaoImp implements ClientDao {
private Connection connexion;
	
	private void loadDatabase() {
        // Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "S1999");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	@Override
	public void save(Client client) {
		/*Connection con=MySqlConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO clients(nom,prenom,email,passwd) VALUES (?,?,?,?); ",Statement.RETURN_GENERATED_KEYS);
			
					ps.setString(1, client.getNom());
					ps.setString(2, client.getPrenom());
					ps.setString(3, client.getEmail());
					ps.setString(4, client.getPasswd());
					ps.executeUpdate();
					ResultSet resultat = ps.getGeneratedKeys();
					if (resultat.next()) {
						client.setId(resultat.getInt(1));
					return client;}
					
			
		}catch(SQLException e) {
			e.printStackTrace();

		}
		
		finally {
			try {
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			}
		return null;*/
		
		loadDatabase();
		//connexion = null;
	    PreparedStatement ps = null;
        
        	try {
        		ps = connexion.prepareStatement("INSERT INTO clients(nom, prenom,email,passwd) VALUES(?, ?, ?, ?);");
        		ps.setString(1, client.getNom());
        		ps.setString(2, client.getPrenom());
        		ps.setString(3, client.getEmail());
        		ps.setString(4, client.getPasswd());
            
        		ps.executeUpdate();
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}finally {
    	        try {
    	            if (ps != null) {
    	                ps.close();
    	            }
    	            if (connexion != null) {
    	                connexion.close();
    	            }
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	}

	@Override
	public boolean remove(int id) {
		loadDatabase();
		//connexion = null;
	    PreparedStatement ps = null;
		try {
    		ps = connexion.prepareStatement("DELETE FROM clients WHERE id=? ; ");
    		ps.setInt(1, id);
			int resultat=ps.executeUpdate();
			if (resultat==1) {
				return true;
				}
		}catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	            if (connexion != null) {
	                connexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return false;
			
			
		/*Connection con=MySqlConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM clients WHERE id=? ; ",Statement.RETURN_GENERATED_KEYS);	
					ps.setInt(1, id);
					int resultat=ps.executeUpdate();
					if (resultat==1) {
						return true;
						}
					
			
		}catch(SQLException e) {
			e.printStackTrace();

		}
		
		finally {
			try {
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			}
		return false;*/
	}
	@Override
	public void update(Client client) {
		loadDatabase();
	    //connexion = null;
	    PreparedStatement ps = null;
	    

	    try {
	        ps = connexion.prepareStatement("UPDATE clients SET nom = ?, prenom = ?, email = ?, passwd = ? WHERE id = ?;");
	        ps.setString(1, client.getNom());
	        ps.setString(2, client.getPrenom());
	        ps.setString(3, client.getEmail());
	        ps.setString(4, client.getPasswd());
	        ps.setInt(5, client.getId());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	            if (connexion != null) {
	                connexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	/*public void update(client client) {
		loadDatabase();
		try {
    		PreparedStatement preparedStatement = connexion.prepareStatement("update clients set nom=?, prenom=?, email=?, passwd=? WHERE id=?;");
    		preparedStatement.setString(1, client.getNom());
			preparedStatement.setString(2, client.getPrenom());
			preparedStatement.setString(3, client.getEmail());
			preparedStatement.setString(4, client.getPasswd());
			//preparedStatement.setInt(5, client.getId());
			preparedStatement.executeUpdate();
			//return client;
			
			
		}catch (SQLException e) {
        		e.printStackTrace();
        	}finally {
    			try {
    				
    				connexion.close();
    				} catch (SQLException e) {
    				e.printStackTrace();
    				}
    				}
			
			
			//int resultat=preparedStatement.executeUpdate();
		/*Connection con=MySqlConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update clients set nom = ?,prenom=?, email= ?,passwd= ?, id=? where id = ?;",Statement.RETURN_GENERATED_KEYS);
			
					ps.setString(1, client.getNom());
					ps.setString(2, client.getPrenom());
					ps.setString(3, client.getEmail());
					ps.setString(4, client.getPasswd());
					ps.setInt(5, client.getId());
					ps.executeUpdate();
					return client;
			
		}catch(SQLException e) {
			e.printStackTrace();

		}
		
		finally {
			try {
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			}
		return null;*/


	@Override
	public Client findById(int id) {
		Client client = null;
		loadDatabase();
		//connexion = null;
	    PreparedStatement ps = null;
		try {
		String request = "SELECT * FROM clients WHERE id = ?;";
		ps = connexion.prepareStatement(request);
		ps.setInt(1, id);
		ResultSet r = ps.executeQuery();
		if (r.next())
		client = new Client(r.getInt("id"), r.getString("nom"), r.getString("prenom"),r.getString("email"),r.getString("passwd"));
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	            if (connexion != null) {
	                connexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		
		return client;
	}

	@Override
	public List<Client> getAll() {
		List<Client> clients = new ArrayList<Client>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM clients;");

            // Récupération des données
            while (resultat.next()) {
            	int id = resultat.getInt("id");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String email = resultat.getString("email");
                String passwd = resultat.getString("passwd");
                
                Client client = new Client();
                client.setId(id);
                client.setNom(nom);
                client.setPrenom(prenom);
                client.setEmail(email);
                client.setPasswd(passwd);
                
                
                clients.add(client);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return clients;
		
		/*Connection con=MySqlConnection.getConnection();
		//Connection con=connexion.getConnection();
		List<client> clients=new ArrayList<client>();
		
		try {
			Statement statement=con.createStatement();
			String requete="SELECT * FROM clients;";
			ResultSet res=statement.executeQuery(requete);
			while(res.next()) {
				client p=new client();
				p.setId(res.getInt(1));
				p.setNom(res.getString(2));
				p.setPrenom(res.getString(3));
				p.setEmail(res.getString(4));
				p.setPasswd(res.getString(5));

				clients.add(p);
			}
			return clients;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;*/
	}
}
