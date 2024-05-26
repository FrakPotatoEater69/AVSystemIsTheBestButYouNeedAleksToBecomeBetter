package com.shakhner.commands.commandImpl;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.models.Elevator;
import com.shakhner.states.ElevatorState;
import com.shakhner.states.stateImpl.MovingDownState;
import com.shakhner.states.stateImpl.MovingUpState;
import com.shakhner.states.stateImpl.ReceivingOrderState;

public class MoveToCommand implements ElevatorCommand {
    private Integer floorNumber;
    private Integer direction;
    private ElevatorCommand command;
    public MoveToCommand(Integer floorNumber, Integer direction, ElevatorCommand command) {
        this.floorNumber = floorNumber;
        this.direction = direction;
        this.command = command;
    }


    @Override
    public void execute(Elevator elevator) {
        elevator.removeExecutedCommand();
        command.execute(elevator);
        elevator.updateState();
    }

    @Override
    public void setElevatorState(Elevator elevator) {
        elevator.changeState(selectState(elevator));
        elevator.setNextDirection(direction);
    }

    @Override
    public Integer getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    private ElevatorState selectState(Elevator elevator) {
        Integer currentFloor = elevator.getCurrentFloor();

        if(currentFloor.equals(floorNumber))
            return new ReceivingOrderState(elevator);
        else if(currentFloor < floorNumber)
            return new MovingUpState(elevator);
        else
            return new MovingDownState(elevator);
    }
}
