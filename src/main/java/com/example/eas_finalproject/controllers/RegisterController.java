package com.example.eas_finalproject.controllers;

import com.example.eas_finalproject.services.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;


public class RegisterController {

    public PasswordField securityCodeField;
    @FXML
    public void confirmSecurityCode(ActionEvent actionEvent) throws Exception {

        try {

            if (securityCodeField.getText().equals("1111")) {

                SceneService.showAlert("Security Code entered successfully",
                        "Authorization successful",
                        Alert.AlertType.CONFIRMATION
                );

                SceneService.changeScene(actionEvent,"register");

            }else {
                SceneService.showAlert("Security Code entered wrong",
                        "Authorization failed",
                        Alert.AlertType.ERROR
                );
            }
        }catch (Exception e) {
            SceneService.showAlert("Login Failed", e.getMessage(), Alert.AlertType.ERROR);
        }

    }


    public void confirmRegistration(ActionEvent actionEvent) {
        //SceneService.changeScene(actionEvent, "XXXXXXXXXXXXXX");
    }
}

