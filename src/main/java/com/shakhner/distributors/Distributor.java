package com.shakhner.distributors;

import java.util.List;

import com.shakhner.models.Elevator;

public interface Distributor {
    public void distribute(List<Elevator> elevators, Integer floorNumber, Integer direction);
}
