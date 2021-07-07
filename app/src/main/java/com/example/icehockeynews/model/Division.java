package com.example.icehockeynews.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public @Data class  Division {

    private int divisionID;
    private String name;

    List<Teams> teamsList = new ArrayList<Teams>();

}
