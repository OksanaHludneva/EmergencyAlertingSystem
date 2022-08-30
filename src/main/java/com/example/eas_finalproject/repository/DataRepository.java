package com.example.eas_finalproject.repository;

import com.example.eas_finalproject.models.Accidents;
import lombok.Data;

import java.util.ArrayList;
@Data
public class DataRepository {

    private static DataRepository dataRepository_instance;

    private Integer loggedInUserId = null;
    private Accidents loggedInUser = null;
    private ArrayList<Accidents> onGoingAccidents = new ArrayList<>();

    DataRepository() {

    }

    public static DataRepository getInstance() {

        if (dataRepository_instance == null) dataRepository_instance = new DataRepository();

        return dataRepository_instance;
    }



}
