package com.hsbc.kata.romannumberals;

import com.google.common.base.Strings;

import java.util.Comparator;
import java.util.EnumSet;

public class RomanNumerals {

    public String convert(int number) {
        RomanNumber lessSymbol = findLessSymbol(number);
        RomanNumber biggestSymbol = findBiggestSymbol(number);
        if (isNumberEqualsSymbol(number)) {
            return lessSymbol.name();
        } else if (isNumberBiggerThanSymbol(number)) {
            int seed = number - RomanNumber.V.number;
            return RomanNumber.V.name() + Strings.repeat(RomanNumber.I.name(), seed);
        } else if (isNumberLessThanSymbol(number)) {
            if (isNumberLessOneThanOfSymbol(number)) {
                return RomanNumber.I.name() + RomanNumber.V.name();
            } else {
                String name = RomanNumber.I.name();
                return Strings.repeat(name, number);
            }
        }
        return "";
    }

    private boolean isNumberLessThanSymbol(int number) {
        return number % RomanNumber.I.number == 0;
    }

    private boolean isNumberLessOneThanOfSymbol(int number) {
        return RomanNumber.V.number - number == 1;
    }

    private boolean isNumberBiggerThanSymbol(int number) {
        return number - RomanNumber.V.number > 0;
    }

    private boolean isNumberEqualsSymbol(int number) {
        return RomanNumber.V.number == number;
    }

    public RomanNumber findLessSymbol(int number) {
        EnumSet<RomanNumber> enumSet = EnumSet.noneOf(RomanNumber.class);
        for (RomanNumber romanNumber : RomanNumber.values()) {
            if (romanNumber.number <= number) {
                enumSet.add(romanNumber);
            }
        }
        RomanNumber romanNumber = enumSet.stream().max(Comparator.comparing(e -> e.number)).orElse(null);
        return romanNumber;
    }

    public RomanNumber findBiggestSymbol(int number) {
        EnumSet<RomanNumber> enumSet = EnumSet.noneOf(RomanNumber.class);
        for (RomanNumber romanNumber : RomanNumber.values()) {
            if (romanNumber.number >= number) {
                enumSet.add(romanNumber);
            }
        }
        RomanNumber romanNumber = enumSet.stream().min(Comparator.comparing(e -> e.number)).orElse(null);
        return romanNumber;
    }

    enum RomanNumber {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        M(1000),
        ;

        private final int number;

        RomanNumber(int number) {
            this.number = number;
        }


    }
}
