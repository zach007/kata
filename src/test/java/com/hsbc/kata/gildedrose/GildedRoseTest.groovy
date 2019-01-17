package com.hsbc.kata.gildedrose

import spock.lang.Specification

class GildedRoseTest extends Specification {

    def "foo"() {
        Item[] items = [new Item("foo", 0, 0)]
        GildedRose app = new GildedRose(items)
        app.updateQuality()
        expect:
        "fixme" == app.items[0].name
    }

    def "quality should never more than 50"() {

    }
}
