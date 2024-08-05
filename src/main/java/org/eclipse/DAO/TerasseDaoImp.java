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

import org.eclipse.beans.Terasse;

public class TerasseDaoImp implements TerasseDao {
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
	public void save(Terasse terasse) {
		loadDatabase();
	    PreparedStatement ps = null;
        
        	try {
        		ps = connexion.prepareStatement("INSERT INTO terasses(terasseType, capacite, nbPersonne, tarifId) VALUES(?, ?, ?, ?);");
        		ps.setString(1, terasse.getTerasseType());
        		ps.setInt(2, terasse.getCapacite());
        		ps.setInt(3, terasse.getNbPersonne());
        		ps.setInt(4, terasse.getTarifId());
            
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
	public boolean remove(int terasseId) {
		loadDatabase();
	    PreparedStatement ps = null;
		try {
    		ps = connexion.prepareStatement("DELETE FROM terasses WHERE terasseId=? ; ");
    		ps.setInt(1, terasseId);
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
	public void update(Terasse terasse) {
		loadDatabase();
	    PreparedStatement ps = null;
	    

	    try {
	        ps = connexion.prepareStatement("UPDATE terasses SET terasseType = ?, capacite = ?, nbPersonne = ?, tarifId = ? WHERE terasseId = ?;");
	        ps.setString(1, terasse.getTerasseType());
	        ps.setInt(2, terasse.getCapacite());
	        ps.setInt(3, terasse.getNbPersonne());
	        ps.setInt(4, terasse.getTarifId());
	        ps.setInt(5, terasse.getTerasseId());
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
	public Terasse findById(int terasseId) {
		Terasse terasse = null;
		loadDatabase();
	    PreparedStatement ps = null;
		try {
		String request = "SELECT * FROM terasses WHERE terasseId = ?;";
		ps = connexion.prepareStatement(request);
		ps.setInt(1, terasseId);
		ResultSet r = ps.executeQuery();
		if (r.next())
		terasse = new Terasse(r.getInt("terasseId"), r.getString("terasseType"), r.getInt("capacite"),r.getInt("nbPersonne"),r.getInt("tarifId"));
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
		
		
		return terasse;
	}

	@Override
	public List<Map<String, Object>> getAll() {
		List<Map<String, Object>> terasses = new ArrayList<>();
	    Statement statement = null;
	    ResultSet resultat = null;

	    loadDatabase();

	    try {
	        statement = connexion.createStatement();

	        // Exécution de la requête
	        resultat = statement.executeQuery("SELECT tr.*, t.nvPrix FROM terasses tr JOIN tarifs t ON tr.tarifId = t.tarifId;");

	        // Récupération des données
	        while (resultat.next()) {
	            Map<String, Object> terasse = new HashMap<>();
	            terasse.put("terasseId", resultat.getInt("terasseId"));
	            terasse.put("terasseType", resultat.getString("terasseType"));
	            terasse.put("capacite", resultat.getInt("capacite"));
	            terasse.put("nbPersonne", resultat.getInt("nbPersonne"));
	            terasse.put("nvPrix", resultat.getDouble("nvPrix"));

	            terasses.add(terasse);
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
        
        return terasses;
	}
}
