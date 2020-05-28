
package DAO;

import DTO.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CommandeDAO 
{
    public static Commande findCommandeWithId(int idCommande)
    {
        Commande commande = null;
        
        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT * FROM Commande WHERE Commande.idCommande=?");
            state.setInt(1, idCommande); 

            ResultSet result = state.executeQuery();

            if(result.next())
            {
                commande = new Commande();
                commande.setIdCommande(result.getInt("idCommande"));
                commande.setDateCommande(result.getDate("dateCommande"));
                commande.setIdSession(result.getInt("idSession"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return commande;
    }
    
    
    public static ArrayList<Commande> findAllCommandes()
    {
        ArrayList<Commande> listeCommandes = new ArrayList<Commande>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT idCommande FROM Commande");

            ResultSet result = state.executeQuery();

            while(result.next())
            {
                Commande commande = CommandeDAO.findCommandeWithId(result.getInt("idCommande"));
                listeCommandes.add(commande);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listeCommandes;
    }
    
    
    public static ArrayList<Commande> findCommandesWithSession(int idSession)
    {
        ArrayList<Commande> listeCommandes = new ArrayList<Commande>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT idCommande FROM Commande WHERE idSession=?");
            state.setInt(1, idSession); 
            
            ResultSet result = state.executeQuery();

            while(result.next())
            {
                Commande commande = CommandeDAO.findCommandeWithId(result.getInt("idCommande"));
                listeCommandes.add(commande);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listeCommandes;
    }
    
    public static void insertCommande(Commande commande)
    {
        Connection connex = DatabaseConnecter.getConnexion();
            
        try 
        {
            String query = "INSERT INTO Commande(dateCommande, idSession) VALUES (?,?)";
            PreparedStatement state = connex.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            
            //LocalDate currentDate = null;
            //currentDate = java.sql.Date.valueOf(commande.getDateCommande());
            //state.setDate(1,currentDate);
            state.setInt(2,commande.getIdSession());
            
            state.executeUpdate();
            ResultSet rs = state.getGeneratedKeys();
            
            if(rs.next())
            {
                int idCommandeGenere=rs.getInt(1);
                commande.setIdCommande(idCommandeGenere);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteCommande(int idCommande)
    {			
        Connection connex = DatabaseConnecter.getConnexion();
        
        try 
        {
            String query = "DELETE FROM Commande WHERE Commande.idCommande=? ";
            PreparedStatement state = connex.prepareStatement(query);
            state.setInt(1, idCommande);
            state.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
