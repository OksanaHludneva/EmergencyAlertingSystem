package com.example.eas_finalproject.repository;

import lombok.Data;

@Data
public class DataRepository {

    private static DataRepository dataRepository_instance;

    private Integer loggedInUserId = null;
    DataRepository() {

    }

    public static DataRepository getInstance() {

        if (dataRepository_instance == null) dataRepository_instance = new DataRepository();

        return dataRepository_instance;
    }
}