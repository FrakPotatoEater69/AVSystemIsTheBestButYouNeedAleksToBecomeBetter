package com.shakhner.states.stateImpl;

import com.shakhner.models.Elevator;
import com.shakhner.models.ElevatorStatus;
import com.shakhner.states.ElevatorState;

public class MovingUpState implements ElevatorState {
    private Elevator elevator;

    public MovingUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void doStep() {
        elevator.moveUp();

        if (isTargetFloorReached())
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
