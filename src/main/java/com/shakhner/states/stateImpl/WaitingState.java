package com.shakhner.states.stateImpl;

import com.shakhner.model.Elevator;
import com.shakhner.model.ElevatorStatus;
import com.shakhner.states.ElevatorState;

public class WaitingState implements ElevatorState {

    private Elevator elevator;

    @Override
    public void doStep() {

    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getElevatorId(), elevator.getCurrentFloor(), null);
    }
}
