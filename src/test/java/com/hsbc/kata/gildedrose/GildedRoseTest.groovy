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
        expect:
        quality == 50
    }

    def "“Sulfuras”, being a legendary item, never has to be sold or decreases in Quality"() {
        Item[] items = [new Item("Sulfuras, Hand of Ragnaros", 3, 10)]
        def app = new GildedRose(items)
        for (int i = 0; i < 50; i++) {
            app.updateQuality()
        }
        def quality = app.items[0].quality
        def sellIn = app.items[0].sellIn
        expect:
        quality == 10
        and:
        sellIn == 3
    }

    def "Backstage passes quality always increases and Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert"() {
        Item[] items = [new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10)]
        def app = new GildedRose(items)
        for (int i = 0; i < 6; i++) {
            app.updateQuality()
        }
        def QualityOf10Days = app.items[0].quality
        def sellInOf10Days = app.items[0].sellIn
        for (int i = 0; i < 5; i++) {
            app.updateQuality()
        }
        def QualityOf5Days = app.items[0].quality
        def sellInOf5Days = app.items[0].sellIn
        for (int i = 0; i < 1; i++) {
            app.updateQuality()
        }
        def qualityAfterConcert = app.items[0].quality
        def sellOutDays = app.items[0].sellIn
        expect:
        QualityOf10Days == 21
        and:
        sellInOf10Days == 5
        and:
        QualityOf5Days == 36
        and:
        sellInOf5Days == 0
        and:
        qualityAfterConcert == 0
        sellOutDays == -1
    }

    def "“Conjured” items degrade in Quality twice as fast as normal items"() {
        Item[] items = [new Item("Conjured", 3, 10)]
        def app = new GildedRose(items)
        for (int i = 0; i < 4; i++) {
            app.updateQuality()
        }
        def quality = app.items[0].quality
        expect:
        quality == 2
    }
}
