package com.hsbc.kata.fizzbuzz

import spock.lang.Specification
import spock.lang.Unroll

class FizzBuzzTest extends Specification {

    def fizzBuzz = new FizzBuzz()

    @Unroll
    def "should return #result when input #parameter"() {
        expect:
        fizzBuzz.getResult(parameter) == result
        where:
        parameter || result
        1         || "1"
        3         || "fizz"
        5         || "buzz"
        15        || "fizzBuzz"
    }

}
