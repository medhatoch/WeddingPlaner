/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import beans.Guest;
import beans.Wedding;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.GuestFacade;
import services.WeddingFacade;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AddGuestController implements Initializable {

    private static Wedding wedding;
    @FXML
    private TextField guestFirstName;
    @FXML
    private TextField guestLastName;
    @FXML
    private TextField guestPhoneNumber;

    @FXML
    private Label errorMsg;

    public Wedding getWedding() {
        return wedding;
    }

    public void setWedding(Wedding wedding) {
        this.wedding = wedding;
    }

    public Guest getParams() {
        if (guestFirstName.getText() == "" || ("" + guestFirstName.getText()).equals("") || guestLastName.getText() == "" || ("" + guestLastName.getText()).equals("")) {
            errorMsg.setText(" One of the fields above is empty ");
            return null;
        } else {
            if (!(guestFacade.isUnique(wedding, guestFirstName.getText(), guestLastName.getText()))) {
                errorMsg.setText(" This guest is already added to the list ");
                return null;
            }
            Guest guest = new Guest(guestFirstName.getText(), guestLastName.getText(), guestPhoneNumber.getText());
            guest.setWeding(wedding);
            return guest;

        }
    }
    WeddingFacade weddingFacade = new WeddingFacade();
    GuestFacade guestFacade = new GuestFacade();

    @FXML
    public void Home(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "WelcomeMenu.fxml", this.getClass());
    }

    @FXML
    public int save(ActionEvent actionEvent) {

        Guest guest = getParams();
        if (guest == null) {
            return -1;
        } else {
            errorMsg.setText("The operation is a success");
//        guestFacade.create(getParams());
            guestFacade.create(guest);

        }
        return 1;
    }

    @FXML
    public void addGift(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent, "giftAdd.fxml", this.getClass());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
