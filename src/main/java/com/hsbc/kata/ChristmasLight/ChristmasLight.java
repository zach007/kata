package com.hsbc.kata.ChristmasLight;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChristmasLight {

    private final List<Point> points;

    public ChristmasLight() {
        ArrayList<Point> allPoints = Lists.newArrayList();
        for (int i = 0; i < 999; i++) {
            for (int j = 0; j < 999; j++) {
                Point point = new Point(i, j);
                allPoints.add(point);
            }
        }
        this.points = allPoints;
    }

    public long findTurnOnLights() {
        return points.stream().filter(point -> point.getStatus() == 1).count();
    }

    public void turnOn(Point pointA, Point pointB) {
        List<Point> points = findPoints(pointA, pointB);
        points.stream().forEach(p -> p.setStatus(1));
    }

    public void toggle(Point pointA, Point pointB) {
        List<Point> points = findPoints(pointA, pointB);
        points.stream().forEach(point -> {
            int status = point.getStatus();
            status ^= 1;
            point.setStatus(status);
        });
    }

    public List<Point> findPoints(Point pointA, Point pointB) {
        List<Point> pointArray = points.stream().filter(p -> {
            boolean betweenLength = pointA.getStart() <= p.getStart() && p.getStart() <= pointB.getStart();
            boolean betweenWidth = pointA.getEnd() <= p.getEnd() && p.getEnd() <= pointB.getEnd();
            return betweenLength && betweenWidth;
        }).collect(Collectors.toList());
        return pointArray;
    }
}
