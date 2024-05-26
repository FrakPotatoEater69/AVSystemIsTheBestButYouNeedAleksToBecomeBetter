package com.shakhner.commands.commandImpl;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.models.Elevator;

public class AddTargetAsFirstCommand implements ElevatorCommand {
    private Integer floorNumber;
    @Override
    public void execute(Elevator elevator) {
        elevator.addCommandAsFirst(new MoveToTargetCommand(floorNumber));
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
}
