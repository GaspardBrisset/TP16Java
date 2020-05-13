package DAO;

import DTO.Categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CategorieDAO 
{
    public static Categorie findCategorieWithId(int idCategorie)
    {
        Categorie categorie = null;
        
        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT * FROM Categorie WHERE Categorie.idCategorie=?");
            state.setInt(1, idCategorie); 

            ResultSet result = state.executeQuery();

            if(result.next())
            {
                categorie = new Categorie();
                categorie.setIdCategorie(result.getInt("idCategorie"));
                categorie.setNomCategorie(result.getString("nomCategorie"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return categorie;
    }
    
    public static ArrayList<Categorie> findAllCategories() 
    {
        ArrayList<Categorie> listeCategories = new ArrayList<Categorie>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT idCategorie FROM Categorie");

            ResultSet result = state.executeQuery();

            while(result.next())
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
    
    
}