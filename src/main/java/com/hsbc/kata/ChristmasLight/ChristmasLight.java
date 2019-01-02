package com.hsbc.kata.ChristmasLight;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChristmasLight {

    @Getter
    private final List<Point> points;

    public ChristmasLight() {
        ArrayList<Point> allPoints = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                Point point = new Point(i, j);
                allPoints.add(point);
            }
        }
        this.points = allPoints;
    }

    public long findTurnOnLights() {
        return points.stream().filter(point -> point.getStatus() == 1).count();
    }

    public List<Point> turnOn(Point pointA, Point pointB) {
        List<Point> points = findPoints(pointA, pointB);
        points.stream().forEach(p -> p.setStatus(1));
        return points;
    }

    public List<Point> toggle(Point pointA, Point pointB) {
        List<Point> points = findPoints(pointA, pointB);
        points.stream().forEach(point -> {
            int status = point.getStatus();
            status ^= 1;
            point.setStatus(status);
        });
        return points;
    }

    public List<Point> findPoints(Point pointA, Point pointB) {
        List<Point> pointArray = points.stream().filter(p -> {
            boolean betweenLength = pointA.getStart() <= p.getStart() && p.getStart() <= pointB.getStart();
            boolean betweenWidth = pointA.getEnd() <= p.getEnd() && p.getEnd() <= pointB.getEnd();
            return betweenLength && betweenWidth;
        }).collect(Collectors.toList());
        return pointArray;
    }

    public List<Point> turnOff(Point pointA, Point pointB) {
        List<Point> points = findPoints(pointA, pointB);
        points.stream().forEach(point -> point.setStatus(0));
        return points;
    }
}
