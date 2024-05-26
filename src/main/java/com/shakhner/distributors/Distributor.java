package com.shakhner.distributors;

import java.util.ArrayList;
import java.util.List;

import com.shakhner.model.Elevator;

public interface Distributor {
    public void distribute(List<Elevator> elevators, Integer floorNumber, Integer direction);
}
