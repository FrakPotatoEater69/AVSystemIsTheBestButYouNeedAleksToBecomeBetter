package com.shakhner.states;

import com.shakhner.models.ElevatorStatus;

public interface ElevatorState {
    public void doStep();

    public ElevatorStatus getStatus();
}
