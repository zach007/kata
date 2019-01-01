package com.hsbc.kata.ChristmasLight;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"status"})
public class Point {
    private int start;
    private int end;
    private int status;

    public Point(int p, int q) {
        this.start = p;
        this.end = q;
    }
}
