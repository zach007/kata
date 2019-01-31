package com.hsbc.kata.manhattandistance

import spock.lang.Specification

class ManhattanDistanceTest extends Specification {

    def "should return sum of absolute value between two point"() {
        given:
        def x = ManhattanDistance.DistancePoint.builder().start(1).end(1).build()
        def y = ManhattanDistance.DistancePoint.builder().start(1).end(1).build()
        when:
        def manhattanDistance = new ManhattanDistance()
        def distance = manhattanDistance.manhattanDistance(x, y)
        then:
        distance == 0
    }
}
