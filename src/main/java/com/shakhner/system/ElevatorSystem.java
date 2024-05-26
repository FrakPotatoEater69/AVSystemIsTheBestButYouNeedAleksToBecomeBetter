package com.shakhner.system;

import com.shakhner.distributors.Distributor;
import com.shakhner.models.Elevator;
import com.shakhner.models.ElevatorStatus;
import com.shakhner.util.ConsoleInputHandler;
import com.shakhner.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElevatorSystem {
    private Integer numberOfFloors;
    private Distributor ordersDistributor;
    private List<Elevator> elevators = new ArrayList<>();

    public ElevatorSystem(Integer numberOfElevators, Integer numberOfFloors, Distributor distributionStrategy) {
        this.numberOfFloors = numberOfFloors;
        this.ordersDistributor = distributionStrategy;

        for (int id = 0; id < numberOfElevators; id++)
            elevators.add(new Elevator(id, 0));

        Validator.setMaximumFloorsNumber(numberOfElevators);
    }

    public ElevatorSystem() {
        //Add default 8 floors and 2 elevator, add default Distributor;
    }

    public void run() {
        while (true) {
            System.out.println("--------------------------");
            System.out.println("Id  Location  Target");
            for (ElevatorStatus status : status())
                System.out.println(status);
            System.out.println("--------------------------");
            System.out.println("Order elevator:  \"pickup <floor number> <direction>\"");
            System.out.println("Next step:       \"s\"");
            System.out.println("Insert operation:");

            String[] command = ConsoleInputHandler.getCommandFromConsoleWithCheck();

            Arrays.toString(command);
            switch (command[0]) {
                case "pickup":
                    pickUp(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "s":
                    step();
                    break;
            }
        }
    }

    public void pickUp(Integer floorNumber, Integer direction) {
        ordersDistributor.distribute(elevators, Validator.validateFloorNumber(floorNumber), direction);
    }

    public void step() {
        for (Elevator elevator : elevators)
            elevator.doStep();
    }

    public List<ElevatorStatus> status() {
        List<ElevatorStatus> elevatorsStatuses = new ArrayList<>();

        for (Elevator elevator : elevators)
            elevatorsStatuses.add(elevator.getStatus());

        return elevatorsStatuses;
    }
}
