package com.shakhner.states.stateImpl;

import com.shakhner.models.Elevator;
import com.shakhner.models.ElevatorStatus;
import com.shakhner.states.ElevatorState;

public class WaitingState implements ElevatorState {

    private Elevator elevator;

    public WaitingState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void doStep() {

    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getElevatorId(), elevator.getCurrentFloor(), null);
    }
}
