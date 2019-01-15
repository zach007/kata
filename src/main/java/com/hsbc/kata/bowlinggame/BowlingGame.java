package com.hsbc.kata.bowlinggame;


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
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else {
                score += sumOfDownPins(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int sumOfDownPins(int frameIndex) {
        return records[frameIndex] + records[frameIndex + 1];
    }

    private boolean isStrike(int frameIndex) {
        return records[frameIndex] == 10;
    }

    private int strikeBonus(int frameIndex) {
        return records[frameIndex + 1] + records[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex) {
        return records[frameIndex] + records[frameIndex + 1] == 10;
    }

    private int spareBonus(int frameIndex) {
        return records[frameIndex + 2];
    }
}
