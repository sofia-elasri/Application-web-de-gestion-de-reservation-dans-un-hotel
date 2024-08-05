package org.eclipse.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.eclipse.beans.User;
 
public class LoginDao {
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

 
public String authenticateUser(User user)
{
    String login = user.getLogin();
    String passwd = user.getPasswd();
 
    connexion = null;
    ResultSet resultSet = null;
 
    String userNameDB = "";
    String passwordDB = "";
    String roleDB = "";
    
    loadDatabase();
    PreparedStatement ps = null;
 
    try
    {
    	String request = "select login,passwd,rolee from users";
		ps = connexion.prepareStatement(request);
		resultSet = ps.executeQuery();
        while(resultSet.next())
        {
            userNameDB = resultSet.getString("login");
            passwordDB = resultSet.getString("passwd");
            roleDB = resultSet.getString("rolee");
 
            if(login.equals(userNameDB) && passwd.equals(passwordDB) && roleDB.equals("manager"))
            return "manager_Role";
            else if(login.equals(userNameDB) && passwd.equals(passwordDB) && roleDB.equals("receptionist"))
            return "receptionist_Role";
            else if(login.equals(userNameDB) && passwd.equals(passwordDB) && roleDB.equals("maitre des operations"))
            return "operation_Role";
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
}
}