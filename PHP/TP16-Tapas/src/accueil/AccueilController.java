
package accueil;

import tools.Switcher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tools.Session;


public class AccueilController implements Initializable
{
    @FXML
    private Label labelNumTable;
    
    @FXML
    private TextField fieldNbClients;
    
    @FXML
    private void goToChoixPage(ActionEvent event)
    {
        int nbClients = Integer.parseInt(fieldNbClients.getText());
        Session.setNbClients(nbClients);
        
        Switcher.switchPage("choixTapas");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }
}
