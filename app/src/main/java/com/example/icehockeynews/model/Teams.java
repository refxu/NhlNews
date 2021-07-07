package com.example.icehockeynews.model;

import lombok.Data;

public @Data class Teams {

    private int teamsID;
    private String name;
    private int gamesPlayed;
    private int wins;
    private int losses;
    private int points;
    private int overTime;
    private int goalsScored;

    public Teams() {

    }

    @Override
    public String toString() {
        return
                 name + " " + "GP" + " " +gamesPlayed + " " +
                 "W"+ " " + wins + " " + "L" + " " + losses + " " + "PTS" + " " +
                 points+ " " + "OT" + " " + overTime + " " + "GF" + " " + goalsScored
                ;
    }
}
