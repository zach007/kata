package com.hsbc.kata.romannumberals;

import com.google.common.base.Strings;

import java.util.Comparator;
import java.util.EnumSet;

public class RomanNumerals {

    public static void main(String[] args) {
        System.out.println(8 / 5);
    }

    public String convert(int number) {
        RomanNumber smallSymbol = findLessSymbol(number);
        RomanNumber bigSymbol = findBiggestSymbol(number);
        if (isNumberEqualsSmallSymbol(number, smallSymbol)) {
            return smallSymbol.name();
        } else if (isNumberBiggerThanSmallSymbol(number, smallSymbol) && !isNumberEqualsBigSmybleM1(number, bigSymbol)) {
            int i = number - smallSymbol.number;
            if (i / 10 <= 10 && i <= 3) {
                return smallSymbol.name() + Strings.repeat(RomanNumber.I.name(), i);
            } else if (i / 10 <= 10 && i > 3) {
                return smallSymbol.name() + convert(i);
            }
        } else if (isNumberEqualsBigSmybleM1(number, bigSymbol)) {
            int i = number - smallSymbol.number;
            if (i / 10 <= 10) {
                if (bigSymbol.number >= 50) {
                    return RomanNumber.X + bigSymbol.name() + RomanNumber.I + RomanNumber.X;
                } else {
                    return RomanNumber.I.name() + bigSymbol.name();
                }
            } else if (1 == 0) {
                System.out.println(2);
            }
        } else if (isNumberLessThanBigSymbol(number, bigSymbol)) {
            String name = RomanNumber.I.name();
            return Strings.repeat(name, number);
        }
        return "";
    }

    private boolean isNumberEqualsBigSmybleM1(int number, RomanNumber bigSymbol) {
        return number == bigSymbol.number - 1;
    }

    private boolean isNumberLessThanBigSymbol(int number, RomanNumber bigSymbol) {

        return number % RomanNumber.I.number == 0;
    }

    private boolean isNumberLessOneThanOfSymbol(int number) {
        return RomanNumber.V.number - number == 1;
    }

    private boolean isNumberBiggerThanSmallSymbol(int number, RomanNumber smallSymbol) {
        return number - smallSymbol.number > 0;
    }

    private boolean isNumberEqualsSmallSymbol(int number, RomanNumber smallSymbol) {
        return smallSymbol.number == number;
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
