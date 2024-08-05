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

import org.eclipse.beans.Club;

public class ClubDaoImp implements ClubDao {
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
	public void save(Club club) {
		loadDatabase();
	    PreparedStatement ps = null;
        
        	try {
        		ps = connexion.prepareStatement("INSERT INTO clubs(clubType, capacite, nbPersonne, tarifId) VALUES(?, ?, ?, ?);");
        		ps.setString(1, club.getClubType());
        		ps.setInt(2, club.getCapacite());
        		ps.setInt(3, club.getNbPersonne());
        		ps.setInt(4, club.getTarifId());
            
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
	public boolean remove(int clubId) {
		loadDatabase();
	    PreparedStatement ps = null;
		try {
    		ps = connexion.prepareStatement("DELETE FROM clubs WHERE clubId=? ; ");
    		ps.setInt(1, clubId);
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
	public void update(Club club) {
		loadDatabase();
	    PreparedStatement ps = null;
	    

	    try {
	        ps = connexion.prepareStatement("UPDATE clubs SET clubType = ?, capacite = ?, nbPersonne = ?, tarifId = ? WHERE clubId = ?;");
	        ps.setString(1, club.getClubType());
	        ps.setInt(2, club.getCapacite());
	        ps.setInt(3, club.getNbPersonne());
	        ps.setInt(4, club.getTarifId());
	        ps.setInt(5, club.getClubId());
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
	public Club findById(int clubId) {
		Club club = null;
		loadDatabase();
	    PreparedStatement ps = null;
		try {
		String request = "SELECT * FROM clubs WHERE clubId = ?;";
		ps = connexion.prepareStatement(request);
		ps.setInt(1, clubId);
		ResultSet r = ps.executeQuery();
		if (r.next())
		club = new Club(r.getInt("clubId"), r.getString("clubType"), r.getInt("capacite"),r.getInt("nbPersonne"),r.getInt("tarifId"));
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
		
		
		return club;
	}

	@Override
	public List<Map<String, Object>> getAll() {
		List<Map<String, Object>> clubs = new ArrayList<>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT c.*, t.nvPrix FROM clubs c JOIN tarifs t ON c.tarifId = t.tarifId;");

            // Récupération des données
            while (resultat.next()) {
            	Map<String, Object> club = new HashMap<>();
	            club.put("clubId", resultat.getInt("clubId"));
	            club.put("clubType", resultat.getString("clubType"));
	            club.put("capacite", resultat.getInt("capacite"));
	            club.put("nbPersonne", resultat.getInt("nbPersonne"));
	            club.put("nvPrix", resultat.getDouble("nvPrix"));
                
                
                clubs.add(club);
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
        
        return clubs;
	}
}
