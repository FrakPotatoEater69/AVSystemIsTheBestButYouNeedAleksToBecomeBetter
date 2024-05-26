package com.shakhner.util;

import java.util.Scanner;

public class ConsoleInputHandler {
    private static Scanner scanner = new Scanner(System.in);
    ;

    public static Integer getIntegerFromConsoleWithCheck(Integer defaultValue) {
        try {
            Integer value = scanner.nextInt();

            return Validator.validateFloorNumber(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String[] getCommandFromConsoleWithCheck() {
            String[] input = scanner.nextLine().trim().split("\\s+");

            Validator.validateCommandString(input);

            return input;
    }
}
