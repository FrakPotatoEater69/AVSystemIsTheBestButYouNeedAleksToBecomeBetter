package com.shakhner.states.stateImpl;

import com.shakhner.model.Elevator;
import com.shakhner.model.ElevatorStatus;
import com.shakhner.states.ElevatorState;

public class ReceivingOrderState implements ElevatorState {
    private Elevator elevator;

    public ReceivingOrderState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void doStep() {
        elevator.getCurrentCommand().execute(elevator);
    }

    @Override
    public ElevatorStatus getStatus() {
        return new ElevatorStatus(elevator.getElevatorId(), elevator.getCurrentFloor(), elevator.getCurrentCommand().getFloorNumber());
    }

}
