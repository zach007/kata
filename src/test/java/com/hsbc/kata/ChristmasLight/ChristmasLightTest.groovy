package com.hsbc.kata.ChristmasLight

import spock.lang.Specification
import spock.lang.Unroll

class ChristmasLightTest extends Specification {

    def christmasLight = new ChristmasLight()

    @Unroll
    def "should return #result when turn on light from #lightA to #lightB"() {
        for (int i = 0; i < 2; i++) {
            christmasLight.turnOn(lightA, lightB)
        }
        expect:
        christmasLight.findTurnOnLights() == result
        where:
        lightA          | lightB          || result
        new Point(0, 0) | new Point(0, 0) || 2
        new Point(3, 3) | new Point(4, 4) || 8
    }

    @Unroll
    def "should return #result when toggle light from #point1 to #point2"() {
        when:
        for (int i = 0; i < 2; i++) {
            christmasLight.toggle(point1, point2)
        }
        then:
        christmasLight.findTurnOnLights() == result
        where:
        point1          | point2            || result
        new Point(0, 0) | new Point(999, 0) || 4000
        new Point(2, 2) | new Point(3, 4)   || 24
        new Point(2, 2) | new Point(3, 0)   || 24
        new Point(2, 2) | new Point(1, 4)   || 24
        new Point(2, 2) | new Point(1, 0)   || 24
    }

    @Unroll
    def "should return #result when turn off light from #point1 to #point2"() {
        christmasLight.turnOn(point1, point1)
        for (int i = 0; i < 2; i++) {
            christmasLight.turnOff(point1, point2)
        }
        expect:
        christmasLight.findTurnOnLights() == result
        where:
        point1          | point2          || result
        new Point(0, 0) | new Point(0, 0) || 0

    }

    def "should return 2000000 after finish instructions"() {
        christmasLight.turnOn(new Point(0, 0), new Point(999, 999))
        christmasLight.toggle(new Point(0, 0), new Point(999, 999))
        christmasLight.turnOff(new Point(0, 0), new Point(999, 999))
        expect:
        christmasLight.findTurnOnLights() == 1000000 * 2
    }
}
