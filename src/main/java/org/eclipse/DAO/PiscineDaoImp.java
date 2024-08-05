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

import org.eclipse.beans.Piscine;

public class PiscineDaoImp implements PiscineDao {
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
	public void save(Piscine piscine) {
		loadDatabase();
	    PreparedStatement ps = null;
        
        	try {
        		ps = connexion.prepareStatement("INSERT INTO piscines(piscineType, capacite, nbPersonne, tarifId) VALUES(?, ?, ?, ?);");
        		ps.setString(1, piscine.getPiscineType());
        		ps.setInt(2, piscine.getCapacite());
        		ps.setInt(3, piscine.getNbPersonne());
        		ps.setInt(4, piscine.getTarifId());
            
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
	public boolean remove(int piscineId) {
		loadDatabase();
	    PreparedStatement ps = null;
		try {
    		ps = connexion.prepareStatement("DELETE FROM piscines WHERE piscineId=? ; ");
    		ps.setInt(1, piscineId);
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
	public void update(Piscine piscine) {
		loadDatabase();
	    PreparedStatement ps = null;
	    

	    try {
	        ps = connexion.prepareStatement("UPDATE piscines SET piscineType = ?, capacite = ?, nbPersonne = ?, tarifId = ? WHERE piscineId = ?;");
	        ps.setString(1, piscine.getPiscineType());
	        ps.setInt(2, piscine.getCapacite());
	        ps.setInt(3, piscine.getNbPersonne());
	        ps.setInt(4, piscine.getTarifId());
	        ps.setInt(5, piscine.getPiscineId());
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
	public Piscine findById(int piscineId) {
		Piscine piscine = null;
		loadDatabase();
	    PreparedStatement ps = null;
		try {
		String request = "SELECT * FROM piscines WHERE piscineId = ?;";
		ps = connexion.prepareStatement(request);
		ps.setInt(1, piscineId);
		ResultSet r = ps.executeQuery();
		if (r.next())
		piscine = new Piscine(r.getInt("piscineId"), r.getString("piscineType"), r.getInt("capacite"),r.getInt("nbPersonne"),r.getInt("tarifId"));
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
		
		
		return piscine;
	}

	@Override
	public List<Map<String, Object>> getAll() {
		List<Map<String, Object>> piscines = new ArrayList<>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT p.*, t.nvPrix FROM piscines p JOIN tarifs t ON p.tarifId = t.tarifId;");

            // Récupération des données
            while (resultat.next()) {
            	Map<String, Object> piscine = new HashMap<>();
            	piscine.put("piscineId", resultat.getInt("piscineId"));
            	piscine.put("piscineType", resultat.getString("piscineType"));
            	piscine.put("capacite", resultat.getInt("capacite"));
            	piscine.put("nbPersonne", resultat.getInt("nbPersonne"));
            	piscine.put("nvPrix", resultat.getDouble("nvPrix"));
                
                
            	piscines.add(piscine);
            }
        } catch (SQLException e) {
        } finally {
            //Fermeture de la connexion
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
        
        return piscines;
	}
}
