package com.shakhner.util;

public class Validator {
    private static Integer MAXIMUM_FLOORS_NUMBER;

    public static void setMaximumFloorsNumber(Integer maximumFloorsNumber) {
        Validator.MAXIMUM_FLOORS_NUMBER = maximumFloorsNumber;
    }

    public static Integer validateFloorNumber(Integer value) {
        if (value < 0)
            return 0;
        else if (value > MAXIMUM_FLOORS_NUMBER)
            return MAXIMUM_FLOORS_NUMBER;
        else
            return value;
    }

    public static void validateCommandString(String[] input) {
        if (input.length > 2 && input.length < 4) {
            input[1] = String.valueOf(validateFloorNumber(Integer.parseInt(input[1])));
            input[2] = String.valueOf(validateDirectionValue(Integer.parseInt(input[2])));
        } else if (input.length != 1) {
            throw new UnsupportedOperationException();
        }
    }

    public static Integer validateDirectionValue(Integer value) {
        return (int) Math.signum(value);
    }

    public static void validateArguments(String[] args) {
        if (args.length < 2) {
            System.out.println("You must provide 2 arguments: <number of elevators> <number of floors>");
            System.exit(0);
        }

        if (Integer.parseInt(args[0]) < 1 && Integer.parseInt(args[0]) > 16) {
            System.out.println("Number of elevators should be beetwen 0 and 16");
            System.exit(0);
        }

        if (Integer.parseInt(args[1]) < 1) {
            System.out.println("Number of floors must be positive");
            System.exit(0);
        }
    }
}
