package com.shakhner;

import com.shakhner.distributors.distibutorImpl.FirstComeFirstServeDistributor;
import com.shakhner.system.ElevatorSystem;
import com.shakhner.util.Validator;

public class Main {
    public static void main(String[] args) {
        validateArguments(args);

        Validator.setMaximumNumber(Integer.parseInt(args[1]));
        ElevatorSystem elevatorSystem = new ElevatorSystem(Integer.parseInt(args[0]), Integer.parseInt(args[1]), new FirstComeFirstServeDistributor());
        elevatorSystem.run();
    }

    private static void validateArguments(String[] args) {
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
