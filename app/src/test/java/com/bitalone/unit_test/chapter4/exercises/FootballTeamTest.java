package com.bitalone.unit_test.chapter4.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

/**
 * Created by mahdi on 11/14/18.
 */

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    private static final int ANY_NUMBER = 123;


    private static Object[] numOfGamesWon() {
        return new Object[]{
                new Object[]{0},
                new Object[]{1},
                new Object[]{2}
        };
    }

    @Test
    @Parameters(method = "numOfGamesWon")
    public void testConstructorSetsNumberOfGamesWon(int numberOfGamesWon) {
        FootballTeam team = new FootballTeam(numberOfGamesWon);

        assertEquals(numberOfGamesWon + " passed to constructor but " +
                team.getGamesWon() + " were returned ", numberOfGamesWon, team.getGamesWon());
    }


    private static Object[] illegalNumOfGamesWon() {
        return $ (-1, -10);
    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalNumOfGamesWon")
    public void testIllegalNumOfGamesWonInConstructor(int illegalNumOfGamesWon) {
        new FootballTeam(illegalNumOfGamesWon);
    }


    @Test
    public void shouldBePossibleToCompareTeams() {
        FootballTeam footballTeam = new FootballTeam(ANY_NUMBER);
        assertTrue("FootballTeam must implement Comparable interface",
                footballTeam instanceof Comparable);
    }

    private static Object[] constructorTeamWithMoreWinsShouldBeGreater() {
        return new Object[]{
                new Object[]{10, 100},
                new Object[]{2, 10},
                new Object[]{11, 99}
        };
    }

    @Test
    @Parameters(method = "constructorTeamWithMoreWinsShouldBeGreater")
    public void teamWithMoreWinsShouldBeGreater(int lessNumOfWins, int moreNumOfWins) {
        FootballTeam teamWithLessWins = new FootballTeam(lessNumOfWins);
        FootballTeam teamWithMoreWins = new FootballTeam(moreNumOfWins);

        assertTrue("team with " + moreNumOfWins + " wins should rank higher than team with " +
                lessNumOfWins + " wins", teamWithMoreWins.compareTo(teamWithLessWins) > 0);
    }


    private static Object[] constructorTeamWithLessWinsShouldBeLesser() {
        return new Object[] {
                new Object[] {2, 0},
                new Object[] {10, 9},
                new Object[] {100, 1},
        };
    }
    @Test
    @Parameters(method = "constructorTeamWithLessWinsShouldBeLesser")
    public void teamWithLessWinsShouldBeLesser(int moreNumOfWins, int lessNumOfWins) {
        FootballTeam teamWithLessWins = new FootballTeam(lessNumOfWins);
        FootballTeam teamWithMoreWins = new FootballTeam(moreNumOfWins);

        assertTrue("team with " + lessNumOfWins + " wins should rank lesser than team with " +
                moreNumOfWins + " wins", teamWithLessWins.compareTo(teamWithMoreWins) < 0);
    }

    private static Object[] constructorTeamsWithEqualWins() {
        return new Object[]{
                new Object[]{0, 0},
                new Object[]{1, 1},
                new Object[]{2, 2},
                new Object[]{100, 100}
        };
    }

    @Test
    @Parameters(method = "constructorTeamsWithEqualWins")
    public void teamsWithEqualWins(int firstTeamWins, int secondTeamWins) {
        FootballTeam team1 = new FootballTeam(firstTeamWins);
        FootballTeam team2 = new FootballTeam(secondTeamWins);

        assertEquals(0, team1.compareTo(team2));
    }



}