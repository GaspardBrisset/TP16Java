
package tools;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Switcher 
{
    private static Stage stage;

    public static void setStage(Stage stage) 
    {
        Switcher.stage = stage;
    }
    
    public static void switchPage(String nomPage)
    {
        if("FXMLDocument.fxml".equals(nomPage))
        {
            nomPage = "/application/FXMLDocument.fxml";
        }
        else
        {
            nomPage = "/" + nomPage + "/" + nomPage + ".fxml";
        }

        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Switcher.class.getResource(nomPage));
            Parent root = (Parent) fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Switcher.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
