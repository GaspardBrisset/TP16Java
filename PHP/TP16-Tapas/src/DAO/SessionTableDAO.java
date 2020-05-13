
package DAO;

import DTO.SessionTable;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SessionTableDAO 
{
    
    public static SessionTable findSessionWithId(int idSession)
    {
        SessionTable session = null;
        
        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT * FROM SessionTable WHERE SessionTable.idSession=?");
            state.setInt(1, idSession); 

            ResultSet result = state.executeQuery();

            if(result.next())
            {
                session = new SessionTable();
                session.setIdSession(result.getInt("idSession"));
                session.setDateDebut(result.getDate("dateDebut"));
                session.setDateFin(result.getDate("dateFin"));
                session.setNbClients(result.getInt("nbClients"));
                session.setIdTable(result.getInt("idTable"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return session;
    }
    
    public static ArrayList<SessionTable> findAllSessions() 
    {
        ArrayList<SessionTable> listeSessions = new ArrayList<SessionTable>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT idSession FROM SessionTable");

            ResultSet result = state.executeQuery();

            while(result.next())
            {
                SessionTable session = SessionTableDAO.findSessionWithId(result.getInt("idSession"));
                listeSessions.add(session);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listeSessions;		
    }
    
    public static ArrayList<SessionTable> findSessionsWithTable(int idTable)
    {
        ArrayList<SessionTable> listeSessions = new ArrayList<SessionTable>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT idSession FROM SessionTable WHERE idTable=?");
            state.setInt(1, idTable); 
            
            ResultSet result = state.executeQuery();

            while(result.next())
            {
                SessionTable session = SessionTableDAO.findSessionWithId(result.getInt("idSession"));
                listeSessions.add(session);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listeSessions;
    }
}
