/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class WelcomeMenu implements Initializable {
@FXML
private Button signIn ;
@FXML
private Button signUp ;
@FXML
private Button Exit ;
@FXML
private Button aboutUs ;
@FXML
public void signUp(ActionEvent actionEvent) throws IOException {
                    ViewLauncher.forward(actionEvent, "AddWedding.fxml", this.getClass());
}
@FXML
public void signIn(ActionEvent actionEvent) throws IOException{
                    ViewLauncher.forward(actionEvent, "SignIn.fxml", this.getClass());


}


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
