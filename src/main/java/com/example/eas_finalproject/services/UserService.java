package com.example.eas_finalproject.services;

import com.example.eas_finalproject.exceptions.UserNotFoundException;
import com.example.eas_finalproject.models.User;
import com.example.eas_finalproject.repository.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    private Connection connection = DBConnectionManager.getConnection();
    public int verifyUserDetails(String username, String password) throws Exception {
        connection = DBConnectionManager.getConnection();

        String query = "SELECT id FROM users WHERE username = ? && password = ? LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        Integer userId = null;
        if (resultSet.next()) userId = resultSet.getInt("id");

        DBConnectionManager.close(resultSet, preparedStatement, connection);

        if (userId != null) return userId;

        throw new UserNotFoundException("User with username "+ username + " not found");
    }

    public void registerUser(User user) throws Exception {
        connection = DBConnectionManager.getConnection();
        String query = "INSERT INTO users(username, password, name, email, phone) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);


        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getName());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getPhone());
        int result = preparedStatement.executeUpdate();

        DBConnectionManager.close(null, preparedStatement, connection);

        if (result != 1) throw new Exception("Registration failed for user with username " + user.getUsername());
    }
}
