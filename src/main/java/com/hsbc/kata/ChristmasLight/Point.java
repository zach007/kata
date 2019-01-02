package com.hsbc.kata.ChristmasLight;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@Getter
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
