
package DAO;

import DTO.TableResto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableRestoDAO 
{
    public static TableResto findTableWithId(int idTable)
    {
        TableResto table = null;
        
        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT * FROM TableResto WHERE TableResto.idTable=?");
            state.setInt(1, idTable); 

            ResultSet result = state.executeQuery();

            if(result.next())
            {
                table = new TableResto();
                table.setIdTable(result.getInt("idTable"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return table;
    }
    
    public static ArrayList<TableResto> findAllTables() 
    {
        ArrayList<TableResto> listeTables = new ArrayList<TableResto>();

        try
        {
            Connection co = DatabaseConnecter.getConnexion();
            PreparedStatement state = co.prepareStatement("SELECT idTable FROM TableResto");

            ResultSet result = state.executeQuery();

            while(result.next())
            {
                TableResto table = TableRestoDAO.findTableWithId(result.getInt("idTable"));
                listeTables.add(table);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listeTables;		
    }
}
