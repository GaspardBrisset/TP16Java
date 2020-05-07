
package DAO;

import DTO.Tapas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TapasDAO 
{
    public static Tapas findTapasWithId(int idTapas)
    {
        Tapas tapas = null;
        
        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT * FROM Tapas WHERE Tapas.idTapas=?");
            state.setInt(1, idTapas); 

            ResultSet result = state.executeQuery();

            if(result.next())
            {
                tapas = new Tapas();
                tapas.setIdTapas(result.getInt("idTapas"));
                tapas.setNomTapas(result.getString("nomTapas"));

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return tapas;
    }
    
    
    public static ArrayList<Tapas> findAllTapas() 
    {
        ArrayList<Tapas> listeTapas = new ArrayList<Tapas>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT idTapas FROM Tapas");

            ResultSet result = state.executeQuery();

            while(result.next())
            {
                Tapas tapas = TapasDAO.findTapasWithId(result.getInt("idTapas"));
                listeTapas.add(tapas);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listeTapas;		
    }
    
    
    public static ArrayList<Tapas> findAllTapasWithCategorie(int idCategorie)
    {
        ArrayList<Tapas> listeTapas = new ArrayList<Tapas>();
        
        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT Tapas.idTapas FROM Tapas INNER JOIN TapasCategorie ON Tapas.idTapas=TapasCategorie.idTapas WHERE TapasCategorie.idCategorie=?");
            state.setInt(1, idCategorie); 

            ResultSet result = state.executeQuery();

            while(result.next())
            {
                Tapas tapas = TapasDAO.findTapasWithId(result.getInt("idTapas"));
                listeTapas.add(tapas);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listeTapas;
    }
    
    
    public static ArrayList<Tapas> findAllTapasWithCommande(int idCommande)
    {
        ArrayList<Tapas> listeTapas = new ArrayList<Tapas>();
        
        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT Tapas.idTapas FROM Tapas INNER JOIN TapasCommande ON Tapas.idTapas=TapasCommande.idTapas WHERE TapasCommande.idCommande=?");
            state.setInt(1, idCommande); 

            ResultSet result = state.executeQuery();

            while(result.next())
            {
                Tapas tapas = TapasDAO.findTapasWithId(result.getInt("idTapas"));
                listeTapas.add(tapas);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return listeTapas;
    }
    
}
