package com.example.eas_finalproject.controllers;

import com.example.eas_finalproject.repository.DataRepository;
import com.example.eas_finalproject.services.SceneService;
import com.example.eas_finalproject.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    UserService userService = new UserService();

    @FXML
    public void onUserLoginClick(ActionEvent actionEvent) {

        try {
            String username = usernameField.getText();
            String password = passwordField.getText();

            int userId = this.userService.verifyUserDetails(username, password);

            DataRepository.getInstance().setLoggedInUserId(userId);
            SceneService.showAlert(
                    "Login success",
                    "Logged in successfully",
                    Alert.AlertType.CONFIRMATION
            );
            DataRepository.getInstance().setLoggedInUserId(userId);
            SceneService.changeScene(actionEvent, "messaging");
        }catch (Exception exception){
            SceneService.showAlert("Login Failed", exception.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    protected void onUserRegisterClick(ActionEvent actionEvent){
        SceneService.changeScene(actionEvent, "registerSecurityCode");
    }
}
