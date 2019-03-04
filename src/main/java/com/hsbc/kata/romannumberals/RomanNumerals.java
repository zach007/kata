package com.hsbc.kata.romannumberals;

import com.google.common.base.Strings;

public class RomanNumerals {

    public static void main(String[] args) {
        System.out.println(3 / 2);
    }

    public String convert(int number) {
        if (RomanNumber.V.number == number) {
            return RomanNumber.V.name();
        } else if (number - RomanNumber.V.number > 0) {
            int seed = number - RomanNumber.V.number;
            return RomanNumber.V.name() + Strings.repeat(RomanNumber.I.name(), seed);
        } else if (RomanNumber.V.number - number == 1) {
            return RomanNumber.I.name() + RomanNumber.V.name();
        } else if (number % RomanNumber.I.number == 0) {
            String name = RomanNumber.I.name();
            return Strings.repeat(name, number);
        }
        return "";
    }

    enum RomanNumber {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        M(1000);

        private final int number;

        RomanNumber(int number) {
            this.number = number;
        }

    }
}
