package com.shakhner.distributors.distibutorImpl;

import com.shakhner.commands.commandImpl.*;
import com.shakhner.distributors.Distributor;
import com.shakhner.models.Elevator;

import java.util.ArrayList;
import java.util.List;

public class FirstComeFirstServeDistributor implements Distributor {
    @Override
    public void distribute(List<Elevator> elevators, Integer floorNumber, Integer direction) {
        List<Elevator> freeElevators = findFreeElevators(elevators);

        if (freeElevators.isEmpty())
            findNearestElevator(elevators, floorNumber).receiveNewCommand(
                    new AddCommandAsLast(
                            new MoveToCommand(floorNumber, direction,
                                    new AddCommandAsFirst(
                                            new ReceiveCommand(floorNumber,
                                                    new AddTargetAsFirstCommand())))));
        else
            findNearestElevator(freeElevators, floorNumber).receiveNewCommand(
                    new AddCommandAsLast(
                            new MoveToCommand(floorNumber, direction,
                                    new AddCommandAsFirst(new ReceiveCommand(floorNumber,
                                            new AddTargetAsFirstCommand())))));
    }

    private List<Elevator> findFreeElevators(List<Elevator> elevators) {
        List<Elevator> freeElevators = new ArrayList<>();

        for (Elevator elevator : elevators)
            if (elevator.getStatus().getTargetFloor() == null)
                freeElevators.add(elevator);

        return freeElevators;
    }

    private Elevator findNearestElevator(List<Elevator> elevators, Integer floorNumber) {
        Elevator nearestElevator = elevators.get(0);
        Integer smallestDifference = Math.abs(floorNumber - elevators.get(0).getStatus().getCurrentFloor());
        Integer minAmountOfCommandToDo = elevators.get(0).getAmountOfCommandToDo();
////Indicate command check
        for (Elevator elevator : elevators) {
            Integer difference = Math.abs(floorNumber - elevator.getStatus().getCurrentFloor());

            if (smallestDifference > difference) {
                nearestElevator = elevator;
                smallestDifference = difference;
                minAmountOfCommandToDo = elevator.getAmountOfCommandToDo();
            } else if(smallestDifference == difference) {
                if(minAmountOfCommandToDo > elevator.getAmountOfCommandToDo())
                    nearestElevator = elevator;
            }
        }

        return nearestElevator;
    }
}
