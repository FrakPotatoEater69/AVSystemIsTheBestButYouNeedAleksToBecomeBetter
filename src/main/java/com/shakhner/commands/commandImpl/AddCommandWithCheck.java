package com.shakhner.commands.commandImpl;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.models.Elevator;

public class AddCommandWithCheck implements ElevatorCommand {
    private ElevatorCommand command;

    public AddCommandWithCheck(ElevatorCommand command) {
        this.command = command;
    }

    @Override
    public void execute(Elevator elevator) {
        if(elevator.getCurrentCommand() != null) {
            Integer targetFloor = elevator.getCurrentCommand().getFloorNumber();
            Integer currentFloor = elevator.getCurrentFloor();
            Integer currentDirection = (int) Math.signum(targetFloor - currentFloor);

            if(shouldCommandBeAddedFirst(targetFloor, currentDirection))
                elevator.addCommandAsFirst(command);
            else
                elevator.addCommandAsLast(command);
        } else {
            elevator.addCommandAsLast(command);
        }
    }

    @Override
    public void setElevatorState(Elevator elevator) {

    }

    @Override
    public Integer getFloorNumber() {
        return null;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) {

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
        return command.getFloorNumber() < targetFloor;
    }
}
