package org.eclipse.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnexion {
	private static Connection connexion ;
	static {
	try {
	String url = "jdbc:mysql://127.0.0.1:3306/projet";
	String utilisateur = "root";
	String motDePasse = "S1999";
	Class.forName("com.mysql.cj.jdbc.Driver");
	connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	//private MySqlConnection() { }
	public static Connection getConnection() {
	return connexion;
	}
}
