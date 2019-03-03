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
        //4      || "IV"

    }
}
