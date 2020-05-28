
package DAO;

import DTO.Categorie;
import DTO.Tapas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TapasCategorieDAO  
{
    public static ArrayList<Categorie> findCategoriesWithTapas(int idTapas)
    {
        ArrayList<Categorie> listeCategories = new ArrayList<Categorie>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT * FROM TapasCategorie WHERE TapasCategorie.idTapas=?");
            state.setInt(1, idTapas); 

            ResultSet result = state.executeQuery();

            if(result.next())
            {
                Categorie categorie = CategorieDAO.findCategorieWithId(result.getInt("idCategorie"));
                
                listeCategories.add(categorie);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listeCategories;
    }

    public static ArrayList<Tapas> findTapasWithCategorie(int idCategorie)
    {
        ArrayList<Tapas> listeTapas = new ArrayList<Tapas>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT * FROM TapasCategorie WHERE TapasCategorie.idCategorie=?");
            state.setInt(1, idCategorie); 

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
    
    
}

