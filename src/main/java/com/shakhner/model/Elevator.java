package com.shakhner.model;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.states.ElevatorState;

import java.util.Deque;
import java.util.LinkedList;

public class Elevator {
    private Integer elevatorId;
    private ElevatorState elevatorState;
    private Integer currentFloor;
    private Integer nextDirection;
    private Deque<ElevatorCommand> commands = new LinkedList<>();

    public Elevator(int elevatorId, int initialFloor) {
        this.elevatorId = elevatorId;
        this.currentFloor = initialFloor;
        //Initialize state!
        //Add Status!
    }

    public ElevatorStatus getStatus() {
        return elevatorState.getStatus();
    }

    public Integer getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(Integer elevatorId) {
        this.elevatorId = elevatorId;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Integer getNextDirection() {
        return nextDirection;
    }

    public void setNextDirection(Integer nextDirection) {
        this.nextDirection = nextDirection;
    }
}
