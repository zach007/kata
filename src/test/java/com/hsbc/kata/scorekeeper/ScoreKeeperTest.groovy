package com.hsbc.kata.scorekeeper

import spock.lang.Specification

class ScoreKeeperTest extends Specification {
    def scorekeeper = new ScoreKeeper()

    def "should always return seven characters"() {
        expect:
        scorekeeper.getScore() == "000:000"
    }

    def "left point should add one when call scoreTeamA1"() {
        when:
        scorekeeper.scoreTeamA1()
        scorekeeper.scoreTeamA2()
        scorekeeper.scoreTeamA3()
        scorekeeper.scoreTeamB1()
        scorekeeper.scoreTeamB2()
        scorekeeper.scoreTeamB3()
        then:
        scorekeeper.getScore() == "006:006"
    }

    def "should format score"() {
        expect:
        scorekeeper.formatNumber(score) == formatNumber
        where:
        score || formatNumber
        1     || "001"
        10    || "010"
        100   || "100"
    }
}

