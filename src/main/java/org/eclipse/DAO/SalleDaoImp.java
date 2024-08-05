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

import org.eclipse.beans.Salle;

public class SalleDaoImp implements SalleDao {
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
	public void save(Salle salle) {
		loadDatabase();
	    PreparedStatement ps = null;
        
        	try {
        		ps = connexion.prepareStatement("INSERT INTO salles(salleType, capacite, nbPersonne, tarifId) VALUES(?, ?, ?, ?);");
        		ps.setString(1, salle.getSalleType());
        		ps.setInt(2, salle.getCapacite());
        		ps.setInt(3, salle.getNbPersonne());
        		ps.setInt(4, salle.getTarifId());
            
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
	public boolean remove(int salleId) {
		loadDatabase();
	    PreparedStatement ps = null;
		try {
    		ps = connexion.prepareStatement("DELETE FROM salles WHERE salleId=? ; ");
    		ps.setInt(1, salleId);
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
	public void update(Salle salle) {
		loadDatabase();
	    PreparedStatement ps = null;
	    

	    try {
	        ps = connexion.prepareStatement("UPDATE salles SET salleType = ?, capacite = ?, nbPersonne = ?, tarifId = ? WHERE salleId = ?;");
	        ps.setString(1, salle.getSalleType());
	        ps.setInt(2, salle.getCapacite());
	        ps.setInt(3, salle.getNbPersonne());
	        ps.setInt(4, salle.getTarifId());
	        ps.setInt(5, salle.getSalleId());
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
	public Salle findById(int salleId) {
		Salle salle = null;
		loadDatabase();
	    PreparedStatement ps = null;
		try {
		String request = "SELECT * FROM salles WHERE salleId = ?;";
		ps = connexion.prepareStatement(request);
		ps.setInt(1, salleId);
		ResultSet r = ps.executeQuery();
		if (r.next())
		salle = new Salle(r.getInt("salleId"), r.getString("salleType"), r.getInt("capacite"),r.getInt("nbPersonne"),r.getInt("tarifId"));
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
		
		
		return salle;
	}

	@Override
	public List<Map<String, Object>> getAll() {
		List<Map<String, Object>> salles = new ArrayList<>();
	    Statement statement = null;
	    ResultSet resultat = null;

	    loadDatabase();

	    try {
	        statement = connexion.createStatement();

	        // Exécution de la requête
	        resultat = statement.executeQuery("SELECT s.*, t.nvPrix FROM salles s JOIN tarifs t ON s.tarifId = t.tarifId;");

	        // Récupération des données
	        while (resultat.next()) {
	            Map<String, Object> salle = new HashMap<>();
	            salle.put("salleId", resultat.getInt("salleId"));
	            salle.put("salleType", resultat.getString("salleType"));
	            salle.put("capacite", resultat.getInt("capacite"));
	            salle.put("nbPersonne", resultat.getInt("nbPersonne"));
	            salle.put("nvPrix", resultat.getDouble("nvPrix"));

	            salles.add(salle);
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
        
        return salles;
	}
}
