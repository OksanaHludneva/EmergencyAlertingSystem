package com.example.eas_finalproject.services;

import com.example.eas_finalproject.exceptions.UserNotFoundException;
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
}
