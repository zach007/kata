package com.hsbc.kata.romannumberals

import spock.lang.Specification

class RomanNumeralsTest extends Specification {
    def romanNumberals = new RomanNumerals()

    def "should return roman number when convert number"() {
        expect:
        romanNumberals.convert(number) == romanNumber
        where:
        number || romanNumber
        1      || "I"
        2      || "II"
        3      || "III"
        4      || "IV"
        5      || "V"
        6      || "VI"
        7      || "VII"
        8      || "VIII"
        // 9      || "IX"
    }

    def "should return the less Roman number when give a number"() {
        expect:
        romanNumberals.findLessSymbol(number) == lessSymbol
        where:
        number || lessSymbol
        1      || RomanNumerals.RomanNumber.I
        6      || RomanNumerals.RomanNumber.V
        11     || RomanNumerals.RomanNumber.X
    }

    def "should return the biggest Roman number when give a number"() {
        expect:
        romanNumberals.findBiggestSymbol(number) == lessSymbol
        where:
        number || lessSymbol
        1      || RomanNumerals.RomanNumber.I
        6      || RomanNumerals.RomanNumber.X
        11     || RomanNumerals.RomanNumber.L
    }
}
