package com.example.icehockeynews.model;

import java.util.ArrayList;
import java.util.List;

public class Tabelle {

    int teamsID;
    int gamesPlayed;
    int wins;
    int looses;
    int points;
    int goalsScored;

    public Tabelle(int teamsID, int gamesPlayed, int wins, int looses, int points, int goalsScored) {
        this.teamsID = teamsID;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.looses = looses;
        this.points = points;
        this.goalsScored = goalsScored;
    }

    public Tabelle() {

    }


    public int getTeamsID() {
        return teamsID;
    }

    public void setTeamsID(int teamsID) {
        this.teamsID = teamsID;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLooses() {
        return looses;
    }

    public void setLooses(int looses) {
        this.looses = looses;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void removeTabelle(Tabelle tabelle){
        this.rankingTeams.remove(tabelle);
    }

    public void addTabelle(Tabelle tabelle){
        this.rankingTeams.add(tabelle);
    }

    List<Tabelle> rankingTeams = new ArrayList<>();

}
