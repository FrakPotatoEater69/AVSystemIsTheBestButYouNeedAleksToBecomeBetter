package com.shakhner.states.stateImpl;

import com.shakhner.model.Elevator;
import com.shakhner.model.ElevatorStatus;
import com.shakhner.states.ElevatorState;

public class MovingDownState implements ElevatorState {
    private Elevator elevator;

    public MovingDownState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void doStep() {
        elevator.moveDown();

        if(isTargetFloorReached())
            elevator.getCurrentCommand().execute(elevator);
    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getElevatorId(), elevator.getCurrentFloor(), elevator.getCurrentCommand().getFloorNumber());
    }

    private boolean isTargetFloorReached() {
        return elevator.getCurrentFloor().equals(elevator.getCurrentCommand().getFloorNumber());
    }
}
