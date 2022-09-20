package com.example.eas_finalproject.controllers;

import com.example.eas_finalproject.repository.DataRepository;
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

            checkBoxDetails(messagingService, selectedComboBoxAlert,
                    checkBoxKurzeme, checkBoxZemgale, checkBoxLatgale, checkBoxRiga, checkBoxVidzeme, message);

        }catch (Exception e) {
            return "Error in sending message";
        }
        return null;
    }

    private void checkBoxDetails(MessagingService messagingService, String selectedComboBoxAlert,
                                 CheckBox checkBoxKurzeme, CheckBox checkBoxZemgale, CheckBox checkBoxLatgale,
                                 CheckBox checkBoxRiga, CheckBox checkBoxVidzeme, String message) {
        String selectedCheckBoxRegionKurzeme = checkBoxKurzeme.getText();
        boolean isSelectedKurzeme = checkBoxKurzeme.isSelected();
        if(isSelectedKurzeme == true){
            messagingService.messagingRequest(selectedComboBoxAlert, selectedCheckBoxRegionKurzeme, message);}

        String selectedCheckBoxRegionZemgale = checkBoxZemgale.getText();
        boolean isSelectedZemgale = checkBoxZemgale.isSelected();
        if(isSelectedZemgale == true){
            messagingService.messagingRequest(selectedComboBoxAlert, selectedCheckBoxRegionZemgale, message);}

        String selectedCheckBoxRegionLatgale = checkBoxLatgale.getText();
        boolean isSelectedLatgale = checkBoxLatgale.isSelected();
        if(isSelectedLatgale == true){
            messagingService.messagingRequest(selectedComboBoxAlert, selectedCheckBoxRegionLatgale, message);}

        String selectedCheckBoxRegionRiga = checkBoxRiga.getText();
        boolean isSelectedRiga = checkBoxRiga.isSelected();
        if(isSelectedRiga == true){
            messagingService.messagingRequest(selectedComboBoxAlert, selectedCheckBoxRegionRiga, message);}

        String selectedCheckBoxRegionVidzeme = checkBoxVidzeme.getText();
        boolean isSelectedVidzeme = checkBoxVidzeme.isSelected();
        if(isSelectedVidzeme == true){
            messagingService.messagingRequest(selectedComboBoxAlert, selectedCheckBoxRegionVidzeme, message);}
    }

    public void logoutClick(ActionEvent actionEvent) {
        SceneService.changeScene(actionEvent, "login");
    }
}