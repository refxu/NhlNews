package com.example.icehockeynews.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.example.icehockeynews.model.Division;
import com.example.icehockeynews.model.Teams;

public class RankingNhl {

    public static List<Division> createTabelleFromJsonString(JSONObject response) throws JSONException{

        List<Division> divisionList = new ArrayList<Division>();
        JSONObject ranglisteObject = response;
        JSONArray recordsObject = ranglisteObject.getJSONArray("records");

        for (int i = 0; i < recordsObject.length(); i++) {
            List<Teams> teamsList = new ArrayList<Teams>();
            Division division = new Division();
            JSONObject divisionObject = recordsObject.getJSONObject(i);
            JSONObject divisionInfoObject = divisionObject.getJSONObject("division");
            division.setDivisionID(divisionInfoObject.getInt("id"));
            division.setName(divisionInfoObject.getString("name"));

            JSONArray teamRecordsObject = divisionObject.getJSONArray("teamRecords");

            for (int j = 0; j < teamRecordsObject.length(); j++) {
                Teams teams = new Teams();
                JSONObject teamObject = teamRecordsObject.getJSONObject(j);
                JSONObject teamInfoObject = teamObject.getJSONObject("team");
                teams.setTeamsID(teamInfoObject.getInt("id"));
                teams.setName(teamInfoObject.getString("name"));
                JSONObject leagueRecordInObject = teamObject.getJSONObject("leagueRecord");
                teams.setWins(leagueRecordInObject.getInt("wins"));
                teams.setLosses(leagueRecordInObject.getInt("losses"));
                teams.setPoints(teamObject.getInt("points"));
                teams.setGamesPlayed(teamInfoObject.getInt("gamesPlayed"));
                teams.setGoalsScored(teamObject.getInt("goalsScored"));

                teamsList.add(teams);
            }
            division.setTeamsList(teamsList);
            divisionList.add(division);
        }

         return divisionList;
    }

}
