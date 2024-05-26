package com.shakhner;

import com.shakhner.distributors.distibutorImpl.FirstComeFirstServeDistributor;
import com.shakhner.system.ElevatorSystem;
import com.shakhner.util.Validator;

public class Main {
    public static void main(String[] args) {
        Validator.validateArguments(args);

        ElevatorSystem elevatorSystem = new ElevatorSystem(Integer.parseInt(args[0]), Integer.parseInt(args[1]), new FirstComeFirstServeDistributor());
        elevatorSystem.run();
    }
}
