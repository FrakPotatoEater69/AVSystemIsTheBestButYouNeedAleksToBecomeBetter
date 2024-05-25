package com.shakhner.model;

import com.shakhner.commands.ElevatorCommand;
import com.shakhner.states.ElevatorState;

import java.util.Deque;
import java.util.LinkedList;

public class Elevator {
    private Integer id;
    private ElevatorState elevatorState;
    private Integer currentFloor;
    private Integer nextDirection;
    private Deque<ElevatorCommand> commands = new LinkedList<>();

    public Elevator(int id, int initialFloor) {
        this.id = id;
        this.currentFloor = initialFloor;
        //Initialize state!
        //Add Status!
    }
}
