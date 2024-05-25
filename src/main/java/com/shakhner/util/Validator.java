package com.shakhner.util;

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
}
