package com.hsbc.kata.ChristmasLight

import spock.lang.Specification
import spock.lang.Unroll

class ChristmasLightTest extends Specification {

    def christmasLight = new ChristmasLight()

    def "should return 1000000 turn off lights"() {
        expect:
        christmasLight.getPoints().size() == 1000000
        and:
        def turnOffLight = { point -> point.status == 0 }
        christmasLight.getPoints().stream().allMatch(turnOffLight)
    }

    def "should return 1 when turn on light from (0,0) to (0,0)"() {
        when:
        christmasLight.turnOn(new Point(0, 0), new Point(0, 0))
        then:
        christmasLight.findTurnOnLights() == 1
    }

    def "should return 9 when turn on light from (0,0) to (3,3)"() {
        when:
        def turnOnLights = christmasLight.turnOn(new Point(3, 3), new Point(4, 4))
        then:
        christmasLight.findTurnOnLights() == 4
        and:
        turnOnLights.stream().allMatch({ p -> p.status == 1 })

    }

    @Unroll
    def "should return #result when toggle light from #point1 to #point2"() {
        when:
        def list = christmasLight.toggle(point1, point2)
        then:
        christmasLight.findTurnOnLights() == result
        and:
        list.stream().allMatch({ p -> p.status == 1 })
        where:
        point1          | point2            || result
        new Point(0, 0) | new Point(999, 0) || 1000
        new Point(2, 2) | new Point(3, 4)   || 6
        new Point(2, 2) | new Point(3, 0)   || 6
        new Point(2, 2) | new Point(1, 4)   || 6
        new Point(2, 2) | new Point(1, 0)   || 6
    }

    def "should return #result when turn off light from #point1 to #point2"() {
        def list = christmasLight.turnOff(point1, point2)
        expect:
        list.size() == result
        list.stream().allMatch({ p -> p.status == 0 })
        where:
        point1              | point2              || result
        new Point(499, 499) | new Point(500, 500) || 4
        new Point(2, 2)     | new Point(0, 0)     || 9

    }

    def "should return 998996 after finish instructions"() {
        christmasLight.turnOn(new Point(0, 0), new Point(999, 999))
        christmasLight.toggle(new Point(0, 0), new Point(999, 0))
        christmasLight.turnOff(new Point(499, 499), new Point(500, 500))
        expect:
        christmasLight.findTurnOnLights() == 998996
    }
}
