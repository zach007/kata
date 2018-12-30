package com.hsbc.kata.BowlingGame;


public class BowlingGame {

    private int currentRound = 0;
    private int[] records = new int[21];

    public void roll(int i) {
        records[currentRound++] = i;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(frameIndex)) {
                score = spareBonus(score, frameIndex);
                frameIndex += 2;
            } else if (isStrike(records[frameIndex])) {
                score = strikeBonus(score, frameIndex);
                frameIndex ++;
            } else {
                score = sumOfDownPins(score, frameIndex, records[frameIndex], 1);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int sumOfDownPins(int score, int frameIndex, int record, int i) {
        score += record + records[frameIndex + i];
        return score;
    }

    private boolean isStrike(int record) {
        return record == 10;
    }

    private int strikeBonus(int score, int frameIndex) {
        score += 10 + records[frameIndex + 1] + records[frameIndex + 2];
        return score;
    }

    private boolean isSpare(int frameIndex) {
        return records[frameIndex] + records[frameIndex + 1] == 10;
    }

    private int spareBonus(int score, int frameIndex) {
        score += 10 + records[frameIndex + 2];
        return score;
    }
}
