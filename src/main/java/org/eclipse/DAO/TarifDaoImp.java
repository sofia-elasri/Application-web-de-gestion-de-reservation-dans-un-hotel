package org.eclipse.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.beans.Tarif;

public class TarifDaoImp implements TarifDao {
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
	public Tarif findById(int tarifId) {
		Tarif tarif = null;
		loadDatabase();
	    PreparedStatement ps = null;
		try {
		String request = "SELECT * FROM tarifs WHERE tarifId = ?;";
		ps = connexion.prepareStatement(request);
		ps.setInt(1, tarifId);
		ResultSet r = ps.executeQuery();
		if (r.next())
		tarif = new Tarif(r.getInt("tarifId"),r.getFloat("prix"),r.getFloat("nvPrix"));
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
		
		
		return tarif;
	}
	@Override
	public void update(Tarif tarif) {
		loadDatabase();
	    PreparedStatement ps = null;
	    

	    try {
	        ps = connexion.prepareStatement("UPDATE tarifs SET prix= ? ,  nvPrix = ? WHERE tarifId = ?;");
	        ps.setFloat(1, tarif.getPrix());
	        ps.setFloat(2, tarif.getNvPrix());
	        ps.setInt(3, tarif.getTarifId());
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
	public List<Tarif> getAll() {
		List<Tarif> tarifs = new ArrayList<Tarif>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM tarifs;");

            // Récupération des données
            while (resultat.next()) {
            	int tarifId = resultat.getInt("tarifId");
                float prix = resultat.getFloat("prix");
                float nvPrix = resultat.getFloat("nvPrix");
                
                Tarif tarif = new Tarif();
                tarif.setTarifId(tarifId);
                tarif.setPrix(prix);
                tarif.setNvPrix(nvPrix);
                
                
                
                tarifs.add(tarif);
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
        
        return tarifs;
        
	}
}
