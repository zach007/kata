package com.hsbc.kata.gildedrose

import spock.lang.Specification

class GildedRoseTest extends Specification {

    def "foo"() {
        Item[] items = [new Item("foo", 0, 0)]
        GildedRose app = new GildedRose(items)
        app.updateQuality()
        expect:
        "foo" == app.items[0].name
    }

    def "Once the sell by date has passed, Quality degrades twice as fast"() {
        Item[] items = [new Item("foo", 3, 10)]
        def app = new GildedRose(items)
        for (int i = 0; i < 5; i++) {
            app.updateQuality()
        }
        def quality = app.items[0].quality
        expect:
        quality == 3
    }

    def "The Quality of an item is never negative"() {
        Item[] items = [new Item("foo", 1, 10)]
        def app = new GildedRose(items)
        for (int i = 0; i < 10; i++) {
            app.updateQuality()
        }
        def quality = app.items[0].quality
        expect:
        quality == 0
    }

    def "“Aged Brie” actually increases in Quality the older it gets"() {
        Item[] items = [new Item("Aged Brie", 3, 10)]
        def app = new GildedRose(items)
        for (int i = 0; i < 10; i++) {
            app.updateQuality()
        }
        def quality = app.items[0].quality
        println(quality)
        expect:
        quality == 27
    }

    def "The Quality of an item is never more than 50"() {
        Item[] items = [new Item("Aged Brie", 3, 10)]
        def app = new GildedRose(items)
        for (int i = 0; i < 50; i++) {
            app.updateQuality()
        }
        def quality = app.items[0].quality
        println(quality)
        expect:
        quality == 50
    }

    def "“Sulfuras”, being a legendary item, never has to be sold or decreases in Quality"() {

    }
}
