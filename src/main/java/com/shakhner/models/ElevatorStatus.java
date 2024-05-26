package com.shakhner.models;

public class ElevatorStatus {
    private Integer elevatorId;
    private Integer currentFloor;
    private Integer targetFloor;

    public ElevatorStatus(Integer elevatorId, Integer currentFloor, Integer targetFloor) {
        this.elevatorId = elevatorId;
        this.currentFloor = currentFloor;
        this.targetFloor = targetFloor;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public Integer getTargetFloor() {
        return targetFloor;
    }

    public String toString() {
        return "[" + elevatorId + "]  | " + currentFloor + " | " + "  | " + targetFloor + " |";
    }
}
