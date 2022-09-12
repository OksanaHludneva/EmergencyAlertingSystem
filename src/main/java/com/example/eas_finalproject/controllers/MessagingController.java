package com.example.eas_finalproject.controllers;

import com.example.eas_finalproject.services.SceneService;
import javafx.event.ActionEvent;

public class MessagingController {
    public void sendMessageClick(ActionEvent actionEvent) {
    }

    public void logoutClick(ActionEvent actionEvent) {
        SceneService.changeScene(actionEvent,"login");
    }
}
