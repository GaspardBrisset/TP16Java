
package DAO;

import DTO.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
}
