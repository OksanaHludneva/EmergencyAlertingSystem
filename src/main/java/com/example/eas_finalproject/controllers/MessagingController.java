package com.example.eas_finalproject.controllers;

import com.example.eas_finalproject.services.MessagingService;
import com.example.eas_finalproject.services.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MessagingController  {
    @FXML
    private TextArea messageTextField;
    @FXML
    CheckBox checkBoxRiga = new CheckBox();
    @FXML
    CheckBox checkBoxVidzeme = new CheckBox();
    @FXML
    CheckBox checkBoxKurzeme = new CheckBox();
    @FXML
    CheckBox checkBoxZemgale = new CheckBox();
    @FXML
    CheckBox checkBoxLatgale = new CheckBox();
    @FXML
    ComboBox<String>comboBox = new ComboBox();

    @FXML
    public String sendMessageClick(ActionEvent actionEvent) throws Exception {

        try {
            MessagingService messagingService = new MessagingService();

            String selectedComboBoxAlert = comboBox.getValue();

            String message = messageTextField.getText();

            String selectedCheckBoxRegionRiga = checkBoxRiga.getText();
            boolean isSelectedRiga = checkBoxRiga.isSelected();
                if(isSelectedRiga == true){
                    messagingService.messagingRequest(selectedCheckBoxRegionRiga, selectedComboBoxAlert, message);}

            String selectedCheckBoxRegionVidzeme = checkBoxVidzeme.getText();
            boolean isSelectedVidzeme = checkBoxVidzeme.isSelected();
                if(isSelectedVidzeme == true){messagingService.messagingRequest(selectedCheckBoxRegionVidzeme, selectedComboBoxAlert, message);}

            String selectedCheckBoxRegionKurzeme = checkBoxKurzeme.getText();
            boolean isSelectedKurzeme = checkBoxKurzeme.isSelected();
                if(isSelectedKurzeme == true){messagingService.messagingRequest(selectedCheckBoxRegionKurzeme, selectedComboBoxAlert, message);}

            String selectedCheckBoxRegionZemgale = checkBoxZemgale.getText();
            boolean isSelectedZemgale = checkBoxZemgale.isSelected();
                if(isSelectedZemgale == true){messagingService.messagingRequest(selectedCheckBoxRegionZemgale, selectedComboBoxAlert, message);}

            String selectedCheckBoxRegionLatgale = checkBoxLatgale.getText();
            boolean isSelectedLatgale = checkBoxLatgale.isSelected();
                if(isSelectedLatgale == true){messagingService.messagingRequest(selectedCheckBoxRegionLatgale, selectedComboBoxAlert, message);}


        }catch (Exception e) {
            return "Error in sending message";
        }

        return null;
    }

    public void logoutClick(ActionEvent actionEvent) {
        SceneService.changeScene(actionEvent, "login");
    }
}