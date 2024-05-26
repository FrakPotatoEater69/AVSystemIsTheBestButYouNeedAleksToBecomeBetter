package com.shakhner.commands.commandImpl;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.models.Elevator;

public class AddTargetWithCheck implements ElevatorCommand {

    private Integer floorNumber;

    @Override
    public void execute(Elevator elevator) {
        if(elevator.getCurrentCommand() != null) {
            Integer targetFloor = elevator.getCurrentCommand().getFloorNumber();
            Integer currentFloor = elevator.getCurrentFloor();
            Integer currentDirection = (int) Math.signum(targetFloor - currentFloor);

            if(shouldCommandBeAddedFirst(targetFloor, currentDirection))
                elevator.addCommandAsFirst(new MoveToTargetCommand(floorNumber));
            else
                elevator.addCommandAsLast(new MoveToTargetCommand(floorNumber));
        } else {
            elevator.addCommandAsLast(new MoveToTargetCommand(floorNumber));
        }
    }

    @Override
    public void setElevatorState(Elevator elevator) {

    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    private boolean shouldCommandBeAddedFirst(Integer targetFloor, Integer currentDirection) {
        if(isMovingUpAndBelowTarget(targetFloor, currentDirection))
            return true;
        else if(isMovingUp(currentDirection))
            return false;
        else return !isBelowTarget(targetFloor);
    }

    private boolean isMovingUp(Integer currentDirection) {
        return currentDirection.equals(1);
    }

    private boolean isMovingUpAndBelowTarget(Integer targetFloor, Integer currentDirection) {
        return isMovingUp(currentDirection) && isBelowTarget(targetFloor);
    }

    private boolean isBelowTarget(Integer targetFloor) {
        return floorNumber < targetFloor;
    }
}
