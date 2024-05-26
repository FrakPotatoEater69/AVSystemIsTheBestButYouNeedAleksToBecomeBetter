package com.shakhner.util;

import java.util.Scanner;

public class Validator {
    private static Integer maximumNumber;

    public static void setMaximumNumber(Integer maximumNumber) {
        Validator.maximumNumber = maximumNumber;
    }

    public static Integer validateFloorNumber(Integer value) {
        if (0 > value)
            return 0;
        else if(value > maximumNumber)
            return maximumNumber;
        else
            return value;
    }

    public static void validateCommandString(String[] input) {
        if(input.length > 2) {
            input[1] = String.valueOf(validateFloorNumber(Integer.parseInt(input[1])));
            input[2] = String.valueOf(validateDirectionValue(Integer.parseInt(input[2])));
        }
    }

    private static Integer validateDirectionValue(Integer value) {
        return (int) Math.signum(value);
    }
}
