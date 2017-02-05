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
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.GuestFacade;
import services.WeddingFacade;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class SignInViewController implements Initializable {

    @FXML
    private ComboBox<String> userType = new ComboBox<>();
    @FXML
    private TextField userFName;
    @FXML
    private TextField userLName;
    @FXML
    private Label message;

////    public Guest existsGuest(String usrFName, String usrLName) {
////
////        if (!(guestFacade.findGuestByFirstnLastNameFindAll(usrFName, usrLName) == null)) {
////            return guestFacade.findGuestByFirstnLastNameFindAll(usrFName, usrLName);
//////        } else if (!(guestFacade.findGuestByNameQuery(usrFName, usrLName) == null)) {
//////            return guestFacade.findGuestByNameQuery(usrFName, usrLName);
////        } else {
////            return null;
////        }
////    }
////
////    public Wedding existsWedding(String usrFName, String usrLName) {
////
////        if (!(weddingFacade.findWeddingByOneWedsName(usrFName, usrLName) == null)) {
////
////            return weddingFacade.findWeddingByOneWedsName(usrFName, usrLName);
//////        } else if (!(weddingFacade.findWeddingByWedsNameQuery(usrLName, usrLName) == null)) {
//////            return weddingFacade.findWeddingByWedsNameQuery(usrLName, usrLName);
////        } else {
////            return null;
////        }
////
////    }
    public void initComboBox() {
        userType.setItems(FXCollections.observableArrayList(Arrays.asList("Guest", "Host")));
        userType.getSelectionModel().select(1);
    }

    public Wedding getParamsWed() {
        if (userFName.getText() == "" || userFName.getText().isEmpty() || userLName.getText() == "" || userLName.getText().isEmpty()) {
            message.setText("One of the fields above is empty");
            return null;
        } else {
            WeddingFacade weddingFacade = new WeddingFacade();
            Wedding wedding = weddingFacade.findWeddingByOneWedsName(userFName.getText(), userLName.getText());
            if (!(wedding == null)) {
                message.setText("");
                return wedding;
            } else {
                message.setText("Please sign up to get invited !");
                return null;
            }
        }
    }

    public Guest getParamsGuest() {
        if (userFName.getText() == "" || userLName.getText() == "") {
            message.setText("One of the fields above is empty");
            return null;
        } else {
            GuestFacade guestFacade = new GuestFacade();
            Guest guest1 = guestFacade.findGuestByFirstnLastNameFindAll(userFName.getText(), userLName.getText());
            if (guest1 != null) {
                message.setText("");
                return guest1;
            } else {

                message.setText("Please sign up to get invited !");
                return null;
            }
        }
    }

        ChooseGiftsController chooseGiftsController = new ChooseGiftsController();
        AddGuestController addGuestController = new AddGuestController();

        @FXML
        public int click
        (ActionEvent actionEvent) throws IOException {
            Wedding wedding = getParamsWed();
            Guest guest = getParamsGuest();
            if (userType.getValue() == "Guest" || userType.getValue().equals("Guest")) {

                if (guest != null) {

                    chooseGiftsController.setGuest(guest);
                    ViewLauncher.forward(actionEvent, "ChooseGift.fxml", this.getClass());
                    addGuestController.setWedding(guest.getWeding());
                    return 1;

                } else {
                    return -1;
                }
            } else if (wedding != null) {
                ViewLauncher.forward(actionEvent, "AddGuest.fxml", this.getClass());
                addGuestController.setWedding(wedding);
                return 1;
            } else {
                return -1;
            }

        }

        @FXML
        public void Home
        (ActionEvent actionEvent) throws IOException {
            ViewLauncher.forward(actionEvent, "WelcomeMenu.fxml", this.getClass());
        }

        @Override
        public void initialize
        (URL url, ResourceBundle rb
        
            ) {
        initComboBox();
        }

    }
