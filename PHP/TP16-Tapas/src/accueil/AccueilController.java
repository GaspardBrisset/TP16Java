
package accueil;

import tools.Switcher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class AccueilController implements Initializable
{
    @FXML
    private void goToChoixPage(ActionEvent event)
    {
        Switcher.switchPage("choix");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }
}
