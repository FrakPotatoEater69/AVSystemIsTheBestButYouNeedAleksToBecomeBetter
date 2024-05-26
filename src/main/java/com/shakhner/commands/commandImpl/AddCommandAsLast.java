package com.shakhner.commands.commandImpl;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.models.Elevator;

public class AddCommandAsLast implements ElevatorCommand {
    ElevatorCommand command;

    public AddCommandAsLast(ElevatorCommand command) {
        this.command = command;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.addCommandAsLast(command);
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
}
