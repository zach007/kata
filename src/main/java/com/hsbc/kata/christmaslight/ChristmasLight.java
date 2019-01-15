package com.hsbc.kata.christmaslight;

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
        return points.stream().mapToInt(p -> p.getStatus()).sum();
    }

    public void turnOn(Point pointA, Point pointB) {
        List<Point> points = findPoints(pointA, pointB);
        points.stream().forEach(p -> {
            int increaseNumber = p.getStatus() + 1;
            p.setStatus(increaseNumber);
        });
    }

    public void toggle(Point pointA, Point pointB) {
        List<Point> points = findPoints(pointA, pointB);
        points.stream().forEach(point -> {
            int status = point.getStatus();
            status += 2;
            point.setStatus(status);
        });
    }

    public List<Point> findPoints(Point pointA, Point pointB) {
        List<Point> pointArray = points.stream().filter(p -> {
            int currentPointStart = p.getStart();
            int currentPointEnd = p.getEnd();
            int startA = pointA.getStart();
            int startB = pointB.getStart();
            int endA = pointA.getEnd();
            int endB = pointB.getEnd();
            int foo = Math.min(startA, startB);
            int maxFoo = Math.max(startA, startB);
            int bar = Math.min(endA, endB);
            int maxBar = Math.max(endA, endB);
            boolean test = foo <= currentPointStart && currentPointStart <= maxFoo;
            boolean check = bar <= currentPointEnd && currentPointEnd <= maxBar;
            return test && check;
        }).collect(Collectors.toList());
        return pointArray;
    }

    public List<Point> turnOff(Point pointA, Point pointB) {
        List<Point> points = findPoints(pointA, pointB);
        points.stream().forEach(point -> {
            int status = point.getStatus();
            status -= 1;
            int newStatus = status >= 0 ? status : 0;
            point.setStatus(newStatus);
        });
        return points;
    }
}
