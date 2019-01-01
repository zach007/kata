package com.hsbc.kata.ChristmasLight

import spock.lang.Specification

class ChristmasLightTest extends Specification {

    def christmasLight = new ChristmasLight()

    def "should return 1 when turn on light from (0,0) to (0,0)"() {
        when:
        christmasLight.turnOn(new Point(0, 0), new Point(0, 0))
        then:
        christmasLight.findTurnOnLights() == 1
    }

    def "should return 9 when turn on light from (0,0) to (3,3)"() {
        when:
        christmasLight.turnOn(new Point(3, 3), new Point(4, 4))
        then:
        christmasLight.findTurnOnLights() == 4
    }

    def "should return 999 when toggle light from (0,0) to (999,0)"() {
        when:
        christmasLight.toggle(new Point(0, 0), new Point(900, 0))
        then:
        christmasLight.findTurnOnLights() == 999
    }
}
