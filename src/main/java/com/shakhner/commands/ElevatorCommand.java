package com.shakhner.commands;

import com.shakhner.models.Elevator;

public interface ElevatorCommand {
    public void execute(Elevator elevator);

    public void setElevatorState(Elevator elevator);

    public Integer getFloorNumber();

    public void setFloorNumber(Integer floorNumber);
}
