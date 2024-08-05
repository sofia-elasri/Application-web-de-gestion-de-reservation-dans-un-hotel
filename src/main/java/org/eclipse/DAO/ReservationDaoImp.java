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

import org.eclipse.beans.Reservation;

public class ReservationDaoImp implements ReservationDao {
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
	public void save(Reservation res) {
		loadDatabase();
	    PreparedStatement ps = null;
        
        	try {
        		ps = connexion.prepareStatement("INSERT INTO reservations(bookId, chambreId, salleId, tableId, terasseId, piscineId, clubId ) VALUES(?, ?, ?, ?, ?, ?, ?);");
        		ps.setInt(1, res.getBookId());
        		ps.setInt(2, res.getChambreId());
        		ps.setInt(3, res.getSalleId());
        		ps.setInt(4, res.getTableId());
        		ps.setInt(5, res.getTerasseId());
        		ps.setInt(6, res.getPiscineId());
        		ps.setInt(7, res.getClubId());
            
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
	public boolean remove(int resId) {
		loadDatabase();
	    PreparedStatement ps = null;
		try {
    		ps = connexion.prepareStatement("DELETE FROM reservations WHERE resId=? ; ");
    		ps.setInt(1, resId);
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
	public void update(Reservation res) {
		loadDatabase();
	    PreparedStatement ps = null;
	    

	    try {
	        ps = connexion.prepareStatement("UPDATE reservations SET bookId = ?, chambreId = ?, salleId = ?, tableId = ? , terasseId = ?, piscineId = ? , clubId = ? WHERE resId = ?;");
	        ps.setInt(1, res.getBookId());
	        ps.setInt(2, res.getChambreId());
	        ps.setInt(3, res.getSalleId());
	        ps.setInt(4, res.getTableId());
	        ps.setInt(5, res.getTerasseId());
	        ps.setInt(6, res.getPiscineId());
	        ps.setInt(7, res.getClubId());
	        ps.setInt(8, res.getResId());
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
	public Reservation findById(int resId) {
		Reservation res = null;
		loadDatabase();
	    PreparedStatement ps = null;
		try {
		String request = "SELECT * FROM reservations WHERE resId = ?;";
		ps = connexion.prepareStatement(request);
		ps.setInt(1, resId);
		ResultSet r = ps.executeQuery();
		if (r.next())
		res = new Reservation(r.getInt("resId"), r.getInt("bookId"), r.getInt("chambreId"),r.getInt("salleId"),r.getInt("tableId"),r.getInt("terasseId"),r.getInt("piscineId"),r.getInt("clubId"));
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
		return res;
	}

	@Override
	public List<Map<String,Object>> getAll() {
		List<Map<String,Object>> reservations = new ArrayList<>();
	    Statement statement = null;
	    ResultSet resultat = null;

	    loadDatabase();

	    try {
	        statement = connexion.createStatement();
	        
	        // Exécution de la requête
	        resultat = statement.executeQuery("SELECT res.*, ch.chambreType ,  sl.salleType ,  tab.tableType ,  ter.terasseType , pis.piscineType ,  cl.clubType    FROM reservations res JOIN chambres ch ON res.chambreId = ch.chambreId JOIN salles sl ON res.salleId = sl.salleId JOIN tables tab ON res.tableId = tab.tableId JOIN terasses ter ON res.terasseId = ter.terasseId JOIN piscines pis ON res.piscineId = pis.piscineId JOIN clubs cl ON res.clubId = cl.clubId;");

	        // Récupération des données
	        while (resultat.next()) {
	            Map<String, Object> res = new HashMap<>();
	            res.put("resId", resultat.getInt("chambreId"));
	            res.put("bookId", resultat.getInt("bookId"));
	            res.put("chambreId", resultat.getInt("chambreId"));
	            res.put("salleId", resultat.getInt("salleId"));
	            res.put("tableId", resultat.getInt("tableId"));
	            res.put("terasseId", resultat.getInt("terasseId"));
	            res.put("piscineId", resultat.getInt("piscineId"));
	            res.put("clubId", resultat.getInt("clubId"));
	            res.put("chambreType", resultat.getString("chambreType"));
	            res.put("salleType", resultat.getString("salleType"));
	            
	            res.put("tableType", resultat.getString("tableType"));
	            
	            res.put("terasseType", resultat.getString("terasseType"));
	            
	            res.put("piscineType", resultat.getString("piscineType"));
	            
	            res.put("clubType", resultat.getString("clubType"));
	            
	            reservations.add(res);
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

	    return reservations;
	}
}
