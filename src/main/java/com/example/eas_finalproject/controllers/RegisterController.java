package com.example.eas_finalproject.controllers;

import com.example.eas_finalproject.models.User;
import com.example.eas_finalproject.services.SceneService;
import com.example.eas_finalproject.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class RegisterController {

    public PasswordField securityCodeField;

    public Integer id;
    public TextField usernameField;
    public PasswordField passwordField;
    public PasswordField confirmPasswordField;
    public TextField nameField;
    public TextField emailField;
    public TextField phoneField;
    private UserService userService = new UserService();

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

    public void onUserRegisterClick(ActionEvent actionEvent) {
        try {
            User user = new User (
                    null,
                    usernameField.getText(),
                    passwordField.getText(),
                    //confirmPasswordField.getText(),
                    nameField.getText(),
                    emailField.getText(),
                    phoneField.getText()
            );
            this.validateUser(user);
            this.userService.registerUser(user);
            SceneService.showAlert("Registration successfully",
                    "User " + usernameField.getText() + " registered successfully",
                    Alert.AlertType.CONFIRMATION);

            SceneService.changeScene(actionEvent,"messaging");

        }catch (Exception e) {
            SceneService.showAlert("Login failed", e.getMessage(), Alert.AlertType.ERROR);

        }
    }

    private void validateUser(User user) throws Exception{

        if (user.getUsername().length() < 4) throw new Exception("Username should be minimum 4 characters");
        if (!user.getPassword().equals(confirmPasswordField.getText())) throw new Exception("Password doesnt match");
        if (user.getPassword().length() < 4) throw new Exception("Password should be minimum 4 characters");
        if (user.getName().isEmpty()) throw new Exception("Please, provide Name");
        if (user.getEmail().isEmpty()) throw new Exception("Please, enter  Email");
        if (!user.getEmail().contains("@")) throw new Exception("Please, enter valid Email");
        if (user.getPhone().isEmpty()) throw new Exception("Please, enter valid Phone Number");
        //if (user.getPhone().length() >10) throw new Exception("Please, enter valid Phone Number in international format, eg +371...");
    }

    @FXML
    public void onUserLoginClick(ActionEvent actionEvent) {
        SceneService.changeScene(actionEvent, "login");
    }
}

