package com.hsbc.kata.manhattandistance;

import lombok.Builder;

/**
 * @author Jack
 * todo :implement your own builder design
 */
public class ManhattanDistance {

    int manhattanDistance(DistancePoint x, DistancePoint y) {
        return Math.abs(x.start - y.start) - Math.abs(y.start - y.end);
    }

    @Builder
    static class DistancePoint {
        private int start;
        private int end;
    }
}
