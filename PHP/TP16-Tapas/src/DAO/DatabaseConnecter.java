
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnecter 
{
    private static final String url = "jdbc:mysql://localhost:3306/bdd_tapas?useSSL=false&serverTimezone=UTC";

    private static final String user = "root";
    private static final String password = "root";

    private static Connection connex = null;

    public static Connection getConnexion()
    {
        try 
        {
            if (connex == null)
            {
                    connex = DriverManager.getConnection(url, user, password);
            }	 
        }
        catch (SQLException e) 
        {
                e.printStackTrace();
        }

        return connex;
    }	
}
