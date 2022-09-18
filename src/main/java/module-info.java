module com.example.eas_finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires commons.configuration;
    requires twilio;
    requires mysql.connector.java;

    opens com.example.eas_finalproject to javafx.fxml;
    exports com.example.eas_finalproject;

    exports com.example.eas_finalproject.controllers;
    opens com.example.eas_finalproject.controllers;

    exports com.example.eas_finalproject.services;
    opens com.example.eas_finalproject.services;
}