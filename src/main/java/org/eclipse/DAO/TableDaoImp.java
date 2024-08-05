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

import org.eclipse.beans.Table;

public class TableDaoImp  implements TableDao{
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
	public void save(Table table) {
		loadDatabase();
	    PreparedStatement ps = null;
        
        	try {
        		ps = connexion.prepareStatement("INSERT INTO tables(tableType, capacite, nbPersonne, tarifId) VALUES(?, ?, ?, ?);");
        		ps.setString(1, table.getTableType());
        		ps.setInt(2, table.getCapacite());
        		ps.setInt(3, table.getNbPersonne());
        		ps.setInt(4, table.getTarifId());
            
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
	public boolean remove(int tableId) {
		loadDatabase();
	    PreparedStatement ps = null;
		try {
    		ps = connexion.prepareStatement("DELETE FROM tables WHERE tableId=? ; ");
    		ps.setInt(1, tableId);
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
	public void update(Table table) {
		loadDatabase();
	    PreparedStatement ps = null;
	    

	    try {
	        ps = connexion.prepareStatement("UPDATE tables SET tableType = ?, capacite = ?, nbPersonne = ?, tarifId = ? WHERE tableId = ?;");
	        ps.setString(1, table.getTableType());
	        ps.setInt(2, table.getCapacite());
	        ps.setInt(3, table.getNbPersonne());
	        ps.setInt(4, table.getTarifId());
	        ps.setInt(5, table.getTableId());
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
	public Table findById(int tableId) {
		Table table = null;
		loadDatabase();
	    PreparedStatement ps = null;
		try {
		String request = "SELECT * FROM tables WHERE tableId = ?;";
		ps = connexion.prepareStatement(request);
		ps.setInt(1, tableId);
		ResultSet r = ps.executeQuery();
		if (r.next())
		table = new Table(r.getInt("tableId"), r.getString("tableType"), r.getInt("capacite"),r.getInt("nbPersonne"),r.getInt("tarifId"));
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
		
		
		return table;
	}

	@Override
	public List<Map<String, Object>> getAll() {
		List<Map<String, Object>> tables = new ArrayList<>();
	    Statement statement = null;
	    ResultSet resultat = null;

	    loadDatabase();

	    try {
	        statement = connexion.createStatement();

	        // Exécution de la requête
	        resultat = statement.executeQuery("SELECT tl.*, t.nvPrix FROM tables tl JOIN tarifs t ON tl.tarifId = t.tarifId;");

	        // Récupération des données
	        while (resultat.next()) {
	            Map<String, Object> table = new HashMap<>();
	            table.put("tableId", resultat.getInt("tableId"));
	            table.put("tableType", resultat.getString("tableType"));
	            table.put("capacite", resultat.getInt("capacite"));
	            table.put("nbPersonne", resultat.getInt("nbPersonne"));
	            table.put("nvPrix", resultat.getDouble("nvPrix"));

	            tables.add(table);
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
        
        return tables;
	}
}
