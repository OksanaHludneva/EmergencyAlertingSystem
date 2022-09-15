package com.example.eas_finalproject.controllers;

import com.example.eas_finalproject.services.MessagingService;
import com.example.eas_finalproject.services.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MessagingController implements Initializable {
    @FXML
    private TextArea messageTextField;
    @FXML
    CheckBox checkBoxRiga = new CheckBox();
    @FXML
    ComboBox comboBox = new ComboBox();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*comboBox.setOnAction((ActionEvent) -> {

            System.out.println(comboBox.getSelectionModel().getSelectedIndex());
            System.out.println(comboBox.getSelectionModel().getSelectedItem());
        });*/
    }
    @FXML
    public String sendMessageClick(ActionEvent actionEvent) throws Exception {

        try {
            String selectedComboBoxAlert = Integer.toString(comboBox.getSelectionModel().getSelectedIndex()+1);



            String selectedCheckBoxRegion = checkBoxRiga.getText();

            String message = messageTextField.getText();

            MessagingService messagingService = new MessagingService();
            boolean isSelected = checkBoxRiga.isSelected();

            if(isSelected == true){
                messagingService.messagingRequest(selectedCheckBoxRegion, selectedComboBoxAlert, message);
            }

        }catch (Exception e) {
            return "Error in sending message";
        }

        return null;
    }


    public void logoutClick(ActionEvent actionEvent) {
        SceneService.changeScene(actionEvent, "login");
    }
}