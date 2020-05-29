
package choixTapas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import tools.Session;


public class ChoixTapasController implements Initializable
{
    @FXML
    private Label labelNbClients;
    
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        labelNbClients.setText(Integer.toString(Session.getNbClients()));
    }
}
