package com.hsbc.kata.fizzBuzz

import spock.lang.Specification
import spock.lang.Unroll

class FizzBuzzTest extends Specification {
    def fizzBuzz = new FizzBuzz()

    def "should return fizz when given a 3"() {
        given:
        def number = 3
        when:
        def result = fizzBuzz.checkNumber(number)
        then:
        result == "fizz"
    }

    def "should return buzz when given 5 "() {
        given:
        def number = 5
        when:
        def result = fizzBuzz.checkNumber(number)
        then:
        result == "buzz"
    }

    def "should return fizzBuzz when given 15"() {
        given:
        def number = 15
        when:
        def result = fizzBuzz.checkNumber(number)
        then:
        result == "fizzBuzz"
    }

    def "should print number when given a number isn't  multiples of 3 or 5 "() {
        given:
        def number = 1
        when:
        def result = fizzBuzz.checkNumber(number)
        then:
        result == String.valueOf(number)
    }

    @Unroll
    def "should return #result when given #number"() {
        expect:
        fizzBuzz.checkNumber(number) == result
        where:
        number | result
        //normal number
        1      | "1"
        2      | "2"
        //fizz
        3      | "fizz"
        6      | "fizz"
        //buzz
        5      | "buzz"
        55     | "buzz"
        //fizzBuzz
        15     | "fizzBuzz"
        30     | "fizzBuzz"
    }
}
