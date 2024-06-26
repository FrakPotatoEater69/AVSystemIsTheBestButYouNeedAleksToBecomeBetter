package com.shakhner.models;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.states.ElevatorState;
import com.shakhner.states.stateImpl.WaitingState;
import com.shakhner.util.ConsoleInputHandler;

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
        this.elevatorState = new WaitingState(this);
        //Add Status!
    }

    public ElevatorCommand getCurrentCommand() {
        return commands.peek();
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

    public Integer receiveTargetFloorFromInput() {
        System.out.printf("\n[ %d ] You're on %d floor. Choose target: ", elevatorId, currentFloor);

        return ConsoleInputHandler.getIntegerFromConsoleWithCheck(currentFloor);
    }

    public void doStep() {
        elevatorState.doStep();
    }

    public void moveUp() {
        currentFloor++;
    }

    public void moveDown() {
        currentFloor--;
    }

    public void addCommandAsFirst(ElevatorCommand command) {
        this.commands.addFirst(command);
    }

    public void receiveNewCommand(ElevatorCommand command) {
        command.execute(this);
        updateState();
    }

    public void updateState() {
        if (commands.isEmpty())
            changeState(new WaitingState(this));
        else {
            commands.peek().setElevatorState(this);
        }
    }

    public void changeState(ElevatorState newState) {
        this.elevatorState = newState;
    }

    public void removeExecutedCommand() {
        commands.pop();
    }

    public void addCommandAsLast(ElevatorCommand command) {
        this.commands.addLast(command);
    }

    public Integer getAmountOfCommandToDo() {
        return commands.size();
    }
}
