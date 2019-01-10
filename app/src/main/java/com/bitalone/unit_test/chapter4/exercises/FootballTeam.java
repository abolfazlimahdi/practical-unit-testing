package com.bitalone.unit_test.chapter4.exercises;


import androidx.annotation.NonNull;

/**
 * Created by mahdi on 11/14/18.
 */

public class FootballTeam implements Comparable<FootballTeam> {

    private int gamesWon;

    public FootballTeam(int gamesWon) {
        if (gamesWon < 0)
            throw new IllegalArgumentException(
                    "numberOfGamesWon parameter must be non-negative but passed: " + gamesWon);
        this.gamesWon = gamesWon;
    }


    public int getGamesWon() {
        return gamesWon;
    }



    @Override
    public int compareTo(@NonNull FootballTeam otherTeam) {
        return gamesWon - otherTeam.getGamesWon();

    }
}
