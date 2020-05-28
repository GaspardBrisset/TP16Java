
package DAO;

import DTO.Tapas;
import DTO.TapasCommande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TapasCommandeDAO  
{
    public static ArrayList<Tapas> findTapasWithCommande(int idCommande)
    {
        ArrayList<Tapas> listeTapas = new ArrayList<Tapas>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT * FROM TapasCommande WHERE TapasCommande.idCommande=?");
            state.setInt(1, idCommande); 

            ResultSet result = state.executeQuery();

            if(result.next())
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
    
    public static void insertTapasCommande(TapasCommande tapasCommande)
    {
        Connection connex = DatabaseConnecter.getConnexion();
            
        try 
        {
            String query = "INSERT INTO TapasCommande(idTapas, idCommande, quantite) VALUES (?, ?, ?)";
            PreparedStatement state = connex.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            
            state.setInt(1,tapasCommande.getIdTapas());
            state.setInt(2,tapasCommande.getIdCommande());
            state.setInt(3,tapasCommande.getQuantite());
            
            state.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(TapasCommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteTapasCommande(int idTapas, int idCommande)
    {
        Connection connex = DatabaseConnecter.getConnexion();
            
        try 
        {
            String query = "DELETE FROM TapasCommande WHERE TapasCommande.idCommande=? AND TapasCommande.idTapas=?";
            PreparedStatement state = connex.prepareStatement(query);
            state.setInt(1, idCommande);
            state.setInt(2, idTapas);
            state.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(TapasCommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}