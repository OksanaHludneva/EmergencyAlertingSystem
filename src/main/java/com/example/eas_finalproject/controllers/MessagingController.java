package com.example.eas_finalproject.controllers;

import com.example.eas_finalproject.services.MessagingService;
import com.example.eas_finalproject.services.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MessagingController {
    @FXML
    private TextArea messageTextField;
    CheckBox checkBoxRiga = new CheckBox("Riga");

    public void sendMessageClick(ActionEvent actionEvent) {
        String message = messageTextField.getText();
        MessagingService messagingService = new MessagingService();
        boolean isSelected = checkBoxRiga.isSelected();
        if(isSelected == true){
            messagingService.messagingRequest("Riga", "Weather alert", message);
        }
    }

    public void logoutClick(ActionEvent actionEvent) {
        SceneService.changeScene(actionEvent, "login");
    }
}
