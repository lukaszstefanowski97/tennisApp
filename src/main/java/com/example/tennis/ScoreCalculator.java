package com.example.tennis;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * User: Łukasz Stefanowski
 * Date: 10/10/2018
 */
public class ScoreCalculator {

    public static int[] getScores() {
        int[] scores = new int[2];
        try {
            Scanner enterInteger = new Scanner(System.in);
            System.out.println("Please type score of player 1: \n");
            scores[0] = enterInteger.nextInt();
        } catch (Exception type) {
            System.out.println("That was not an integer. Please type again:\n");
            return getScores();
        }
        try {
            Scanner enterInteger = new Scanner(System.in);
            System.out.println("Please type score of player 2: \n");
            scores[1] = enterInteger.nextInt();
        } catch (Exception type) {
            System.out.println("That was not an integer. Please type again:\n");
            return getScores();
        }
        return scores;
    }

    public static String getScoreAsString(int score) {
        String result = "";
        if (score == 0) result = "Love";
        else if (score == 1) result = "Fifteen";
        else if (score == 2) result = "Thirty";
        else if (score == 3) result = "Forty";
    
        return result;
    }

    public static void validateInput(int player1Score, int player2Score) {

        if (player1Score < 0 || player2Score < 0) {
            System.out.println("Given scores are not valid.");
            getScores();
        }

        int difference = Math.abs(player1Score - player2Score);
        int sum = player1Score + player2Score;
        if (difference > 4 || difference > 2 && sum > 6) {
            System.out.println("Given scores are not valid.");
            getScores();
        }
    }

    public static String displayScore(int player1Score, int player2Score) {
        int sum = player1Score + player2Score;
        int difference = Math.abs(player1Score - player2Score);

        String player1Result = getScoreAsString(player1Score);
        String player2Result = getScoreAsString(player2Score);

        if (player1Score == player2Score) {
            if (player1Score == 3) return "Deuce";
            return player1Result + "-All";
        }
        
        if (difference == 3 && sum = 3) return player1Result + "-" + player2Result;

        if (difference > 1 && player1Score > player2Score) return "Win for player 1";
        if (difference > 1 && player1Score < player2Score) return "Win for player 2";

        if (player1Score > player2Score && difference < 2 && sum > 3) return "Advantage player 1";
        if (player1Score < player2Score && difference < 2 && sum > 3) return "Advantage player 2";

        if (player1Score > player2Score && difference == 2 && sum > 3) return "Win for player 1";
        if (player1Score < player2Score && difference == 2 && sum > 3) return "Win for player 2";

        return player1Result + "-" + player2Result;
    }

    public static String computeScore(int player1Score, int player2Score){
        validateInput(player1Score, player2Score);
        return displayScore(player1Score, player2Score);
    }
}
