package com.hsbc.kata.bowlinggame

import spock.lang.Specification

class BowlingGameTest extends Specification {
    BowlingGame game = new BowlingGame()

    def "should return 20 when call 20 times of roll()"() {
        when:
        rollManyTimes(20, 1)
        then:
        game.score() == 20
    }

    def "should return 0 when call 20 times of roll()"() {
        when:
        rollManyTimes(20, 0)
        then:
        game.score() == 0
    }

    def "should return 16 when call a spare"() {
        when:
        rollSpare()
        game.roll(3)
        rollManyTimes(17, 0)
        then:
        game.score() == 16
    }

    def "should return 24 when call a strike"() {
        when:
        rollStrike()
        game.roll(3)
        game.roll(4)
        rollManyTimes(16, 0)
        then:
        game.score() == 24
    }

    def "should return 300 when call a perfect game"() {
        when:
        rollManyTimes(20, 10)
        then:
        game.score() == 300
    }

    private void rollManyTimes(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins)
        }
    }

    private void rollSpare() {
        game.roll(5)
        game.roll(5)
    }

    private rollStrike() {
        game.roll(10)
    }
}
