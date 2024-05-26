package com.shakhner.commands.commandImpl;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.models.Elevator;
import com.shakhner.states.ElevatorState;
import com.shakhner.states.stateImpl.MovingDownState;
import com.shakhner.states.stateImpl.MovingUpState;
import com.shakhner.states.stateImpl.ReceivingOrderState;

public class MoveToTargetCommand implements ElevatorCommand {
    private Integer floorNumber;

    public MoveToTargetCommand(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void execute(Elevator elevator) {
        elevator.removeExecutedCommand();
        elevator.updateState();
    }

    @Override
    public void setElevatorState(Elevator elevator) {
        elevator.changeState(selectState(elevator));
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

        if (currentFloor.equals(floorNumber))
            return new ReceivingOrderState(elevator);
        else if (currentFloor < floorNumber)
            return new MovingUpState(elevator);
        else
            return new MovingDownState(elevator);
    }
}
