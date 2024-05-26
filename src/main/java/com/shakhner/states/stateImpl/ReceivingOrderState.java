package com.shakhner.states.stateImpl;

import com.shakhner.models.Elevator;
import com.shakhner.models.ElevatorStatus;
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
