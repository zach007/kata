package com.hsbc.kata.singasong

import org.assertj.core.util.Lists
import spock.lang.Specification

class SongTest extends Specification {
    def song = new Song()

    def "should return empty lyrics when the animal is empty"() {
        when:
        def animal = Lists.newArrayList()
        def lyrics = song.lyricsFor(animal)
        then:
        lyrics == ""
    }

    def "should return one short verse for a single animal"() {
        when:
        def animal = Lists.newArrayList("fly")
        def lyrics = song.lyricsFor(animal)
        then:
        lyrics == '''There was an old lady who swallowed a fly.\nI don't know why she swallowed a fly - perhaps she'll die!\n\n'''
    }

    def "should return two short verse for two animals"() {
        when:
        def animals = Lists.newArrayList("fly", "spider")
        def lyrics = song.lyricsFor(animals)
        then:
        def sb = new StringBuilder()
        sb.append("There was an old lady who swallowed a fly.")
                .append(System.lineSeparator())
                .append("I don't know why she swallowed a fly - perhaps she'll die!")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("There was an old lady who swallowed a spider;")
                .append(System.lineSeparator())
                .append("That wriggled and wiggled and tickled inside her.")
                .append(System.lineSeparator())
                .append("She swallowed the spider to catch the fly;")
                .append(System.lineSeparator())
                .append("I don't know why she swallowed a fly - perhaps she'll die!")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
        lyrics == sb.toString()

    }
}
