package com.shakhner.commands.commandImpl;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.models.Elevator;
import com.shakhner.states.ElevatorState;

public class AddCommandAsFirst implements ElevatorCommand {
    ElevatorCommand command;

    public AddCommandAsFirst(ElevatorCommand command) {
        this.command = command;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.addCommandAsFirst(command);
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
