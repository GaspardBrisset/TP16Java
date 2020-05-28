
package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Switcher 
{
    private static Stage stage;

    public static void setApplication(Stage stage) 
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

        /*FXMLLoader fxmlLoader = new FXMLLoader(Switcher.class.getResource(nomPage));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);*/

    }
}
