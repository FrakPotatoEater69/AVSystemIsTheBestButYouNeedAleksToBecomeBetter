package com.shakhner.util;

import java.util.Scanner;

public class ConsoleInputHandler implements AutoCloseable{
    private Scanner scanner;

    public ConsoleInputHandler() {
        scanner = new Scanner(System.in);
    }

    public Integer getIntegerFromConsoleAndCheck(Integer defaultValue) {
        try {
            Integer inputInt = scanner.nextInt();

            return Validator.validateFloorNumber(inputInt);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }

    public String[] getCommandFromConsole() {
        try {
            String[] input = scanner.nextLine().trim().split(" ");

            Validator.validateCommandString(input);

            return  input;
        } catch (Exception e) {
            System.out.println("Invalid operation");
            return null;
        }
    }
}
