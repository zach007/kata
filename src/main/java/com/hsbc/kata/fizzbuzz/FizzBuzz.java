package com.hsbc.kata.fizzbuzz;

public class FizzBuzz {

    public String getResult(int parameter) {
        if (isFizz(parameter) && isBuzz(parameter)) {
            return "fizzBuzz";
        }
        if (isFizz(parameter)) {
            return "fizz";
        }
        if (isBuzz(parameter)) {
            return "buzz";
        }
        return String.valueOf(parameter);
    }

    private boolean isBuzz(int parameter) {
        return parameter % 5 == 0;
    }

    private boolean isFizz(int parameter) {
        return parameter % 3 == 0;
    }
}
