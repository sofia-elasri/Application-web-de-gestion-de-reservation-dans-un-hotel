package org.eclipse.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.beans.Chambre;

public class ChambreDaoImp implements ChambreDao {
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
	public void save(Chambre chambre) {
		loadDatabase();
	    PreparedStatement ps = null;
        
        	try {
        		ps = connexion.prepareStatement("INSERT INTO chambres(chambreType, capacite, nbPersonne, tarifId) VALUES(?, ?, ?, ?);");
        		ps.setString(1, chambre.getChambreType());
        		ps.setInt(2, chambre.getCapacite());
        		ps.setInt(3, chambre.getNbPersonne());
        		ps.setInt(4, chambre.getTarifId());
            
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
	public boolean remove(int chambreId) {
		loadDatabase();
	    PreparedStatement ps = null;
		try {
    		ps = connexion.prepareStatement("DELETE FROM chambres WHERE chambreId=? ; ");
    		ps.setInt(1, chambreId);
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
	}

	@Override
	public void update(Chambre chambre) {
		loadDatabase();
	    PreparedStatement ps = null;
	    

	    try {
	        ps = connexion.prepareStatement("UPDATE chambres SET chambreType = ?, capacite = ?, nbPersonne = ?, tarifId = ? WHERE chambreId = ?;");
	        ps.setString(1, chambre.getChambreType());
	        ps.setInt(2, chambre.getCapacite());
	        ps.setInt(3, chambre.getNbPersonne());
	        ps.setInt(4, chambre.getTarifId());
	        ps.setInt(5, chambre.getChambreId());
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

	@Override
	public Chambre findById(int chambreId) {
		Chambre chambre = null;
		loadDatabase();
	    PreparedStatement ps = null;
		try {
		String request = "SELECT * FROM chambres WHERE chambreId = ?;";
		ps = connexion.prepareStatement(request);
		ps.setInt(1, chambreId);
		ResultSet r = ps.executeQuery();
		if (r.next())
		chambre = new Chambre(r.getInt("chambreId"), r.getString("chambreType"), r.getInt("capacite"),r.getInt("nbPersonne"),r.getInt("tarifId"));
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
		
		
		return chambre;
	}

	@Override
	/*public List<Chambre> getAll() {
		List<Chambre> chambres = new ArrayList<Chambre>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT chambres.*, tarifs.nvPrix FROM chambres JOIN tarifs ON chambres.tarifId = tarifs.tarifId;");

            // Récupération des données
            while (resultat.next()) {
            	int chambreId = resultat.getInt("chambreId");
                String chambreType = resultat.getString("chambreType");
                int capacite = resultat.getInt("capacite");
                int nbPersonne = resultat.getInt("nbPersonne");
                int tarifId = resultat.getInt("tarifId");
                double nvPrix = resultat.getDouble("nvPrix");

                
                Chambre chambre = new Chambre();
                chambre.setChambreId(chambreId);
                chambre.setChambreType(chambreType);
                chambre.setCapacite(capacite);
                chambre.setNbPersonne(nbPersonne);
                chambre.setTarifId(tarifId);
                chambre.setNvPrix(nvPrix);
                
                
                chambres.add(chambre);
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
        
        return chambres;
	}*/
	public List<Map<String,Object>> getAll() {
	    List<Map<String, Object>> chambres = new ArrayList<>();
	    Statement statement = null;
	    ResultSet resultat = null;

	    loadDatabase();

	    try {
	        statement = connexion.createStatement();

	        // Exécution de la requête
	        resultat = statement.executeQuery("SELECT c.*, t.nvPrix FROM chambres c JOIN tarifs t ON c.tarifId = t.tarifId;");

	        // Récupération des données
	        while (resultat.next()) {
	            Map<String, Object> chambre = new HashMap<>();
	            chambre.put("chambreId", resultat.getInt("chambreId"));
	            chambre.put("chambreType", resultat.getString("chambreType"));
	            chambre.put("capacite", resultat.getInt("capacite"));
	            chambre.put("nbPersonne", resultat.getInt("nbPersonne"));
	            chambre.put("nvPrix", resultat.getDouble("nvPrix"));

	            chambres.add(chambre);
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

	    return chambres;
	}

}
