package com.example.eas_finalproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ContactsRepository {
    protected final DBConnectionManager dbConnectionManager = new DBConnectionManager();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    public ArrayList<String> getAllPhoneNr(String region){

        ArrayList<String> phoneNr = new ArrayList();

        try {
            String query = "SELECT `phoneNr` FROM contacts WHERE region = ?";
            this.connection = this.dbConnectionManager.getConnection();
            this.statement = connection.prepareStatement(query);
            this.statement.setString(1, region);
            this.resultSet = statement.executeQuery();
            while (resultSet.next()){
                phoneNr.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.dbConnectionManager.close(resultSet, statement, connection);
        }

        return phoneNr;
    }
}
