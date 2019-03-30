package com.hsbc.kata.scorekeeper;

public class ScoreKeeper {

    private int leftScore;
    private int rightScore;

    public String getScore() {
        return formatNumber(leftScore) + ":" + formatNumber(rightScore);
    }

    public void scoreTeamA1() {
        leftScore += 1;
    }

    public void scoreTeamA2() {
        leftScore += 2;
    }

    public void scoreTeamA3() {
        leftScore += 3;
    }

    public void scoreTeamB1() {
        rightScore += 1;
    }

    public void scoreTeamB2() {
        rightScore += 2;
    }

    public void scoreTeamB3() {
        rightScore += 3;
    }

    public String formatNumber(int score) {
        if (score > 0 && score < 10) {
            return "00" + score;
        } else if (score >= 10 && score < 100) {
            return "0" + score;
        } else if (score >= 100 && score < 1000) {
            return score + "";
        } else {
            return "000";
        }
    }
}
