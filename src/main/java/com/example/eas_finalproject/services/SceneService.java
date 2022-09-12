package com.example.eas_finalproject.services;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneService {

    public static void changeScene(ActionEvent actionEvent, String sceneName){

        String scenePath = "/view/" + sceneName + ".fxml";

        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(SceneService.class.getResource(scenePath)));
            stage.setScene(new Scene(parent, 700, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAlert(String title, String message, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
