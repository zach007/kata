package com.hsbc.kata;

public class FizzBuzz {

    public String checkNumber(int number) {
        boolean multiplesOf3 = number % 3 == 0;
        boolean multiplesOf5 = number % 5 == 0;
        if (multiplesOf3 && multiplesOf5) {
            return "fizzBuzz";
        } else if (multiplesOf3) {
            return "fizz";
        } else if (multiplesOf5) {
            return "buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
