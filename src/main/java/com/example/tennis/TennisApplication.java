package com.example.tennis;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisApplication {

	public static void main(String[] args) {
		int[] scores = ScoreCalculator.getScores();
		String result = ScoreCalculator.computeScore(scores[0], scores[1]);
		System.out.println(result);
	}
}
