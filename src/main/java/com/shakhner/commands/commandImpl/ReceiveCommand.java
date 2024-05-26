package com.shakhner.commands.commandImpl;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.models.Elevator;
import com.shakhner.states.stateImpl.ReceivingOrderState;

public class ReceiveCommand implements ElevatorCommand {
    private Integer floorNumber;
    private ElevatorCommand command;

    public ReceiveCommand(Integer floorNumber, ElevatorCommand command) {
        this.floorNumber = floorNumber;
        this.command = command;
    }
    @Override
    public void execute(Elevator elevator) {
        elevator.removeExecutedCommand();

        Integer targetFloor = elevator.receiveTargetFloorFromInput();
        command.setFloorNumber(targetFloor);
        command.execute(elevator);
        elevator.updateState();
    }

    @Override
    public void setElevatorState(Elevator elevator) {
        elevator.setNextDirection(null);
        elevator.changeState(new ReceivingOrderState(elevator));
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
