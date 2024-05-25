package com.shakhner.states;

import com.shakhner.model.ElevatorStatus;

public interface ElevatorState {
    public void doStep();

    public ElevatorStatus getStatus();
}
