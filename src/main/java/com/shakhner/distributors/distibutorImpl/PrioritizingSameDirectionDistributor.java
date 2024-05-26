package com.shakhner.distributors.distibutorImpl;

import com.shakhner.commands.commandImpl.*;
import com.shakhner.distributors.Distributor;
import com.shakhner.models.Elevator;

import java.util.ArrayList;
import java.util.List;

public class PrioritizingSameDirectionDistributor implements Distributor {
    @Override
    public void distribute(List<Elevator> elevators, Integer floorNumber, Integer direction) {
        List<Elevator> selectedElevators = new ArrayList<>();

        Elevator nearestFreeElevator = getNearestElevator(getFreeElevators(elevators), floorNumber);
        if(nearestFreeElevator != null)
            selectedElevators.add(nearestFreeElevator);

        Elevator nearestOnTheWayElevator = getNearestElevator(getElevatorsThatAreOnTheWay(getBusyElevators(elevators), floorNumber, direction), floorNumber);
        if(nearestOnTheWayElevator != null)
            selectedElevators.add(nearestOnTheWayElevator);

        Elevator selectedElevator = getNearestElevator(selectedElevators, floorNumber);

        if(selectedElevator != null)
            selectedElevator.receiveNewCommand(
                                            new AddCommandWithCheck(
                                                    new MoveToCommand(floorNumber, direction,
                                                            new AddCommandAsFirst(
                                                                    new ReceiveCommand(floorNumber,
                                                                        new AddTargetWithCheck())))));
        else
            getNearestElevator(elevators, floorNumber).receiveNewCommand(
                                                                    new AddCommandAsLast(
                                                                            new MoveToCommand(floorNumber, direction,
                                                                                new AddCommandAsFirst(
                                                                                        new ReceiveCommand(floorNumber,
                                                                                                new AddTargetWithCheck())))));

    }

    private ArrayList<Elevator> getElevatorsThatAreOnTheWay(ArrayList<Elevator> elevators, Integer floorNumber, Integer direction) {
        ArrayList<Elevator> onTheWayElevators = new ArrayList<>();

        for(Elevator elevator : elevators) {
            Integer elevatorTargetFloor = elevator.getCurrentCommand().getFloorNumber();
            Integer elevatorCurrentFloor = elevator.getCurrentFloor();
            Integer elevatorNextDirection = elevator.getNextDirection();
            Integer elevatorCurrentDirection = (int) Math.signum(elevatorTargetFloor - elevatorCurrentFloor);

            if(elevatorCurrentFloor < floorNumber && elevatorCurrentDirection.equals(1) && direction.equals(1) && direction.equals(elevatorNextDirection))  //!!
                onTheWayElevators.add(elevator);
            else if(elevatorCurrentFloor < floorNumber && elevatorCurrentDirection.equals(-1) && direction.equals(-1) && direction.equals(elevatorNextDirection))
                onTheWayElevators.add(elevator);
        }

        return onTheWayElevators;
    }

    private ArrayList<Elevator> getFreeElevators(List<Elevator> elevators) {
        ArrayList<Elevator> freeElevators = new ArrayList<>();

        for (Elevator elevator : elevators)
            if (elevator.getStatus().getTargetFloor() == null)
                freeElevators.add(elevator);

        return freeElevators;
    }

    private ArrayList<Elevator> getBusyElevators(List<Elevator> elevators) {
        ArrayList<Elevator> freeElevators = new ArrayList<>();

        for (Elevator elevator : elevators)
            if (elevator.getStatus().getTargetFloor() != null)
                freeElevators.add(elevator);

        return freeElevators;
    }

    private Elevator getNearestElevator(List<Elevator> elevators, Integer floorNumber) {
        if(elevators.isEmpty())
            return null;

        Elevator nearestElevator = elevators.get(0);
        Integer smallestDifference = Math.abs(floorNumber - elevators.get(0).getStatus().getCurrentFloor());

        for (Elevator elevator : elevators) {
            Integer difference = Math.abs(floorNumber - elevator.getStatus().getCurrentFloor());

            if (smallestDifference > difference) {
                nearestElevator = elevator;
                smallestDifference = difference;
            }
        }

        return nearestElevator;
    }
}
